import java.awt.*;
import java.awt.event.*;


public class WindowEventExample4 {
    public static void main(String[] args) {
        Frame frame = new Frame("Main Window");
        frame.setSize(400, 300);
        frame.addWindowListener(new MyWindowAdapter());

        WindowEvent windowOpenedEvent = new WindowEvent(frame, WindowEvent.WINDOW_OPENED);
        WindowEvent windowClosedEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSED);
        WindowEvent windowIconifiedEvent = new WindowEvent(frame, WindowEvent.WINDOW_ICONIFIED);
EventQueue.invokeLater(() -> {
            frame.dispatchEvent(windowOpenedEvent);
        frame.dispatchEvent(windowClosedEvent);
        frame.dispatchEvent(windowIconifiedEvent);
        });
        

        frame.setVisible(true);
    }
}

class MyWindowAdapter extends WindowAdapter {
    public void windowOpened(WindowEvent e) {
        System.out.println("Window opened");
    }

    public void windowClosed(WindowEvent e) {
        System.out.println("Window closed");
    }

    public void windowIconified(WindowEvent e) {
        System.out.println("Window iconified");
    }
	public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
}
