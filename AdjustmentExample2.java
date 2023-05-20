import java.awt.*;
import java.awt.event.*;



class MyAdjustmentListener implements AdjustmentListener {
    @Override
    public void adjustmentValueChanged(AdjustmentEvent event) {
        Adjustable adjustable = event.getAdjustable();
        // Используйте объект Adjustable для выполнения нужных действий
        // Например, можно получить текущее значение настройки:
        int value = adjustable.getValue();
        System.out.println("Текущее значение настройки: " + value);
    }
}

public class AdjustmentExample2 {
    public static void main(String[] args) {
        Frame frame = new Frame("Adjustment Event Example2");

        // Создаем настраиваемый объект (Scrollbar)
        Scrollbar scrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 100);

        // Регистрируем слушателя событий AdjustmentListener
        scrollbar.addAdjustmentListener(new MyAdjustmentListener() );

        // Добавляем настраиваемый объект в окно
        frame.add(scrollbar, BorderLayout.CENTER);
        frame.setSize(300, 200);
		//frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
