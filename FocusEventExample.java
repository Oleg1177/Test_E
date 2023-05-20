import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FocusEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FocusEvent Example");

        MyComponent component = new MyComponent("Button");
        frame.add(component);

        component.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                System.out.println("Focus gained");
            }

            public void focusLost(FocusEvent e) {
                System.out.println("Focus lost");
            }
        });

        // Допустим, компонент получает фокус
        //component.requestFocusInWindow();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

class MyComponent extends JButton {
    public MyComponent(String text) {
        super(text);
    }
}
