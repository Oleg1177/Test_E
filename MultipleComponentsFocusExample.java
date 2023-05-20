import javax.swing.*;
import java.awt.event.*;
import java.awt.EventQueue;


public class MultipleComponentsFocusExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Multiple Components Focus Example");

        JTextField textField1 = new JTextField("Text Field 1", 20);
        JTextField textField2 = new JTextField("Text Field 2", 20);
        JButton button = new JButton("Button");

        textField1.addFocusListener(new CustomFocusListener());
        textField2.addFocusListener(new CustomFocusListener());
        button.addFocusListener(new CustomFocusListener());
		
	

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(textField1);
        frame.add(textField2);
        frame.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Пример создания событий фокуса для каждого компонента
        FocusEvent focusGainedEvent1 = new FocusEvent(textField1, FocusEvent.FOCUS_GAINED);
        FocusEvent focusLostEvent1 = new FocusEvent(textField1, FocusEvent.FOCUS_LOST);

        FocusEvent focusGainedEvent2 = new FocusEvent(textField2, FocusEvent.FOCUS_GAINED);
        FocusEvent focusLostEvent2 = new FocusEvent(textField2, FocusEvent.FOCUS_LOST);

        FocusEvent focusGainedEventButton = new FocusEvent(button, FocusEvent.FOCUS_GAINED);
        FocusEvent focusLostEventButton = new FocusEvent(button, FocusEvent.FOCUS_LOST);

        EventQueue.invokeLater(() -> {
            textField1.dispatchEvent(focusGainedEvent1);
            textField2.dispatchEvent(focusGainedEvent2);
            button.dispatchEvent(focusGainedEventButton);

            textField1.dispatchEvent(focusLostEvent1);
            textField2.dispatchEvent(focusLostEvent2);
            button.dispatchEvent(focusLostEventButton);
        });
		
		  
		
    }

    static class CustomFocusListener implements FocusListener {
        public void focusGained(FocusEvent e) {
            System.out.println("Focus gained: " + e.getComponent().getClass().getSimpleName());
        }

        public void focusLost(FocusEvent e) {
            System.out.println("Focus lost: " + e.getComponent().getClass().getSimpleName());
        }
    }
	
	
}
