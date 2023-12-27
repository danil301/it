import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
//import java.util.Map.Entry;

public abstract class HashTable<K, V>
{
    private LinkedList<Entry<K, V>>[] table;
    private int count;

    public HashTable()
    {
        table = (LinkedList<Entry<K, V>>[]) new LinkedList<?>[100];
        count = 0;
    }

    public HashTable(int size)
    {
        table = table = (LinkedList<Entry<K, V>>[]) new LinkedList<?>[size];
        count = 0;
    }

    private int hash(K key)
    {
        if(table.length != 0) return key.hashCode() % (table.length);
        return 0;
    }

    public void put(K key, V value)
    {
        int index = hash(key);
        if (table[index] == null)
        {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry : table[index])
        {
            if (entry.getKey().equals(key))
            {
                entry.set(value);
                return;
            }
        }
        table[index].add(new Entry<K, V>(key, value));
        count++;
    }

    public V get(K key)
    {
        int index = hash(key);
        if (table[index] != null)
        {
            for (Entry<K, V> entry : table[index])
            {
                if (entry.getKey().equals(key))
                {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    count--;
                    break;
                }
            }
        }
    }

    public int size()
    {
        return count;
    }

    public boolean isEmpty()
    {
        return count == 0;
    }



}
