import java.util.Random;

public class MathQuestion implements Question {

    private String question;
    private int correctAnswer;

    public MathQuestion(int difficulty) {
        Random rand = new Random();

        if (difficulty == 1) { // Easy
            int a = rand.nextInt(10);
            int b = rand.nextInt(10);
            question = a + " + " + b;
            correctAnswer = a + b;

        } else if (difficulty == 2) { // Medium (power)
            int a = rand.nextInt(5) + 1;
            int b = rand.nextInt(3) + 2;
            question = a + "^" + b;
            correctAnswer = power(a, b);

        } else { // Hard (factorial + fibonacci)

    int type = rand.nextInt(2); 

    if (type == 0) {
        int n = rand.nextInt(5) + 3;
        question = n + "! (factorial)";
        correctAnswer = factorial(n);
    } else {
        int n = rand.nextInt(6) + 3; 
        question = "Fibonacci of " + n;
        correctAnswer = fibonacci(n);
    }
}
        }
    
    @Override
    public int ask() {
        System.out.println(question + " = ?");
        return correctAnswer;
    }

    //  recursion
    private int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    private int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

    private int power(int a, int b) {
        if (b == 0) return 1;
        return a * power(a, b - 1);
    }
    public String getQuestion() {
    return question;
}
}
