import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Warehouse {
    private static final int MAX_WEIGHT_PER_LOAD = 150;
    private static final int NUM_LOADERS = 3;
    private static final int NUM_PRODUCTS = 30;

    private static Stack<Integer> productWeights;
    private final CyclicBarrier cyclicBarrier;

    public Warehouse() {
        productWeights = new Stack<>();
        cyclicBarrier = new CyclicBarrier(NUM_LOADERS, this::unloadTruck);

        // Генерируем случайные веса для товаров
        Random random = new Random();
        for (int i = 0; i < NUM_PRODUCTS; i++)
        {
            int weight = random.nextInt(50) + 1; // Вес от 1 до 50 кг
            productWeights.push(weight);
        }
    }

    public void startLoading() {
        for (int i = 0; i < NUM_LOADERS; i++) {
            new Thread(new Loader(i)).start();
        }
    }

    private void unloadTruck()
    {
        System.out.println("Грузчики отправляются на другой склад...");
    }

    private class Loader implements Runnable {
        private final int loaderId;

        private static int totalWeight = 0;

        private static int productIndex = 0;

        public Loader(int loaderId) {
            this.loaderId = loaderId;
        }

        @Override
        public synchronized void run() {
            while (!productWeights.empty())
            {
                int productWeight = productWeights.peek();

                if (totalWeight + productWeight <= MAX_WEIGHT_PER_LOAD) {
                    productWeights.pop();
                    totalWeight += productWeight;
                    productIndex++;
                    try
                    {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Грузчик " + loaderId + " загружает товар с весом " + productWeight + " кг.");
                }
                else {
                    // Если суммарный вес товаров превысил лимит, грузчики отправляются на другой склад
                    try
                    {
                        cyclicBarrier.await();
                    }
                    catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                    catch (BrokenBarrierException e)
                    {
                        throw new RuntimeException(e);
                    }
                    totalWeight = 0;
                }
            }




        }
    }
}