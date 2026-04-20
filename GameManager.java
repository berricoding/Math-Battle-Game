import java.util.*;
import java.io.*;
public class GameManager {
    // Queue is used to manage questions in FIFO order (First-In-First-Out)
    // Generics ensure type safety by only allowing Question objects
    private Queue<Question> questions = new LinkedList<>(); 
    // Stack is used to store history in LIFO order (Last-In-First-Out)
    // Generics ensure only String data is stored safely
    private Stack<String> history = new Stack<>(); 
    // Set is used to prevent duplicate questions
    // Generics ensure only String values (questions) are stored
    private Leaderboard leaderboard = new Leaderboard();

    private int damage = 10;

    // needed for round-based enemy rotation)
    private static int roundCounter = 0;

    public void startGame(Scanner sc) {
    // Scanner is used to take user input from the keyboard
    // This allows interaction between the user and the game
    System.out.println("Enter name (or type exit): ");
    String name = sc.nextLine();
    saveHistoryToFile();

    if (name.equalsIgnoreCase("exit")) {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    int difficulty = 0;

    while (true) {
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("Choice: ");
     //The program uses both built-in exceptions and a custom exception to handle invalid user input safely.
        try {
            difficulty = Integer.parseInt(sc.nextLine());

        if (difficulty < 1 || difficulty > 3) {
    // custom exception is thrown for invalid difficulty range
    // This improves code readability and separates custom error logic from general exceptions
        throw new InvalidChoiceException("Please choose between 1 and 3 only!");
                }
             break;
            }
    // handles custom exception with specific message
    //It ensures the program continues running and improves user experience
        catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            } 
        catch (Exception e) { //handles built-in exceptions (e.g., non-numeric input)
                System.out.println("Invalid input! Please enter a number:");
            }
        }

    Player player = new Player(name, 100);

    // Create circular linked list of enemies
    EnemyCLL enemyList = new EnemyCLL();
    Enemy enemy1 = new Enemy("Enemy 1", 100);
    Enemy enemy2 = new Enemy("Enemy 2", 100);
    Enemy enemy3 = new Enemy("Enemy 3", 100);

    enemyList.add(enemy1);
    enemyList.add(enemy2);
    enemyList.add(enemy3);

    
    Enemy enemy = enemyList.getHead();

    // rotate enemy based on roundCounter
    for (int i = 0; i < roundCounter % 3; i++) {
         enemy = enemyList.getNextEnemy(enemy);
        }

     // demonstrate circular behavior
    System.out.println("Current: " + enemy.name);

    // Demonstrate circular behavior
    Enemy nextEnemy = enemyList.getNextEnemy(enemy);
    System.out.println("Next enemy (circular): " + nextEnemy.name);
    loadQuestions(difficulty);

    while (player.getHp() > 0 && enemy.getHp() > 0) {

        if (questions.isEmpty()) {
                loadQuestions(difficulty);
            }

    Question q = questions.poll();

    int correct = q.ask();
    int ans = 0;

    while (true) {
        System.out.print("Answer: ");

    try {
        ans = Integer.parseInt(sc.nextLine());
                 break; 

         } 
    catch (Exception e) {
            System.out.println("Invalid input! Please enter a number:");
                }
            }

    history.push("Correct: " + correct + " Your: " + ans);

    if (ans == correct) {
        enemy.takeDamage(damage);
        player.addScore(10);
        System.out.println("Correct!");
        } else {
                player.takeDamage(damage);
                System.out.println("Wrong!");
            }

    System.out.println(name + " HP: " + player.getHp());
    System.out.println("Enemy HP: " + enemy.getHp());
        }

    System.out.println(player.getHp() > 0 ? "YOU WIN!" : "ENEMY WINS!");

    leaderboard.add(player);
    leaderboard.display();

    System.out.println("\nHistory:");
    showHistoryRecursive(history);

    roundCounter++;
    }

    private void loadQuestions(int d) {

    Set<String> used = new HashSet<>();
    int limit = (d == 3) ? 5 : 10; 

    while (used.size() < limit) {
         MathQuestion mq = new MathQuestion(d);

        if (!used.contains(mq.getQuestion())) {
            questions.add(mq);
            used.add(mq.getQuestion());
            }
        }
    }
    private void saveHistoryToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("history.txt", true))) {
        for (String record : history) {
            writer.write(record);
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println("Error writing to file.");
    }
}

    private void showHistoryRecursive(Stack<String> stack) {
         Stack<String> temp = new Stack<>();
    temp.addAll(stack);
     showHelper(temp);
    }

    private void showHelper(Stack<String> stack) {
        if (stack.isEmpty()) return;

    String top = stack.pop();
    showHelper(stack);
    System.out.println(top);
}
}