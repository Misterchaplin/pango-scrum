package net.controller;

import net.models.Sprint;
import net.models.Userstory;
import net.technics.DAOProduct;
import net.vues.VAddUserStorie;
import net.vues.VOverview;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class OverviewController implements SelectionListener {
	private VOverview vOverview;

	public OverviewController(VOverview vOverview) {
		this.vOverview = vOverview;
	}

	public void init() {

		vOverview.getBtnToDo().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				VAddUserStorie vAddUserStorie = new VAddUserStorie();
				new AppController(vAddUserStorie);

				vAddUserStorie.getTbfProductBacklog().setSelection(0);
				vAddUserStorie.open();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		vOverview.getBtnProgress().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				VAddUserStorie vAddUserStorie = new VAddUserStorie();
				new AppController(vAddUserStorie);

				vAddUserStorie.getTbfProductBacklog().setSelection(1);
				vAddUserStorie.open();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		vOverview.getBtnDone().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				VAddUserStorie vAddUserStorie = new VAddUserStorie();
				new AppController(vAddUserStorie);

				vAddUserStorie.getTbfProductBacklog().setSelection(2);
				vAddUserStorie.open();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		vOverview.getTableSprintRecent().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				StructuredSelection selection = (StructuredSelection) vOverview.getTableVOverview().getSelection();
				Sprint activeSprint = (Sprint) selection.getFirstElement();

				vOverview.getTableViewer().setInput(DAOProduct.getLesUserstoriesAFaireDeSprint(activeSprint.getId()));
				vOverview.getTableViewer2().setInput(DAOProduct.getLesUserstoriesEnCoursDeSprint(activeSprint.getId()));
				vOverview.getTableViewer3().setInput(DAOProduct.getLesUserstoriesFaitDeSprint(activeSprint.getId()));
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		vOverview.getTableToDo().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				StructuredSelection selection = (StructuredSelection) vOverview.getTvToDo().getSelection();
				Userstory activeUserstoies = (Userstory) selection.getFirstElement();

				vOverview.getTextNom().setText(activeUserstoies.getLabel());
				vOverview.getTextDescription().setText(activeUserstoies.getDescription());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		vOverview.getTableInProgress().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				StructuredSelection selection = (StructuredSelection) vOverview.getTvInProgress().getSelection();
				Userstory activeUserstoies = (Userstory) selection.getFirstElement();

				vOverview.getTextNom().setText(activeUserstoies.getLabel());
				vOverview.getTextDescription().setText(activeUserstoies.getDescription());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		vOverview.getTableDone().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				StructuredSelection selection = (StructuredSelection) vOverview.getTvDone().getSelection();
				Userstory activeUserstoies = (Userstory) selection.getFirstElement();

				vOverview.getTextNom().setText(activeUserstoies.getLabel());
				vOverview.getTextDescription().setText(activeUserstoies.getDescription());
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
}
