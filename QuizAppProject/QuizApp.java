import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        
        // Add Questions
        questions.add(new Question("What is the capital of India?",
                new String[]{"Delhi", "Mumbai", "Kolkata", "Chennai"}, 0));
        questions.add(new Question("Which language is used in Android development?",
                new String[]{"Swift", "Java", "C#", "PHP"}, 1));
        questions.add(new Question("What does JVM stand for?",
                new String[]{"Java Virtual Machine", "Java Visual Method", "Just View Mode", "Joint Virtual Method"}, 0));

        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            questions.get(i).displayQuestion();

            System.out.print("Enter your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (questions.get(i).isCorrect(userAnswer - 1)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect! Correct Answer: " + 
                    questions.get(i).options[questions.get(i).correctAnswerIndex]);
            }
        }

        System.out.println("\n🎉 Quiz Completed!");
        System.out.println("Your Score: " + score + " out of " + questions.size());

        scanner.close();
    }
}
