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

/**
 *
 * @author Danica
 */
public class ToolControlTest {

    public ToolControlTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

   /*
    * Test chopWood method of ToolControl
    * Danica's Test
    */
    @Test
    public void chopWood() {
        System.out.println("chopWood Danica's Test");
        
        //Create object instances
        InventoryItem item = new InventoryItem();
        
        //Test Case 1
        System.out.println("\n\tTest case 1");
        
        //Define the input variables    
        item.setCount(11);
        item.setWeight(5);    
        double scrap = 0.5;
       
        //Expected output
        double expResult = 27.5;
        
        //Call method
        double result = ToolControl.chopWood(item, scrap);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tGathered Wood = " + result);
        
        
        //Test Case 2
        System.out.println("\n\tTest case 2");
        
        //Define the input variables    
        item.setCount(-2);
        item.setWeight(10);    
        scrap = 0.5;
       
        //Expected output
        expResult = -1;
        
        //Call method
        result = ToolControl.chopWood(item, scrap);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tGathered Wood = " + result);
        
        
        //Test Case 3
        System.out.println("\n\tTest case 3");
        
        //Define the input variables    
        item.setCount(9);
        item.setWeight(-5);    
        scrap = 0.5;
       
        //Expected output
        expResult = -2;
        
        //Call method
        result = ToolControl.chopWood(item, scrap);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tGathered Wood = " + result);
        
        
        //Test Case 4
        System.out.println("\n\tTest case 4");
        
        //Define the input variables    
        item.setCount(16);
        item.setWeight(12);    
        scrap = 0.5;
       
        //Expected output
        expResult = -3;
        
        //Call method
        result = ToolControl.chopWood(item, scrap);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tGathered Wood = " + result);
        
        
        //Test Case 5
        System.out.println("\n\tTest case 5");
        
        //Define the input variables    
        item.setCount(1);
        item.setWeight(13);    
        scrap = 0.5;
       
        //Expected output
        expResult = -4;
        
        //Call method
        result = ToolControl.chopWood(item, scrap);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tGathered Wood = " + result);
        
        
        //Test Case 6
        System.out.println("\n\tTest case 6");
        
        //Define the input variables    
        item.setCount(1);
        item.setWeight(12);    
        scrap = 0.5;
       
        //Expected output
        expResult = 6;
        
        //Call method
        result = ToolControl.chopWood(item, scrap);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tGathered Wood = " + result);
        
        
        //Test Case 7
        System.out.println("\n\tTest case 7");
        
        //Define the input variables    
        item.setCount(15);
        item.setWeight(1);    
        scrap = 0.5;
       
        //Expected output
        expResult = 7.5;
        
        //Call method
        result = ToolControl.chopWood(item, scrap);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tGathered Wood = " + result);
        
        
        //Test Case 8
        System.out.println("\n\tTest case 8");
        
        //Define the input variables    
        item.setCount(15);
        item.setWeight(12);    
        scrap = 0.5;
       
        //Expected output
        expResult = 90;
        
        //Call method
        result = ToolControl.chopWood(item, scrap);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tGathered Wood = " + result);
    }

}
