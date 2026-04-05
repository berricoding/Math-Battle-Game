//Singly Linked List
//Singly Linked List is used in the leaderboard to store players sequentially.
public class Node {
    Player data;
    Node next;//Doubly Linked List
    Node prev;//Doubly Linked List is implemented in Node with prev and next pointers, allowing forward and backward traversal.

    public Node(Player data) {
        this.data = data;
    }
}