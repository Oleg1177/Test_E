import java.awt.*;
import java.awt.event.*;


public class AdjustmentEventExample2 {
    public static void main(String[] args) {
        Frame frame = new Frame("AdjustmentEvent Example");
        Adjustable scrollbar = new Scrollbar();
        int id = AdjustmentEvent.ADJUSTMENT_VALUE_CHANGED;
        int type = AdjustmentEvent.TRACK;
        int value = 10;

        AdjustmentEvent event = new AdjustmentEvent(scrollbar, id, type, value);

        // Добавляем настраиваемый объект в окно
        frame.add((Scrollbar) scrollbar, BorderLayout.CENTER);
        frame.setSize(300, 200);
  frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Здесь можно добавить код для обработки закрытия окна
                System.exit(0); // Пример: закрытие приложения
            }
        });
		
        frame.setVisible(true);

        // Обрабатываем событие AdjustmentEvent
        processAdjustmentEvent(event);
    }

    public static void processAdjustmentEvent(AdjustmentEvent event) {
        Adjustable adjustable = event.getAdjustable();
        int value = event.getValue();
        int type = event.getAdjustmentType();

        System.out.println("Adjustment Event - Value: " + value + ", Type: " + type);
		    System.out.println("Adjustable: " + adjustable);

    }
}
