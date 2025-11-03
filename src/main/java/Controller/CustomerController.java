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
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<CustomerInforDTO> tblCustomerinfo1;

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
        String id=txtID.getText();
        String title=txtTitle.getText();
        String name=txtName.getText();
        String dob=txtDOB.getText();
        Double salary= Double.valueOf(txtSalary.getText());
        String address=txtAddress.getText();
        String city=txtCity.getText();
        String province=txtProvince.getText();
        String postalCode=txtPostalCode.getText();

        CustomerInforDTO customerInfoDTO=new CustomerInforDTO(id,title,name,dob,salary,address,city,province,postalCode);
        customerInforDTO.add(customerInfoDTO);

        tblCustomerinfo1.refresh();

        txtID.setText("");
        txtTitle.setText("");
        txtName.setText("");
        txtDOB.setText("");
        txtSalary.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtProvince.setText("");
        txtPostalCode.setText("");
    }

    @FXML
    void btnOnActionClear(ActionEvent event) {
       txtID.setText("");
       txtTitle.setText("");
       txtName.setText("");
       txtDOB.setText("");
       txtSalary.setText("");
       txtAddress.setText("");
       txtCity.setText("");
       txtProvince.setText("");
       txtPostalCode.setText("");
    }


    @FXML
    void btnOnActionDelete(ActionEvent event) {
        CustomerInforDTO selectedItem=tblCustomerinfo1.getSelectionModel().getSelectedItem();
        customerInforDTO.remove(selectedItem);

        tblCustomerinfo1.refresh();

        txtID.setText("");
        txtTitle.setText("");
        txtName.setText("");
        txtDOB.setText("");
        txtSalary.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtProvince.setText("");
        txtPostalCode.setText("");

    }

    @FXML
    void btnOnActionUpdate(ActionEvent event) {
        CustomerInforDTO selectedItem=tblCustomerinfo1.getSelectionModel().getSelectedItem();

        selectedItem.setId(txtID.getText());
        selectedItem.setTitle(txtTitle.getText());
        selectedItem.setName(txtName.getText());
        selectedItem.setDob(txtDOB.getText());
        selectedItem.setSalary(Double.valueOf(txtSalary.getText()));
        selectedItem.setAddress(txtAddress.getText());
        selectedItem.setCity(txtCity.getText());
        selectedItem.setProvince(txtProvince.getText());
        selectedItem.setPostalCode(txtPostalCode.getText());

        tblCustomerinfo1.refresh();

        txtID.setText("");
        txtTitle.setText("");
        txtName.setText("");
        txtDOB.setText("");
        txtSalary.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtProvince.setText("");
        txtPostalCode.setText("");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCusId1.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle1.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName1.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB1.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary1.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity1.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince1.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode1.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        tblCustomerinfo1.setItems(customerInforDTO);

        //Autofill txt field
        tblCustomerinfo1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            if(newValue != null){
                txtID.setText(newValue.getId());
                txtTitle.setText(newValue.getTitle());
                txtName.setText(newValue.getName());
                txtDOB.setText(newValue.getDob());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                txtProvince.setText(newValue.getProvince());
                txtPostalCode.setText(newValue.getPostalCode());
            }
        });
    }
}
