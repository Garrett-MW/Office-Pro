
package Business;
import java.io.PrintStream;
import java.sql.*;

/*
 *Class: CIST2931 Advanced Systems Project
 *Term: Fall 2024
 *Instructor: Ron Enz
 *Description: OfficeSupplyProject
 *Author: Brendan Stroud
 *Date: 09-05-2024
 */

/**
 * This class is a business class model for Customer
 * @author Brendan Stroud
 */
public class Customer{
   public String custID;
   public String passwd;
   public String firstName;
   public String lastName;
   public String addr;
   public String email;
   public String phone;
   public OrderList OrderList = new OrderList();
   public CartList CartList = new CartList();
   public boolean Exists;

   public Customer() {
      this.custID = "";
      this.passwd = "";
      this.firstName = "";
      this.lastName = "";
      this.addr = "";
      this.email = "";
      this.phone = "";
   }

   public Customer(String cID, String pw, String fN, String lN, String adrs, String eMail, String pn) {
      this.custID = cID;
      this.passwd = pw;
      this.firstName = fN;
      this.lastName = lN;
      this.addr = adrs;
      this.email = eMail;
      this.phone = pn;
   }

   public void setCustID(String cid) {
      this.custID = cid;
   }

   public String getCustID() {
      return this.custID;
   }

   public void setPasswd(String pw) {
      this.passwd = pw;
   }

   public String getPasswd() {
      return this.passwd;
   }

   public void setFirstName(String fN) {
      this.firstName = fN;
   }

   public String getFirstName() {
      return this.firstName;
   }

   public void setLastName(String lN) {
      this.lastName = lN;
   }

   public String getLastName() {
      return this.lastName;
   }

   public void setAddr(String adrs) {
      this.addr = adrs;
   }

   public String getAddr() {
      return this.addr;
   }

   public void setEmail(String eMail) {
      this.email = eMail;
   }

   public String getEmail() {
      return this.email;
   }

   public void setPhone(String pn) {
      this.phone = pn;
   }

   public String getPhone() {
      return this.phone;
   }
   
   public OrderList getOrderList(){return OrderList;}
   
   public CartList getCartList(){return CartList;}

   public void display() {
      System.out.println("Customer ID: " + this.getCustID());
      System.out.println("Password: " + this.getPasswd());
      PrintStream var10000 = System.out;
      String var10001 = this.getFirstName();
      var10000.println("Name: " + var10001 + " " + this.getLastName());
      System.out.println("Address: " + this.getAddr());
      System.out.println("Email: " + this.getEmail());
      System.out.println("Phone Number: " + this.getPhone());
      System.out.println("List of Orders: ");
      OrderList.displayOrderList();
   }

/**
 * selectDB() - takes in a customer ID string and uses it to pull all information 
 *              of a customer associated with the given ID.
 * @param cid
 */
   public void selectDB(String cid) {
      this.custID = cid;

      try {
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
         System.out.println("Database connected\n---------------------------");
         if (this.checkExists(cid, connection)) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Customer WHERE CustId = '" + this.getCustID() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL: " + sql);
            rs.next();
            this.setCustID(rs.getString(6));
            this.setPasswd(rs.getString(7));
            this.setFirstName(rs.getString(1));
            this.setLastName(rs.getString(2));
            this.setAddr(rs.getString(3));
            this.setEmail(rs.getString(4));
            this.setPhone(rs.getString(5));
            getOrders();
            
         } else {
            System.out.println("ERROR!\nCustomer with ID " + cid + " does not exist!");
         }

         connection.close();
      } catch (Exception var6) {
         System.out.println("Exception" + String.valueOf(var6));
      }

   }

   public void setExists(boolean exists) {
      this.Exists = exists;
   }

   public boolean getExists() {
      return this.Exists;
   }

