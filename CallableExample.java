import java.util.concurrent.*;

class CallableExample {
    public static void main(String args[]) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        
        System.out.println("Запуск");
        
        Future<Integer> f = es.submit(() -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        });
        
        Future<Double> f2 = es.submit(() -> Math.sqrt(3.0 * 3.0 + 4.0 * 4.0));
        
        Future<Integer> f3 = es.submit(() -> {
            int fact = 1;
            for (int i = 2; i <= 5; i++) {
                fact *= i;
            }
            return fact;
        });
        
        try {
            System.out.println(f.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (InterruptedException ex) {
            System.out.println(ex);
        } catch (ExecutionException ex) {
            System.out.println(ex);
        }
        
        es.shutdown();
        System.out.println("Завершение");
    }
}
