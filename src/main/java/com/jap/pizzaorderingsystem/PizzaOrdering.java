package com.jap.pizzaorderingsystem;

import java.util.Formatter;
import java.util.Scanner;

public class PizzaOrdering {
    public static void main(String[] args) {
        // Make no changes to the main method
        PizzaOrdering pizzaOrdering = new PizzaOrdering();

        String name = "";
        String email = "";
        long phoneNo = 0;
        String address = "";

        // Input customer details
        Scanner scanner = new Scanner(System.in);
        System.out.println("!!! Welcome !!!");
        System.out.println("!!! Enter customer details for placing an order !!!");

        System.out.println("Enter your Name");
        name = scanner.next();
        System.out.println("Enter your Email");
        email = scanner.next();
        System.out.println("Enter your ContactNo.");
        phoneNo = scanner.nextLong();
        System.out.println("Enter your Address");
        address = scanner.next();
        scanner.nextLine();
        System.out.println("\n");
        System.out.println("!!! Thank you for providing your details !!!");
        System.out.println("\n");

        // Display main menu and estimate bill based on user's choice
        int totalPizzaBill = 0;
        totalPizzaBill = pizzaOrdering.displayMenuAndCalculateTotalBill(totalPizzaBill);
        System.out.println("\n");
        System.out.println("Total amount : " + totalPizzaBill);
        System.out.println("\n");

        // Estimate discount amount based on total pizza bill and calculate final bill.
        int discountAmount = pizzaOrdering.estimateDiscountAmount(totalPizzaBill);
        int billAfterDiscount = totalPizzaBill - discountAmount;
        System.out.println("\n");

        // Input the type of delivery of order and add delivery fee and tip charge to total bill
        System.out.println("Please enter 1 for Pick up and 2 for delivery");
        int delivery = scanner.nextInt();
        int deliveryCharge = 0;
        int tipCharge = 0;

        if (delivery == 2) {
            deliveryCharge = 100;
            System.out.println("\n");
            System.out.println("Do you want to give tip to Delivery Boy (yes/no)?");
            String tip = scanner.next();
            if ("yes".equals(tip)) {
                System.out.println("Please enter tip amount :");
                tipCharge = scanner.nextInt();
            }
        }

        // Estimate and display final pizza order bill
        int finalBill = pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(deliveryCharge, tipCharge, billAfterDiscount);
        pizzaOrdering.displayFinalBill(name, phoneNo, totalPizzaBill, discountAmount, deliveryCharge, tipCharge, finalBill);
    }


    // Function to display main menu and call respective methods based on user's choice
    // Do not change the method
    public int displayMenuAndCalculateTotalBill(int totalPizzaBill) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the item from the Main Menu");
        System.out.println("\n");

