import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class MouseEventExample {
    public static void main(String[] args) {
        JButton button = new JButton("Click me");

        // Создание MouseEvent для события щелчка кнопкой мыши
        MouseEvent mouseEvent = new MouseEvent(button, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_DOWN_MASK, 10, 10, 1, false);

        // Вывод информации о событии
        System.out.println("Source: " + mouseEvent.getSource());
        System.out.println("Type: " + mouseEvent.getID());
        System.out.println("When: " + mouseEvent.getWhen());
        System.out.println("Modifiers: " + mouseEvent.getModifiersEx());
        System.out.println("X: " + mouseEvent.getX());
        System.out.println("Y: " + mouseEvent.getY());
        System.out.println("Button: " + mouseEvent.getButton());
        System.out.println("IsPopupTrigger: " + mouseEvent.isPopupTrigger());
    }
}
