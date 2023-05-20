import java.awt.*;
import java.awt.event.*;


public class WindowEventExample3 {
    public static void main(String[] args) {
        Frame frame = new Frame("Main Window");
        frame.setSize(400, 300);
        frame.addWindowListener(new MyWindowAdapter());

        Frame otherWindow = new Frame("Other Window");
        otherWindow.addWindowListener(new MyWindowAdapter());
        otherWindow.setSize(350, 350);

        WindowEvent windowEvent = new WindowEvent(frame, WindowEvent.WINDOW_OPENED, otherWindow, 0, 0);
        frame.dispatchEvent(windowEvent);

        frame.setVisible(true);
        otherWindow.setVisible(true);
    }
}

class MyWindowAdapter extends WindowAdapter {
    public void windowOpened(WindowEvent e) {
        if (e.getWindow() instanceof Frame) {
            Frame frame = (Frame) e.getWindow();
            if (frame.getTitle().equals("Other Window")) {
                System.out.println("Other Window opened");
            } else {
                System.out.println("Main Window opened");
            }
        }
    }

    public void windowClosed(WindowEvent e) {
        if (e.getWindow() instanceof Frame) {
            Frame frame = (Frame) e.getWindow();
            if (frame.getTitle().equals("Other Window")) {
                System.out.println("Other Window closed");
            } else {
                System.out.println("Main Window closed");
            }
        }
    }

    public void windowIconified(WindowEvent e) {
        if (e.getWindow() instanceof Frame) {
            Frame frame = (Frame) e.getWindow();
            if (frame.getTitle().equals("Other Window")) {
                System.out.println("Other Window iconified");
            } else {
                System.out.println("Main Window iconified");
            }
        }
    }

    public void windowDeiconified(WindowEvent e) {
        if (e.getWindow() instanceof Frame) {
            Frame frame = (Frame) e.getWindow();
            if (frame.getTitle().equals("Other Window")) {
                System.out.println("Other Window Deiconified");
            } else {
                System.out.println("Main Window Deiconified");
            }
        }
    }

    public void windowClosing(WindowEvent e) {
		if (e.getWindow() instanceof Frame) {
            Frame frame = (Frame) e.getWindow();
            if (frame.getTitle().equals("Other Window")) {
                frame.dispose();
            } else {
                System.exit(0);
            }
        }
        
    }
	  public void windowActivated(WindowEvent e) {
            Frame frame = (Frame) e.getWindow();
            Window oppositeWindow = e.getOppositeWindow();
            int oldState = e.getOldState();
            int newState = e.getNewState();

            System.out.println("Window activated: " + frame.getTitle());

            if (oppositeWindow != null) {
                System.out.println("Opposite window: " + oppositeWindow);
            } else {
                System.out.println("No opposite window");
            }

            if (isValidState(oldState)) {
                System.out.println("Old state: " + oldState);
            } else {
                System.out.println("Invalid old state");
            }

            if (isValidState(newState)) {
                System.out.println("New state: " + newState);
            } else {
                System.out.println("Invalid new state");
            }
        }

        private boolean isValidState(int state) {
            return state == WindowEvent.WINDOW_OPENED
                    || state == WindowEvent.WINDOW_CLOSED
                    || state == WindowEvent.WINDOW_ICONIFIED
                    || state == WindowEvent.WINDOW_DEICONIFIED;
        }
    }

