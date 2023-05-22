import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RepaintExample2 extends JPanel {
    private int x = 50;
    private int y = 50;

    public RepaintExample2() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(300, 200));
        animate();
    }

    private void animate() {
        Thread animationThread = new Thread(() -> {
            while (true) {
                // Изменяем координаты x и y
                x += 5;
                y += 5;

                // Вызываем метод repaint с заданными параметрами
                repaint(100,0,0, getWidth(), getHeight());

                try {
                    // Задержка перед следующим обновлением
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        animationThread.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Repaint Example2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RepaintExample2());
        frame.pack();
        frame.setVisible(true);
    }
}
