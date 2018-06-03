/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Wagon;

/**
 *
 * @author tinkerc
 */
public class InventoryControlTest {
        
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of calcNewWeight method, of class InventoryControl.
     * Team Assignment 
     */
    @Test
    public void testCalcNewWeight() {
        System.out.println("calcNewWeight" + "\nTeam Assignment");
        
        //Create object instances
        Wagon wagonOne = new Wagon();
        InventoryItem itemOne = new InventoryItem();
        
        //Test Case 1
        System.out.println("\n\tTest case 1");
        
        //Define the input variables    
        itemOne.setWeight(100);
        itemOne.setCount(2);    
        wagonOne.setWeight(100.0);
        wagonOne.setMaxWeight(500);
       
        //Expected output
        double expResult = 300.0;
        
        //Call method
        double result = InventoryControl.calcNewWeight(itemOne, wagonOne);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Weight = " + result);
        
        //Test Case 2
        System.out.println("\n\tTest case 2");
        
        //Define the input variables    
        itemOne.setWeight(-10);
        itemOne.setCount(11);    
        wagonOne.setWeight(450);
        wagonOne.setMaxWeight(500);
       
        //Expected output
        expResult = -1;
        
        //Call method
        result = InventoryControl.calcNewWeight(itemOne, wagonOne);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Weight = " + result);
        
        //Test Case 3
        System.out.println("\n\tTest case 3");
        
        //Define the input variables    
        itemOne.setWeight(100);
        itemOne.setCount(-5);    
        wagonOne.setWeight(400.0);
        wagonOne.setMaxWeight(500);
       
        //Expected output
        expResult = -2;
        
        //Call method
        result = InventoryControl.calcNewWeight(itemOne, wagonOne);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Weight = " + result);
        
        //Test Case 4
        System.out.println("\n\tTest case 4");
        
        //Define the input variables    
        itemOne.setWeight(50);
        itemOne.setCount(11);    
        wagonOne.setWeight(500.0);
        wagonOne.setMaxWeight(500);
       
        //Expected output
        expResult = -3;
        
        //Call method
        result = InventoryControl.calcNewWeight(itemOne, wagonOne);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Weight = " + result);
        
        //Test Case 5
        System.out.println("\n\tTest case 5");
        
        //Define the input variables    
        itemOne.setWeight(1);
        itemOne.setCount(5);    
        wagonOne.setWeight(450.0);
        wagonOne.setMaxWeight(500);
       
        //Expected output
        expResult = 455.0;
        
        //Call method
        result = InventoryControl.calcNewWeight(itemOne, wagonOne);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Weight = " + result);
        
        //Test Case 6
        System.out.println("\n\tTest case 6");
        
        //Define the input variables    
        itemOne.setWeight(10);
        itemOne.setCount(1);    
        wagonOne.setWeight(450.0);
        wagonOne.setMaxWeight(500);
       
        //Expected output
        expResult = 460.0;
        
        //Call method
        result = InventoryControl.calcNewWeight(itemOne, wagonOne);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Weight = " + result);
        
        //Test Case 7
        System.out.println("\n\tTest case 7");
        
        //Define the input variables    
        itemOne.setWeight(50);
        itemOne.setCount(10);    
        wagonOne.setWeight(0.0);
        wagonOne.setMaxWeight(500);
       
        //Expected output
        expResult = 500.0;
        
        //Call method
        result = InventoryControl.calcNewWeight(itemOne, wagonOne);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Weight = " + result);
        
    }  
    /**
     * Test of calcFoodHunt method, of class ToolControl.
     */
    @Test
    public void testCalcFoodHunt() {
        System.out.println("FoodHunt Test 1");
        InventoryItem food = new InventoryItem();
        food.setWeight(10);
        food.setCount(10);
        double expResult = 110;
        double result = ToolControl.calcFoodHunt((food));
        assertEquals(expResult, result, 0.0);
        System.out.println("\tcalc Food Result = " + result);
        
        System.out.println("FoodHunt Test 2");
        food.setWeight(5);
        food.setCount(4);
        expResult = 25;
        result = ToolControl.calcFoodHunt((food));
        assertEquals(expResult, result, 0.0);
        System.out.println("\tcalc Food Result = " + result);
        
        System.out.println("FoodHunt Test 3");
        food.setWeight(50);
        food.setCount(3);
        expResult = 200;
        result = ToolControl.calcFoodHunt((food));
        assertEquals(expResult, result, 0.0);
        System.out.println("\tcalc Food Result = " + result);
    }

}