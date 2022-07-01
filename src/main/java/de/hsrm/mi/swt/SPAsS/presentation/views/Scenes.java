package de.hsrm.mi.swt.SPAsS.presentation.views;

public enum Scenes {
	MAIN_VIEW, START_VIEW, UPLOAD_CURRICULUM_VIEW, UPLOAD_PLAN_VIEW, MODULE_INFORMATION_VIEW, SETTINGS_VIEW, SELECT_VIEW, EXAM_VIEW;

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
