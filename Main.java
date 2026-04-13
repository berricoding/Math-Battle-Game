import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            GameManager game = new GameManager();
            game.startGame(sc);


         while (true) {
             System.out.print("Play again? (yes/no): ");
            String choice = sc.nextLine().toLowerCase(); // Scanner is used to take user input from the keyboard

         if (choice.contains("yes")) {
         break; 
     } 
          else if (choice.contains("no")) {
           System.out.println("Goodbye!");
          return;
    } 
    else {
        System.out.println("Invalid input! Please type yes or no.");
    }
}

            }
        }
    }
