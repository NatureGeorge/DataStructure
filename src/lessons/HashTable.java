package lessons;

public class HashTable<E> {

    private LinkList[] table;

    public HashTable(int size)
    {
        this.table = new LinkList[size];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkList();
        }
    }

    public int hash(int key)
    /*
     * Adapt MOD Method, Linked address method to handle crashes*/
    {
        return key % table.length;
    }

    public void insert(E element) throws Exception {
        int key = element.hashCode();
        int i = hash(key);
        table[i].insert(0, element);
    }

    public String printHashTable()
    {
    	String display = "";
        for (int i = 0; i < table.length; i++) {
        	display = display + String.format("table[%s]= %s\n", i, table[i].display());
        }
        
        return display;
    }

    public Node search(E element) throws Exception {
        int key = element.hashCode();
        int i = hash(key);
        int index = table[i].indexOf(element); // search in linked list
        if (index >= 0) {
            return (Node) table[i].get(index);
        } else {
            return null;
        }
    }

    public boolean contain(E element) throws Exception {
        return this.search(element) != null;
    }

    public boolean remove(E element) throws Exception {
        int key = element.hashCode();
        int i = hash(key);
        int index = table[i].indexOf(element);
        if (index >= 0) {
            table[i].remove(index);
            return true;
        } else {
            return false;
        }
    }   
}