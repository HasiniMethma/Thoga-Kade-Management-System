package Controller;

import Model.dto.ItemInforDTO;
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

public class ItemController implements Initializable {
    ObservableList<ItemInforDTO> itemInforDTOS = FXCollections.observableArrayList(
            new ItemInforDTO("I001","Red Rice 5kg","Groceries",40,1200.00),
            new ItemInforDTO("I002","Anchor F/C Milk powder 450g","Groceries",93,220.00),
            new ItemInforDTO("I003","Lipton Ceylon Tea 100g","Super Market",40,107.00),
            new ItemInforDTO("I004","Mysoor Dhal 1Kg","Groceries",59,180.00),
            new ItemInforDTO("I005","Milo Packet 400g","Super Market",33,560.00)
    );


    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colunitprice;

    @FXML
    private TableView<ItemInforDTO> tblIteminfo;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void btnOnActionAdd(ActionEvent event) {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        String category = txtCategory.getText();
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());

        ItemInforDTO itemInforDTO = new ItemInforDTO(code, description, category, qtyOnHand, unitPrice);
        itemInforDTOS.add(itemInforDTO);

        tblIteminfo.refresh();

        txtCode.setText("");
        txtDescription.setText("");
        txtCategory.setText("");
        txtQtyOnHand.setText("");
        txtUnitPrice.setText("");
    }

    @FXML
    void btnOnActionClear(ActionEvent event) {
        txtCode.setText("");
        txtDescription.setText("");
        txtCategory.setText("");
        txtQtyOnHand.setText("");
        txtUnitPrice.setText("");
    }

    @FXML
    void btnOnActionDelete(ActionEvent event) {
        ItemInforDTO selectedItem = tblIteminfo.getSelectionModel().getSelectedItem();
        itemInforDTOS.remove(selectedItem);

        tblIteminfo.refresh();

        txtCode.setText("");
        txtDescription.setText("");
        txtCategory.setText("");
        txtQtyOnHand.setText("");
        txtUnitPrice.setText("");
    }

    @FXML
    void btnOnActionUpdate(ActionEvent event) {
        ItemInforDTO selectedItem = tblIteminfo.getSelectionModel().getSelectedItem();

        selectedItem.setItemCode(txtCode.getText());
        selectedItem.setDescription(txtDescription.getText());
        selectedItem.setCategory(txtCategory.getText());
        selectedItem.setQtyOnHand(Integer.parseInt(txtQtyOnHand.getText()));
        selectedItem.setUnitPrice(Double.valueOf(txtUnitPrice.getText()));

        tblIteminfo.refresh();

        txtCode.setText("");
        txtDescription.setText("");
        txtCategory.setText("");
        txtQtyOnHand.setText("");
        txtUnitPrice.setText("");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colunitprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tblIteminfo.setItems(itemInforDTOS);

        tblIteminfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            if (newValue != null){
                txtCode.setText(newValue.getItemCode());
                txtDescription.setText(newValue.getDescription());
                txtCategory.setText(newValue.getCategory());
                txtQtyOnHand.setText(String.valueOf(newValue.getQtyOnHand()));
                txtUnitPrice.setText(String.valueOf(newValue.getUnitPrice()));
            }
        });
    }
}
