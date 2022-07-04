package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileManager;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileType;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
/**
 * Reacts to import of Plan/Curriculum file via Drag and Drop
 */
public class DragDropViewController extends ViewController {

	private Button fileOpenButton;
	private DragDropView dragDropView;
	private App app;
	private FileManager fileManager;
	private ViewManager viewManager;
	private FileType fileType;

	public DragDropViewController(App app, FileType fileType) {

		this.app = app;
		this.fileManager = app.getFileManager();
		this.viewManager = app.getViewManager();
		this.fileType = fileType;
		dragDropView = new DragDropView();
		rootView = dragDropView;

		fileOpenButton = dragDropView.getFileOpen();

		initialise();

	}

	@Override
	public void initialise() {

		fileOpenButton.addEventHandler(ActionEvent.ACTION, e -> {

			FileChooser.ExtensionFilter fileFilter = new FileChooser.ExtensionFilter("JSON-Dateien", "*.json");
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().add(fileFilter);
			fileChooser.setTitle("Datei hochladen");
			File file = fileChooser.showOpenDialog(app.getPrimaryStage());
			String fileName = file.getName().substring(0, file.getName().lastIndexOf('.'));
			fileName.replace(" ", "-");

			try {

				if (fileType == FileType.CURRICULA) {
					importCurriculum(file);
				}

				else if (fileType == FileType.PLAN) {
					importPlan(file);
				}

				viewManager.switchScene(Scenes.MAIN_VIEW);

			} catch (IOException e1) {
				e1.printStackTrace();
			}

		});

		rootView.setOnDragOver(new EventHandler<DragEvent>() {

			public void handle(DragEvent event) {

				boolean dropSupported = true;
				boolean copySupported = true;

				Dragboard dragboard;
				Set<TransferMode> modes;

				dragboard = event.getDragboard();
				if (!dragboard.hasFiles())
					dropSupported = false;

				modes = dragboard.getTransferModes();
				for (TransferMode mode : modes)
					copySupported = (copySupported || TransferMode.COPY == mode);

				if (copySupported && dropSupported) {
					event.acceptTransferModes(TransferMode.COPY);
				}
				event.consume();
			}
		});

		rootView.setOnDragDropped(new EventHandler<DragEvent>() {

			public void handle(DragEvent event) {

				Dragboard dragboard = event.getDragboard();

				try {
					List<File> files = dragboard.getFiles();
					for (File file : files) {

						try {

							if (fileType == FileType.CURRICULA) {
								importCurriculum(file);
							}

							else if (fileType == FileType.PLAN) {
								importPlan(file);
							}

							viewManager.switchScene(Scenes.MAIN_VIEW);

						} catch (IOException e1) {
							e1.printStackTrace();
						}

					}
					event.setDropCompleted(true);
				} finally {
					event.consume();
				}
			}
		});

	}

	
	/** 
	 * @param file
	 * Takes curriculum-file and creates Plan-Object.
	 * Then saves plan as curriculum for future use
	 * 
	 */
	private void importCurriculum(File file) {
		Plan plan = fileManager.fileReadFromDirectory(file.getAbsolutePath());
		plan.planToDefaultPlan();
		app.setPlan(plan);

		fileManager.fileSave(FileType.CURRICULA, plan);
	}

	
	/** 
	 * @param file
	 * @throws IOException
	 * Takes Plan-file and creates Plan-Object.
	 * Then saves plan for future use.
	 * Also saves default version as curriculum.
	 */
	private void importPlan(File file) throws IOException {

		// Plan kopieren und in View
		Plan plan = fileManager.fileReadFromDirectory(file.getAbsolutePath());
		plan.initialize();
		app.setPlan(plan);
		fileManager.fileSave(FileType.PLAN, plan);
		fileManager.createMetaFile(FileType.PLAN, plan);

		// Kopie anlegen, Plan zurücksetzen und daraus Curriculumsdatei machen
		Plan planCopy = fileManager.fileReadFromDirectory(file.getAbsolutePath());
		planCopy.planToDefaultPlan();
		fileManager.fileSave(FileType.CURRICULA, planCopy);
	}

}
