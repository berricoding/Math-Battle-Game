
import java.util.*;

public class GameManager {

    private Queue<Question> questions = new LinkedList<>(); //Queue is used to manage questions in FIFO order.
    private Stack<String> history = new Stack<>(); //Stack is used to store answer history in LIFO order.
    private Leaderboard leaderboard = new Leaderboard();

    private int damage = 10;

    public void startGame(Scanner sc) {


     System.out.print("Enter name (or type exit): ");
     String name = sc.nextLine();

    if (name.equalsIgnoreCase("exit")) {
    System.out.println("Goodbye!");
    System.exit(0);
}

        int difficulty = 0;

        while (true) {
            try {
                System.out.println("1. Easy");
                System.out.println("2. Medium");
                System.out.println("3. Hard");
                System.out.print("Choice: ");

                difficulty = sc.nextInt();
                sc.nextLine();

                if (difficulty < 1 || difficulty > 3)
                    throw new InvalidChoiceException("1-3 only");

                break;

            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.next();
            }
           
        }

        Player player = new Player(name, 100);
        Enemy enemy = new Enemy(100);

        loadQuestions(difficulty);

        while (player.getHp() > 0 && enemy.getHp() > 0) {

   
    if (questions.isEmpty()) {
        loadQuestions(difficulty);
    }

    Question q = questions.poll();

    int correct = q.ask();

    System.out.print("Answer: ");

    int ans = 0;

    try {
        ans = sc.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Numbers only!");
        sc.next();
        continue;
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

    System.out.println("Player HP: " + player.getHp());
    System.out.println("Enemy HP: " + enemy.getHp());
}

        System.out.println(player.getHp() > 0 ? "YOU WIN!" : "ENEMY WINS!");

        leaderboard.add(player);
        leaderboard.display();

        System.out.println("\nHistory:");
        showHistoryRecursive(history);
    }

  private void loadQuestions(int d) {

    Set<String> used = new HashSet<>();

    int count = 0;

    while (count < 10) {

        MathQuestion mq = new MathQuestion(d);

        if (!used.contains(mq.getQuestion())) {
            questions.add(mq);
            used.add(mq.getQuestion());
            count++;
        }
    }
}


    // RECURSION
    //Recursion is used to display history by repeatedly popping elements from the stack.
    private void showHistoryRecursive(Stack<String> stack) {//Stack
        if (stack.isEmpty()) return;

        String top = stack.pop();//Stack
        System.out.println(top);

        showHistoryRecursive(stack);
    }
}