package net.controller;

import net.models.Sprint;
import net.technics.DAOProduct;
import net.vues.VAddUserStorie;
import net.vues.VOverview;
import net.vues.VSprint;

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

		vOverview.getBtnSprintRecent().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				VSprint vSprint = new VSprint();
				new AppController(vSprint);
				vSprint.open();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		vOverview.getLblUserstory().setText("Userstory du projet");
		vOverview.getTableSprintRecent().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vOverview.getLblUserstory().setText("Userstory du sprint");
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
