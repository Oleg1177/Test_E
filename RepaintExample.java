
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RepaintExample extends Frame {
    private int x = 50;
    private int y = 50;

    public RepaintExample() {
        super.setTitle("Repaint Example");
        super.setSize(300, 200);
        super.setVisible(true);
        super.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
    }

    public void update(Graphics g) {
        g.clearRect(x, y, getWidth(), getHeight());
        paint(g);
       
    }

    public void animate() {
        while (true) {
            // Изменяем координаты для анимации
            x += 5;
            if (x > super.getWidth()) {
                x = 0;
            }

            // Вызываем метод repaint с задержкой и областью обновления
            repaint(100, x, y, 200, 50);
            

            try {
             Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        RepaintExample example = new RepaintExample();
        example.animate();
        
    }
}
