package net.controller;

import net.vues.VAddUserStorie;
import net.vues.VOverview;
import net.vues.VSprint;

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
				vAddUserStorie.open();
				// vAddUserStorie.getTbfProductBacklog().setSelection(vAddUserStorie.getTbtmInProgress());

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
				vAddUserStorie.open();
				vAddUserStorie.getTbfProductBacklog().setSelection(2);

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
