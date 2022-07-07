package de.hsrm.mi.swt.SPAsS.presentation.views.loadingView;

import java.io.File;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class LoadingView extends BorderPane{

	private ImageView logoText;
	private ImageView logoPic;
	
	public LoadingView() {
		
		StackPane logoStack = new StackPane();
		this.setCenter(logoStack);
		
		logoText = new ImageView(File.separator + "images" + File.separator + "logoSchrift.png");
		logoText.setPreserveRatio(true);
		logoText.setFitWidth(300);
		
		logoPic = new ImageView(File.separator + "images" + File.separator + "logoNurBild.png");
		logoPic.setPreserveRatio(true);
		logoPic.setFitWidth(300);
		
		logoStack.getChildren().addAll(logoText, logoPic);

	}

	public ImageView getLogoText() {
		return logoText;
	}

	public void setLogoText(ImageView logoText) {
		this.logoText = logoText;
	}

	public ImageView getLogoPic() {
		return logoPic;
	}

	public void setLogoPic(ImageView logoPic) {
		this.logoPic = logoPic;
	}
	
	
}