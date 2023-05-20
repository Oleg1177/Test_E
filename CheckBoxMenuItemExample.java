import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxMenuItemExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckBoxMenuItem Example");
        
        JCheckBoxMenuItem option1 = new JCheckBoxMenuItem("Option 1");
        JCheckBoxMenuItem option2 = new JCheckBoxMenuItem("Option 2");
        JCheckBoxMenuItem option3 = new JCheckBoxMenuItem("Option 3");
        
        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (option1.isSelected()) {
                    System.out.println("Option 1 selected");
                } else {
                    System.out.println("Option 1 deselected");
                }
            }
        });
        
        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (option2.isSelected()) {
                    System.out.println("Option 2 selected");
                } else {
                    System.out.println("Option 2 deselected");
                }
            }
        });
        
        option3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (option3.isSelected()) {
                    System.out.println("Option 3 selected");
                } else {
                    System.out.println("Option 3 deselected");
                }
            }
        });
        
        JMenu menu = new JMenu("Options");
        menu.add(option1);
        menu.add(option2);
        menu.add(option3);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        
        frame.setJMenuBar(menuBar);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
