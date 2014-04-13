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
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Event;
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
	 * Onglet To-Do
	 * @wbp.parser.entryPoint
	 */
	public void initToDo() {
		final Session session = AppController.session;
		
		//Chargement des différentes listes
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

		// Récupére l'élément cliquer sur la table
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
				if(selectedUserStory.getSprint() != null){
					vAddUserStorie.getCbvSprint().setSelection(new StructuredSelection(selectedUserStory.getSprint()));
				}else{
					String label = "Aucun";
					Sprint sprint = new Sprint(label);
					getSprint().add(sprint);
					vAddUserStorie.getCbSprint().setText("Aucun");
				}
				vAddUserStorie.getCbvProjet().setSelection(new StructuredSelection(selectedUserStory.getProduct()));
				vAddUserStorie.getGrpParametreUserstory().setVisible(true);
				vAddUserStorie.getGrpChangementDtat().setVisible(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		//Bouton Supprimer une UserStory
		vAddUserStorie.getBtnSupprimerUserstory().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MessageBox msgSupprimer = new MessageBox(vAddUserStorie.getShlProductBacklog(), SWT.OK | SWT.ICON_CANCEL | SWT.ICON_QUESTION);
				msgSupprimer.setMessage("Etes-vous sÃ»r de vouloir supprimer cette UserStory ?");
				int result = msgSupprimer.open();
				if (result == 32) {
					StructuredSelection sel = (StructuredSelection) vAddUserStorie.getTblvUserStory().getSelection();
					Userstory selectedUserstory = (Userstory) sel.getFirstElement();
					Transaction trans = session.beginTransaction();
					session.delete(selectedUserstory);
					trans.commit();
					vAddUserStorie.getGrpParametreUserstory().setVisible(false);
					vAddUserStorie.getGrpChangementDtat().setVisible(false);
				}
				vAddUserStorie.getGrpUserstory().setVisible(false);
				vAddUserStorie.getTblvUserStory().setInput(getUserstories());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub	
			}
		});
		
		//Bouton Modifier une UserStory (Update) 
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
				Product product= new Product();//ProductController.getSelectedProduct();
				product.setId(2);
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
				vAddUserStorie.getGrpParametreUserstory().setVisible(false);
				vAddUserStorie.getGrpChangementDtat().setVisible(false);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		//Bouton Done permettant de mettre une UserStory à Done
		vAddUserStorie.getBtnDone().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Status status=new Status();
				status.setIdStatus(3);
				StructuredSelection select = (StructuredSelection) vAddUserStorie.getTblvUserStory().getSelection();
				Userstory selectedUserStory = (Userstory) select.getFirstElement();
				selectedUserStory.setStatus(status);
				Transaction trans = session.beginTransaction();
				session.update(selectedUserStory);
				trans.commit();
				vAddUserStorie.getTblvUserStory().setInput(getUserstories());
				vAddUserStorie.getTblvDone().setInput(getUserStoryDone());
				vAddUserStorie.getGrpUserstory().setVisible(false);
				vAddUserStorie.getGrpParametreUserstory().setVisible(false);
				vAddUserStorie.getGrpChangementDtat().setVisible(false);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//Bouton InProgress permettant de mettre une UserStory en cours
				vAddUserStorie.getBtnInProgress().addSelectionListener(new SelectionListener() {
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						Status status=new Status();
						status.setIdStatus(2);
						StructuredSelection select = (StructuredSelection) vAddUserStorie.getTblvUserStory().getSelection();
						Userstory selectedUserStory = (Userstory) select.getFirstElement();
						selectedUserStory.setStatus(status);
						Transaction trans = session.beginTransaction();
						session.update(selectedUserStory);
						trans.commit();
						vAddUserStorie.getTblvUserStory().setInput(getUserstories());
						vAddUserStorie.getTblvInProgress().setInput(getUserStoryInProgress());
						vAddUserStorie.getGrpUserstory().setVisible(false);
						vAddUserStorie.getGrpParametreUserstory().setVisible(false);
						vAddUserStorie.getGrpChangementDtat().setVisible(false);
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
		
		//Bouton Valider permet de valider la UserStory à ajouter
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
		
		//Bouton Annuler annule l'ajout d'une UserStory
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

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Onglet In-Progress 
	 */
	
	public void initInProgress(){
		final Session session = AppController.session;
		vAddUserStorie.getTblvInProgress().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getTblvInProgress().setInput(getUserStoryInProgress());
	
		vAddUserStorie.getCbvSprintInProgress().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvSprintInProgress().setInput(getSprint());
		
		vAddUserStorie.getCbvProjetInProgress().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvProjetInProgress().setInput(getProduct());
		
		//Charge les éléments de la ligne sélectionné dans le tableau
		vAddUserStorie.getTblInProgress().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vAddUserStorie.getGrpChangementEtatInProgress().setVisible(true);
				vAddUserStorie.getGrpRcapitulatifInProgress().setVisible(true);
				StructuredSelection sel = (StructuredSelection) vAddUserStorie.getTblvInProgress().getSelection();
				Userstory selectedUserStoryInProgress = (Userstory) sel.getFirstElement();
				vAddUserStorie.getTxtNomInProgress().setText(selectedUserStoryInProgress.getLabel());
				vAddUserStorie.getTxtDescriptionInProgress().setText(selectedUserStoryInProgress.getDescription());
				vAddUserStorie.getTxtPtattribueInProgress().setText(selectedUserStoryInProgress.getStoryPoints().toString());
				vAddUserStorie.getTxtPrioriteInProgress().setText(selectedUserStoryInProgress.getPriority().toString());
				if(selectedUserStoryInProgress.getSprint() != null){
					vAddUserStorie.getCbvSprintInProgress().setSelection(new StructuredSelection(selectedUserStoryInProgress.getSprint()));
				}else{
					String label = "Aucun";
					Sprint sprint = new Sprint(label);
					getSprint().add(sprint);
					vAddUserStorie.getCbSprintInProgress().setText("Aucun");
				}
				vAddUserStorie.getCbvProjetInProgress().setSelection(new StructuredSelection(selectedUserStoryInProgress.getProduct()));
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		//Bouton permettant de passer la UserStory à l'état cloturé (Done)
		vAddUserStorie.getBtncloturerInProgress().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Status status=new Status();
				status.setIdStatus(3);
				StructuredSelection selectInProgress = (StructuredSelection) vAddUserStorie.getTblvInProgress().getSelection();
				Userstory selectedUserStoryInProgress = (Userstory) selectInProgress.getFirstElement();
				selectedUserStoryInProgress.setStatus(status);
				Transaction trans = session.beginTransaction();
				session.update(selectedUserStoryInProgress);
				trans.commit();
				vAddUserStorie.getTblvInProgress().setInput(getUserStoryInProgress());
				vAddUserStorie.getTblvDone().setInput(getUserStoryDone());
				vAddUserStorie.getGrpRcapitulatifInProgress().setVisible(false);
				vAddUserStorie.getGrpChangementEtatInProgress().setVisible(false);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	/**
	 * Onglet Done 
	 */
	
	public void initDone(){
		vAddUserStorie.getTblvDone().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getTblvDone().setInput(getUserStoryDone());
		
		vAddUserStorie.getCbvSprintDone().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvSprintDone().setInput(getSprint());
		
		vAddUserStorie.getCbvProjetDone().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvProjetDone().setInput(getProduct());
		
		//Charge les éléments de la ligne sélectionné
		vAddUserStorie.getTblDone().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vAddUserStorie.getGrpRcapitulatifUserStory().setVisible(true);
				StructuredSelection sel = (StructuredSelection) vAddUserStorie.getTblvDone().getSelection();
				Userstory selectedUserStoryDone = (Userstory) sel.getFirstElement();
				vAddUserStorie.getTxtNomDone().setText(selectedUserStoryDone.getLabel());
				vAddUserStorie.getTxtDescriptionDone().setText(selectedUserStoryDone.getDescription());
				vAddUserStorie.getTxtPtAttribueDone().setText(selectedUserStoryDone.getStoryPoints().toString());
				vAddUserStorie.getTxtPrioriteDone().setText(selectedUserStoryDone.getPriority().toString());
				if(selectedUserStoryDone.getSprint() != null){
					vAddUserStorie.getCbvSprintDone().setSelection(new StructuredSelection(selectedUserStoryDone.getSprint()));
				}else{
					String label = "Aucun";
					Sprint sprint = new Sprint(label);
					getSprint().add(sprint);
					vAddUserStorie.getCbSprintDone().setText("Aucun");
				}
				vAddUserStorie.getCbvProjetDone().setSelection(new StructuredSelection(selectedUserStoryDone.getProduct()));
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
		Query query = session.createQuery("FROM Sprint");//SELECT label FROM Sprint WHERE idproduct="+ ProductController.getSelectedProduct().getId());
		List<Sprint> lessprints = query.list();
		return lessprints;
	}
	
	private List<Userstory> getUserStoryInProgress(){
		Query query = AppController.session.createQuery("FROM Userstory WHERE idStatus = 2");
		List<Userstory> lesuserStoriesInProgress = query.list();
		return lesuserStoriesInProgress;
	}
	
	private List<Userstory> getUserStoryDone(){
		Query query = AppController.session.createQuery("FROM Userstory WHERE idStatus = 3");
		List<Userstory> lesuserStories = query.list();
		return lesuserStories;
	}
}
