package com.jap.pizzaorderingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PizzaOrderingTest {
    PizzaOrdering pizzaOrdering;

    @BeforeEach
    void setUp() {
        pizzaOrdering = new PizzaOrdering();
    }

    @AfterEach
    void tearDown() {
        pizzaOrdering = null;
    }

    /* NOTE: Write a minimum of 4 assert statements for each test case */

    @Test
    public void givenPizzaChoiceAndSizeCalculateBill() {
       assertEquals(300, pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(0,2,"M")); 
       assertEquals(500, pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(0,5,"L")); 
       assertEquals(250, pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(0,3,"R")); 
       assertEquals(450, pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(0,1,"L")); 
       
    }

    @Test
    public void givenCrustChoiceEstimatePrice() {
       assertEquals(60, pizzaOrdering.estimatePriceOfCrust(1));
       assertEquals(80, pizzaOrdering.estimatePriceOfCrust(2));
       assertEquals(70, pizzaOrdering.estimatePriceOfCrust(3));
    
    }

    @Test
    public void givenToppingsChoiceEstimatePrice() {
    assertEquals(80, pizzaOrdering.estimatePriceOfToppings(1));
    assertEquals(120, pizzaOrdering.estimatePriceOfToppings(2));
    
    }

    @Test
    public void givenCrustAndToppingsCostCalculateTotalBill() {
          assertEquals(480, pizzaOrdering.calculateBillWithCrustAndToppings(300, 80, 100));
          assertEquals(720, pizzaOrdering.calculateBillWithCrustAndToppings(500, 100, 120));
          assertEquals(180, pizzaOrdering.calculateBillWithCrustAndToppings(0, 80, 100));
          assertEquals(160, pizzaOrdering.calculateBillWithCrustAndToppings(100, 60, 0));
    }

    @Test
    public void givenBreadChoiceCalculateTotalBill() {
      assertEquals(190, pizzaOrdering.calculateBillBasedOnChoiceOfBread(1, 100));
      assertEquals(280, pizzaOrdering.calculateBillBasedOnChoiceOfBread(2, 200));
    
    }

    @Test
    public void givenDrinksChoiceCalculateTotalBill() {
      assertEquals(160, pizzaOrdering.calculateBillBasedOnDrinksChoice(1, 100));
      assertEquals(360, pizzaOrdering.calculateBillBasedOnDrinksChoice(2, 300));
    }

    @Test
    public void givenTotalBillEstimateDiscountAmount() {
       assertEquals(25, pizzaOrdering.estimateDiscountAmount(500));
       assertEquals(130, pizzaOrdering.estimateDiscountAmount(1300));
       assertEquals(0, pizzaOrdering.estimateDiscountAmount(1500));
       assertEquals(49, pizzaOrdering.estimateDiscountAmount(990));
       
    }

    @Test
    public void givenDeliveryAndTipChargeCalculateFinalBill() {
        assertEquals(1150, pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(100, 50, 1000));
        assertEquals(650, pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(0, 0, 650));
        assertEquals(370, pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(50, 20, 300));
        assertEquals(530, pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(70, 10, 450));
    
    }

}
