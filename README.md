# Gas station terminal 

## Purpose: 

Get familiar with basic Kotlin syntax (types, conditions, functions). You will have experience with Kotlin classes (data and sealed), visibility modifiers.

## Description:
Let’s consider that we need to implement application for gas station due to business rules.  
- Different vehicles can refuel at this gas station: Bus, Bike, Car, Truck 
- Gas station has two types of fuel: Diesel and Petrol. Bike and Car use Petrol. Bus and Truck use Diesel. 
- Each vehicle has information about fuel type (Diesel or Petrol), volume of the tank (liters). Each fuel has information about cost per liter ($) and available discount (%). 
- In case when user will try to fill tank more than volume of it, application will show error notification. The same situation with incorrect discount availability. Application should ask user to enter data one more time. 
- Enter data: vehicle type, discount availability and liters quantity. Discounts values, fuel cost and volume of tank are hardcoded. 
- Exit data: total fuel price (as string). 

## Task: 
Create a program that meets the requirements from the description. What do you need to do: 
- Read java doc (you can find it inside of classes). Java doc includes some additional information. 
- Check codebase and solve all compilation errors 
- Instead “TODO()” fill functions body by your own Kotlin code that will complete program and will pass unit tests 
