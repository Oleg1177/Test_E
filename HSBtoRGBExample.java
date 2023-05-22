
import java.awt.*;

public class HSBtoRGBExample {
    public static void main(String[] args) {
        float hue = 0.5f; // Оттенок (от 0.0 до 1.0)
        float saturation = 1.0f; // Насыщенность (от 0.0 до 1.0)
        float brightness = 1.0f; // Яркость (от 0.0 до 1.0)

        int rgb = Color.HSBtoRGB(hue, saturation, brightness);
        Color color = new Color(rgb);

        Frame frame = new Frame();
        frame.setSize(300, 200);
        frame.setBackground(color);
        frame.setVisible(true);
    }
}
