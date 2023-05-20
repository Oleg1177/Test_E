import java.awt.*;
import java.awt.event.*;

public class ComponentEventExample2 {
    public static void main(String[] args) {
        Frame frame = new Frame("Component Event Example");
        frame.setSize(300, 200);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                Component component = e.getComponent();
                System.out.println("Component resized: " + component.getName());
            }
        });

        Button button = new Button("Resize");
        button.setName("ResizeButton");
        frame.add(button);

        frame.setVisible(true);
    }
}
