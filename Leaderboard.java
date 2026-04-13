

public class Leaderboard {
    private Node head;

    public void add(Player p) {
        Node newNode = new Node(p); 

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void display() {
        System.out.println("\nLeaderboard:");
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.data.getName() + " : " + temp.data.getScore());
            temp = temp.next;
        }
    }
}