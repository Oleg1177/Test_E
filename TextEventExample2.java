import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextEventExample2 {
    public static void main(String[] args) {
        JTextField textField = new JTextField();

        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Text inserted: " + textField.getText());
            }

            public void removeUpdate(DocumentEvent e) {
                System.out.println("Text removed: " + textField.getText());
            }

            public void changedUpdate(DocumentEvent e) {
                // Этот метод не используется для JTextField
            }
        });

        JFrame frame = new JFrame("Text Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(textField);
        frame.pack();
        frame.setVisible(true);
    }
}
