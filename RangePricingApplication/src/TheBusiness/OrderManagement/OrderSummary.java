/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.OrderManagement;

/**
 *
 * @author kal bugrara
 */
public class OrderSummary {
    Order subjectorder;
    private static int count = 0;
    private int modelNumber;
    private int salesvolume;
    boolean totalabovetarget;
    int orderpriceperformance;
    int numberofOrderitemsabovetarget;
    int numberofOrdeitemsbelowtarget;
    
public OrderSummary(Order o){
   
    subjectorder = o;
    salesvolume = o.getOrderTotal();
    totalabovetarget = o.isOrderAboveTotalTarget();
    orderpriceperformance = o.getOrderPricePerformance();
    numberofOrderitemsabovetarget = o.getNumberOfOrderItemsAboveTarget();
//numberofOrdeitemsbelowtarget = o.getNumberOfOrderItemsBelowTarget();
}

public Order getSubjectOrder(){ return subjectorder;}

public int getOrderProfit(){
    return orderpriceperformance;
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

    /**
     * @return the salesvolume
     */
    public int getSalesvolume() {
        return salesvolume;
    }

    /**
     * @param salesvolume the salesvolume to set
     */
    public void setSalesvolume(int salesvolume) {
        this.salesvolume = salesvolume;
    }

}
