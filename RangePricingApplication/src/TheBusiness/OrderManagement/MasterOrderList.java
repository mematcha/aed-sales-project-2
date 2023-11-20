/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.OrderManagement;

import java.util.ArrayList;
import TheBusiness.CustomerManagement.CustomerProfile;
import MarketingManagement.MarketingPersonProfile;
import TheBusiness.SalesManagement.SalesPersonProfile;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderList {
    private ArrayList<Order> orders;
    MasterOrderReport masterorderreport;
    
    public MasterOrderList(){
        orders = new ArrayList();
       
    }
    
    public Order newOrder(CustomerProfile cp){
        Order o= new Order(cp);
        getOrders().add(o);
        return o;
            
 
    }
    public Order newOrder(CustomerProfile cp, SalesPersonProfile spp,float commission){
        Order o = new Order(cp, spp, commission); // Update to match the new constructor with commission
        getOrders().add(o);
        return o;
            
 
    }
    
    public MasterOrderReport generateMasterOrderReport(){
    masterorderreport = new MasterOrderReport();
        
    return masterorderreport;
        
}

public int getSalesVolume(){

int sum = 0;
for(Order order: getOrders()){
    sum = sum + order.getOrderTotal();
}
return sum;
    }

    /**
     * @return the orders
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

}





























































































































