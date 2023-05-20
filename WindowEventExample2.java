import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventExample2 {
    public static void main(String[] args) {
        MyWindow window = new MyWindow();

        window.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {
                System.out.println("Window opened");
            }

            public void windowClosing(WindowEvent e) {
                System.out.println("Window closing");
            }

            public void windowClosed(WindowEvent e) {
                System.out.println("Window closed");
            }

            public void windowIconified(WindowEvent e) {
                System.out.println("Window iconified");
            }

            public void windowDeiconified(WindowEvent e) {
                System.out.println("Window deiconified");
            }

            public void windowActivated(WindowEvent e) {
                System.out.println("Window activated");
            }

            public void windowDeactivated(WindowEvent e) {
                System.out.println("Window deactivated");
            }
        });

        window.setVisible(true);
    }
}

class MyWindow extends Frame {
    public MyWindow() {
        setSize(300, 200);
        setTitle("Window Event Example");
    }
}
