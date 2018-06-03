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
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

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

    /**
     * Test of repairWagon method, of class ToolControl.
     * Camren's test
     */
    @Test
    public void testRepairWagon() {
        System.out.println("repairWagon" + "\nCamren's Assignment");
        
        //Create object instances
        Wagon WAGON = new Wagon();
        InventoryItem WOOD = new InventoryItem();
        Tool HAMMER = new Tool();
        
        

        //Test Case 1
        System.out.println("\n\tTest case 1");
        
        //Define the input variables    
        WOOD.setItemType("Wood");
        WOOD.setCount(10);   
        HAMMER.setMultiplier(2);
        HAMMER.setToolType("Hammer");
        HAMMER.setDurability(80);
        WAGON.setHealth(60);
        WAGON.setMaxHealth(100);
       
        //Expected output
        int expResult = 80;
        
        //Call method
        int result = ToolControl.repairWagon(WOOD, HAMMER, WAGON);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Health = " + result);
        
        //Test Case 2
        System.out.println("\n\tTest case 2");
        
        //Define the input variables    
        WOOD.setItemType("Water");
        WOOD.setCount(12);   
        HAMMER.setMultiplier(2);
        HAMMER.setToolType("Hammer");
        HAMMER.setDurability(60);
        WAGON.setHealth(55);
        WAGON.setMaxHealth(100);
       
        //Expected output
        expResult = -1;
        
        //Call method
        result = ToolControl.repairWagon(WOOD, HAMMER, WAGON);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Health = " + result);
        
        //Test Case 3
        System.out.println("\n\tTest case 3");
        
        //Define the input variables    
        WOOD.setItemType("Wood");
        WOOD.setCount(11);   
        HAMMER.setMultiplier(2);
        HAMMER.setToolType("Hammer");
        HAMMER.setDurability(0);
        WAGON.setHealth(40);
        WAGON.setMaxHealth(100);
       
        //Expected output
        expResult = -2;
        
        //Call method
        result = ToolControl.repairWagon(WOOD, HAMMER, WAGON);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Health = " + result);
        
        //Test Case 4
        System.out.println("\n\tTest case 4");
        
        //Define the input variables    
        WOOD.setItemType("Wood");
        WOOD.setCount(0);   
        HAMMER.setMultiplier(2);
        HAMMER.setToolType("Hammer");
        HAMMER.setDurability(40);
        WAGON.setHealth(20);
        WAGON.setMaxHealth(100);
       
        //Expected output
        expResult = -3;
        
        //Call method
        result = ToolControl.repairWagon(WOOD, HAMMER, WAGON);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Health = " + result);
        
        //Test Case 5
        System.out.println("\n\tTest case 5");
        
        //Define the input variables    
        WOOD.setItemType("Wood");
        WOOD.setCount(5);   
        HAMMER.setMultiplier(2);
        HAMMER.setToolType("Gun");
        HAMMER.setDurability(80);
        WAGON.setHealth(75);
        WAGON.setMaxHealth(100);
       
        //Expected output
        expResult = -4;
        
        //Call method
        result = ToolControl.repairWagon(WOOD, HAMMER, WAGON);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Health = " + result);
        
        //Test Case 6
        System.out.println("\n\tTest case 6");
        
        //Define the input variables    
        WOOD.setItemType("Wood");
        WOOD.setCount(20);   
        HAMMER.setMultiplier(2);
        HAMMER.setToolType("Hammer");
        HAMMER.setDurability(20);
        WAGON.setHealth(80);
        WAGON.setMaxHealth(100);
       
        //Expected output
        expResult = 100;
        
        //Call method
        result = ToolControl.repairWagon(WOOD, HAMMER, WAGON);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Health = " + result);
        
        //Test Case 7
        System.out.println("\n\tTest case 7");
        
        //Define the input variables    
        WOOD.setItemType("Wood");
        WOOD.setCount(1);   
        HAMMER.setMultiplier(2);
        HAMMER.setToolType("Hammer");
        HAMMER.setDurability(100);
        WAGON.setHealth(80);
        WAGON.setMaxHealth(100);
       
        //Expected output
        expResult = 82;
        
        //Call method
        result = ToolControl.repairWagon(WOOD, HAMMER, WAGON);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Health = " + result);
        
        //Test Case 8
        System.out.println("\n\tTest case 8");
        
        //Define the input variables    
        WOOD.setItemType("Wood");
        WOOD.setCount(2);   
        HAMMER.setMultiplier(2);
        HAMMER.setToolType("Hammer");
        HAMMER.setDurability(1);
        WAGON.setHealth(70);
        WAGON.setMaxHealth(100);
       
        //Expected output
        expResult = 74;
        
        //Call method
        result = ToolControl.repairWagon(WOOD, HAMMER, WAGON);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Health = " + result);
        
        //Test Case 9
        System.out.println("\n\tTest case 9");
        
        //Define the input variables    
        WOOD.setItemType("Wood");
        WOOD.setCount(10);   
        HAMMER.setMultiplier(2);
        HAMMER.setToolType("Hammer");
        HAMMER.setDurability(100);
        WAGON.setHealth(0);
        WAGON.setMaxHealth(100);
       
        //Expected output
        expResult = 20;
        
        //Call method
        result = ToolControl.repairWagon(WOOD, HAMMER, WAGON);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Health = " + result);
        
        //Test Case 10
        System.out.println("\n\tTest case 10");
        
        //Define the input variables    
        WOOD.setItemType("Wood");
        WOOD.setCount(20);   
        HAMMER.setMultiplier(2);
        HAMMER.setToolType("Hammer");
        HAMMER.setDurability(40);
        WAGON.setHealth(60);
        WAGON.setMaxHealth(100);
       
        //Expected output
        expResult = 100;
        
        //Call method
        result = ToolControl.repairWagon(WOOD, HAMMER, WAGON);
        
        //compare expected result with returned result
        assertEquals(expResult, result, 0.0);
        System.out.println("\tNew Wagon Health = " + result);
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
