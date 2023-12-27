import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class Main {
    public static void main(String[] args) throws Exception {
        findNumbers("The price of the product is $19.99 27. 35 аб 12 13." );
        validatePassword("dSADFKdcksd12");
        replaceLinks("сайт https://localhost:7125/Subject  mos.ru");
        replaceLinks("сайт https://localhost:7125/Subject  123.r2u");
        validateIPAddress("192.168.123.132");
        findWordsStartingWith("hello world W", 'w');
    }

    public static void findNumbers(String text) throws Exception {
        try {
            Pattern pattern = Pattern.compile("\\b\\d+\\.?\\d*\\b");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            throw new Exception("Error in regular expression: " + e.getMessage());
        }
    }

    public static void validatePassword(String password) throws Exception {
        try
        {
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            Matcher matcher = pattern.matcher(password);

            if (!matcher.matches()) throw new Exception("Некорректный пароль");
        }
        catch (PatternSyntaxException e)
        {
            throw new Exception("Error in regular expression: " + e.getMessage());
        }
    }

    public static void replaceLinks(String text) throws Exception {
        try {

            Pattern pattern = Pattern.compile("\\b(\\w+)[.](\\w+)");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println("https://" + matcher.group());
            }
        } catch (PatternSyntaxException e) {
            throw new Exception("Error in regular expression: " + e.getMessage());
        }
    }

    public static void validateIPAddress(String ipAddress) throws Exception {
        try {
            Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");

            Matcher matcher = pattern.matcher(ipAddress);

            if (!matcher.matches()) {
                throw new Exception("Invalid IP address!");
            }
        } catch (PatternSyntaxException e) {
            throw new Exception("Error in regular expression: " + e.getMessage());
        }
    }

    public static void findWordsStartingWith(String text, char startingLetter) throws Exception {
        try {
            Pattern pattern = Pattern.compile("\\b" + startingLetter + "\\w*\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            throw new Exception("Error in regular expression: " + e.getMessage());
        }
    }
}