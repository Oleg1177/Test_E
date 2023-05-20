import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class FocusEventExample2 {
    public static void main(String[] args) {
		JFrame frame = new JFrame("FocusEvent Example");
        JTextField textField = new JTextField();
        
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                Component source = e.getComponent();
                System.out.println("Focus gained on: " + source.getName());
            }
            
            public void focusLost(FocusEvent e) {
                Component source = e.getComponent();
                System.out.println("Focus lost on: " + source.getName());
            }
        });
		textField.setName("Text Field");
         frame.add(textField);
        frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
        // Допустим, текстовое поле получает фокус
        textField.requestFocusInWindow();
    }
}
