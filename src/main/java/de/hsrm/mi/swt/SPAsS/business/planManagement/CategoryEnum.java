package de.hsrm.mi.swt.SPAsS.business.planManagement;


import javafx.scene.paint.Color;

public enum CategoryEnum{

	INFORMATIK(Color.AZURE), GESTALTUNG(Color.CHOCOLATE), WIRTSCHAFT (Color.YELLOW), KLAUSUR(Color.MOCCASIN), SONSTIGES(Color.LIGHTCORAL), MATHE(Color.DARKBLUE), INFORMATIK_UND_GESTALTUNG(Color.INDIANRED);
	
	Color color;
	
	private CategoryEnum(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
}
