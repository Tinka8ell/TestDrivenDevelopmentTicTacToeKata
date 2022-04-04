# Test-Driven Development - Tic Tac Toe Kata

## My version ...

**Note** that the original exercise is supplied below, starting at "What is a Kata?"

After looking at the rules from the [original kata](https://kata-log.rocks/tic-tac-toe-kata), 
there needs to be some design decisions as there is little in the kata itself!

### Design requirements

* Most 2D board games use an alphanumeric grid system, so will consider the square on the board as columns or rows
(alpha - left to right and numerc - top to bottom) giving A, B & C across and 1, 2 & 3 down.
* X always goes first (it does in my version noughts and crosses)
* Players take turns to give a 2 character grid location 
* Turn will not be accepted if grid already taken, and must be re-entered
* On entering a valid (and empty) grid position, if they form a full row, or column or diagonal, they win and game is over
* If they don't win and there are no more free grid slots, it is a draw and the game is over

### Implications:

* the "game" will be a class called TicTacToe
* once created players make turns: String turn(String grid)
* response is either and error, who moved, or who won or a draw
* to make playable there will be a String toString() method to display the current board state
* the main method will display the board and prompt for turns and repeat until game-over
* will need tests for turn and toString, the main will be pretty simple (and more difficult to test)

## 🤔 What is a kata?

🥋A Kata in martial arts means “a system of individual training exercises”. Just like in martial arts, coding also requires consistent practise to hone in the skill. As you move through the interview stages of the programme, you will most likely be sent tech tasks and/or coding “Katas" to complete for your take-home/live interviews. Test-Driven Development (TDD) is a sought after skill as an engineer in the tech industry, as it can help you write testable and clean code through a test-first approach. We call this ‘test-driving’ a program.

-----

## What do I have to do?

💻 We would like you to plan out and spend 30-45 minutes having a go at the Tic Tac Toe Kata using Test-Driven Development. We don't expect you to have finished the solution for the seminar but that you have had a good go at using Test-Driven Development.

### ⚙️  Before you start on this Kata make sure...⚙️

✅  You watch the Test-Driven Development session if you didn't attend it

✅  You use the programming language recommended for your programme. If you are unsure, please reach out to one of the Tech Coaches.

✅  You have chosen a unit testing framework of your choice.

✅  You have a project ready to go in your chosen Code Editor or IDE set up with a failing unit test.

-----

## 🗒️ Instructions

👉 Tic Tac Toe is a popular game played across the world! Read the Tic Tac Toe requirements. You can find it in the following link: https://kata-log.rocks/tic-tac-toe-kata  (there are many websites like Kata-Log outlining the most popular Katas).

👉 Please note that the kata ‘clues’ section refers to some C# testing frameworks like XUnit, please ignore these.

👉 Solve the Tic Tac Toe kata in a language of your choice. It is highly recommended you choose the language that you’ll be interviewing in/your strongest programming language.

👉 Please set aside up to 10 minutes to make a start on this Kata, don’t worry if you don’t reach a full solution as this Kata is designed for you to practise test-driven development and understand the process. We don't expect you to have finished the solution for the seminar but that you have had a good go at using Test-Driven Development.

-----

## 💡Tips & Tricks on how to get started

Set up your Code Editor / IDE beforehand so you’re ready to write the unit tests and code.

Before you write your code, make sure you understand the problem statement. The Kata may seem large at first, so break it down into smaller, manageable pieces.

Please note down your test cases, inputs and outputs on a notepad like Word / Notepad++ / piece of paper to validate your understanding.

Use the Triple A Structure - Arrange, Act, Assert to guide you when writing your unit tests

Use the RED - GREEN - REFACTOR cycle: Write one failing test first and write the simplest code to make that test pass, then see if there is any opportunity to refactor. If not, move onto writing your next test and follow the cycle through as you build up your solution.

Remember to consider a range of different test cases and edge cases.

-----

## 💡Apply PseudoCode to help you think through your logic

Pseudocode is a description of the steps for an algorithm and can be used to help you think through your logic.

In this video at the 02:20 timestamp, you can see Pseudocode in action on a Codewars challenge: https://storage.googleapis.com/tech-returners-course/Pre-Journey/solving_problems_on_codewars.mp4

In the video, observe how Harriet reads through the solution out loud and notice how she pseudo codes what she needs to do before writing any code.


-----

## 😺  Test-Driven Development Seminar Session

✅  During the seminar session which is happening on Tuesday 5th April, you will have the chance to take part in an open group discussion about applying the Test-Driven Development (TDD) approach to solving the kata. Feel free to bring any sketches or notes that you have made, or any parts of code that you wanted to share. Think of it like a live commentary of your reasoning on 'why' and 'how' you're going about solving the Kata. This is a common ask during tech interviews.

😊 Happy Coding!

-----

## 🥋Extension Exercises

👉 As an optional challenge, you can try to do the kata again in another programming language.

👉 If you finished the kata, why not have a go at another Kata?


https://kata-log.rocks/tdd.html
https://kata-log.rocks/experienced