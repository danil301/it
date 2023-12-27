import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class SalesManager
{
    private ConcurrentHashMap<String, AtomicInteger> salesCount;
    private ConcurrentHashMap<String, Double> salesAmount;

    public SalesManager()
    {
        this.salesCount = new ConcurrentHashMap<>();
        this.salesAmount = new ConcurrentHashMap<>();
    }

    public void addSale(String productName, double amount)
    {
        // Используем compute методы для атомарных операций над AtomicInteger и Double
        salesCount.compute(productName, (key, value) -> (value == null) ? new AtomicInteger(1) : new AtomicInteger(value.incrementAndGet()));
        salesAmount.compute(productName, (key, value) -> (value == null) ? amount : value + amount);
    }

    public void displaySales()
    {
        System.out.println("Sales Report------------------");
        for (String productName : salesCount.keySet())
        {
            AtomicInteger count = salesCount.get(productName);
            Double totalAmount = salesAmount.get(productName);
            System.out.println(productName + ": " + count.get() + " items, Total Amount: $" + totalAmount);
        }
        System.out.println("------------------------------");
    }

    public double getTotalSalesAmount()
    {
        return salesAmount.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public String getMostPopularProduct()
    {
        return salesCount.entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue().get() - entry2.getValue().get())
                .map(Map.Entry::getKey)
                .orElse("No sales yet");
    }
}