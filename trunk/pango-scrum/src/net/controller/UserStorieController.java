package net.controller;

import java.util.List;

import net.models.Sprint;
import net.models.Status;
import net.models.Userstory;
import net.vues.VAddUserStorie;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.MessageBox;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.models.Product;
import net.technics.HibernateUtil;

public class UserStorieController implements SelectionListener {
	
	private VAddUserStorie vAddUserStorie;

	/**
	 * @wbp.parser.entryPoint
	 */
	public UserStorieController(VAddUserStorie vAddUserStorie) {
		this.vAddUserStorie = vAddUserStorie;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void init() {
		final Session session = AppController.session;
		
		//Chargement des différents listes
		vAddUserStorie.getTblvUserStory().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getTblvUserStory().setInput(getUserstories());
		
		vAddUserStorie.getCbvSprint().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvSprint().setInput(getSprint());
		
		vAddUserStorie.getCbvProjet().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvProjet().setInput(getProduct());
		
		//Bouton Ajouter une UserStory, réinitialise tous les champs
		vAddUserStorie.getBtnAjouterUserstorie().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vAddUserStorie.getGrpUserstory().setVisible(true);
				vAddUserStorie.getTxtNom().setText("");
				vAddUserStorie.getTxtDescription().setText("");
				vAddUserStorie.getTxtPtAttribue().setText("");
				vAddUserStorie.getCbvSprint().setSelection(null);;
				vAddUserStorie.getCbvProjet().setSelection(null);
				vAddUserStorie.getTxtPriorite().setText("");
				vAddUserStorie.getBtnValider().setVisible(true);
				vAddUserStorie.getBtnAnnuler().setVisible(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});

		// Clique sur un élement de la table
		vAddUserStorie.getTable().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vAddUserStorie.getGrpUserstory().setVisible(true);
				StructuredSelection sel = (StructuredSelection) vAddUserStorie.getTblvUserStory().getSelection();
				Userstory selectedUserStory = (Userstory) sel.getFirstElement();
				vAddUserStorie.getTxtNom().setText(selectedUserStory.getLabel());
				vAddUserStorie.getTxtDescription().setText(selectedUserStory.getDescription());
				vAddUserStorie.getTxtPtAttribue().setText(selectedUserStory.getStoryPoints().toString());
				vAddUserStorie.getTxtPriorite().setText(selectedUserStory.getPriority().toString());
				vAddUserStorie.getCbvSprint().setSelection(new StructuredSelection(selectedUserStory.getSprint()));
				vAddUserStorie.getCbvProjet().setSelection(new StructuredSelection(selectedUserStory.getProduct()));
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		//Bouton Supprimer
		vAddUserStorie.getBtnSupprimerUserstory().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MessageBox msgSupprimer = new MessageBox(vAddUserStorie.getShlProductBacklog(), SWT.OK | SWT.ICON_CANCEL | SWT.ICON_QUESTION);
				msgSupprimer.setMessage("Etes-vous sûr de vouloir supprimer cette UserStory ?");
				int result = msgSupprimer.open();
				if (result == 32) {
					StructuredSelection sel = (StructuredSelection) vAddUserStorie.getTblvUserStory().getSelection();
					Userstory selectedUserstory = (Userstory) sel.getFirstElement();
					Transaction trans = session.beginTransaction();
					session.delete(selectedUserstory);
					trans.commit();
				}
				//Rafraichi la liste du tableau et masque la fênetre
				vAddUserStorie.getGrpUserstory().setVisible(false);
				vAddUserStorie.getTblvUserStory().setInput(getUserstories());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub	
			}
		});
		
		//Bouton Valider
		vAddUserStorie.getBtnValider().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String label = vAddUserStorie.getTxtNom().getText();
				String description = vAddUserStorie.getTxtDescription().getText();
				Integer storyPoints = Integer.parseInt(vAddUserStorie.getTxtPtAttribue().getText());
				Integer priorite = Integer.parseInt(vAddUserStorie.getTxtPriorite().getText());
				Status status=new Status();
				status.setIdStatus(1);
				IStructuredSelection sel = (IStructuredSelection) (vAddUserStorie.getCbvSprint().getSelection());
				Sprint sprint = (Sprint) (sel.iterator().next());
				Product product= ProductController.getSelectedProduct();
				
				Userstory userStorie = new Userstory(sprint, product, status, label, description, storyPoints, priorite, null);
				Transaction trans = session.beginTransaction();
				session.persist(userStorie);
				trans.commit();
				
				vAddUserStorie.getTblvUserStory().setInput(getUserstories());
				vAddUserStorie.getGrpUserstory().setVisible(false);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//Bouton Update 
		vAddUserStorie.getBtnModifierUserStory().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String label = vAddUserStorie.getTxtNom().getText();
				String description = vAddUserStorie.getTxtDescription().getText();
				Integer storyPoints = Integer.parseInt(vAddUserStorie.getTxtPtAttribue().getText());
				Integer priorite = Integer.parseInt(vAddUserStorie.getTxtPriorite().getText());
				Status status=new Status();
				status.setIdStatus(1);
				IStructuredSelection sel = (IStructuredSelection) (vAddUserStorie.getCbvSprint().getSelection());
				Sprint sprint = (Sprint) (sel.iterator().next());
				Product product= ProductController.getSelectedProduct();
				
				StructuredSelection select = (StructuredSelection) vAddUserStorie.getTblvUserStory().getSelection();
				Userstory selectedUserStory = (Userstory) select.getFirstElement();
				selectedUserStory.setLabel(label);
				selectedUserStory.setDescription(description);
				selectedUserStory.setStoryPoints(storyPoints);
				selectedUserStory.setSprint(sprint);
				selectedUserStory.setProduct(product);
				selectedUserStory.setPriority(priorite);
				Transaction trans = session.beginTransaction();
				session.update(selectedUserStory);
				trans.commit();
				vAddUserStorie.getTblvUserStory().setInput(getUserstories());
				vAddUserStorie.getGrpUserstory().setVisible(false);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		//Bouton Annuler
		vAddUserStorie.getBtnAnnuler().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vAddUserStorie.getGrpUserstory().setVisible(false);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	//Chargement des listes
	private List<Userstory> getUserstories() {
		Query query = AppController.session.createQuery("FROM Userstory WHERE idStatus= 1");
		List<Userstory> userStories = query.list();
		return userStories;
	}
	
	private List<Product> getProduct() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Product");
		List<Product> lesproducts = query.list();
		return lesproducts;
	}
	
	private List<Sprint> getSprint() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Sprint");
		List<Sprint> lessprints = query.list();
		return lessprints;
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
	}

}
