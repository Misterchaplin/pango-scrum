package net.controller;

import net.vues.VLogin;

public class Prog {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VLogin vLogin = new VLogin();
			new AppController(vLogin);
			vLogin.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
