import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class InputEventExample {
    public static void main(String[] args) {
        // Создание MouseEvent с помощью модификаторов и маски кнопок мыши
        int modifiers = InputEvent.CTRL_DOWN_MASK | InputEvent.BUTTON1_DOWN_MASK;
        long when = System.currentTimeMillis();
        
        JFrame frame = new JFrame("Input Event Example");
        frame.setSize(400, 300);
        frame.setVisible(true);

        MouseEvent mouseEvent = new MouseEvent(frame, MouseEvent.MOUSE_CLICKED, when, modifiers, 0, 0, 0, false, MouseEvent.BUTTON1);
        
        System.out.println("Mouse event created: " + mouseEvent);

        // Получение информации о модификаторах и маске кнопок мыши
        int eventModifiers = mouseEvent.getModifiersEx();
        int buttonMask = InputEvent.getMaskForButton(MouseEvent.BUTTON1);

        // Проверка, содержит ли событие определенный модификатор или маску кнопки мыши
        boolean hasCtrlModifier = mouseEvent.isControlDown();
        boolean hasButton1Mask = mouseEvent.isAltGraphDown();

        // Вывод результатов
        System.out.println("Event modifiers: " + eventModifiers);
        System.out.println("Button mask for BUTTON1: " + buttonMask);
        System.out.println("Has Ctrl modifier: " + hasCtrlModifier);
        System.out.println("Has Button1 mask: " + hasButton1Mask);
        
        frame.dispose();
    }
}
