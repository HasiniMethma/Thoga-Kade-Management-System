package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    Stage stage=new Stage();
    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPasswordField;

    @FXML
    void btnOnActionLogin(ActionEvent event) throws IOException {

        String name="Admin";
        String password="123";

        String username=txtUsername.getText();
        String userPassword=txtPasswordField.getText();

        if(name.equals(username) &&  password.equals(userPassword)){
            System.out.println("Hello, Welcome to Our Page");

            try{
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"))));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            stage.show();
        }else{
            System.out.println("Sorry, Your Password is Incorrect");
            System.out.println("Please, Try Again");
            txtUsername.setText("");
            txtPasswordField.setText("");

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid User");
            alert.setContentText("Please enter valid username and password");
            alert.showAndWait();
        }
    }


}
