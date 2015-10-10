/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeview.tableview;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jelle
 */
public class Department {
    
    private String name;
    private ArrayList<Employee> employees;
    private ObservableList<Employee> observEmployees;
    
    public Department(String name)
    {
        this.name = name;
        employees = new ArrayList<>();
        observEmployees = FXCollections.observableArrayList(employees);
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public ObservableList<Employee> getEmployees()
    {
        return this.observEmployees;
    }
    
    public void addEmployee(Employee e)
    {
        observEmployees.add(e);
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
    
}
