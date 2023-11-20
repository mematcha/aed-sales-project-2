/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Personnel;

import TheBusiness.OrderManagement.Order;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmployeeProfile extends Profile {

    ArrayList<Order> employeeorders;

    public EmployeeProfile(Person p) {

        super(p); 
        employeeorders = new ArrayList();

    }
     public void addEmployeeorders(Order o){
        employeeorders.add(o);
    }
    @Override
    public String getRole(){
        return  "Admin";
    }

}