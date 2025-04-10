/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * OrderList Class - used to hold a list of orders
 * @author garrett
 */
public class OrderList {
    public int count;   //tracks count of appointment in list
    public Orders OrderList[]; //= new Appointment[10];    //create list
    
    public OrderList(){
        count = 0;
        OrderList = new Orders[20];
    }
    
    /**
     * addOrder() - adds given order object into list of orders.
     * @param order
     */
    public void addOrder(Orders order){  //takes appointment as parameter
        OrderList[count] = order; //add appointment into list
        count++;    //increase count
    }//end meth
    
    /**
     * getOrders() - returns an arrayList of orders after it populated using the list of orders.
     * @return
     */
    public List<Orders> getOrders() {
        List<Orders> Orders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Orders.add(OrderList[i]);
        }
        return Orders;
    }
    
    /**
     * displayOrderList() - loops through list of orders and displays the information of each.
     */
    public void displayOrderList(){  //display all accounts in list
        for(int x = 0; x < count; x++) {    //use for loop to loop through accounts in list
          OrderList[x].display();
        }//end loop
    }//end meth
}
