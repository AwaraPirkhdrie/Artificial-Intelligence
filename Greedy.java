package lab2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class Greedy {
    public List<Item> items;
    public List<Bag> bags;
    public List<Item> unusedItems;

    public Greedy(List<Item> items, List<Bag> bags) {
        this.items = items;
        this.bags = bags;
        unusedItems = new ArrayList<>();
    }

    public void execute() {
        Collections.sort(items, Collections.reverseOrder()); // sorterar alla items från högst relativa värde till lägst relativa värde

        for(Item item : items) { // går igenom alla items
            Bag selectedBag = null;

            for(Bag bag : bags) { // hittar den bag som har plats och mest plats över och lägger current item i den bagen
                if(bag.getAvailableCapacity() > item.getWeight()
                        && (selectedBag == null
                            || selectedBag.getAvailableCapacity() > bag.getAvailableCapacity())) {
                    selectedBag = bag;
                }
            }
            if(selectedBag != null) { // om en bag med plats för item hittats läggs det i den bagen
                selectedBag.addItem(item);
            } else {
                unusedItems.add(item); // om det inte finns plats för ett item i en bag läggs det i unused items
            }
        }

        int totalValue = 0;

        for(Bag bag : bags) { // utskrift av total value för bags
            for(Item item : bag.items) {
                totalValue += item.getValue();
            }
        }
        JOptionPane.showMessageDialog (null, "\nTotal value in bags: " + totalValue);
        //System.out.println("\nTotal value in bags: " + totalValue);
        System.out.println();
    }


    public void executeRandom() { // samma som execute men random bag
        Collections.sort(items, Collections.reverseOrder());
        Random random = new Random();

        for(Item item : items) {
            Bag randomBag = bags.get(random.nextInt(bags.size()));

            for(Bag bag : bags) {
                if(randomBag.getAvailableCapacity() > item.getWeight()) {
                    randomBag.addItem(item);
                    break;
                } else {
                    randomBag = bags.get(random.nextInt(bags.size()));
                }
            }
        }
    }
}

