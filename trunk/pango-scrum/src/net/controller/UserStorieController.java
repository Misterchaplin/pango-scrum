package net.controller;

import java.util.List;

import net.models.Collaborator;
import net.models.Playrole;
import net.models.PlayroleId;
import net.models.Realize;
import net.models.RealizeId;
import net.models.Role;
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
import net.technics.DAOCollaborator;
import net.technics.DAOProduct;
import net.technics.HibernateUtil;

public class UserStorieController implements SelectionListener {
	
	private VAddUserStorie vAddUserStorie;

	/**
	 * @wbp.parser.entryPoint
	 */
	public UserStorieController(VAddUserStorie vAddUserStorie) {
		this.vAddUserStorie = vAddUserStorie;
	}

	private static Userstory selectedUserStory;
	public static Userstory getSelectedUserStory() {
		return selectedUserStory;
	}
	/**
	 * Onglet To-Do
	 * @wbp.parser.entryPoint
	 */
	public void initToDo() {
		final Session session = AppController.session;
		
		//Chargement des diff√©rentes listes
		vAddUserStorie.getTblvUserStory().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getTblvUserStory().setInput(DAOProduct.getLesUserstoriesAFaire());
		
		vAddUserStorie.getCbvAffectationCollab().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvAffectationCollab().setInput(DAOCollaborator.getAffectedCollaborators());
		
		vAddUserStorie.getCbvSprint().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvSprint().setInput(getSprint());
		
		vAddUserStorie.getCbvProjet().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvProjet().setInput(getProduct());
		
		//Bouton Ajouter une UserStory, r√©initialise tous les champs
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

		// R√©cup√©re l'√©l√©ment cliquer sur la table
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
				vAddUserStorie.getCbvAffectationCollab().setSelection(new StructuredSelection(selectedUserStory.getCollaborators()));
				
				
				vAddUserStorie.getGrpParametreUserstory().setVisible(true);
				vAddUserStorie.getGrpChangementDtat().setVisible(true);
				vAddUserStorie.getBtnValider().setVisible(false);
				vAddUserStorie.getBtnAnnuler().setVisible(false);
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
				msgSupprimer.setMessage("Etes-vous sur de vouloir supprimer cette UserStory ?");
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
				vAddUserStorie.getTblvUserStory().setInput(DAOProduct.getLesUserstoriesAFaire());
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
				StructuredSelection sel = (StructuredSelection) (vAddUserStorie.getCbvSprint().getSelection());
				Sprint sprint = (Sprint) (sel.getFirstElement());
				Product product= new Product();
				product.setId(ProductController.getSelectedProduct().getId());
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
				vAddUserStorie.getTblvUserStory().setInput(DAOProduct.getLesUserstoriesAFaire());
				vAddUserStorie.getGrpUserstory().setVisible(false);
				vAddUserStorie.getGrpParametreUserstory().setVisible(false);
				vAddUserStorie.getGrpChangementDtat().setVisible(false);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		//Bouton Done permettant de mettre une UserStory √† Done
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
				vAddUserStorie.getTblvUserStory().setInput(DAOProduct.getLesUserstoriesAFaire());
				vAddUserStorie.getTblvDone().setInput(DAOProduct.getLesUserstoriesFinies());
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
						vAddUserStorie.getTblvUserStory().setInput(DAOProduct.getLesUserstoriesAFaire());
						vAddUserStorie.getTblvInProgress().setInput(DAOProduct.getLesUserstoriesEnCours());
						vAddUserStorie.getGrpUserstory().setVisible(false);
						vAddUserStorie.getGrpParametreUserstory().setVisible(false);
						vAddUserStorie.getGrpChangementDtat().setVisible(false);
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
		
		//Bouton Valider permet de valider la UserStory √† ajouter
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
				
				vAddUserStorie.getTblvUserStory().setInput(DAOProduct.getLesUserstoriesAFaire());
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
		// Bouton affectation d'un collaborateur ‡ une UserStory
		vAddUserStorie.getBtnAdd().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				StructuredSelection selectCollab = (StructuredSelection) vAddUserStorie.getCbvAffectationCollab().getSelection();
				Collaborator selectedCollaborator = (Collaborator) selectCollab.getFirstElement();
				
				StructuredSelection select = (StructuredSelection) vAddUserStorie.getTblvUserStory().getSelection();
				Userstory selectaz = (Userstory) select.getFirstElement();
				
				if (selectedCollaborator != null) {

					Integer idCollaborator = selectedCollaborator.getId();
					Integer idUserStory = selectaz.getId();
					RealizeId realizeId = new RealizeId(idCollaborator, idUserStory);
					Session session = AppController.session;
					Transaction trans = session.beginTransaction();
					
					Userstory userStory =(Userstory) AppController.session.get(Userstory.class, idUserStory);
					trans.commit();
					Realize realize = new Realize(realizeId, userStory, selectedCollaborator);
					Transaction transRealize = session.beginTransaction();
					session.persist(realize);
					transRealize.commit();
				}else{
					String firstname = "Aucun collaborateur";
					Collaborator collaborator = new Collaborator(firstname);
					DAOCollaborator.getCollaborators().add(collaborator);
					vAddUserStorie.getCbAffectationCollab().setText(firstname);
				}
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
		vAddUserStorie.getTblvInProgress().setInput(DAOProduct.getLesUserstoriesEnCours());
	
		vAddUserStorie.getCbvSprintInProgress().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvSprintInProgress().setInput(getSprint());
		
		vAddUserStorie.getCbvProjetInProgress().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvProjetInProgress().setInput(getProduct());
		
		//Charge les √©l√©ments de la ligne s√©lectionn√© dans le tableau
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
		
		//Bouton permettant de passer la UserStory √† l'Ètat cloturÈ (Done)
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
				vAddUserStorie.getTblvInProgress().setInput(DAOProduct.getLesUserstoriesEnCours());
				vAddUserStorie.getTblvDone().setInput(DAOProduct.getLesUserstoriesFinies());
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
		vAddUserStorie.getTblvDone().setInput(DAOProduct.getLesUserstoriesFinies());
		
		vAddUserStorie.getCbvSprintDone().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvSprintDone().setInput(getSprint());
		
		vAddUserStorie.getCbvProjetDone().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getCbvProjetDone().setInput(getProduct());
		
		//Charge les ÈlÈments de la ligne sÈlectionnÈe
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
	
	private List<Product> getProduct() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Product");
		List<Product> lesproducts = query.list();
		return lesproducts;
	}
	
	private List<Sprint> getSprint() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Sprint WHERE idProduct="+ ProductController.getSelectedProduct().getId());
		List<Sprint> lessprints = query.list();
		return lessprints;
	}
}
