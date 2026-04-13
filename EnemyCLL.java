public class EnemyCLL {
    private Enemy head;

    public void add(Enemy e) {
        if (head == null) {
            head = e;
            head.setNext(head); 
            return;
        }

        Enemy temp = head;
        while (temp.getNext() != head) {
            temp = temp.getNext();
        }

        temp.setNext(e);
        e.setNext(head);
    }

    public Enemy getNextEnemy(Enemy current) {
        return current.getNext(); 
    }

    public Enemy getHead() {
        return head;
    }
}