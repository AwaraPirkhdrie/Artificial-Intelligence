package lab2;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class KnapsackTest {

    public static void main(String[] args) {

        ArrayList<Item> items = generateItems();
        ArrayList<Bag> bags = generateBags();

        System.out.println("Greedy test: \n");

        Greedy greedyTest = new Greedy(items, bags);
        greedyTest.execute();
        print(greedyTest,bags);

        System.out.println("Neighborhood search test: \n");

        Neighborhood neighborhoodTest = new Neighborhood(greedyTest.items, greedyTest.bags, greedyTest.unusedItems);
        neighborhoodTest.execute();
        print(greedyTest,bags);

    }

    public static ArrayList<Item> generateItems() {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(5,6,1));
        items.add(new Item(2,1,2));
        items.add(new Item(3,7,3));
        items.add(new Item(4,6,4));
        items.add(new Item(7,10,5));
        items.add(new Item(10,8,6));
        items.add(new Item(11,13,7));
        items.add(new Item(7,7,8));
        items.add(new Item(6,6,9));
        items.add(new Item(1,3,10));
        items.add(new Item(3,1,11));
        items.add(new Item(14,10,12));
        items.add(new Item(2,5,13));
        items.add(new Item(8,6,14));
        items.add(new Item(12,12,15));
        items.add(new Item(10,13,16));
        items.add(new Item(8,6,17));
        items.add(new Item(15,22,18));
        items.add(new Item(17,22,19));
        items.add(new Item(13,18,20));
        items.add(new Item(6,9,21));
        items.add(new Item(3,3,22));
        items.add(new Item(6,4,23));
        items.add(new Item(7,7,24));

        return items;
    }

    public static ArrayList<Bag> generateBags() {
        ArrayList<Bag> bags = new ArrayList<>();
        bags.add(new Bag(10, 1));
        bags.add(new Bag(11, 2));
        bags.add(new Bag(20,3));
        bags.add(new Bag(15,4));
        bags.add(new Bag(25,5));
        bags.add(new Bag(35,6));

        return bags;
    }

    public static void print(Greedy greedyTest, ArrayList<Bag> bags) {
        System.out.println("Unused items: " + greedyTest.unusedItems.size());
        for(Item item : greedyTest.unusedItems) {
            System.out.println(item.toString());
        }

        System.out.println();

        for(Bag bag : bags)
        	JOptionPane.showMessageDialog (null, bag.toString());
           // System.out.println(
    }
}
