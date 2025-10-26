package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public Button btnLogin;

    Stage stage = new Stage();

    public void btnLoginOnAction(ActionEvent actionEvent) {
        String userName = txtUsername.getText();

        String passWord = txtPassword.getText();

        if ("Admin".equals(userName) && "123".equals((passWord))){
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setTitle("DashBoard");

            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.show();
        }else {
            System.out.println("Invalid user");

            //Alert box
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid user");
            alert.setContentText("Please Enter valid user name and password");
            alert.showAndWait();

            txtUsername.setText("");
            txtPassword.setText("");
        }
    }
}
