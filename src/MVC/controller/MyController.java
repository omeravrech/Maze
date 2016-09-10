package MVC.controller;

import MVC.model.Model;
import MVC.view.View;

public class MyController implements Controller 
{
	private Model modular;
	private View viewer;
	
	
	public MyController() {
		this.modular = null;
		this.viewer = null;
	}


	public Model getModular() {
		return modular;
	}


	public void setModular(Model modular) {
		this.modular = modular;
	}


	public View getViewer() {
		return viewer;
	}


	public void setViewer(View viewer) {
		this.viewer = viewer;
	}
	
	
}
