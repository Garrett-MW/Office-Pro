
package Business;

import java.util.ArrayList;
import java.util.List;
/*
 *Class: CIST2931 Advanced Systems Project
 *Term: Fall 2024
 *Instructor: Ron Enz
 *Description: OfficeSupplyProject
 *Author: Garrett Womack
 *Date: 12/8/2024
 */


/**
 * CartList Class - used to hold items the user adds to their cart.
 * @author Garrett Womack
 */
public class CartList {
    public int count;   //tracks count of appointment in list
    public CartItem Cart[]; //= new Appointment[10];    //create list
    
    public CartList(){
        count = 0;
        Cart = new CartItem[20];
    }
    
/**
 * addCartItem() - takes in a CartItem object and adds it to the list of cartItems.
 * @param cartItem
 */
    public void addCartItem(CartItem cartItem){  //takes appointment as parameter
        Cart[count] = cartItem; //add appointment into list
        count++;    //increase count
    }//end meth
    
/**
 * getCartItems() - used to populate the ArrayList with all cartItems.
 * @return 
 */
    public List<CartItem> getCartItems() {
        List<CartItem> CartList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            CartList.add(Cart[i]);
        }
        return CartList;
    }
    
/**
 * displayCartList() - loops through the list of cartItems and displays the item info.
 */
    public void displayCartList(){  //display all accounts in list
        for(int x = 0; x < count; x++) {    //use for loop to loop through accounts in list
          Cart[x].displayItemInfo();
        }//end loop
    }//end meth
}