/**
 * checkExists() - checks to see if customer with a given ID exists.
 * @param cID
 * @param connection
 * @return 
 */
   public boolean checkExists(String cID, Connection connection) {
      this.Exists = false;

      try {
         Statement stmt = connection.createStatement();
         String sql = "SELECT * FROM Customer WHERE CustId = '" + this.getCustID() + "'";
         ResultSet rs = stmt.executeQuery(sql);
         if (rs.next()) {
            this.Exists = true;
            System.out.println("Customer ID: " + cID + " Exists");
         }
      } catch (Exception var6) {
         System.out.println("Exception: " + String.valueOf(var6));
      }

      return this.Exists;
   }

/**
 * insertDB() - inserts customer object into database.
 * @param cid
 * @param pw
 * @param fN
 * @param lN
 * @param adrs
 * @param eMail
 * @param pn 
 **/
   public void insertDB(String cid, String pw, String fN, String lN, String adrs, String eMail, String pn) {
      this.custID = cid;
      this.passwd = pw;
      this.firstName = fN;
      this.lastName = lN;
      this.addr = adrs;
      this.email = eMail;
      this.phone = pn;

      try {
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
         System.out.println("Database connected\n---------------------------");
         if (!this.checkExists(cid, connection)) {
            String sql = "INSERT INTO Customer(CustId, passwd, firstName, lastName, addr, email, Phone) Values(?,?,?,?,?,?,?)";
            PreparedStatement pStmt = connection.prepareStatement(sql);
            System.out.println("SQL: " + sql);
            pStmt.setString(1, cid);
            pStmt.setString(2, pw);
            pStmt.setString(3, fN);
            pStmt.setString(4, lN);
            pStmt.setString(5, adrs);
            pStmt.setString(6, eMail);
            pStmt.setString(7, pn);
            int n = pStmt.executeUpdate();
            if (n == 1) {
               System.out.println("INSERT Successful!");
            } else {
               System.out.println("INSERT FAILED!");
            }
         } else {
            System.out.println("ERROR!\nCustomer with ID " + cid + " already exists!");
         }

         connection.close();
      } catch (Exception var12) {
         System.out.println("Exception" + String.valueOf(var12));
      }

   }

/**
 * updateDB() - updates customer information in database.
 * @param cid
 */
   public void updateDB(String cid) {
      this.custID = cid;

      try {
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
         System.out.println("Database connected\n---------------------------");
         Statement stmt = connection.createStatement();
         String var10000 = this.getPasswd();
         String sql = "UPDATE Customer SET passwd = '" + var10000 + "', firstName = '" + this.getFirstName() + "', lastName = '" + this.getLastName() + "', addr = '" + this.getAddr() + "', email = '" + this.getEmail() + "', Phone = '" + this.getPhone() + "', WHERE CustId = '" + this.getCustID() + "'";
         int n = stmt.executeUpdate(sql);
         System.out.println("SQL: " + sql);
         if (n == 1) {
            System.out.println("UPDATE Successful!");
         } else {
            System.out.println("UPDATE FAILED!");
         }

         connection.close();
      } catch (Exception var6) {
         System.out.println("Exception" + String.valueOf(var6));
      }

   }

/**
 * deleteDB() - deletes customer object from database.
 * @param cid 
 */
   public void deleteDB(String cid) {
      this.custID = cid;

      try {
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
         System.out.println("Database connected\n---------------------------");
         String sql = "DELETE FROM Customer WHERE CustId = '" + this.getCustID() + "'";
         Statement stmt = connection.createStatement();
         System.out.println("SQL: " + sql);
         int n = stmt.executeUpdate(sql);
         if (n == 1) {
            System.out.println("DELETE Successful!");
         } else {
            System.out.println("DELETE FAILED!");
         }

         connection.close();
      } catch (Exception var6) {
         System.out.println("Exception" + String.valueOf(var6));
      }

   }
   
    /**
     * getOrders() - retrieves all orders from Orders table in database associated with a given customer ID.
     */
    public void getOrders(){
         
         try{
             
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
            
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Order WHERE CustId ='"+ custID +"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Orders order = new Orders(rs.getString(4),rs.getString(10),rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(12), rs.getDouble(11));
                OrderList.addOrder(order);
            }
            
         }catch(Exception e){
             System.out.println(e);
         } 
         
     }

   public static void main(String[] args) {
   }
} // END class