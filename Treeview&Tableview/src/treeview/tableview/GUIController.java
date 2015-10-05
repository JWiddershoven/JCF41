/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeview.tableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private TextField tbFirstname;
    @FXML
    private TextField tbLastname;
    @FXML
    private TextField tbDepartmentName;

    private TreeItem<Department> rootItem;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootItem = new TreeItem<>(new Department("Departments"));
        rootItem.setExpanded(true);
        treeViewDepartments.setRoot(rootItem);
    }

    public void createNewDepartment() {
        if (tbDepartmentName.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Vul een department name in.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (treeViewDepartments.getSelectionModel().getSelectedItem() == null) 
        {
             Department newDepartment = new Department(tbDepartmentName.getText());
             TreeItem<Department> newItem = new TreeItem<>(newDepartment);
             newItem.setExpanded(true);
             rootItem.getChildren().add(newItem);
        }
        else 
        {
            TreeItem<Department> selectedItem = (TreeItem<Department>) treeViewDepartments.getSelectionModel().getSelectedItem();
            TreeItem<Department> newItem = new TreeItem<>(new Department(tbDepartmentName.getText()));
            newItem.setExpanded(true);
            selectedItem.getChildren().add(newItem); 
        }
    }
    
    public void addNewEmployee()
    {
        if (tbFirstname.getText().isEmpty() || tbLastname.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Vul een firstname en lastname in.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (treeViewDepartments.getSelectionModel().getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(null, "Selecteer een department.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }        
        Employee emp = new Employee(tbFirstname.getText(), tbLastname.getText());
        TreeItem<Department> selectedItem = (TreeItem<Department>) treeViewDepartments.getSelectionModel().getSelectedItem();
        selectedItem.getValue().addEmployee(emp);
    }

}
