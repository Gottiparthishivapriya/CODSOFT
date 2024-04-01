import java.util.Scanner;

class Question {
    String text;
    String[] options;
    char correctAnswer;

    // Constructor to initialize question details
    public Question(String text, String[] options, char correctAnswer) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of quiz questions
        Question[] questions = {
            new Question("What is the capital of France?",
                    new String[]{"A. Paris", "B. London", "C. Rome", "D. Madrid"}, 'A'),
            // Add more questions here...
        };

        int totalQuestions = questions.length;
        int score = 0;

        System.out.println("Welcome to the Quiz App!");
        System.out.println("You have " + totalQuestions + " questions to answer.");

        // Loop through each question
        for (int i = 0; i < totalQuestions; i++) {
            Question currentQuestion = questions[i];

            System.out.println("\nQuestion " + (i + 1) + ": " + currentQuestion.text);
            for (String option : currentQuestion.options) {
                System.out.println(option);
            }

            System.out.print("Your answer (A/B/C/D): ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);

            if (userAnswer == currentQuestion.correctAnswer) {
                System.out.println("Correct! You earned 10 points.");
                score += 10;
            } else {
                System.out.println("Incorrect. The correct answer was " + currentQuestion.correctAnswer);
            }
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your final score: " + score + " out of " + (totalQuestions * 10));

        scanner.close();
    }
}