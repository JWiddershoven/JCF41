/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeview.tableview;

/**
 *
 * @author Jelle
 */
public class Employee {
    
    private String firstname;
    private String lastname;
    
    public Employee(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public String getFirstname()
    {
        return this.firstname;
    }
    
    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }
    
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }
    
    public String getLastname()
    {
        return this.lastname;
    } 
}
