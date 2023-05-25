import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridBagLayoutExample2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        // Создание компонентов
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        
        // Создание объекта GridBagConstraints
        GridBagConstraints constraints = new GridBagConstraints();
        
        // Настройка параметров для компонента button1
        constraints.gridx = 0; // Координата X в сетке
        constraints.gridy = 0; // Координата Y в сетке
        //constraints.ipadx = 10;
        constraints.gridwidth = 2; // Объединение двух ячеек по горизонтали
        constraints.weightx = 0.5; // Установка веса компонента по горизонтали
        constraints.weighty = 0.5; // Установка веса компонента по вертикали
        panel.add(button1, constraints);
        
        // Настройка параметров для компонента button2
        constraints.gridx = 2; // Координата X в сетке
        constraints.ipadx = 10;
        constraints.gridy = 0; // Координата Y в сетке
        constraints.gridwidth = 1; // Одна ячейка по горизонтали
        constraints.gridheight = 2; // Объединение двух ячеек по вертикали
        constraints.weightx = 1.0; // Установка веса компонента по горизонтали
        constraints.weighty = 1.0; // Установка веса компонента по вертикали
        panel.add(button2, constraints);
        
        // Настройка параметров для компонента button3
        constraints.gridx = 0; // Координата X в сетке
        constraints.gridy = 1; // Координата Y в сетке
        //constraints.ipadx = 10;
        constraints.gridwidth = 2; // Объединение двух ячеек по горизонтали
        constraints.gridheight = 1; // Одна ячейка по вертикали
        constraints.weightx = 50; // Установка веса компонента по горизонтали
        constraints.weighty = 0; // Установка веса компонента по вертикали
        panel.add(button3, constraints);
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
