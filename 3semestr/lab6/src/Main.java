import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {
    public static void main(String[] args)
    {
        WordsCount("C:/Users/dvory/Desktop/итип/lab6/words.txt");

        System.out.println();
        System.out.println("Stack tests");
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());

        System.out.println();
        System.out.println("Sales tests");
        SalesManager salesManager = new SalesManager();
        salesManager.displaySales();
        System.out.println(salesManager.getTotalSalesAmount());
        salesManager.addSale("banana", 12);
        salesManager.addSale("banana", 12);
        salesManager.addSale("apple", 23);
        salesManager.getTotalSalesAmount();
        salesManager.displaySales();

    }

    public static void WordsCount(String filePath)
    {
        File file = new File(filePath);

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Integer> wordCountMap = new HashMap<>();

        while (scanner.hasNext())
        {
            String word = scanner.next().toLowerCase();
            word = word.replaceAll("[^a-zA-Zа-яА-Я]", "");
            if(wordCountMap.containsKey(word)) wordCountMap.put(word, wordCountMap.get(word) + 1);
            else wordCountMap.put(word, 1);
        }

        scanner.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int count = 0;
        System.out.println("Top 10 words:");
        for (Map.Entry<String, Integer> entry : list)
        {
            if (count < 10)
            {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
                count++;
            }
            else break;
        }
    }
}