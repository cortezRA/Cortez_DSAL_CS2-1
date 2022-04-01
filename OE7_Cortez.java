import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OE7_Cortez {
    
    public static void main(String[] args) {
        HashMap<String, String> NameFood = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int operation = 0;

        do {
            System.out.println("\n\n--  Welcome to HashMap's Food Hub  --");
            System.out.println("\n[1] - Insert A New Food Lover");
            System.out.println("[2] - Traverse All Food Lovers");
            System.out.println("[3] - Search For A Food Lover");
            System.out.println("[4] - Exit Food Hub");
            System.out.print("\nWhat would you like to do? ");
            operation = in.nextInt();
            System.out.println();

            if (operation == 1) {
                System.out.println("\n-- INSERTING NEW FOOD LOVERS --");
                System.out.print("\nHow many food lovers would you like to add to our food hub? ");
                int size = in.nextInt(); String name; String food;

                for (int x = 0; x < size; x++) {

                    System.out.print("\n\nName of Food Lover (1 word only): ");
                    name = in.next();

                    System.out.print("\nFavorite Food/Restaurant Chain (1 word only): ");
                    food = in.next();

                    NameFood.put(name, food);
                }

            } else if (operation == 2) {
                System.out.println("\n-- SHOWING ALL FOOD LOVERS --\n");
                NameFood.forEach((k, v)
                    -> System.out.println("- " + k + " loves " + v + "..."));
            } else if (operation == 3) {
                String name; String food; int method = 0; String value1; String value2;
                
                System.out.println("\n-- SEARCHING FOR A FOOD LOVER --");
                System.out.println("\n[1] - Search For Name");
                System.out.println("[2] - Search For Favorite Food Restaurant Chain");
                System.out.println("[3] - Return To Main Menu");
                System.out.print("\nHow would you like to search? ");
                method = in.nextInt();
                
                if (method == 1) {
                    System.out.print("\nEnter name: ");
                    name = in.next();

                    for (Map.Entry<String, String> entry : NameFood.entrySet()) {
                        if (entry.getKey().contains(name)) {
                            System.out.println(entry.getValue() + " is " + name + "'s favourite food!");
                        }
                    }
                } else if (method == 2) {
                    System.out.print("\nEnter Food or Restaurant Chain: ");
                    food = in.next();

                    for (Map.Entry<String, String> entry : NameFood.entrySet()) {
                        if (entry.getValue().contains(food)) {
                            System.out.println("\n" + entry.getKey() + "'s favorite food is " + food + "!");
                        }
                    }
                } else {
                    System.out.println("\n-- RETURNING TO MAIN MENU --");
                }
            } else if (operation == 4) {
                System.out.println("\nProgram shutting down...");
                return;
            } else {
                System.out.println("-- RETURNING TO MAIN MENU --");
            }   
        } while (operation != 4);
    }
}
