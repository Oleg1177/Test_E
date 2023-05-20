import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllComponentsFocusExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("All Components Focus Example");

        JTextField textField = new JTextField("Text Field", 20);
        JLabel label = new JLabel("Label");
        JButton button = new JButton("Button");
        JCheckBox checkBox = new JCheckBox("Check Box");
        JRadioButton radioButton = new JRadioButton("Radio Button");
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});

        textField.addFocusListener(new CustomFocusListener());
        label.addFocusListener(new CustomFocusListener());
        button.addFocusListener(new CustomFocusListener());
        checkBox.addFocusListener(new CustomFocusListener());
        radioButton.addFocusListener(new CustomFocusListener());
        comboBox.addFocusListener(new CustomFocusListener());

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(textField);
        frame.add(label);
        frame.add(button);
        frame.add(checkBox);
        frame.add(radioButton);
        frame.add(comboBox);
        frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Пример создания события фокуса с использованием всех параметров конструктора
        FocusEvent focusEvent = new FocusEvent(textField, FocusEvent.FOCUS_GAINED, false, comboBox, FocusEvent.Cause.TRAVERSAL_BACKWARD);
		System.out.println("OppositeComponent: " + focusEvent.getOppositeComponent());
		System.out.println("isTemporary: " + focusEvent.isTemporary());
		System.out.println("Cause: " + focusEvent.getCause());
        // Пример вызова метода dispatchEvent() для компонента
        EventQueue.invokeLater(() -> {
            textField.dispatchEvent(focusEvent);
			/* button.dispatchEvent(focusEvent);
			label.dispatchEvent(focusEvent);
			checkBox.dispatchEvent(focusEvent);
			radioButton.dispatchEvent(focusEvent);
			comboBox.dispatchEvent(focusEvent); */
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
