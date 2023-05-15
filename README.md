# Gas station terminal 

## Purpose: 

Get familiar with basic Kotlin syntax (types, conditions, functions). You will have experience with Kotlin classes (data and sealed), visibility modifiers.

## Description:
Let’s consider that we need to implement application for gas station due to business rules.  
- Different vehicles can refuel at this gas station: `Bus`, `Bike`, `Car`, `Truck` 
- Gas station has two types of fuel: `Diesel` and `Petrol`. Bike and car use **petrol**. Bus and truck use **diesel**. 
- Each vehicle has information about `Fuel` type (diesel or petrol) and **volume** of the tank (liters). Each fuel has information about **cost** per liter($) and available **discount**(%). 
- In case when user will try to fill tank more than volume of it, application will show error notification. The same situation with incorrect discount availability. Application should ask clients to enter until it will be valid. 
- Client should enter a vehicle type, discount availability and liters quantity. All this data should be used to prepare an order, which represents in code as `Bill`. 
- *IMPORTANT:* Discounts values, fuel cost and volume of tank are hardcoded. 
- At the end of the program clients should be able to check their order by printing in the terminal fully prepared `Bill`

The main idea is to create a blank/default `Bill` and then update it step-by-step.

## Task: 
Create a program that meets the requirements from the description. What do you need to do: 
- Read java doc (you can find it inside of classes). Java doc includes some additional information. 
- Check codebase and solve all compilation errors 
- Instead of `TODO()` fill functions body by your own Kotlin code that will complete program and will pass unit tests
