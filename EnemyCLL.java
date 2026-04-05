public class EnemyCLL {//Circular Linked List
    //Circular Linked List is used to loop enemies continuously where the last enemy connects back to the first.
    private Enemy head;

    public void add(Enemy e) {
        if (head == null) {
            head = e;
            head.next = head;
            return;
        }

        Enemy temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = e;
        e.next = head;
    }

    public Enemy getNextEnemy(Enemy current) {
        return current.next;
    }
}