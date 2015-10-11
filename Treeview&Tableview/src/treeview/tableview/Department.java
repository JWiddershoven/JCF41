/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeview.tableview;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeCell;

/**
 *
 * @author Jelle
 */
public class Department{
    
    private String name;
    private ArrayList<Employee> employees;
    private ObservableList<Employee> observEmployees;
    
    public Department(String name)
    {
        this.name = name;
        this.employees = new ArrayList<>();
        this.observEmployees = FXCollections.observableArrayList(employees);
    }
    
    public Department(String name, ObservableList<Employee> emps)
    {
        this.name = name;
        this.employees = new ArrayList<>();
        this.observEmployees = emps;
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
        this.observEmployees.add(e);
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
    
}
