import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Division
{
    public double divide(int dividend, int divisor) throws CustomDivisionException
    {
        if (divisor == 0)
        {
            logException(new CustomDivisionException("Деление на ноль недопустимо."));
            throw new CustomDivisionException("Деление на ноль недопустимо.");
        }
        return (double) dividend / divisor;
    }

    public void logException(Exception e)
    {
        try(PrintWriter writer = new PrintWriter(new FileWriter("error.log", true)))
        {
            e.printStackTrace(writer);
        }
        catch (IOException ioException)
        {
            System.out.printf("Ошибка при записи в файл");
        }
    }
}