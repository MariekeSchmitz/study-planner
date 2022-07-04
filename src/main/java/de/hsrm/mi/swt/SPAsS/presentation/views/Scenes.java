package de.hsrm.mi.swt.SPAsS.presentation.views;

/**
 * enumeration of all Scenes
 */
public enum Scenes {
	MAIN_VIEW, START_VIEW, UPLOAD_CURRICULUM_VIEW, UPLOAD_PLAN_VIEW, MODULE_INFORMATION_VIEW, SETTINGS_VIEW, SELECT_VIEW, EXAM_VIEW;

	/**
 	* true -> Scene is currently shown
	* false -> Scene is currently not shown
 	*/
	boolean in = false;
	
	private Scenes () {
		this.in = false;
	}
	
	public boolean isIn() {
		return in;
	}
	
	public void setIn(boolean in) {
		this.in = in;
	}

}
