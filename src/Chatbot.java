import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput;

        System.out.println("🤖 Chatbot: Hello! I am your chatbot. Type 'bye' to exit."); // Greeting

        while (true) {
            System.out.print("You: ");          // Prompt user
            userInput = sc.nextLine().toLowerCase().trim(); // Read input, lowercase & trim spaces


            if (userInput.equals("bye")) {
                System.out.println("🤖 Chatbot: Goodbye! Have a great day!");
                break;
            }

            else if (userInput.contains("hello") || userInput.contains("hi")) {
                System.out.println("🤖 Chatbot: Hi there! How are you?");
            }

            else if (userInput.contains("fine") || userInput.contains("good") ||
                    userInput.contains("well") || userInput.contains("okay") ||
                    userInput.contains("ok")) {
                System.out.println("🤖 Chatbot: Great to hear! 😄");
            }

            else if (userInput.contains("how are you")) {
                System.out.println("🤖 Chatbot: I'm just a program, but I'm doing great! 😊");
            }

            else if (userInput.contains("your name")) {
                System.out.println("🤖 Chatbot: My name is NiceBot!");
            }

            else if (userInput.contains("time")) {
                System.out.println("🤖 Chatbot: Sorry, I can't tell the time yet ⏳");
            }

            else if (userInput.contains("human") || userInput.contains("person")) {
                System.out.println("🤖 Chatbot: Haha, no! I'm just a Java program. 😄");
            }

            else {
                System.out.println("🤖 Chatbot: Hmm... I don't understand that.");
            }
        }

        sc.close();
    }
}
