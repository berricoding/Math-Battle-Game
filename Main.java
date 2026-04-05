import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            GameManager game = new GameManager();
            game.startGame(sc); 
        }

        
       
    }
}