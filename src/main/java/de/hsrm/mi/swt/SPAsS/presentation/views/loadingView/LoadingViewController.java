package de.hsrm.mi.swt.SPAsS.presentation.views.loadingView;


import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class LoadingViewController extends ViewController{

	private LoadingView loadingView;
	private ImageView logoText;
	private ImageView logoPic;
	private ViewManager viewmanager;
	
	public LoadingViewController(ViewManager viewmanager) {
		
		this.viewmanager = viewmanager;
		
		loadingView = new LoadingView();
		rootView = loadingView;
		
		logoText = loadingView.getLogoText();
		logoPic = loadingView.getLogoPic();
		
		loadingView.setStyle("-fx-background-color: white");
		
		initialise();
		
	}
	
	
	@Override
	public void initialise() {
		startRotation();
	}
	
	
	public void startRotation() {
		

		FadeTransition fade = new FadeTransition();
		fade.setFromValue(1.0);
		fade.setToValue(1.0);
		fade.setCycleCount(1);
		fade.setDuration(Duration.millis(7000));
		fade.setNode(loadingView);
		
		RotateTransition rot = new RotateTransition();
		rot.setNode(logoText);
		rot.setDuration(Duration.millis(5000));
		
		rot.setByAngle(2160);
		rot.setCycleCount(1);
		rot.setAutoReverse(true);
		
		rot.setInterpolator(Interpolator.EASE_OUT);
	 
		RotateTransition rotPic = new RotateTransition();
		rotPic.setNode(logoPic);
		rotPic.setDuration(Duration.millis(5000));
		
		rotPic.setByAngle(-2160);
		rotPic.setCycleCount(1);
		rotPic.setAutoReverse(true);
		
		rotPic.setInterpolator(Interpolator.EASE_OUT);
		
		ParallelTransition parallel = new ParallelTransition();
		parallel.getChildren().addAll(rot, rotPic, fade);
		parallel.playFromStart();
		
		parallel.setOnFinished(e -> startTransitionMax());
		
	}
	
	public void startTransitionMax() {
		ScaleTransition scaleText = new ScaleTransition();
		scaleText.setToX(1.2);
		scaleText.setToY(1.2);
		scaleText.setNode(logoText);
		scaleText.setCycleCount(1);
		scaleText.setDuration(Duration.seconds(0.1));
		scaleText.setInterpolator(Interpolator.EASE_BOTH);
		
		ScaleTransition scale = new ScaleTransition();
		scale.setToX(1.2);
		scale.setToY(1.2);
		scale.setNode(logoPic);
		scale.setCycleCount(1);
		scale.setDuration(Duration.seconds(0.1));
		scale.setInterpolator(Interpolator.EASE_BOTH);
		
		ParallelTransition parallel = new ParallelTransition();
		parallel.getChildren().addAll(scaleText, scale);
		parallel.playFromStart();
		
		parallel.setOnFinished(e -> startTransition());
		
	}
	
	
	public void startTransition() {

		
		ScaleTransition scaleText = new ScaleTransition();
		scaleText.setToX(0);
		scaleText.setToY(0);
		scaleText.setNode(logoText);
		scaleText.setCycleCount(1);
		scaleText.setDuration(Duration.seconds(0.5));
		scaleText.setInterpolator(Interpolator.EASE_BOTH);
		
		ScaleTransition scale = new ScaleTransition();
		scale.setToX(0);
		scale.setToY(0);
		scale.setNode(logoPic);
		scale.setCycleCount(1);
		scale.setDuration(Duration.seconds(0.5));
		scale.setInterpolator(Interpolator.EASE_BOTH);
		
		FadeTransition fade = new FadeTransition();
		fade.setFromValue(1.0);
		fade.setToValue(0);
		fade.setCycleCount(1);
		fade.setDuration(Duration.seconds(0.5));
		fade.setInterpolator(Interpolator.EASE_IN);
		fade.setNode(loadingView);
	
		
		ParallelTransition parallel = new ParallelTransition();
		parallel.getChildren().addAll(fade,scaleText,scale);
		parallel.playFromStart();
		
		parallel.setOnFinished(e -> transitionToStart());
		
		
	}
	
	public void transitionToStart() {
		
		viewmanager.switchScene(Scenes.START_VIEW);

	}


}
