public class ArrayAverage
{
    public ArrayAverage()
    {
        String[] invalidData = {"1", "2", "three", "4", "5"};

        try
        {
            int[] arr = new int[invalidData.length];
            for (int i = 0; i < invalidData.length; i++)
            {
                arr[i] = Integer.parseInt(invalidData[i]);
            }

            int sum = 0;
            for (int i = 0; i <= invalidData.length; i++)
            {
                sum += arr[i];
            }
            double average = (double) sum / invalidData.length;
            System.out.println(average);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Выход за границы массива");
        }
        catch (NumberFormatException e)
        {
            System.out.println("Неверные данные");
        }
    }
}
