import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class FocusEventExample3 {
    public static void main(String[] args) {
		JFrame frame = new JFrame("FocusEvent Example");
        JTextField textField = new JTextField();

        FocusListener focusListener = new FocusListener() {
            public void focusGained(FocusEvent e) {
                System.out.println("Focus gained");
            }

            public void focusLost(FocusEvent e) {
                System.out.println("Focus lost");
            }
        };
        textField.addFocusListener(focusListener);
        FocusEvent focusGainedEvent = new FocusEvent(textField, FocusEvent.FOCUS_GAINED);
        FocusEvent focusLostEvent = new FocusEvent(textField, FocusEvent.FOCUS_LOST);
		
		frame.add(textField);
        frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Допустим, текстовое поле получает фокус
        focusListener.focusGained(focusGainedEvent);

        // Допустим, текстовое поле теряет фокус
        focusListener.focusLost(focusLostEvent);
		
    }
}
