//Player inherited Character class
public class Player extends Character {
    private int score;

    public Player(String name, int hp) {
        super(name, hp);
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void addScore(int s) {
        score += s;
    }

    public int getScore() {
        return score;
    }
}