import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(); 

        System.out.println("Запуск потоков");

        new MyThread(phaser, "A").start();
        new MyThread(phaser, "B").start();
        new MyThread(phaser, "C").start();

        // Ждем завершения всех потоков исполнения первой фазы
        int phase = phaser.getPhase();
        System.out.println("Основной поток: Ждем завершения фазы " + phase);
        //System.out.println("Колличество зарегистрированных потоков " + phaser.getRegisteredParties());
        phaser.awaitAdvance(phase);
        

        System.out.println("Основной поток: Фаза " + phase + " завершена");

        // Ждем завершения всех потоков исполнения второй фазы
        phase = phaser.getPhase();
        System.out.println("Основной поток: Ждем завершения фазы " + phase);
        phaser.awaitAdvance(phase);

        System.out.println("Основной поток: Фаза " + phase + " завершена");

        // Ждем завершения всех потоков исполнения третьей фазы
        phase = phaser.getPhase();
        System.out.println("Основной поток: Ждем завершения фазы " + phase);
        phaser.awaitAdvance(phase);

        System.out.println("Основной поток: Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();

        if (phaser.isTerminated()) {
            System.out.println("Синхронизатор фаз завершен");
        }
    }

    static class MyThread extends Thread {
        Phaser p;
        String name;

        MyThread(Phaser p, String name) {
            this.p = p;
            this.name = name;
            p.register(); // Регистрируем поток в Phaser
        }

        public void run() {
            System.out.println("Поток " + name + " начинает первую фазу");
            p.arriveAndAwaitAdvance(); // Сообщаем о достижении первой фазы и ожидаем другие потоки
            
            // Небольшая пауза для демонстрации
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Поток " + name + " начинает вторую фазу");
            p.arriveAndAwaitAdvance(); // Сообщаем о достижении второй фазы и ожидаем другие потоки

            // Небольшая пауза для демонстрации
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Поток " + name + " начинает третью фазу");
            p.arriveAndDeregister(); // Сообщаем о достижении третьей фазы и снимаем поток с регистрации
        }
    }
}
