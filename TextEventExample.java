import java.awt.TextArea;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class TextEventExample {
    public static void main(String[] args) {
        TextArea textArea = new TextArea();

        textArea.addTextListener(new TextListener() {
            public void textValueChanged(TextEvent e) {
                /* System.out.println("Text changed: " + e.getText());
                System.out.println("Start index: " + e.getStart());
                System.out.println("End index: " + e.getEnd()); */
            }
        });

        // Можно также генерировать события TextEvent программно
        TextEvent event = new TextEvent(textArea, TextEvent.TEXT_VALUE_CHANGED);
        textArea.dispatchEvent(event);

        // Программно установить текст и вызвать событие
        textArea.setText("Hello, world!");
    }
}
