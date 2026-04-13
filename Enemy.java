// Enemy class demonstrating encapsulation
public class Enemy extends Character {

    // private field (hidden from outside)
    private Enemy next;

    public Enemy(String name, int hp) {
        super(name, hp);
    }

    // Getter for next (controlled access)
    public Enemy getNext() {
        return next;
    }

    // Setter for next (controlled modification)
    public void setNext(Enemy next) {
        this.next = next;
    }
}