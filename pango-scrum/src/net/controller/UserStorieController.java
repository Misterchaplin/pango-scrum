package net.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import net.models.Collaborator;
import net.models.Sprint;
import net.models.Status;
import net.models.Userstory;
import net.vues.VAddUserStorie;

import org.eclipse.jface.text.templates.GlobalTemplateVariables.Year;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.TouchSource;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.omg.CORBA.portable.ValueOutputStream;

import net.models.Product;
import net.technics.DAOCollaborator;
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

		vAddUserStorie.getTblvUserStory().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getTblvUserStory().setInput(getUserstories());
		
		vAddUserStorie.getCbvSprint().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvSprint().setInput(getSprint());
		
		vAddUserStorie.getCbvProjet().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvProjet().setInput(getProduct());
		
		//Bouton Ajouter une UserStory
		vAddUserStorie.getBtnAjouterUserstorie().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vAddUserStorie.getGrpUserstory().setVisible(true);
				vAddUserStorie.getTxtNom().setText("");
				vAddUserStorie.getTxtDescription().setText("");
				vAddUserStorie.getTxtPtAttribue().setText("");
				vAddUserStorie.getCbvSprint().setSelection(null);
				vAddUserStorie.getCbvProjet().setSelection(null);
				vAddUserStorie.getTxtPriorite().setText("");
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
		});;
		
		//Bouton Annuler
		vAddUserStorie.getBtnAnnuler().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vAddUserStorie.getShlProductBacklog().close();
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
