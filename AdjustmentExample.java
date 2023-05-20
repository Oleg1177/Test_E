import java.awt.*;
import java.awt.event.*;

public class AdjustmentExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Adjustment Event Example");

        // Создаем настраиваемый объект (Scrollbar)
        Scrollbar scrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 100);

        // Регистрируем слушателя событий AdjustmentListener
        scrollbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                // Проверяем идентификатор события
                if (e.getID() == AdjustmentEvent.ADJUSTMENT_VALUE_CHANGED) {
                    // Получаем текущее значение настраиваемого объекта
                    int value = scrollbar.getValue();
					
					
					
                    System.out.println("Value changed: " + value);
                }
            }
        });

        // Добавляем настраиваемый объект в окно
        frame.add(scrollbar, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
