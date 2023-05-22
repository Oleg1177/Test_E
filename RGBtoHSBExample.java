import java.awt.*;

public class RGBtoHSBExample {
    public static void main(String[] args) {
        int red = 255;
        int green = 0;
        int blue = 0;

        float[] hsbValues = new float[3];
        Color.RGBtoHSB(red, green, blue, hsbValues);

        float hue = hsbValues[0];
        float saturation = hsbValues[1];
        float brightness = hsbValues[2];

        System.out.println("Hue: " + hue);
        System.out.println("Saturation: " + saturation);
        System.out.println("Brightness: " + brightness);
    }
}
