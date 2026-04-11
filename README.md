# Math-Battle-Game
To enhance users’ mathematical skills through a structured and interactive game-based learning system.

🔹 1. Queue (FIFO)

📍 Used in:
GameManager
private Queue<Question> questions = new LinkedList<>();
🎯 Purpose:
Stores questions in First-In-First-Out order
Questions are asked in the order they are generated
📌 Methods used:
add() → insert question
poll() → remove and return next question
💡 Explanation:

The queue ensures that questions are asked in a structured sequence, where the first generated question is asked first.

🔹 2. Stack (LIFO)

📍 Used in:
GameManager
private Stack<String> history = new Stack<>();
🎯 Purpose:
Stores answer history
Last answer is shown first
📌 Methods used:
push() → store history
pop() → retrieve history
💡 Explanation:

The stack is used to display the history of answers in reverse order using recursion.

🔹 3. Singly Linked List

📍 Used in:
Leaderboard + Node
Node next;
🎯 Purpose:
Stores players in sequence for leaderboard
📌 Methods used:
traversal using:
while (temp != null)
💡 Explanation:

A singly linked list is used to store player scores dynamically, allowing easy insertion and traversal.

🔹 4. Doubly Linked List (concept)

📍 Used in:
Node class
Node prev;
Node next;
🎯 Purpose:
Allows forward and backward traversal (even if not fully used)
💡 Explanation:

The Node class supports a doubly linked list structure with both next and previous pointers.


🔹 5. Circular Linked List

📍 Used in:
EnemyCLL
head.next = head;
🎯 Purpose:
Enemies loop continuously
Last enemy connects back to first
📌 Methods used:
add()
getNextEnemy()
💡 Explanation:

A circular linked list is used to cycle through enemies continuously without reaching a null reference.

🔹 6. Set (HashSet)

📍 Used in:
loadQuestions()
Set<String> used = new HashSet<>();
🎯 Purpose:
Prevent duplicate questions
📌 Methods used:
contains()
add()
💡 Explanation:

A HashSet is used to ensure that only unique questions are added to the queue.

🔹 7. Recursion
📍 Used in:
factorial()
fibonacci()
power()
showHistoryRecursive()
🎯 Purpose:
1. Mathematical calculations:
factorial(n)
fibonacci(n)
power(a, b)
2. Display history:
showHistoryRecursive()
💡 Explanation:

Recursion is used to solve problems by calling the same function repeatedly with smaller inputs.







FOR OODP 
🔹 8. Exception Handling
📍 Used in:
Difficulty input
Answer input
try-catch
🎯 Purpose:
Prevent program crash
Handle invalid input
💡 Explanation:

Exception handling ensures the program continues running even when invalid input is entered.

🔹 9. OOP Concepts
📍 Used in:
Character (abstract class)
Player, Enemy (inheritance)
Question (interface)
💡 Explanation:
Concept	Where
Abstraction	Character
Inheritance	Player, Enemy
Polymorphism	Question interface
Encapsulation	private fields + getters

