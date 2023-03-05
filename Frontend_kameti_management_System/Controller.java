package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller implements Initializable{
	@FXML private Button SignUpButton;
	@FXML private Button LoginButton;
	@FXML private Button LogOut;
	@FXML private Button minimize_button;
	@FXML private Button maximize_button;


	@FXML private Button OwnerProfileButton;
	@FXML private Button OwnerMembersButton;
	@FXML private Button OwnerPartyDetailsButton;
	@FXML private Button OwnerAddNewPartyButton;
	@FXML private Button OwnerPaymentButton;
	@FXML private Button OwnerCalendarButton;


	@FXML private AnchorPane AnchorProfile;
	@FXML private AnchorPane AnchorMember;
	@FXML private AnchorPane PaneMain = new AnchorPane();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Theme button =new Theme();
		SimpleBooleanProperty isOn=button.switchOnProperty();
		isOn.addListener((observable,oldValue,newValue)->{
		if(newValue) {
		button.getScene().getRoot().getStylesheets().add(getClass().getResource("application.css").toString());

		}
		else
		{
		button.getScene().getRoot().getStylesheets().remove(getClass().getResource("application.css").toString());
		}
		});
		PaneMain.getChildren().add(button);
	}
	
	@FXML
	// When user click on the cross in the Login page
	public void RedExit(ActionEvent event) {
		int response=JOptionPane.showConfirmDialog(null, "Do you want to Exit","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if (response==JOptionPane.YES_OPTION)
		{
			Platform.exit();
			System.exit(0);
		}
	}

	@FXML
	// When user click on the cross in the Login page
	public void YellowMaximize(ActionEvent event) {
		Stage stage = (Stage) maximize_button.getScene().getWindow();
		if(stage.isMaximized()) {
			stage.setMaximized(false);	
		}
		else {
			stage.setMaximized(true);	
		}
	}

	@FXML
	// When user click on the cross in the Login page
	public void GreenMinimize(ActionEvent event) {
		Stage stage = (Stage) minimize_button.getScene().getWindow();
		stage.setIconified(true);
	}



	@FXML
	void GoToOwnerORMemberPage(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("OwnerORMember.fxml"));
			Scene scene =  new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("Java fx Project");
			stage.show();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You are in OwnerORMember page");
	}

	@FXML
	void GoToSignUpPage(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
			Scene scene =  new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("Java fx Project");
			stage.show();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You are in SignUp page");
	}

	@FXML
	void GoToLoginAsMember(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("LoginAsMember.fxml"));
			Scene scene =  new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("Java fx Project");
			stage.show();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You are in LoginAsMember page");
	}

	@FXML
	void GoToLoginAsOwner(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("LoginAsOwner.fxml"));
			Scene scene =  new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("Java fx Project");
			stage.show();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You are in LoginAsOwner page");
	}

	@FXML
	void GoToOwnerHomePage(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("OwnerHomePage.fxml"));
			Scene scene =  new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("Java fx Project");
			stage.show();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You are in HomePage page");
	}

	@FXML
	void GoToMemberHomePage(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("MemberHomePage.fxml"));
			Scene scene =  new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("Java fx Project");
			stage.show();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You are in HomePage page");
	}

	@FXML
	void OwnerTabButtons(ActionEvent event) {
		if (event.getSource() == OwnerProfileButton) {
			AnchorProfile.toFront();
		}
		else if (event.getSource() == OwnerMembersButton) {
			AnchorMember.toFront();
		}
		else if (event.getSource() == OwnerPartyDetailsButton) {
			//PaneMain.toFront();
		}

		else if (event.getSource() == OwnerPartyDetailsButton) {

		}
		else if (event.getSource() == OwnerPaymentButton) {

		}
		else if (event.getSource() == OwnerCalendarButton) {

		}
	}

}
