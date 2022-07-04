package de.hsrm.mi.swt.SPAsS.business.planManagement;


import javafx.scene.paint.Color;
/**
 * enumeration of categories. Represent which category a module is allocated to.
 * A fitting name and color is assigned to each entry
 */
public enum CategoryEnum{

	INFORMATIK(Color.AZURE, "Informatik"), GESTALTUNG(Color.CHOCOLATE, "Gestaltung"), WIRTSCHAFT (Color.YELLOW, "Wirtschaft"), KLAUSUR(Color.MOCCASIN, "Klausur"), SONSTIGES(Color.LIGHTCORAL, "Sonstiges"), MATHE(Color.DARKBLUE, "Mathematik"), INFORMATIK_UND_GESTALTUNG(Color.INDIANRED, "Informatik und Gestaltung");
	
	Color color;
	String name;
	
	private CategoryEnum(Color color, String name) {
		this.color = color;
		this.name = name;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	
	
}
