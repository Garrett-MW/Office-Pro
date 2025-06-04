
package Business;
/*
 *Class: CIST2931 Advanced Systems Project
 *Term: Fall 2024
 *Instructor: Ron Enz
 *Description: OfficeSupplyProject
 *Author: Garrett Womack
 *Date: 12/8/2024
 */

/**
 * CartItem Class - used to create a item that will be stored in the cart.
 * @author Garrett Womack
 */
public class CartItem {
    private String productName;
    private double price;
    private int quantity;
    private String productCode;
    
    public CartItem(){
        productName = "";
        price = 0.0;
        quantity = 0;
        productCode = "";
    }
    
    public CartItem(String productName, double price, int quantity, String productCode){
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    
    public void displayItemInfo(){
        System.out.println("\n----------------------------------------");
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Product Code: " + productCode);
         System.out.println("----------------------------------------");
    }
}
