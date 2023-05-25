import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridBagLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        // Создание компонентов
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField(20);
        JButton submitButton = new JButton("Submit");
        
        // Создание объекта GridBagConstraints
        GridBagConstraints constraints = new GridBagConstraints();
        
        // Настройка параметров для компонента nameLabel
        constraints.gridx = 0; // Координата X в сетке
        constraints.gridy = 0; // Координата Y в сетке
        constraints.anchor = GridBagConstraints.LINE_END; // Выравнивание по правому краю
        constraints.insets = new Insets(5, 5, 5, 5); // Внутренние отступы
        panel.add(nameLabel, constraints);
        
        // Настройка параметров для компонента nameTextField
        constraints.gridx = 1; // Координата X в сетке
        constraints.gridy = 0; // Координата Y в сетке
        constraints.anchor = GridBagConstraints.LINE_START; // Выравнивание по левому краю
        panel.add(nameTextField, constraints);
        
        // Настройка параметров для компонента submitButton
        constraints.gridx = 0; // Координата X в сетке
        constraints.gridy = 1; // Координата Y в сетке
        constraints.gridwidth = 2; // Объединение двух ячеек по горизонтали
        constraints.anchor = GridBagConstraints.CENTER; // Выравнивание по центру
        panel.add(submitButton, constraints);
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
