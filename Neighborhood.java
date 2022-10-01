package lab2;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class Neighborhood {

    private List<Item> items;
    private List<Bag> bags;
    private List<Item> unusedItems;

    public Neighborhood(List<Item> items, List<Bag> bags, List<Item> unusedItems) {
        this.items = items;
        this.bags = bags;
        this.unusedItems = unusedItems;
    }

    public void execute() {
        int failureCounter = 0; // för att inte hamna i oändlig loop
        Collections.sort(unusedItems); // sortera items efter relativt värde

        while(failureCounter++ < 100) { // försöker förbättra lösningen 100 gånger och stoppar sedan

            if(unusedItems.size() == 0) { // om inga unused items finns så avslutas loopen
                break;
            }
            Collections.sort(bags); // sorterar bags från lite ledig plats till mer ledig plats

            Bag bigCapBag = bags.get(bags.size() - 1); // väljer den bag med mest ledig plats

            for(int i = bags.size()-2; i >= 0; i--) { // loopar igenom från bag med näst mest ledig plats till den med minst
                Bag b = bags.get(i);
                Bag increasedCapBag = null;

                for(int j = 0; j < b.getAvailableCapacity(); j++) {

                    // Hämta item med weight b.getAvailableCapacity() - j från bigCapBag
                    Item bigCapBagItem = bigCapBag.findItem(b.getAvailableCapacity()-j);

                    // Om det finns, flytta till b
                    if(bigCapBagItem != null) {
                        bigCapBag.removeItem(bigCapBagItem);
                        b.addItem(bigCapBagItem);
                        increasedCapBag = bigCapBag;
                        break;
                    }

                    // Hämta item med weight bigCapBag.getAvailableCapacity() - j från b
                    Item bItem = b.findItem(bigCapBag.getAvailableCapacity()-j);

                    // Om det finns, flytta till bigCapBag
                    if(bItem != null) {
                        b.removeItem(bItem);
                        bigCapBag.addItem(bItem);
                        increasedCapBag = b;
                        break;
                    }
                }

                if(increasedCapBag != null) { // lägger till från unused items till bag
                    for (int j = unusedItems.size() - 1; j >= 0; j--) {
                        Item unusedItem = unusedItems.get(j);
                        if (unusedItem.getWeight() <= increasedCapBag.getAvailableCapacity()) {
                            unusedItems.remove(j);
                            increasedCapBag.addItem(unusedItem);
                        }
                    }
                }
            }

        }

        int totalValue = 0;

        for(Bag bag : bags) { // skriver ut totala värdet på bags
            for(Item item : bag.items) {
                totalValue += item.getValue();
            }
        }
        JOptionPane.showMessageDialog (null, "\nTotal value in bags: " + totalValue);


       // System.out.println("\nTotal value in bags: " + totalValue);
        System.out.println();
    }
}
