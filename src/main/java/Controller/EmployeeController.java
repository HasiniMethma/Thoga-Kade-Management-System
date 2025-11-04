package Controller;

import Model.dto.EmployeeInforDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {
    ObservableList<EmployeeInforDTO> employeeInforDTOS = FXCollections.observableArrayList(
            new EmployeeInforDTO("E001", "Sunil Perera", "2000450245789", "2000-05-10", "Manager", 75000.0, "0712456789", "No.15,Temple Road, Kalutara", "2018-05-10", "Active"),
            new EmployeeInforDTO("E002", "Kumara Fernando", "200463802280", "2004-07-12", "Assistant", 60000.0, "0702474789", "No.45,Main Road, Matara", "2019-07-21", "Active"),
            new EmployeeInforDTO("E003", "Raveen Karunarathna", "200452789569", "2004-10-30", "HR Manager", 79000.0, "0752456686", "Hospital Road, Matale", "2015-03-30", "Active"),
            new EmployeeInforDTO("E004", "Naduni Chamathka", "1987356413200", "1987-01-08", "Director", 90000.0, "0772456781", "Maliban Street, Colombo", "2020-08-02", "Active"),
            new EmployeeInforDTO("E005", "Vikum Wijerathne", "832451230V", "1983-07-12", "Section Head", 55000.0, "0702456784", "Ranabima Mawatha, Kaduwela", "2024-09-23", "Active")
    );

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colEmployeeID;

    @FXML
    private TableColumn<?, ?> colJoinedDate;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colPosition;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableView<EmployeeInforDTO> tblEmployeeinfo;

    @FXML
    private TextField txtAddress1;

    @FXML
    private TextField txtDOB1;

    @FXML
    private TextField txtID1;

    @FXML
    private TextField txtJoinedDate1;

    @FXML
    private TextField txtNIC1;

    @FXML
    private TextField txtName1;

    @FXML
    private TextField txtPhone1;

    @FXML
    private TextField txtPosition1;

    @FXML
    private TextField txtSalary1;

    @FXML
    private TextField txtStatus1;

    @FXML
    void btnOnActionAdd(ActionEvent event) {
        String id = txtID1.getText();
        String name = txtName1.getText();
        String nic = txtNIC1.getText();
        String dob = txtDOB1.getText();
        String position = txtPosition1.getText();
        Double salary = Double.valueOf(txtSalary1.getText());
        String phone = txtPhone1.getText();
        String address = txtAddress1.getText();
        String joinedDate = txtJoinedDate1.getText();
        String status = txtStatus1.getText();

        EmployeeInforDTO employeeInforDTO = new EmployeeInforDTO(id, name, nic, dob, position, salary, phone, address, joinedDate, status);
        employeeInforDTOS.add(employeeInforDTO);

        tblEmployeeinfo.refresh();

        txtID1.setText("");
        txtName1.setText("");
        txtNIC1.setText("");
        txtDOB1.setText("");
        txtPosition1.setText("");
        txtSalary1.setText("");
        txtPhone1.setText("");
        txtAddress1.setText("");
        txtJoinedDate1.setText("");
        txtStatus1.setText("");

    }

    @FXML
    void btnOnActionClear(ActionEvent event) {
        txtID1.setText("");
        txtName1.setText("");
        txtNIC1.setText("");
        txtDOB1.setText("");
        txtPosition1.setText("");
        txtSalary1.setText("");
        txtPhone1.setText("");
        txtAddress1.setText("");
        txtJoinedDate1.setText("");
        txtStatus1.setText("");
    }

    @FXML
    void btnOnActionDelete(ActionEvent event) {
        EmployeeInforDTO selectedItem = tblEmployeeinfo.getSelectionModel().getSelectedItem();
        employeeInforDTOS.remove(selectedItem);

        tblEmployeeinfo.refresh();

        txtID1.setText("");
        txtName1.setText("");
        txtNIC1.setText("");
        txtDOB1.setText("");
        txtPosition1.setText("");
        txtSalary1.setText("");
        txtPhone1.setText("");
        txtAddress1.setText("");
        txtJoinedDate1.setText("");
        txtStatus1.setText("");
    }

    @FXML
    void btnOnActionUpdate(ActionEvent event) {
        EmployeeInforDTO selectedItem = tblEmployeeinfo.getSelectionModel().getSelectedItem();
        selectedItem.setId(txtID1.getText());
        selectedItem.setName(txtName1.getText());
        selectedItem.setNic(txtNIC1.getText());
        selectedItem.setDob(txtDOB1.getText());
        selectedItem.setPosition(txtPosition1.getText());
        selectedItem.setSalary(Double.valueOf(txtSalary1.getText()));
        selectedItem.setPhone(txtPhone1.getText());
        selectedItem.setAddress(txtAddress1.getText());
        selectedItem.setJoinedDate(txtJoinedDate1.getText());
        selectedItem.setStatus(txtStatus1.getText());

        tblEmployeeinfo.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colEmployeeID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblEmployeeinfo.setItems(employeeInforDTOS);

        tblEmployeeinfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtID1.setText(newValue.getId());
                txtName1.setText(newValue.getName());
                txtNIC1.setText(newValue.getNic());
                txtDOB1.setText(newValue.getDob());
                txtPosition1.setText(newValue.getPosition());
                txtSalary1.setText(String.valueOf(newValue.getSalary()));
                txtPhone1.setText(newValue.getPhone());
                txtAddress1.setText(newValue.getAddress());
                txtJoinedDate1.setText(newValue.getJoinedDate());
                txtStatus1.setText(newValue.getStatus());
            }
        });
    }
}

