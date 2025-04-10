
package Business;

import java.sql.*;

/**
 * Orders Class - this is the business class model for orders
 */
public class Orders {

    String OrderID, CustID, prodCode, prodName;
    boolean OrderDel;
    String firstName, lastName, addr, email, phone;
    int quantity;
    double cost;

    // Default constructor
    public Orders(){
        OrderID = "";
        CustID = "";
        prodCode = "";
        prodName = "";
        OrderDel = false;
        firstName = "";
        lastName = "";
        addr = "";
        email = "";
        phone = "";
        quantity = 0;
        cost = 0.0;
    }

    // Parameterized constructor
    public Orders(String orderID, String custID, String prodCode, String prodName, Boolean orderDel,
                  String firstName, String lastName, String addr, String email, String phone, int quantity, double cost) {
        OrderID = orderID;
        CustID = custID;
        this.prodCode = prodCode;
        this.prodName = prodName;
        OrderDel = orderDel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addr = addr;
        this.email = email;
        this.phone = phone;
        this.quantity = quantity;
        this.cost = cost;
    }

    // Getter and Setter methods for the existing fields
    public String getOrderID() { return OrderID; }
    public void setOrderID(String orderID) { OrderID = orderID; }

    public String getCustID() { return CustID; }
    public void setCustID(String custID) { CustID = custID; }

    public String getProdCode() { return prodCode; }
    public void setProdCode(String prodCode) { this.prodCode = prodCode; }

    public String getProdName() { return prodName; }
    public void setProdName(String prodName) { this.prodName = prodName; }

    public boolean getOrderDel() { return OrderDel; }
    public void setOrderDel(boolean orderDel) { OrderDel = orderDel; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddr() { return addr; }
    public void setAddr(String addr) { this.addr = addr; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    // Display method
    public void display() {
        System.out.println("Order ID: " + getOrderID());
        System.out.println("Customer ID: " + getCustID());
        System.out.println("Product Code: " + getProdCode());
        System.out.println("Product Name: " + getProdName());
        System.out.println("Order Fulfilled: " + getOrderDel());
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Address: " + getAddr());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhone());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Cost: " + getCost());
    }


    /**
     * selectDB() - selects all information of an order with the given orderID from orders table.
     * @param OID
     */
    public void selectDB(String OID) {
        OrderID = OID;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
            Statement st = con.createStatement();
            String sql = "select * from Order where OrderID = '" + getOrderID() + "'";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                setOrderID(rs.getString(4));
                setCustID(rs.getString(2));
                setProdCode(rs.getString(1));
                setProdName(rs.getString(2));
                setOrderDel(rs.getBoolean(3));
                setFirstName(rs.getString(5));
                setLastName(rs.getString(6));
                setAddr(rs.getString(7));
                setEmail(rs.getString(8));
                setPhone(rs.getString(9));
                setQuantity(rs.getInt(12));
                setCost(rs.getDouble(11));
            }

            con.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * updateDB() - updates information of an order stored in the database.
     */
    public void updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
            Statement st = con.createStatement();
            String sql = "UPDATE Order SET OrderID = '" + getOrderID() + "'," +
                    " CustID = '" + getCustID() + "'," +
                    " prodCode = '" + getProdCode() + "'," +
                    " prodName = '" + getProdName() + "'," +
                    " OrderFulfilled = '" + getOrderDel() + "'," +
                    " firstName = '" + getFirstName() + "'," +
                    " lastName = '" + getLastName() + "'," +
                    " addr = '" + getAddr() + "'," +
                    " email = '" + getEmail() + "'," +
                    " phone = '" + getPhone() + "'," +
                    " quantity = " + getQuantity() + "," +
                    " cost = " + getCost() + " WHERE OrderID = '" + getOrderID() + "'";
            int n1 = st.executeUpdate(sql);
            if (n1 == 1) {
                System.out.println("UPDATE Successful!!!");
            } else {
                System.out.println("UPDATE FAILED**********************");
            }

            con.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     *insertDB() - inserts an order object into database.
     * @param orderID
     * @param custID
     * @param prodCode
     * @param prodName
     * @param orderDel
     * @param firstName
     * @param lastName
     * @param addr
     * @param email
     * @param phone
     * @param quantity
     * @param cost
     */
    public void insertDB(String orderID, String custID, String prodCode, String prodName, boolean orderDel,
                         String firstName, String lastName, String addr, String email, String phone, int quantity, double cost) {
        OrderID = orderID;
        CustID = custID;
        this.prodName = prodName;
        OrderDel = orderDel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addr = addr;
        this.email = email;
        this.phone = phone;
        this.quantity = quantity;
        this.cost = cost;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");

            String sql = "Insert into Order(OrderID,CustID,prodCode,prodName,OrderFulfilled,firstName,lastName,addr,email,phone,quantity,cost)" +
                    " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, OrderID);
            ps.setString(2, CustID);
            ps.setString(3, prodCode);
            ps.setString(4, prodName);
            ps.setBoolean(5, OrderDel);
            ps.setString(6, firstName);
            ps.setString(7, lastName);
            ps.setString(8, addr);
            ps.setString(9, email);
            ps.setString(10, phone);
            ps.setInt(11, quantity);
            ps.setDouble(12, cost);

            ps.execute();

            con.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }


    /**
     * deleteDB() - deletes an order from the database.
     * @param OID
     */
    public void deleteDB(String OID) {
        OrderID = OID;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
            Statement st = con.createStatement();
            String sql = "DELETE from Order where OrderID = '" + getOrderID() + "'";
            int n1 = st.executeUpdate(sql);
            if (n1 == 1) {
                System.out.println("DELETE Successful!!!");
            } else {
                System.out.println("DELETE FAILED**********************");
            }

            con.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
}
