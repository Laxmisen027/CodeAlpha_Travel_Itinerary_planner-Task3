import java.util.ArrayList;
import java.util.Scanner;

class TravelDestination {
    String destination;
    String startDate;
    String endDate;
    double budget;

    public TravelDestination(String destination, String startDate, String endDate, double budget) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public void displayDestination() {
        System.out.println("Destination: " + destination);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Budget: ₹" + budget);
        System.out.println("Weather: (To be fetched from API)");
        System.out.println("Map: (To be integrated with map API)");
        System.out.println("---------------------------");
    }
}

class TravelPlanner {
    private ArrayList<TravelDestination> itinerary = new ArrayList<>();
    private double totalBudget = 0;

    public void addDestination(String destination, String startDate, String endDate, double budget) {
        TravelDestination newDestination = new TravelDestination(destination, startDate, endDate, budget);
        itinerary.add(newDestination);
        totalBudget += budget;
    }

    public void displayItinerary() {
        System.out.println("Your Travel Itinerary:");
        for (TravelDestination destination : itinerary) {
            destination.displayDestination();
        }
        System.out.println("Total Budget: $" + totalBudget);
    }
}

public class TravelItineraryPlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TravelPlanner planner = new TravelPlanner();
        String moreDestinations = "yes";

        while (moreDestinations.equalsIgnoreCase("yes")) {
            System.out.println("Enter Destination:");
            String destination = sc.nextLine();

            System.out.println("Enter Start Date (dd/mm/yyyy):");
            String startDate = sc.nextLine();

            System.out.println("Enter End Date (dd/mm/yyyy):");
            String endDate = sc.nextLine();

            System.out.println("Enter Budget for this destination:");
            double budget = sc.nextDouble();
            sc.nextLine();  // Consume newline

            planner.addDestination(destination, startDate, endDate, budget);

            System.out.println("Do you want to add more destinations? (yes/no)");
            moreDestinations = sc.nextLine();
        }

        planner.displayItinerary();
        sc.close();
    }
}
