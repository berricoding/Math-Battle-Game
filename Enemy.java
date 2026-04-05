public class Enemy extends Character {
    Enemy next; // Circular Linked List

    public Enemy(int hp) {
        super("Enemy", hp);
    }
}