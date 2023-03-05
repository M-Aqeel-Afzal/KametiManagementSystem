package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	double x,y;
	@Override
	public void start(Stage stage) {	
		try {
			Parent root = FXMLLoader.load(getClass().getResource("OwnerORMember.fxml"));
			Scene scene =  new Scene(root);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setResizable(true);
			root.setOnMousePressed(evt->{
				x = evt.getSceneX();
				y = evt.getSceneY();
			});
			
			root.setOnMouseDragged(evt->{
				stage.setX(evt.getScreenX() - x);
				stage.setY(evt.getScreenY() - y);
			});



			stage.setScene(scene);
			stage.setTitle("Java fx Project");
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
