/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.OrderManagement;

import java.util.ArrayList;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductSummary;
import TheBusiness.SalesManagement.SalesPersonProfile;

/**
 *
 * @author kal bugrara
 */
public class Order {

    private ArrayList<OrderItem> orderitems;
    private CustomerProfile customer;
    private SalesPersonProfile salesperson;
    private MarketChannelAssignment mca;
    private String status;
    private ProductSummary productSummary;
    private static int count = 0;
    private int modelNumber;
    private float commission; // New attribute for commission

    public Order(){
         count++;
         modelNumber = count;
    }
    
    public Order(CustomerProfile cp) {
        orderitems = new ArrayList();
        customer = cp;
        customer.addCustomerOrder(this); //we link the order to the customer
        salesperson = null;
        status = "in process";
        count++;
        modelNumber = count;
    }
    public Order(CustomerProfile cp, SalesPersonProfile ep, float commission) {
        orderitems = new ArrayList();
        customer = cp;
        salesperson = ep;
        customer.addCustomerOrder(this); //we link the order to the customer
        salesperson.addSalesOrder(this); 
        this.commission = commission;
        count++;
        modelNumber = count;
    }
    public OrderItem newOrderItem(Product p, int actualprice, int q) {
        OrderItem oi = new OrderItem(p, actualprice, q);
        getOrderitems().add(oi);
        return oi;
    }
      public void setCommission(float commission) {
        this.commission = commission;
    }

    // New method to get the commission
    public float getCommission() {
        return this.commission;
    }
    //order total is the sumer of the order item totals
    public int getOrderTotal() {
        int sum = 0;
        for (OrderItem oi : getOrderitems()) {
            sum = sum + oi.getOrderItemTotal();
        }
        return sum;
    }

    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : getOrderitems()) {
            sum = sum + oi.calculatePricePerformance();     //positive and negative values       
        }
        return sum;
    }

    public int getNumberOfOrderItemsAboveTarget() {
        int sum = 0;
        for (OrderItem oi : getOrderitems()) {
            if (oi.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }
    
    //sum all the item targets and compare to the total of the order 
    public boolean isOrderAboveTotalTarget(){
        int sum = 0;
        for (OrderItem oi: getOrderitems()){
            sum = sum + oi.getOrderItemTargetTotal(); //product targets are added
        }
        if(getOrderTotal()>sum) {return true;}
        else {return false;}
        
    }
public void CancelOrder(){
        setStatus("Cancelled");
}
public void Submit(){
        setStatus("Submitted");
}

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the orderitems
     */
    public ArrayList<OrderItem> getOrderitems() {
        return orderitems;
    }

    /**
     * @param orderitems the orderitems to set
     */
    public void setOrderitems(ArrayList<OrderItem> orderitems) {
        this.orderitems = orderitems;
    }

    /**
     * @return the customer
     */
    public CustomerProfile getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
    }

    /**
     * @return the salesperson
     */
    public SalesPersonProfile getSalesperson() {
        return salesperson;
    }

    /**
     * @param salesperson the salesperson to set
     */
    public void setSalesperson(SalesPersonProfile salesperson) {
        this.salesperson = salesperson;
    }

    /**
     * @return the mca
     */
    public MarketChannelAssignment getMca() {
        return mca;
    }

    /**
     * @param mca the mca to set
     */
    public void setMca(MarketChannelAssignment mca) {
        this.mca = mca;
    }

    /**
     * @return the productSummary
     */
    public ProductSummary getProductSummary() {
        return productSummary;
    }

    /**
     * @param productSummary the productSummary to set
     */
    public void setProductSummary(ProductSummary productSummary) {
        this.productSummary = productSummary;
    }

    /**
     * @return the modelNumber
     */
    public int getModelNumber() {
        return modelNumber;
    }

    /**
     * @param modelNumber the modelNumber to set
     */
    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

  

    
}
