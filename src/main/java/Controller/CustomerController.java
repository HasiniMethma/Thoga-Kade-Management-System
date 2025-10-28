package Controller;

import Model.dto.CustomerInforDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    ObservableList<CustomerInforDTO> customerInforDTO = FXCollections.observableArrayList(
            new CustomerInforDTO("C001","Mr.","Raveen","1993-05-16",56000.00,"537/B,Pathkolagolla","Galewela","Central","21200"),
            new CustomerInforDTO("C002","Mrs.","Ravindi","1998-06-06",48000.00,"No.02,Diyagama","Homagama","Western","25600"),
            new CustomerInforDTO("C003","Mrs.","Limasha","1996-08-20",89000.00,"537/B,No.01 road","Panadura","Western","25600"),
            new CustomerInforDTO("C004","Miss.","Naduni","2002-05-17",63000.00,"Jinasiri Mawatha","Moratuwa","Western","25600"),
            new CustomerInforDTO("C005","Mr.","Sadiw","2004-10-21",75500.00,"Dharmapala Mawatha","Galewela","Cental","21200")

    );

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colAddress1;

    @FXML
    private TableColumn<?, ?> colCity1;

    @FXML
    private TableColumn<?, ?> colCusId1;

    @FXML
    private TableColumn<?, ?> colDOB1;

    @FXML
    private TableColumn<?, ?> colName1;

    @FXML
    private TableColumn<?, ?> colPostalCode1;

    @FXML
    private TableColumn<?, ?> colProvince1;

    @FXML
    private TableColumn<?, ?> colSalary1;

    @FXML
    private TableColumn<?, ?> colTitle1;

    @FXML
    private TableView<?> tblCustomerinfo1;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

    @FXML
    void btnOnActionAdd(ActionEvent event) {

    }

    @FXML
    void btnOnActionClear(ActionEvent event) {

    }

    @FXML
    void btnOnActionDelete(ActionEvent event) {

    }

    @FXML
    void btnOnActionUpdate(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
