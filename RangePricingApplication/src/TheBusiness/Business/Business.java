/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Business;

import MarketingManagement.MarketingPersonDirectory;
import TheBusiness.MarketModel.ChannelCatalog;
import java.util.ArrayList;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.ProductSummary;
import TheBusiness.ProductManagement.ProductsReport;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.OrderManagement.Order;
import TheBusiness.Personnel.EmployeeDirectory;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class Business {

    private String name;
    private PersonDirectory persondirectory; //all people profiles regardless of the role
    private MasterOrderList masterorderlist;
    private CustomerDirectory customers;
    private SupplierDirectory suppliers;
    private MarketCatalog marketcatalog;
    private ChannelCatalog channelcatalog;
    private MarketChannelComboCatalog marketChannelComboCatalog;
    private SolutionOfferCatalog solutionoffercatalog;
    private CustomerDirectory customerdirectory;
    private EmployeeDirectory employeedirectory;
    private SalesPersonDirectory salespersondirectory;
    private UserAccountDirectory useraccountdirectory;
    private MarketingPersonDirectory marketingpersondirectory;
    private MasterSolutionOrderList mastersolutionorderlist;


    public Business(String n) {
        name = n;
        masterorderlist = new MasterOrderList();
        suppliers = new SupplierDirectory();

        persondirectory = new PersonDirectory();
        customerdirectory = new CustomerDirectory(this);
        salespersondirectory = new SalesPersonDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        marketingpersondirectory = new MarketingPersonDirectory(this);
        employeedirectory=new EmployeeDirectory(this);
        marketcatalog = new MarketCatalog();

        channelcatalog = new ChannelCatalog();

//        Channel c = channelcatalog.newChannel("tv");
//        market.addValidChannel(c);
//        c = channelcatalog.newChannel("");

        marketChannelComboCatalog = new MarketChannelComboCatalog();
//        MarketChannelAssignment mca2 = marketChannelComboCatalog.newMarketChannelCombo(market, c);

        solutionoffercatalog = new SolutionOfferCatalog();
        mastersolutionorderlist  = new MasterSolutionOrderList();

    }
  
    public int getSalesVolume() {
        return getMasterorderlist().getSalesVolume();

    }

    public PersonDirectory getPersonDirectory() {
        return getPersondirectory();
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return getUseraccountdirectory();
    }

    public MarketingPersonDirectory getMarketingPersonDirectory() {
        return getMarketingpersondirectory();
    }

    public SupplierDirectory getSupplierDirectory() {
        return getSuppliers();
    }

    public ProductsReport getSupplierPerformanceReport(String n) {
        Supplier supplier = getSuppliers().findSupplier(n);
        if (supplier == null) {
            return null;
        }
        return supplier.prepareProductsReport();

    }

    public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(String n) {

        ProductsReport productsreport = getSupplierPerformanceReport(n);
        return productsreport.getProductsAlwaysAboveTarget();

    }

    public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
        ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
        int i = productsreport.getProductsAlwaysAboveTarget().size(); //return size of the arraylist
        return i;
    }

    public CustomerDirectory getCustomerDirectory() {
        return getCustomerdirectory();
    }

    public SalesPersonDirectory getSalesPersonDirectory() {
        return getSalespersondirectory();
    }

    public MasterOrderList getMasterOrderList() {
        return getMasterorderlist();
    }

    public MarketCatalog getMarketCatalog() {
        return getMarketcatalog();
    }

    public ChannelCatalog getChannelCatalog() {
        return getChannelcatalog();
    }
    public SolutionOfferCatalog getSolutionOfferCatalog(){
        return getSolutionoffercatalog();
    }
    public MarketChannelComboCatalog getMarketChannelComboCatalog() {

        return marketChannelComboCatalog;
    }
    public MasterSolutionOrderList getMasterSolutionOrderList(){
        return getMastersolutionorderlist();
    }
           public EmployeeDirectory getEmployeeDirectory() {
          return getEmployeedirectory();
      }

    /**
     * @return the employeedirectory
     */
    public EmployeeDirectory getEmployeedirectory() {
        return employeedirectory;
    }

    /**
     * @param employeedirectory the employeedirectory to set
     */
    public void setEmployeedirectory(EmployeeDirectory employeedirectory) {
        this.employeedirectory = employeedirectory;
    }

    public List<Order> getAllOrders() {
    return getMasterorderlist().getOrders();
}

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the persondirectory
     */
    public PersonDirectory getPersondirectory() {
        return persondirectory;
    }

    /**
     * @param persondirectory the persondirectory to set
     */
    public void setPersondirectory(PersonDirectory persondirectory) {
        this.persondirectory = persondirectory;
    }

    /**
     * @return the masterorderlist
     */
    public MasterOrderList getMasterorderlist() {
        return masterorderlist;
    }

    /**
     * @param masterorderlist the masterorderlist to set
     */
    public void setMasterorderlist(MasterOrderList masterorderlist) {
        this.masterorderlist = masterorderlist;
    }

    /**
     * @return the customers
     */
    public CustomerDirectory getCustomers() {
        return customers;
    }

    /**
     * @param customers the customers to set
     */
    public void setCustomers(CustomerDirectory customers) {
        this.customers = customers;
    }

    /**
     * @return the suppliers
     */
    public SupplierDirectory getSuppliers() {
        return suppliers;
    }

    /**
     * @param suppliers the suppliers to set
     */
    public void setSuppliers(SupplierDirectory suppliers) {
        this.suppliers = suppliers;
    }

    /**
     * @return the marketcatalog
     */
    public MarketCatalog getMarketcatalog() {
        return marketcatalog;
    }

    /**
     * @param marketcatalog the marketcatalog to set
     */
    public void setMarketcatalog(MarketCatalog marketcatalog) {
        this.marketcatalog = marketcatalog;
    }

    /**
     * @return the channelcatalog
     */
    public ChannelCatalog getChannelcatalog() {
        return channelcatalog;
    }

    /**
     * @param channelcatalog the channelcatalog to set
     */
    public void setChannelcatalog(ChannelCatalog channelcatalog) {
        this.channelcatalog = channelcatalog;
    }

    /**
     * @param marketChannelComboCatalog the marketChannelComboCatalog to set
     */
    public void setMarketChannelComboCatalog(MarketChannelComboCatalog marketChannelComboCatalog) {
        this.marketChannelComboCatalog = marketChannelComboCatalog;
    }

    /**
     * @return the solutionoffercatalog
     */
    public SolutionOfferCatalog getSolutionoffercatalog() {
        return solutionoffercatalog;
    }

    /**
     * @param solutionoffercatalog the solutionoffercatalog to set
     */
    public void setSolutionoffercatalog(SolutionOfferCatalog solutionoffercatalog) {
        this.solutionoffercatalog = solutionoffercatalog;
    }

    /**
     * @return the customerdirectory
     */
    public CustomerDirectory getCustomerdirectory() {
        return customerdirectory;
    }

    /**
     * @param customerdirectory the customerdirectory to set
     */
    public void setCustomerdirectory(CustomerDirectory customerdirectory) {
        this.customerdirectory = customerdirectory;
    }

    /**
     * @return the salespersondirectory
     */
    public SalesPersonDirectory getSalespersondirectory() {
        return salespersondirectory;
    }

    /**
     * @param salespersondirectory the salespersondirectory to set
     */
    public void setSalespersondirectory(SalesPersonDirectory salespersondirectory) {
        this.salespersondirectory = salespersondirectory;
    }

    /**
     * @return the useraccountdirectory
     */
    public UserAccountDirectory getUseraccountdirectory() {
        return useraccountdirectory;
    }

    /**
     * @param useraccountdirectory the useraccountdirectory to set
     */
    public void setUseraccountdirectory(UserAccountDirectory useraccountdirectory) {
        this.useraccountdirectory = useraccountdirectory;
    }

    /**
     * @return the marketingpersondirectory
     */
    public MarketingPersonDirectory getMarketingpersondirectory() {
        return marketingpersondirectory;
    }

    /**
     * @param marketingpersondirectory the marketingpersondirectory to set
     */
    public void setMarketingpersondirectory(MarketingPersonDirectory marketingpersondirectory) {
        this.marketingpersondirectory = marketingpersondirectory;
    }

    /**
     * @return the mastersolutionorderlist
     */
    public MasterSolutionOrderList getMastersolutionorderlist() {
        return mastersolutionorderlist;
    }

    /**
     * @param mastersolutionorderlist the mastersolutionorderlist to set
     */
    public void setMastersolutionorderlist(MasterSolutionOrderList mastersolutionorderlist) {
        this.mastersolutionorderlist = mastersolutionorderlist;
    }

    public String getSalesData() {
       
        StringBuilder salesData = new StringBuilder();
    
    // Add your logic here to retrieve sales data from your business model
    // For example, you can iterate over orders and append relevant information
    
    List<Order> orders = getMasterorderlist().getOrders();
    for (Order order : orders) {
        // Customize this part based on your actual Order structure
        salesData.append("Order ID: ").append(order.getModelNumber())
                 .append(", Sales Amount: ").append(order.getOrderTotal())
                 .append("\n");
    }
    
    return salesData.toString();
    }

}
