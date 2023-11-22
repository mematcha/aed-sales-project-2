/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheBusiness.Business;

import TheBusiness.OrderManagement.Order;
import java.util.Comparator;

public class OrderTotalComparator implements Comparator<Order> {
    @Override
    public int compare(Order order1, Order order2) {
        // Compare based on getOrderTotal() values
        return Integer.compare(order1.getOrderTotal(), order2.getOrderTotal());
    }
}
