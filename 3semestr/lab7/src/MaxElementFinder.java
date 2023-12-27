public class MaxElementFinder {
    static class MaxElementRunnable implements Runnable {
        private int[] row;
        private int result;

        public MaxElementRunnable(int[] row)
        {
            this.row = row;
            this.result = Integer.MIN_VALUE;
        }

        public int getResult()
        {
            return result;
        }

        @Override
        public void run()
        {
            for (int element : row)
            {
                if (element > result) result = element;
            }
        }
    }

    public static void main(String[] args) {
        // Пример матрицы
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        // Создаем массив потоков
        Thread[] threads = new Thread[matrix.length];

        // Создаем массив для хранения результатов каждого потока
        int[] results = new int[matrix.length];

        // Создаем и запускаем потоки для обработки строк матрицы
        for (int i = 0; i < matrix.length; i++)
        {
            MaxElementRunnable maxElementRunnable = new MaxElementRunnable(matrix[i]);
            threads[i] = new Thread(maxElementRunnable);
            threads[i].start();
            try
            {
                threads[i].join(); // Ждем завершения потока
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            results[i] = maxElementRunnable.getResult();
        }

        // Находим максимальный элемент из результатов
        int maxElement = Integer.MIN_VALUE;
        for (int result : results)
        {
            if (result > maxElement) maxElement = result;
        }

        System.out.println("Наибольший элемент в матрице: " + maxElement);
    }
}
