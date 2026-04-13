public class EnemyCLL {
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
    public Enemy getHead() {
    return head;
}
}