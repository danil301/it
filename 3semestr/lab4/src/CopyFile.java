import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile
{
    public void CopyFromTo(String from, String to)
    {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(from);
            outputStream = new FileOutputStream(to);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Копирование завершено успешно.");
        } catch (IOException e) {
            System.out.printf("ошибка открытия");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.printf("ошибка закрытия");
            }
        }
    }
}
