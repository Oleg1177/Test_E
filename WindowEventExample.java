import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Frame;

public class WindowEventExample {
    public static void main(String[] args) {
        MyWindowAdapter windowAdapter = new MyWindowAdapter();

        // Создание окна и добавление слушателя событий окна
        MyWindow window = new MyWindow();
        window.addWindowListener(windowAdapter);

        window.setVisible(true);
    }
}

// Пользовательский класс окна
class MyWindow extends Frame {
    public MyWindow() {
        setSize(300, 200);
        setTitle("Window Event Example");
    }
}

// Пользовательский класс адаптера окна
class MyWindowAdapter extends WindowAdapter {
    public void windowOpened(WindowEvent e) {
        System.out.println("Window opened");
    }

    public void windowClosing(WindowEvent e) {
        System.out.println("Window closing");
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
        System.out.println("Window closed");
    }
}
