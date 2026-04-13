//Player and Enemy inherited character
//The Player and Enemy classes inherit from the abstract Character class, allowing them to reuse common properties like name and hp.
//Inheritance allows code reuse and establishes an is-a relationship (Player/ Enemy is a Character)


public abstract class Character ////Abstraction hides implementation details and shows only essential features
{
    protected String name;
    protected int hp;

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
    }
}
