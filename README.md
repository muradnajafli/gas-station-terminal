# Gas station terminal 

## Purpose: 

Get familiar with the basic Kotlin syntax (types, conditions, functions). You will have experience with the Kotlin classes (data and sealed) and the visibility modifiers.

## Description:
Let’s consider that we need to implement an application for a gas station due to some business rules.
- Different vehicles can refuel at the gas station: Buses, Bikes, Cars, Trucks.
- The gas station has two types of fuel: Diesel and Petrol. Bikes and Cars use Petrol. Buses and Trucks use Diesel.
- Each vehicle has information about the fuel type (Diesel or Petrol), the volume of the tank (liters). Each fuel has information about the cost per liter ($) and the available discount (%).
- When a user tries to fill the tank and exceeds its volume, the application will show an error notification. The same situation with the incorrect discount availability. The application should ask the user to enter data one more time. 
- Enter data include vehicle type, discount availability, and liters quantity. Discounts values, fuel cost, and volume of the tank are hardcoded.
- Exit data includes total fuel price (as string).

## Task: 
Create a program that meets the requirements from the description. You will need to:
- Read java doc (you can find it inside classes). Java doc includes some additional information.
- Check codebase and solve all compilation errors.
- Change “TODO()” and fill functions body with your own Kotlin code that will complete the program and pass unit tests.
