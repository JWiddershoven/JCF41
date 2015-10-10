/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeview.tableview;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Jelle
 */
public class GUIController implements Initializable {

    @FXML
    private TreeView treeViewDepartments;
    @FXML
    private TableView tableViewEmployees;

    @FXML
    private TableColumn tcFirstname;
    @FXML
    private TableColumn tcLastname;
    @FXML
    private TextField tbFirstname;
    @FXML
    private TextField tbLastname;
    @FXML
    private TextField tbDepartmentName;

    private TreeItem<Department> rootItem;

    private ObservableList<TreeItem<Department>> observableDepartments;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootItem = new TreeItem<>(new Department("Departments"));
        rootItem.setExpanded(true);
        treeViewDepartments.setRoot(rootItem);

        tcFirstname.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstname"));
        tcLastname.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastname"));

//        ObservableList<Employee> data = FXCollections.observableArrayList(
//              new Employee("Jelle", "Widdershoven"),
//              new Employee("Jordy", "Guzak")
//        );
//        
//        tableViewEmployees.setItems(data);
        ArrayList<TreeItem<Department>> departments = new ArrayList<>();
        observableDepartments = FXCollections.observableArrayList(departments);
        observableDepartments.addListener(new ListChangeListener<TreeItem<Department>>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends TreeItem<Department>> c) {
                if (treeViewDepartments.getSelectionModel().getSelectedItem() == null) {
                    rootItem.getChildren().setAll(observableDepartments);
                } else {
                    TreeItem<Department> selectedItem = (TreeItem<Department>) treeViewDepartments.getSelectionModel().getSelectedItem();
                    selectedItem.getChildren().add(c.getList().get(c.getList().size() - 1));
                }
            }
        });
    }

    public void updateTableView() {
        tableViewEmployees.getItems().clear();
        TreeItem<Department> selectedDep = (TreeItem<Department>) treeViewDepartments.getSelectionModel().getSelectedItem();
        System.out.println(selectedDep.getValue().getEmployees().size());
        if (selectedDep.getValue().getEmployees().size() > 0) {
            tableViewEmployees.setItems((ObservableList) selectedDep.getValue().getEmployees());
        }
    }

    public void createNewDepartment() {
        if (tbDepartmentName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vul een department name in.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        TreeItem<Department> newItem = new TreeItem<>(new Department(tbDepartmentName.getText()));
        newItem.setExpanded(true);
        observableDepartments.add(newItem);
    }

    public void addNewEmployee() {
        if (tbFirstname.getText().isEmpty() || tbLastname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vul een firstname en lastname in.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (treeViewDepartments.getSelectionModel().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Selecteer een department.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Employee emp = new Employee(tbFirstname.getText(), tbLastname.getText());
        TreeItem<Department> selectedItem = (TreeItem<Department>) treeViewDepartments.getSelectionModel().getSelectedItem();
        selectedItem.getValue().addEmployee(emp);
        updateTableView();
    }

}
