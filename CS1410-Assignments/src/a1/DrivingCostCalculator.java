package a1;

//CS1410 Assignment 1: Driving Cost Calculator by Jorge Orozco

public class DrivingCostCalculator {

	/* The method below calculateGasTripCost calculates the cost of a trip in a gas vehicle
	 * by using the three double values within the parenthesis.
	 * These values are sent from the main method to this method.
	 * It stores (distance/MPG) inside the numberOfGallons double variable.
	 * Then multiplies it by the dollars per gallon and stores the value in gasVehicleCostTrip double variable.
	 * This value is then returned to the main method.
	 */
	public static double calculateGasTripCost(double milesToDrive, double milesPerGallon, double dollarsPerGallon) {
		double numberOfGallons = milesToDrive / milesPerGallon;  
		double gasVehicleTripCost = numberOfGallons * dollarsPerGallon; 
		return gasVehicleTripCost; 
	}
	
	/* The method below calculateElectricTripCost calculates the cost of a trip in an electric vehicle
	 * by using the three double variables within the parenthesis.
	 * These values are sent from the main method to this method.
	 * It stores the product of (distance/miles per kilowatt) in the numberOfHours double variable. 
	 * Then multiplies it by the dollars per kilowatt and stores this value inside the electricVehhicleTripCost double variable. 
	 * This value is returned to the main method.
	 */
	public static double calculateElectricTripCost(double milesToDrive, double milesPerKWh, double dollarsPerKWh) {
		double numberOfHours = milesToDrive / milesPerKWh; 
		double electricVehicleTripCost = numberOfHours * dollarsPerKWh;
		return electricVehicleTripCost;
		

	}
	
	
	/* The method below displayBanner does not return a value to the main method.
	 * It simply displays an output in the console. 
	 */
	public static void displayBanner() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("Driving Cost Calculator");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(" ");

	}

	
	
	
	public static void main(String[] args) {
		displayBanner();
		double drivingDistance = 100;
		double milesPGallon = 10;
		double costPerGallon = 3;
		double electricVehicleMilesPerKilowatt = 3;
		double costPerKilowatt = 0.106 ;
		double gasVehicleCostOfTheTrip = calculateGasTripCost(drivingDistance, milesPGallon, costPerGallon);
		double electricCarCostOfTheTrip = calculateElectricTripCost (drivingDistance, electricVehicleMilesPerKilowatt, costPerKilowatt); 
		String formattedNumberGasVehicleCostOfTheTrip = String.format("%.2f", gasVehicleCostOfTheTrip);
		String formattedNumberElectricVehicleCostOfTheTrip = String.format("%.2f", electricCarCostOfTheTrip);
		System.out.print("The cost of a " + drivingDistance); 
		System.out.print(" mile trip by gas is $" + formattedNumberGasVehicleCostOfTheTrip);
		System.out.print(" and by electric is $" + formattedNumberElectricVehicleCostOfTheTrip);
		
		

	}

}
