import java.lang.reflect.Array;
import java.net.Socket;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("nonRepeatable-------------------");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println();

        System.out.println("generateBrackets----------------------");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println();

        System.out.println("binarySystem-----------------");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println();

        System.out.println("alphabeticRow-------------------");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("lmabzyxw"));
        System.out.println();

        System.out.println("Task5----------------");
        System.out.println(Task5("aaabbcdd"));
        System.out.println(Task5("vvvvaajaaaaa"));
        System.out.println();

        System.out.println("convertToNum----------------");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println();

        System.out.println("uniqueSubstring--------------");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("11111111"));
        System.out.println();


        System.out.println("shortestWay-------------------");
        System.out.println(shortestWay(new int[][] {{1, 3, 1},
                                                    {1, 5, 1},
                                                    {4, 2, 1}
                                                    }));
        System.out.println(shortestWay(new int[][] {{2, 7, 3},
                                                    {1, 4, 8},
                                                    {4, 5, 9}
                                                    }));
        System.out.println();
    
        System.out.println("numericOrder-------------------------");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println();


        System.out.println("switchNums-----------");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
        System.out.println();
    }

    public static String nonRepeatable(String a) {
        if (a == null || a.length() <= 1) {
            return a;
        }
        String firstChar = ""+ a.charAt(0);
        String remaining = nonRepeatable(a.substring(1));
        remaining = remaining.replace(firstChar, "");
        return firstChar + remaining;
    }

    public static String generateBrackets(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return Arrays.toString(res.toArray());
    }
    
    public static void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        
        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }
        
        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }

    public static void backtrackBinary(ArrayList<String> list, String str, int one, int zero, int max) {
        if (str.length() == max) {
            list.add(str);
            return;
        }

        if (str.length() == 0 || str.charAt(str.length() - 1) != '0') {
            backtrackBinary(list, str + "0", one, zero + 1, max);
        }
        if (one + zero < max) {
            backtrackBinary(list, str + "1", one + 1, zero, max);
        }
    }

    public static List<String> binarySystem(int n) {
        ArrayList<String> list = new ArrayList<String>();
        backtrackBinary(list, "", 0, 0, n);
        return list;
    } 
    
    public static String alphabeticRow(String s)
    {           
        String maxLenForw = "";
        String currForw = "" + s.charAt(0);

        String maxLenBack = "";
        String currBack = "" + s.charAt(s.length() - 1);

        for(int i = 0; i < s.length() - 1; i++)
        {    
            if((int)(s.charAt(i)) - (int)(s.charAt(i + 1)) == -1) currForw += s.charAt(i + 1);
            else
            {
                if(maxLenForw.length() < currForw.length()) maxLenForw = currForw;
                currForw = "" + s.charAt(i + 1);
            }
            
            if((int)(s.charAt(s.length() - 1 - i)) - (int)(s.charAt(s.length() - 2 - i)) == -1) currBack += s.charAt(s.length() - 2 - i);
            else
            {
                if(maxLenBack.length() < currBack.length()) maxLenBack = currBack;
                currBack = "" + s.charAt(s.length() - 2 - i);
            }
        }

        return (maxLenBack.length() > maxLenForw.length()) ? new StringBuilder(maxLenBack).reverse().toString() : maxLenForw;
    }

    public static String Task5(String s)
    {
        ArrayList<String> words = new ArrayList<>();
        String word = "" + s.charAt(0);

        for(int i = 0; i < s.length() - 1; i++)
        {
            if(s.charAt(i) == s.charAt(i + 1)) word += s.charAt(i + 1);
            else
            {
                words.add(word);
                word = "" + s.charAt(i + 1);
            }
        }
        words.add(word);

        List<String> sortedList = words.stream().sorted( (str1,str2) ->  str1.length() - str2.length()).collect(Collectors.toList());

        String result = "";
        for (String str : sortedList) {
            result += str.charAt(0) + String.valueOf(str.length());
        }
        return result;
    }

    public static int convertToNum(String a) {
        String[] strNum = new String[]{
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };

        String[] tens = new String[]{
                "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
        };

        String[] vovs = a.split(" ");
        int result = 0;
        int currentNumber = 0;

        for (int j = 0; j < vovs.length; j++) {
            for (int i = 0; i < strNum.length; i++) {
                if (vovs[j].equals(strNum[i])) {
                    currentNumber += i;
                    break;
                }
            }
            for (int i = 2; i < tens.length; i++) {
                if (vovs[j].equals(tens[i])) {
                    currentNumber += i * 10;
                    break;
                }
            }
            if (vovs[j].equals("hundred")) {
                currentNumber *= 100;
            }
            if (vovs[j].equals("thousand")) {
                result += currentNumber * 1000;
                currentNumber = 0;
            }
        }

        result += currentNumber;
        return result;
    }

    public static String uniqueSubstring(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        String maxLen = "";
        String curr = "";
        for (int i = 0; i < s.length(); i++)
        {
            if (!map.containsKey(s.charAt(i)))
            {
                curr += s.charAt(i);
                map.put(s.charAt(i), i);
            }
            else
            {
                if (curr.length() > maxLen.length()) maxLen = curr;
                if(curr.length() > 1) curr = curr.substring(1);
                for(Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator(); it.hasNext(); )
                {
                    Map.Entry<Character, Integer> entry = it.next();
                    if(entry.getKey() < i) it.remove();
                    map.put(s.charAt(i), i);
                }
            }
        }
        return maxLen;
    }

    public static int shortestWay(int[][] arr)
    {
        int n = arr.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == 0 && j == 0) continue;
                else if(i == 0) arr[i][j] += arr[i][j - 1];
                else if(j == 0) arr[i][j] += arr[i - 1][j];
                else arr[i][j] += Math.min(arr[i][j - 1], arr[i - 1][j]);
                
            }
        }
        return arr[n - 1][n - 1];
        
    }   

    public static String numericOrder(String s)
    {
        String result = "";
        HashMap<Integer, String> map = new HashMap<>();
        Character[] arr = new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        List<Character> nums = Arrays.asList(arr);

        for (String str : s.split(" "))
        {
            String word = "";
            String num = "";
            for (char c : str.toCharArray()) 
            {
                if(nums.contains(c)) num += c;
                else word += c;
            }
            map.put(Integer.valueOf(num), word);   
        }
        for (Integer key : map.keySet()) {
            result += map.get(key) + " ";
        }
        return result;
    }

    public static int switchNums(int a, int b)
    {
        char[] aChars = (String.valueOf(a)).toCharArray();
        char[] bChars = (String.valueOf(b)).toCharArray();

        Arrays.sort(aChars);
        
        int index = aChars.length - 1;
        for(int i = 0; i < bChars.length; i++)
        {
            if(index >= 0 && bChars[i] < aChars[index])
            {
                bChars[i] = aChars[index];
                index--;
            }
        }

        return Integer.valueOf(String.valueOf(bChars));
    }

}