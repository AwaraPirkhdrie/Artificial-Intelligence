package lab2;
import java.util.ArrayList;
import java.util.List;

public class Bag implements Comparable<Bag>{

    public List <Item> items;
    public int weightCapacity;
    public int currentWeight;
    private int bagNbr;


    public Bag(int weightCapacity, int bagNbr) {
        this.weightCapacity = weightCapacity;
        items = new ArrayList<>();
        currentWeight = 0;
        this.bagNbr = bagNbr;
        System.out.println("Bag " + bagNbr + " created with weight capacity of: " + weightCapacity);
    }

    public void addItem(Item item) {
        items.add(item);
        currentWeight += item.getWeight();
        System.out.println("Item " + item.getItemNbr() + " added to bag " + bagNbr + " Total items: "
                + items.size() + " Current weight is: " + currentWeight);
    }

    public void removeItem(Item item) {
        items.remove(item);
        currentWeight -= item.getWeight();
        System.out.println("Item " + item.getItemNbr() + " removed from bag " + bagNbr + " . Total items: "
                + items.size() + " Current weight is: " + currentWeight);
    }

    public Item findItem(int weight) {
        for(Item item : items) {
            if(item.getWeight() == weight) {
                return item;
            }
        }
        return null;
    }

    public int getAvailableCapacity() {
        return weightCapacity - currentWeight;
    }

    @Override
    public String toString() {
        String str = "Bag " + bagNbr + ": Weight capacity: " + weightCapacity + " - Current weight: "
                + currentWeight + "\n" ;
        for(Item item : items) {
            str += item.toString() + "\n";
        }
        return str;
    }

    @Override
    public int compareTo(Bag bag) {
        return getAvailableCapacity() - bag.getAvailableCapacity();
    }
}
