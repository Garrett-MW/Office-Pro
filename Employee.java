/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;
import java.io.PrintStream;
import java.sql.*;

/*
 *Class:
 *Term: Fall 2024
 *Instructor: Ron Enz
 *Description: OfficeSupplyProject
 *Author: Brendan Stroud
 *Date: 09-13-2024
 */

/**
 * This a business class model for Employee
 * @author BrendanStroud
 */
public class Employee {

    String id;
   String passwd;
   String firstName;
   String lastName;
   String email;
   String phone;
   String addr;
   static final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
   static final String DBLocation = "jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb";
   public boolean Exists;

   public OrderList openOrderList = new OrderList();   //add account list
   
   public Employee() {
      this.id = "";
      this.passwd = "";
      this.firstName = "";
      this.lastName = "";
      this.email = "";
      this.phone = "";
      this.addr = "";
   }

   public Employee(String eid, String epw, String efn, String eln, String eem, String ep, String eadrs) {
      this.id = eid;
      this.passwd = epw;
      this.firstName = efn;
      this.lastName = eln;
      this.email = eem;
      this.phone = ep;
      this.addr = eadrs;
   }

   public void setId(String eId) {
      this.id = eId;
   }

   public String getId() {
      return this.id;
   }

   public void setPasswd(String epw) {
      this.passwd = epw;
   }

   public String getPasswd() {
      return this.passwd;
   }

   public void setFirstName(String efn) {
      this.firstName = efn;
   }

   public String getFirstName() {
      return this.firstName;
   }

   public void setLastName(String eln) {
      this.lastName = eln;
   }

   public String getLastName() {
      return this.lastName;
   }

   public void setEmail(String eem) {
      this.email = eem;
   }

   public String getEmail() {
      return this.email;
   }

   public void setPhone(String ep) {
      this.phone = ep;
   }

   public String getPhone() {
      return this.phone;
   }

   public void setAddr(String eadrs) {
      this.addr = eadrs;
   }

   public String getAddr() {
      return this.addr;
   }
   
   public OrderList getOpenOrders(){return openOrderList;}

   public void display() {
      System.out.println("Employee ID: " + this.getId());
      System.out.println("Password: " + this.getPasswd());
      PrintStream var10000 = System.out;
      String var10001 = this.getFirstName();
      var10000.println("Name: " + var10001 + " " + this.getLastName());
      System.out.println("Email: " + this.getEmail());
      System.out.println("Phone: " + this.getPhone());
      System.out.println("Employee Address: " + this.getAddr());
   }

    /**
     *selectDB() - retrieves all information of employee associated with given ID.
     * @param eId
     */
    public void selectDB(String eId) {
      this.id = eId;

      try {
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
         System.out.println("Database Connected");
         if (this.checkExists(eId, connection)) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Employee WHERE id = '" + this.getId() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL: " + sql);
            rs.next();
            this.setId(rs.getString(4));
            this.setPasswd(rs.getString(5));
            this.setFirstName(rs.getString(1));
            this.setLastName(rs.getString(2));
            this.setEmail(rs.getString(3));
            this.setPhone(rs.getString(6));
            this.setAddr(rs.getString(7));
            getOpenOrders();
         } else {
            System.out.println("Error! \nEmployee with ID " + eId + " does not exist!");
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
     * checkExists() - checks to see if an employee with given ID exists in database.
     * @param eId
     * @param connection
     * @return
     */
    public boolean checkExists(String eId, Connection connection) {
      this.Exists = false;

      try {
         Statement stmt = connection.createStatement();
         String sql = "SELECT * FROM Employee WHERE id = '" + this.getId() + "'";
         ResultSet rs = stmt.executeQuery(sql);
         if (rs.next()) {
            this.Exists = true;
            System.out.println("Employee ID: " + eId + " Exists");
         }
      } catch (Exception var6) {
         System.out.println("Exception: " + String.valueOf(var6));
      }

      return this.Exists;
   }

    /**
     * insertDB() - inserts employee object into database.
     * @param eid
     * @param epw
     * @param efn
     * @param eln
     * @param eem
     * @param ep
     * @param eadrs
     */
    public void insertDB(String eid, String epw, String efn, String eln, String eem, String ep, String eadrs) {
      this.id = eid;
      this.passwd = epw;
      this.firstName = efn;
      this.lastName = eln;
      this.email = eem;
      this.phone = ep;
      this.addr = eadrs;

      try {
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
         System.out.println("Database Connected");
         if (!this.checkExists(eid, connection)) {
            String sql = "INSERT INTO Employee(id, passwd, firstName, lastName, email, phone, addr) Values(?,?,?,?,?,?,?)";
            PreparedStatement pStmt = connection.prepareStatement(sql);
            System.out.println("SQL Statement: " + sql);
            pStmt.setString(1, eid);
            pStmt.setString(2, epw);
            pStmt.setString(3, efn);
            pStmt.setString(4, eln);
            pStmt.setString(5, eem);
            pStmt.setString(6, ep);
            pStmt.setString(7, eadrs);
            int n = pStmt.executeUpdate();
            if (n == 1) {
               System.out.println("INSERT Successful!");
            } else {
               System.out.println("INSERT FAILED!");
            }
         } else {
            System.out.println("ERROR!\n Employee with ID " + eid + " already exists!");
         }

         connection.close();
      } catch (Exception var12) {
         System.out.println("Exception" + String.valueOf(var12));
      }

   }

    /**
     * updateDB() - updates information of employee associated with given ID.
     * @param eid
     */
    public void updateDB(String eid) {
      this.id = eid;

      try {
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
         System.out.println("Database Connected");
         Statement stmt = connection.createStatement();
         String var10000 = this.getPasswd();
         String sql = "UPDATE Employee SET passwd = '" + var10000 + "', firstName = '" + this.getFirstName() + "', lastName = '" + this.getLastName() + "', addr = '" + this.getAddr() + "', email = '" + this.getEmail() + "', phone = '" + this.getPhone() + "', WHERE ID = '" + this.getId() + "'";
         int n = stmt.executeUpdate(sql);
         System.out.println("SQL Statement: " + sql);
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
     * deleteDB() - deletes employee associated with given ID from database.
     * @param eid
     */
    public void deleteDB(String eid) {
      this.id = eid;

      try {
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
         System.out.println("Database Connected");
         String sql = "DELETE FROM Employee WHERE id = '" + this.getId() + "'";
         Statement stmt = connection.createStatement();
         System.out.println("SQL Statement: " + sql);
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

   public static void main(String[] args) {
   }
} // END class
