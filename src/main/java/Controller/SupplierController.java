package Controller;

import Model.dto.SupplierInforDTO;
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

public class SupplierController implements Initializable {
    ObservableList<SupplierInforDTO> supplierInforDTOS = FXCollections.observableArrayList(
            new SupplierInforDTO("S001","Fernando","Agro Foods Pvt Ltd","No.45 Main Street","Matara","Southern","81000","0712345678","agrofoods@gmail.com"),
            new SupplierInforDTO("S002","Karunarathna","Ceylon Biscuits Pvt Ltd","Main Street","Colombo","Western","25600","0702474384","ceylonbiscuits@gmail.com"),
            new SupplierInforDTO("S003","Jayarathna","Medicine Pvt Ltd","Maliban Street","Colombo","Western","25600","0718623686","medicine@gmail.com"),
            new SupplierInforDTO("S004","Perera","Lanka Rice Pvt Ltd","Hospital Road","Dambulla","Central","21200","0778998082","lankarice@gmail.com"),
            new SupplierInforDTO("S005","Somarathna","Fresh Meals Pvt Ltd","No.55 Main Street","Kandy","Central","21300","0716991817","freshmeals@gmail.com")

    );

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCompanyName;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private TableView<SupplierInforDTO> tblSupplierinfo;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    void btnOnActionAdd(ActionEvent event) {
        String id=txtID.getText();
        String name=txtName.getText();
        String companyName=txtCompanyName.getText();
        String address=txtAddress.getText();
        String city= txtCity.getText();
        String province=txtProvince.getText();
        String postalCode=txtPostalCode.getText();
        String phone=txtPhone.getText();
        String email=txtEmail.getText();

        SupplierInforDTO supplierInfoDTO=new SupplierInforDTO(id,name,companyName,address,city,province,postalCode,phone,email);
        supplierInforDTOS.add(supplierInfoDTO);

        tblSupplierinfo.refresh();

        txtID.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtProvince.setText("");
        txtPostalCode.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }

    @FXML
    void btnOnActionClear(ActionEvent event) {
        txtID.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtProvince.setText("");
        txtPostalCode.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }

    @FXML
    void btnOnActionDelete(ActionEvent event) {
        SupplierInforDTO selectedItem=tblSupplierinfo.getSelectionModel().getSelectedItem();
        supplierInforDTOS.remove(selectedItem);

        tblSupplierinfo.refresh();

        txtID.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtProvince.setText("");
        txtPostalCode.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }

    @FXML
    void btnOnActionUpdate(ActionEvent event) {
        SupplierInforDTO selectedItem=tblSupplierinfo.getSelectionModel().getSelectedItem();

        selectedItem.setId(txtID.getText());
        selectedItem.setName(txtName.getText());
        selectedItem.setCompanyName(txtCompanyName.getText());
        selectedItem.setAddress(txtAddress.getText());
        selectedItem.setCity(txtCity.getText());
        selectedItem.setProvince(txtProvince.getText());
        selectedItem.setPostalCode(txtPostalCode.getText());
        selectedItem.setPhone(txtPhone.getText());
        selectedItem.setEmail(txtEmail.getText());

        tblSupplierinfo.refresh();

        txtID.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtProvince.setText("");
        txtPostalCode.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblSupplierinfo.setItems(supplierInforDTOS);

        tblSupplierinfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            if(newValue != null){
                txtID.setText(newValue.getId());
                txtName.setText(newValue.getName());
                txtCompanyName.setText(newValue.getCompanyName());
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(String.valueOf(newValue.getCity()));
                txtProvince.setText(newValue.getProvince());
                txtPostalCode.setText(newValue.getPostalCode());
                txtPhone.setText(newValue.getPhone());
                txtEmail.setText(newValue.getEmail());
            }
        });
    }
}
