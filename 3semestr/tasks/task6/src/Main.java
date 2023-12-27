import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("hiddenAnagram-----------------");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println();

        System.out.println("collect---------------------------");
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));
        System.out.println();

        System.out.println("nicoCipher---------------------------------");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println();

        System.out.println("twoProduct-----------");
        System.out.println(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45));
        System.out.println(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45));
        System.out.println(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20));
        System.out.println(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
        System.out.println(twoProduct(new int[]{100, 12, 4, 1, 2}, 15));
        System.out.println();

        System.out.println("isExact------------");
        System.out.println(isExact(6));
        System.out.println(isExact(24));
        System.out.println(isExact(125));
        System.out.println(isExact(720));
        System.out.println(isExact(1024));
        System.out.println(isExact(40320));
        System.out.println();

        System.out.println("fractions--------------");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println();

        System.out.println("pilish_string-----------------");
        System.out.println(pilish_string("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        System.out.println(pilish_string("FORALOOP"));
        System.out.println(pilish_string("CANIMAKEAGUESSNOW"));
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println();

        System.out.println("generateNonconsecutive-------------------------");
        System.out.println(calculateExpression("3 + 5 * (2 - 6)"));
        System.out.println(calculateExpression("6 - 18 / (-1 + 4)"));
        System.out.println();

        System.out.println("isValid---------------");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println();

        System.out.println("findLCS---------------");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
    }

    public static String hiddenAnagram(String str1, String str2)
    {
        str1 = str1.replaceAll("[^A-Za-zА-Яа-я]", "").toLowerCase();
        str2 = str2.replaceAll("[^A-Za-zА-Яа-я]", "").toLowerCase();
        var arr2 = str2.toCharArray();
        Arrays.sort(arr2);

        for (int i = 0; i < str1.length() - str2.length() + 1; i++)
        {
            var arr1 = str1.substring(i, i + str2.length()).toCharArray();
            Arrays.sort(arr1);
            if (Arrays.equals(arr1, arr2)) return str1.substring(i, i + str2.length());
        }
        return "Not found";
    } //1

    public static String collect(String word, int n)
    {
        var res = recurse(word, n, new String[word.length() / n]);
        Arrays.sort(res);
        return Arrays.toString(res);
    } //2

    public static String[] recurse(String word, int n, String[] result)
    {
        if (word.length() < n) return result;
        String newWord = word.substring(0, n);
        for (int i = 0; i < result.length; i++)
        {
            if (result[i] == null)
            {
                result[i] = newWord;
                return recurse(word.substring(n, word.length()), n, result);
            }
        }
        return result;
    } //2

    public static String nicoCipher(String message, String key)
    {
        int mesLen = message.length();
        int keyLen = key.length();
        char[][] chars = new char[mesLen / keyLen + 2][keyLen];
        for (int i = 0; i < keyLen; i++) chars[0][i] = key.charAt(i);

        int k = 0;
        for (int i = 1; i < mesLen / keyLen + 2; i++)
        {
            for (int j = 0; j < keyLen; j++)
            {
                if (k >= mesLen) break;
                chars[i][j] = message.charAt(k);
                k++;
            }
        }
        sortColumns(chars);

        String result = "";

        for (int i = 1; i < chars.length; i++)
        {
            for (int j = 0; j < chars[i].length; j++)
            {
                if (chars[i][j] != Character.MIN_VALUE) result += chars[i][j];
                else result += " ";
            }
        }
        return result;
    } //3

    private static void sortColumns(char[][] matrix)
    {
        for (int a = 0; a < matrix.length; a++)
        {
            for (int i = 1; i < matrix[a].length; i++)
            {
                if (matrix[0][i - 1] > matrix[0][i])
                {
                    for (int j = 0; j < matrix.length; j++)
                    {
                        char tmp = matrix[j][i - 1];
                        matrix[j][i - 1] = matrix[j][i];
                        matrix[j][i] = tmp;
                    }
                }
            }
        }

    } //3

    public static String twoProduct(int[] arr, int num)
    {
        int[] result = new int[2];
        int minLen = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                if (arr[i] * arr[j] == num && i - j < minLen)
                {
                    result[0] = arr[j];
                    result[1] = arr[i];
                    minLen = i - j;
                }
            }
        }
        if (num != 0 && result[0] == 0 && result[1] == 0) return "[]";
        return Arrays.toString(result);
    } //4

    public static String isExact(int num)
    {
        var result = factorial(1, 2, num);
        if (result != -1) return Arrays.toString(new int[]{num, result});
        else return Arrays.toString(new int[0]);
    } //5

    public static int factorial(int num, int next, int target)
    {
        if (num * next < target) return factorial(num * next, ++next, target);
        else if (num * next > target) return -1;
        else return next;
    } //5

    public static String fractions(String decimalStr)
    {
        String repeatingPart = decimalStr.substring(decimalStr.indexOf('(') + 1, decimalStr.indexOf(')'));

        String nonRepeatingPart = decimalStr.substring(0, decimalStr.indexOf('('));

        String beforedot = decimalStr.substring(decimalStr.indexOf('.') + 1, decimalStr.indexOf('('));

        int denominator = Integer.parseInt(makeDenomOfNumer(repeatingPart.length(), beforedot.length()));

        int numerator = Integer.parseInt(decimalStr.replace(".", "").replace("(", "").replace(")", ""))
                - Integer.parseInt(nonRepeatingPart.replace(".", ""));

        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        
        return numerator + "/" + denominator;
    } //6

    public static String makeDenomOfNumer(int firstl, int secondl)
    {
        String res = "";
        for (int i=0; i<firstl; i++) res += "9";
        for (int i=0; i<secondl; i++) res += "0";
        return res;
    } //6

    private static int gcd(int a, int b) {
        while (b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    } //6

    public static String pilish_string(String message)
    {
        if (message.length() == 0) return "";
        String pi = "3.14159265358979";

        String result = "";
        int lastIndex = 0;
        for (int i = 0; i < pi.length(); i++)
        {
            if (pi.charAt(i) != '.') {
                int num = Integer.parseInt(String.valueOf(pi.charAt(i)));
                if (lastIndex + num <= message.length())
                {
                    result += message.substring(lastIndex, lastIndex + num) + " ";
                    lastIndex += num;
                }
                else if (lastIndex + num >= message.length() && lastIndex < message.length())
                {
                    result += message.substring(lastIndex, message.length());
                    for (int j = 0; j < lastIndex + num - message.length(); j++) result += message.charAt(message.length() - 1);
                    break;
                }
                else break;
            }
        }
        return result;
    } //7

    public static double calculateExpression(String expression) {
        try {
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();

            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (Character.isDigit(ch))
                {
                    StringBuilder num = new StringBuilder();
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.'))
                    {
                        num.append(expression.charAt(i));
                        i++;
                    }
                    i--;
                    numbers.push(Double.parseDouble(num.toString()));
                }
                else if (ch == '(') operators.push(ch);
                else if (ch == ')')
                {
                    while (operators.peek() != '(') numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                    operators.pop();
                }
                else if (isOperator(ch))
                {
                    while (!operators.isEmpty() && hasPrecedence(operators.peek(), ch)) numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                    operators.push(ch);
                }
            }

            while (!operators.isEmpty() && numbers.stream().count() >= 2) numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));

            return numbers.pop();
        }
        catch (Exception e)
        {
            return Double.NaN;
        }
    } //8

    private static boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    } //8

    private static boolean hasPrecedence(char op1, char op2) { return (op2 == '+' || op2 == '-') && (op1 == '*' || op1 == '/'); } //8

    private static double applyOperator(char operator, double b, double a) {
        switch (operator)
        {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                return Math.floor(a / b);
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    } //8

    public static String isValid(String str)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray())
        {
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }

        var x = map.values().toArray();
        boolean flag = false;
        for (int i = 1; i < x.length; i++)
        {
            int a = Integer.parseInt(x[i - 1].toString());
            int b = Integer.parseInt(x[i].toString());
            if(a != b)
            {
                if (flag || b - a < 0) return "NO";
                else
                {
                    i++;
                    flag = true;
                }
            }
        }

        return "YES";
    } //9

    public static String findLCS(String str1, String str2)
    {
        String[][] matrix = new String[str1.length() + 1][str2.length() + 1];
        for (String[] arr: matrix) Arrays.fill(arr, "");

        for (int i = matrix.length - 2; i >= 0; i--)
        {
            for(int j = matrix[i].length - 2; j >= 0; j--)
            {
                if (str1.charAt(i) == str2.charAt(j)) matrix[i][j] = str1.charAt(i) + matrix[i + 1][j + 1];
                else
                {
                    if (matrix[i][j + 1].length() > matrix[i + 1][j].length()) matrix[i][j] = matrix[i][j + 1];
                    else matrix[i][j] = matrix[i + 1][j];
                }
            }
        }
        return matrix[0][0];
    } //10
}