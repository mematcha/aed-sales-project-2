/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Main;

import MarketingManagement.MarketingPersonDirectory;
import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.Personnel.EmployeeDirectory;
import TheBusiness.Personnel.EmployeeProfile;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccount;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Xerox");
        //product data
        readDataFromCSV(business, "./data.csv");
        readMarketDatafromCSV(business,"./market.csv");
        readUserAccountDataFromCSV(business, "./user_accounts.csv");
        readChannelDataFromCSV(business, "./channel.csv");
        readMarketChannelMappingFromCSV(business,"./marketChannelMapping.csv");
        printAllProductCatalogs(business);
        printAllSuppliers(business);
        printAllUsers(business);

        return business;

    }
private static void readChannelDataFromCSV(Business business, String pathToYourCSVFile) {
    try (BufferedReader br = new BufferedReader(new FileReader(pathToYourCSVFile))) {
        // Skip the header line
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            try {
                String[] data = line.split(",");
                if (data.length < 3) {
                    // Skip lines with insufficient data
                    continue;
                }

                String channelType = data[0].trim();
                int price = Integer.parseInt(data[1].trim());
                String unitOfMeasure = data[2].trim();

                // Create a channel based on the read data
                // Assuming you have a ChannelCatalog in your Business class
                business.getChannelCatalog().newChannel(channelType, price, unitOfMeasure);

            } catch (NumberFormatException e) {
                System.err.println("Error parsing line: " + line);
                e.printStackTrace();
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private static void readDataFromCSV(Business business, String pathtoyourcsvfilecsv) {
       try (BufferedReader br = new BufferedReader(new FileReader(pathtoyourcsvfilecsv))) {
        String line;
        SupplierDirectory supplierDirectory = business.getSupplierDirectory();

        while ((line = br.readLine()) != null) {
            try {
                String[] data = line.split(",");
                if (data.length < 7) {
                    continue; // Skip lines with insufficient data
                }

                String supplierName = data[0].trim();
                String productName = data[1].trim();
                int floorPrice = Integer.parseInt(data[2].trim());
                int ceilingPrice = Integer.parseInt(data[3].trim());
                int targetPrice = Integer.parseInt(data[4].trim());
                int actualPrice = Integer.parseInt(data[5].trim());
                int quantity = Integer.parseInt(data[6].trim());

                // Check if supplier already exists, else create a new one
                Supplier supplier = supplierDirectory.findSupplier(supplierName);
                if (supplier == null) {
                    supplier = supplierDirectory.newSupplier(supplierName);
                }

                ProductCatalog productCatalog = supplier.getProductCatalog();
                // Add product if it's not already in the catalog
                Product product = null;
                if (!productCatalog.containsProduct(productName)) {
                    product = productCatalog.newProduct(productName, floorPrice, ceilingPrice, targetPrice);
                } else {
                    product = productCatalog.getProduct(productName);
                }

                // Add an OrderItem for the product
                OrderItem orderItem = new OrderItem(product, actualPrice, quantity);

            } catch (NumberFormatException e) {
                System.err.println("Error parsing line: " + line);
                e.printStackTrace();
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
        PersonDirectory persondirectory = business.getPersonDirectory();
        // person representing sales organization        
        Person xeroxsalesperson001 = persondirectory.newPerson("Xerox sales");
        Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox marketing");
        Person xeroxadminperson001 = persondirectory.newPerson("Xerox admin");
         SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
        SalesPersonProfile salespersonprofile = salespersondirectory.newSalesPersonProfile(xeroxsalesperson001);

// Create Marketing people
        MarketingPersonDirectory marketingpersondirectory = business.getMarketingPersonDirectory();
        MarketingPersonProfile marketingpersonprofile0 = marketingpersondirectory.newMarketingPersonProfile(xeroxmarketingperson001);

// Create Admins to manage the business
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(xeroxadminperson001);

        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua1 = uadirectory.newUserAccount(salespersonprofile, "Sales", "sales"); /// order products for one of the customers and performed by a sales person
        UserAccount ua2 = uadirectory.newUserAccount(marketingpersonprofile0, "Marketing", "marketing"); /// order products for one of the customers and performed by a sales person
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "Admin", "admin"); /// order products for one of the customers and performed by a sales person
/// order products for one of the customers and performed by a sales person 
    }

    private static void printAllProductCatalogs(Business business) {
        SupplierDirectory supplierDirectory = business.getSupplierDirectory();
        ArrayList<Supplier> suppliers = supplierDirectory.getSuplierList();

        for (Supplier supplier : suppliers) {
            System.out.println("Supplier: " + supplier.getName());
            ProductCatalog productCatalog = supplier.getProductCatalog();
            for (Product product : productCatalog.getProductList()) {
                System.out.println("  Product Name: " + product.getName() +
                                   ", Floor Price: " + product.getFloorPrice() +
                                   ", Ceiling Price: " + product.getCeilingPrice() +
                                   ", Target Price: " + product.getTargetPrice());
            }
        }
    }

    private static void printAllSuppliers(Business business) {
        SupplierDirectory supplierDirectory = business.getSupplierDirectory();
        ArrayList<Supplier> suppliers = supplierDirectory.getSuplierList();

        System.out.println("Suppliers:");
        for (Supplier supplier : suppliers) {
            System.out.println("  Supplier Name: " + supplier.getName());
            // Here you can also print more details of each supplier if needed
        }
    }
private static void printAllUsers(Business business) {
    UserAccountDirectory userAccountDirectory = business.getUserAccountDirectory();
    ArrayList<UserAccount> userAccounts = userAccountDirectory.useraccountlist; 

    System.out.println("User Accounts:");
    for (UserAccount userAccount : userAccounts) {
        System.out.println("  Username: " + userAccount.getUsername() +
                           ", Role: " + userAccount.getRole() +
                           ", Person ID: " + userAccount.getPersonId());
    }
}
   private static void readMarketDatafromCSV(Business business, String pathtoyourcsvfilecsv) {
    try (BufferedReader br = new BufferedReader(new FileReader(pathtoyourcsvfilecsv))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",");

            // Assuming the order of columns is Main Market, Sub Market, Sub Market Type, Characteristics
            String mainMarketName = data[0].trim();
            String subMarketName = data[1].trim();
            String subMarketType = data[2].trim();
            String characteristics = data[3].trim();
ArrayList<String> characteristicsList = new ArrayList<>();
characteristicsList.add(characteristics);
            MarketCatalog marketCatalog = business.getMarketCatalog();

            Market mainMarket = findMarketByName(mainMarketName, marketCatalog.getMarkets());
            if (mainMarket == null) {
                mainMarket = new Market(mainMarketName);
                marketCatalog.addMarket(mainMarket);
            }

            // Find or create the sub market
            Market subMarket = findMarketByName(subMarketName, mainMarket.getSubmarkets());
            if (subMarket == null) {
                subMarket = new Market(subMarketName);
                mainMarket.addSubmarket(subMarket);
            }

            // Set sub market type and characteristics
            subMarket.setSubmarketType(subMarketType);
            subMarket.setCharacteristics(characteristicsList);

                } catch (NumberFormatException e) {
                    System.err.println("Error parsing line: " + line);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
   }

  private  static Market findMarketByName(String marketName, ArrayList<Market> markets) {
    for (Market market : markets) {
        if (market.getName().equals(marketName)) {
            return market;
        }
    }
    return null; // Market not found
}
  private static void readUserAccountDataFromCSV(Business business, String user_accountscsv) {
    try (BufferedReader br = new BufferedReader(new FileReader(user_accountscsv))) {
        String line;
        while ((line = br.readLine()) != null) {
            try {
                String[] data = line.split(",");
                if (data.length < 4) {
                    // Skip lines with insufficient data
                    continue;
                }

                String username = data[0].trim();
                String password = data[1].trim();
                String personId = data[2].trim();
                String role = data[3].trim();

                // Find or create the person in the person directory
                PersonDirectory personDirectory = business.getPersonDirectory();
                Person person = personDirectory.findPerson(personId);
                if (person == null) {
                    person = personDirectory.newPerson(personId);
                }

                // Create a user account based on the role
                UserAccountDirectory userAccountDirectory = business.getUserAccountDirectory();
                switch (role.toLowerCase()) {
                    case "sales":
                        SalesPersonDirectory salesPersonDirectory = business.getSalesPersonDirectory();
                        SalesPersonProfile salesPersonProfile = salesPersonDirectory.newSalesPersonProfile(person);
                        userAccountDirectory.newUserAccount(salesPersonProfile, username, password);
                        break;
                    case "marketing":
                        MarketingPersonDirectory marketingPersonDirectory = business.getMarketingPersonDirectory();
                        MarketingPersonProfile marketingPersonProfile = marketingPersonDirectory.newMarketingPersonProfile(person);
                        userAccountDirectory.newUserAccount(marketingPersonProfile, username, password);
                        break;
                    case "admin":
                        EmployeeDirectory employeeDirectory = business.getEmployeeDirectory();
                        EmployeeProfile employeeProfile = employeeDirectory.newEmployeeProfile(person);
                        userAccountDirectory.newUserAccount(employeeProfile, username, password);
                        break;
                    case "customer":
                        CustomerDirectory customerDirectory = business.getCustomerDirectory();
                        CustomerProfile customerProfile = customerDirectory.newCustomerProfile(person);
                        userAccountDirectory.newUserAccount(customerProfile, username, password);
                        break;
                    default:
                        System.out.println("Unknown role: " + role);
                }

            } catch (NumberFormatException e) {
                System.err.println("Error parsing line: " + line);
                e.printStackTrace();
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
private static void readMarketChannelMappingFromCSV(Business business, String pathToYourCSVFile) {
    try (BufferedReader br = new BufferedReader(new FileReader(pathToYourCSVFile))) {
        // Skip the header line
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            try {
                String[] data = line.split("\t"); // Assuming tab-delimited data
                if (data.length < 3) {
                    // Skip lines with insufficient data
                    continue;
                }

                String mainMarketName = data[0].trim();
                String channelType = data[1].trim();
                int adBudget = Integer.parseInt(data[2].trim());

                MarketCatalog marketCatalog = business.getMarketCatalog();

                // Find or create the main market
                Market mainMarket = findMarketByName(mainMarketName, marketCatalog.getMarkets());
                if (mainMarket == null) {
                    mainMarket = new Market(mainMarketName);
                    marketCatalog.addMarket(mainMarket);
                }

                // Create a MarketChannelMapping and add it to the main market
                mainMarket.addMarketChannelMapping(channelType, adBudget);

            } catch (NumberFormatException e) {
                System.err.println("Error parsing line: " + line);
                e.printStackTrace();
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


}


