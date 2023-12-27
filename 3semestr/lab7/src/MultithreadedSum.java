public class MultithreadedSum {

    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int length = array.length;

        // Разделение массива на две части
        int mid = length / 2;

        // Создание объекта для хранения результатов каждого потока
        ResultContainer resultContainer = new ResultContainer();

        // Создание и запуск первого потока
        Thread thread1 = new Thread(new SumThread(array, 0, mid, resultContainer));
        thread1.start();

        // Создание и запуск второго потока
        Thread thread2 = new Thread(new SumThread(array, mid, length, resultContainer));
        thread2.start();

        try
        {
            // Ожидание завершения обоих потоков
            thread1.join();
            thread2.join();

            // Получение результатов и вывод суммы
            int totalSum = resultContainer.getResult1() + resultContainer.getResult2();
            System.out.println("Total Sum: " + totalSum);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

// Класс для хранения результатов
class ResultContainer
{
    private int result1;
    private int result2;

    public synchronized void setResult1(int result1)
    {
        this.result1 = result1;
    }

    public synchronized void setResult2(int result2)
    {
        this.result2 = result2;
    }

    public synchronized int getResult1()
    {
        return result1;
    }

    public synchronized int getResult2()
    {
        return result2;
    }
}

// Класс, представляющий поток вычисления суммы
class SumThread implements Runnable
{
    private int[] array;
    private int start;
    private int end;
    private ResultContainer resultContainer;

    public SumThread(int[] array, int start, int end, ResultContainer resultContainer)
    {
        this.array = array;
        this.start = start;
        this.end = end;
        this.resultContainer = resultContainer;
    }

    @Override
    public void run()
    {
        int sum = 0;
        for (int i = start; i < end; i++) sum += array[i];

        // Установка результата в объект ResultContainer
        if (start == 0) resultContainer.setResult1(sum);
        else resultContainer.setResult2(sum);
    }
}