        int input = 0;
        do {
            System.out.format("%10s %30s", "Srno", "Item Category\n");
            System.out.format("%10s %30s", "1", "Pizza\n");
            System.out.format("%10s %30s", "2", "Garlic Bread\n");
            System.out.format("%10s %30s", "3", "Beverages\n");
            System.out.println();
            System.out.println("Enter your Choice of item");
            int choiceForItems = scanner.nextInt();

            if (choiceForItems == 1) {
                System.out.println("Please enter the number of pizza you want to order :");
                int noOfPizza = scanner.nextInt();
                totalPizzaBill = displayPizzaChoicesAndCalculateTotalBill(noOfPizza, totalPizzaBill);
            } // End of pizza

            else if (choiceForItems == 2) {
                totalPizzaBill = displayBreadChoiceAndCalculateBill(totalPizzaBill);
            }// End of breads

            else if (choiceForItems == 3) {
                totalPizzaBill = displayDrinksChoicesAndCalculateBill(totalPizzaBill);
            } // End of drinks

            System.out.println("\n");
            System.out.println("Your total Pizza Bill :" + totalPizzaBill);
            System.out.println("\n");
            System.out.println("Do you want to place another order enter 1 to continue or 0 to exit");
            input = scanner.nextInt();

        } while (input == 1);
        return totalPizzaBill;
    }


    public int displayPizzaChoicesAndCalculateTotalBill(int noOfPizza, int totalPizzaBill) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < noOfPizza; i++) {
            // Call the method displayPizzaChoices() to display pizza choices
            displayPizzaChoices();
            System.out.println("\nEnter your Choice of Pizza :");
            // accept the choice of pizza from user
            int pizzaChoice = scanner.nextInt();
            // accept the size of the pizza
            System.out.println("Enter Size of Pizza (L for Large, M for Medium, R for Regular) :");
            String pizzaSize = scanner.next();
            // Call the method calculateBillBasedOnPizzaChoiceAndSize(totalPizzaBill, pizzaChoice, pizzaSize)
            // to calculate total bill amount based on pizza choice and size
            totalPizzaBill = calculateBillBasedOnPizzaChoiceAndSize(totalPizzaBill, pizzaChoice, pizzaSize);

            // Accept the choice of crust from user
            System.out.println("Do you want to choose Crust of your choice (yes/no)?");
            String choiceOfCrust = scanner.next();
            // Call method displayCrustChoicesAndEstimatePrice(choiceOfCrust) to display the crust choice
            // and returns cost based on crust choice
            
            int costOfCrust = displayCrustChoicesAndEstimatePrice(choiceOfCrust);
            System.out.println("\n");
            // Accept the choice of extra toppings from user
            System.out.println("Do you want to choose extra Toppings (yes/no)?");
            String choiceOfToppings = scanner.next();
            // Call method displayToppingsAndEstimatePrice(choiceOfToppings) to display the choice of toppings
            // and returns the cost of the toppings based on toppings choice
            int costOfToppings = displayToppingsAndEstimatePrice(choiceOfToppings);

            // Call method calculateBillWithCrustAndToppings(totalPizzaBill, costOfCrust, costOfToppings)
            // to calculate the total cost of the pizza
            totalPizzaBill = calculateBillWithCrustAndToppings(totalPizzaBill, costOfCrust, costOfToppings);
        }
        // return the total amount
        return totalPizzaBill;
    }

    // Function displays choices of pizza
    public void displayPizzaChoices() {
        // Use System.out.format to display the menu in a tabular format
        
           System.out.format("\n%s %10s %15s %10s %10s","S.No ","Pizza                      ","Regular","Medium","Large");
           System.out.println("\n-------------------------------------------------------------------------");
           System.out.format("\n%s %10s %15s %10s %10s","1    ","African Peri Peri Veg      ","100 ","350","450");
           System.out.format("\n%s %10s %15s %10s %10s","2    ","Barbecue Veg               ","150 ","300","400");
           System.out.format("\n%s %10s %15s %10s %10s","3    ","Jamaican Jerk Veg          ","250","350","450");
           System.out.format("\n%s %10s %15s %10s %10s","4    ","What-a-pizza Exotic        ","200","300","400");
           System.out.format("\n%s %10s %15s %10s %10s","5    ","English Cheddar and Veggies","175","375","500");
           
    }

    // Function calculates total pizza bill based on choice of pizza and its size
    public int calculateBillBasedOnPizzaChoiceAndSize(int totalPizzaBill, int pizzaChoice, String pizzaSize) {
       // write logic to calculate the cost of pizza based on pizza choice and size
       // return the cost calculated
       switch (pizzaChoice) {
	              case 1:  switch(pizzaSize) {
	                        case "R":  return totalPizzaBill+100;
	                                   
	                        case "M":  return totalPizzaBill+350;
	                                   
	                        case "L":  return totalPizzaBill+450;
	                                    	
	                       }
	             
	              case 2:  switch(pizzaSize) {
                            case "R":  return totalPizzaBill+150;
                             
                            case "M":  return totalPizzaBill+300;
                             
                            case "L":  return totalPizzaBill+400;
                              	
                 }
	              
	              case 3:  switch(pizzaSize) {
	              			case "R":  return totalPizzaBill+250;
                             
	              			case "M":  return totalPizzaBill+350;
                             
	              			case "L":  return totalPizzaBill+450;
                              	
                 }
	              
	              case 4:  switch(pizzaSize) {
                            case "R":  return totalPizzaBill+200;
                             
                            case "M":  return totalPizzaBill+300;
                             
                            case "L":  return totalPizzaBill+400;
                              	
                 }
	              
	              case 5:  switch(pizzaSize) {
                            case "R":  return totalPizzaBill+175;
                             
                            case "M":  return totalPizzaBill+375;
                             
                            case "L":  return totalPizzaBill+500;
                              	
                 }
	

       }
    	return -1;
    }

    // Function displays choices of crusts and calls method to estimate cost of crust
    public int displayCrustChoicesAndEstimatePrice(String choiceOfCrust) {
         int crustChoice=0;
         int costOfCrust=0;
           //Call method estimatePriceOfCrust(crustChoice) to estimate the cost and return the cost
         if(choiceOfCrust.equals("yes")) {
         Scanner scanner=new Scanner(System.in);
         System.out.format("\n%s %10s %15s","S. No.","Crust              ","Price (in Rupees)");
         System.out.println("\n-----------------------------------------------");
         System.out.format("\n%s %10s %5s","1     ","Wheat Thin Crust   ","  60");
         System.out.format("\n%s %10s %5s","2     ","Fresh Pan Base     ","  80");
         System.out.format("\n%s %10s %5s","3     ","Hand Tossed        ","  70");
         System.out.println("\nEnter your choice of crust: ");
         crustChoice=scanner.nextInt();
         costOfCrust=estimatePriceOfCrust(crustChoice);
         return costOfCrust;
         }
         else 
         {
        	 return costOfCrust;
         }
    }

    // Function estimates cost of crust based on user's choice of crust
    public int estimatePriceOfCrust(int crustChoice) {
        //write logic to calculate the estimated price based on choice of crust
        // return the estimated price
        
        switch(crustChoice) {
        case 1: return 60;
        case 2: return 80;
        case 3: return 70;
        }
    	
    	
    	return 0;
    }

    // Function displays choices of toppings ans calls method to estimate price of topping
    public int displayToppingsAndEstimatePrice(String choiceOfToppings) {
        // Call method estimatePriceOfToppings(int toppingsChoice) to estimate the cost and return the cost
    	Scanner scanner=new Scanner(System.in);
    	int toppingsChoice;
    	int costOfToppings;
       if(choiceOfToppings.equals("no")) {
    	   return 0;
       }
       System.out.format("\n%s %10s %15s","S. No.","Toppings          ","Price (in Rupees)");
       System.out.println("\n-----------------------------------------------");
       System.out.format("\n%s %10s %5s","1     ","Extra Cheese       ","  80");
       System.out.format("\n%s %10s %5s","2     ","Veg Toppings       ","  120");
       System.out.println("\nEnter your choice of Toppings: ");
       toppingsChoice=scanner.nextInt();
       costOfToppings = estimatePriceOfToppings(toppingsChoice);
       return costOfToppings;
    }

    // Function estimates cost of toppings based on user's choice of toppings
    public int estimatePriceOfToppings(int toppingsChoice) {
        //write logic to calculate the estimated price based on choice of toppings
        // return the estimated price
    	switch(toppingsChoice) {
    	case 1: return 80;
    	case 2: return 120;
    	}
        return 0;
    }

    // Function calculates total pizza bill by adding cost of crust and toppings
    public int calculateBillWithCrustAndToppings(int totalPizzaBill, int costOfCrust, int costOfToppings) {
       return totalPizzaBill+costOfCrust+costOfToppings;
    }

    // Function displays choices of bread and calls method to calculates total bill
    public int displayBreadChoiceAndCalculateBill(int totalPizzaBill) {
        // display the choice of breads
    	 Scanner scanner=new Scanner(System.in);
    	 int breadChoice;
    	 
    	 System.out.format("\n%s %10s %5s","S. No.","Bread                     ","Price (in Rupees)");
    	 System.out.println("\n-----------------------------------------------------");
         System.out.format("\n%s %10s %5s","1     ","Stuffed Garlic Bread       ","  90");
         System.out.format("\n%s %10s %5s","2     ","Plain Garlic Bread Sticks  ","  80");
         System.out.println("\nEnter your choice of Bread: ");
         breadChoice=scanner.nextInt();
         totalPizzaBill = calculateBillBasedOnChoiceOfBread(breadChoice, totalPizzaBill);
       // Call the method calculateBillBasedOnChoiceOfBread(breadChoice, totalPizzaBill) to calculate total cost
       // return the total bill amount
        return totalPizzaBill;
    }

    // Function estimates cost of bread based on user's choice and adds it to the total pizza bill
    public int calculateBillBasedOnChoiceOfBread(int breadChoice, int totalPizzaBill) {
        // write logic to calculate the cost of bread based on choice and add it to the total pizza bill amount
        // return the cost calculated
    	switch(breadChoice) {
    	case 1: return totalPizzaBill+90;
    	case 2: return totalPizzaBill+80;
    	}

        return 0;
    }

    // Function displays choices of drinks and calls method to calculates total bill
    public int displayDrinksChoicesAndCalculateBill(int totalPizzaBill) {
       //display the choice of drinks
    	Scanner scanner=new Scanner(System.in);
   	    int drinksChoice;
   	 
   	    System.out.format("\n%s %10s %5s","S. No.","Beverage    ","Price (in Rupees)");
   	    System.out.println("\n---------------------------------------------");
        System.out.format("\n%s %10s %5s","1     ","Pepsi       ","  60");
        System.out.format("\n%s %10s %5s","2     ","Coke        ","  60");
        System.out.println("\nEnter your choice of Beverage: ");
        drinksChoice=scanner.nextInt();
        totalPizzaBill = calculateBillBasedOnDrinksChoice(drinksChoice, totalPizzaBill);
        //Call the method calculateBillBasedOnDrinksChoice(drinksChoice, totalPizzaBill) to calculate total cost
        // return the cost calculated;

        return totalPizzaBill;
    }

    // Function estimates cost of drink based on user's choice and adds it to the total pizza bill
    public int calculateBillBasedOnDrinksChoice(int drinksChoice, int totalPizzaBill) {
        // write logic to calculate the cost of drinks based on choice and add it to the total pizza bill amount
        // return the cost calculated
        switch(drinksChoice) {
        case 1: return totalPizzaBill+60;
        case 2: return totalPizzaBill+60;
        }
        return 0;
    }

    // Function calculates discount amount based on total pizza bill
    // Do not change the method
    public int estimateDiscountAmount(int totalPizzaBill) {
        int discount = 0;
        int discountamount = 0;

        if (totalPizzaBill >= 500 && totalPizzaBill < 1000) {
            discount = 5;
            discountamount = (totalPizzaBill * discount) / 100;

        } else if (totalPizzaBill >= 1000 && totalPizzaBill < 1500) {
            discount = 10;
            discountamount = (totalPizzaBill * discount) / 100;
        }
        return discountamount;
    }

    // Function calculates final bill by adding delivery fee and tip charge to total bill
    // Do not change the method
    public int calculateFinalBillBasedOnDeliveryChargeAndTipCharge(int deliveryCharge, int tipCharge, int finalBill) {
        return finalBill + deliveryCharge + tipCharge;
    }

    // Function displays final bill with all necessary details to customer
    // Do not change the method
    public void displayFinalBill(String name, long phoneNo, int totalPizzaBill, int discountAmount, int deliveryCharge, int tipCharge, int finalBill) {
        System.out.println("--------------------------------------------------------");
        System.out.println(" !!! BILL REPORT !!!");
        System.out.println(" Customer Name     : " + name + " \n");
        System.out.println(" Contact No.       : " + phoneNo + " \n");
        System.out.println(" Total Amount      : " + totalPizzaBill + " \n");
        System.out.println(" Discount Applied  : " + "- " + discountAmount + " \n");
        System.out.println(" Delivery Fee      : " + "+ " + deliveryCharge + " \n");
        System.out.println(" Tip               : " + "+ " + tipCharge + " \n");
        System.out.println(" Total Amount      : " + finalBill + " \n");
        System.out.println("--------------------------------------------------------");
    }
}
