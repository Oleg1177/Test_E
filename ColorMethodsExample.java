import java.awt.Color;

public class ColorMethodsExample {
    public static void main(String[] args) {
        Color color = new Color(255, 128, 64); // Создание объекта Color с заданными значениями RGB

        // Использование методов getRed(), getGreen() и getBlue()
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        System.out.println("Red: " + red);
        System.out.println("Green: " + green);
        System.out.println("Blue: " + blue);

        // Использование метода getRGB()
        int rgb = color.getRGB();

        System.out.println("RGB: " + rgb);
    }
}
