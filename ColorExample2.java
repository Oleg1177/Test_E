import java.awt.*;

public class ColorExample2 {
    public static void main(String[] args) {
        int newRed = (0xFF << 16) | (0x00 << 8) | 0x00;
        Color darkRed = new Color(newRed);

        Frame frame = new Frame();
        frame.setSize(300, 200);
        frame.setBackground(darkRed);
        frame.setVisible(true);
    }
}
