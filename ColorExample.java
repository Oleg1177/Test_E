import java.awt.*;

public class ColorExample {
    public static void main(String[] args) {
        // Создание объекта Color с помощью значения цвета RGB
        Color color = new Color(255, 0, 0); // Красный цвет
        
        // Использование созданного цвета для отрисовки фигур
        Frame frame = new Frame();
        frame.setSize(300, 200);
        frame.setBackground(color);
        frame.setVisible(true);
    }
}
