package lab2;
public class Item implements Comparable<Item> {

    private int weight;
    private int value;
    private int itemNbr;

    public Item(int weight, int value, int itemNbr) {
        this.weight = weight;
        this.value = value;
        this.itemNbr = itemNbr;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public int getItemNbr() {
        return itemNbr;
    }

    @Override
    public int compareTo(Item item) {
        if((value / weight) >= (item.value / item.weight)) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Item: " + itemNbr + " - Weight: " + weight + " - Value: " + value;
    }
}
