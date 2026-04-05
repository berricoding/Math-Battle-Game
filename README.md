# Math-Battle-Game
To enhance users’ mathematical skills through a structured and interactive game-based learning system.

//✅Stack → GameManager (history)

👉 Used in:
history.push(...)
showHistoryRecursive()

📌 Explanation:

Stack is used to store the player’s answer history in LIFO (Last In First Out) order.
The most recent answer is stored on top and displayed first when popping.

//✅ Queue → GameManager (questions)

👉 Used in:
questions.add(...) → enqueue
questions.poll() → dequeue

📌 Explanation:

Queue is used to manage questions in FIFO (First In First Out) order.
Questions are asked in the same order they are generated.

//✅ SLL (Singly Linked List) → Leaderboard

👉 Used in:
add(Player p)
display()

📌 Explanation:

Singly Linked List is used to store players in the leaderboard sequentially.
Each node points to the next player, allowing traversal from start to end.

//✅ DLL (Doubly Linked List) → Node (prev, next)

📌 Explanation:

Doubly Linked List is implemented in the Node class using both next and prev pointers.
This allows traversal in both forward and backward directions, even though only forward traversal is used in the leaderboard.

//✅ CLL (Circular Linked List) → Enemy + EnemyCLL

👉 Used in:
EnemyCLL.add()
circular linking logic

📌 Explanation:

Circular Linked List is used to connect enemies in a loop.
The last enemy points back to the first enemy, allowing continuous cycling through enemies without reaching null.

//✅ Recursion → MathQuestion + GameManager
1. In MathQuestion

2. In GameManager
showHistoryRecursive(Stack<String> stack)

📌 Explanation:

Recursion is used to solve mathematical operations like factorial and power by calling the method repeatedly.
It is also used to display the history by repeatedly popping elements from the stack until it is empty.

//Iteration → GameManager + Leaderboard


📌 Explanation:

Iteration is used through loops to control game flow, generate questions, and traverse data structures like the leaderboard.