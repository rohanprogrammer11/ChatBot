import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatbotGUI extends JFrame implements ActionListener {

    private JTextArea chatArea;   // 1. Area to display conversation
    private JTextField inputField; // 2. Field to type message
    private JButton sendButton;    // 3. Button to send message

    public ChatbotGUI() {
        // 4. Frame setup
        setTitle("Java Chatbot");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 5. Chat area setup
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // 6. Input panel setup
        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        // 7. Event handling
        sendButton.addActionListener(this);
        inputField.addActionListener(this); // Press Enter = Send

        setVisible(true);

        // 8. Initial greeting
        chatArea.append("🤖 Chatbot: Hello! Type 'bye' to exit.\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userText = inputField.getText().trim();
        if (userText.isEmpty()) return;

        chatArea.append("You: " + userText + "\n");
        inputField.setText("");

        String botReply = getResponse(userText);
        chatArea.append("🤖 Chatbot: " + botReply + "\n");

        // Optional: Scroll to bottom
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    // 9. Chatbot logic
    private String getResponse(String msg) {
        msg = msg.toLowerCase().trim();

        if (msg.equals("bye")) return "Goodbye! Have a great day!";
        if (msg.contains("hello") || msg.contains("hi")) return "Hi there! How are you?";
        if (msg.contains("how are you")) return "I'm just a program, but I'm doing great! 😊";
        if (msg.contains("your name")) return "My name is JavaBot!";
        if (msg.contains("time")) return "Sorry, I can't tell the time yet ⏳";
        if (msg.contains("human") || msg.contains("person")) return "Haha, no! I'm just a Java program. 😄";
        if (msg.contains("fine") || msg.contains("good") || msg.contains("well") ||
                msg.contains("okay") || msg.contains("ok")) return "Great to hear! 😄";

        return "Hmm... I don't understand that.";
    }

    public static void main(String[] args) {
        new ChatbotGUI();
    }
}
