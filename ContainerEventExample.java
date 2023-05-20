import java.awt.*;
import java.awt.event.*;

public class ContainerEventExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Container Event Example");
        frame.setSize(300, 200);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Panel panel = new Panel();
        panel.setLayout(new FlowLayout());

        panel.addContainerListener(new ContainerAdapter() {
            public void componentAdded(ContainerEvent e) {
                Component child = e.getChild();
                Container container = e.getContainer();
                int index = getComponentIndex(container, child);

                System.out.println("Component added: " + child + ", Index: " + index + ", Container: " + container);
            }

            public void componentRemoved(ContainerEvent e) {
                Component child = e.getChild();
                Container container = e.getContainer();
                int index = getComponentIndex(container, child);

                System.out.println("Component removed: " + child + ", Index: " + index + ", Container: " + container);
            }

            private int getComponentIndex(Container container, Component component) {
                for (int i = 0; i < container.getComponentCount(); i++) {
                    if (container.getComponent(i) == component) {
                        return i;
                    }
                }
                return -1;
            }
        });

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");

        panel.add(button1);
        panel.add(button2);
		
		panel.remove(button2);

        frame.add(panel);

        frame.setVisible(true);
    }
}
