package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;

import java.util.List;

public class GroceryReporter {
    private final String originalFileText;
    private ItemParser itemParser;

    public GroceryReporter(String jerksonFileName) {
        this.itemParser = new ItemParser();
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {
        List<Item> itemList = itemParser.parseItemList(originalFileText);


        String newString = itemList.toString();
        return newString;
    }

    public static void main(String[] args) {
        GroceryReporter gr = new GroceryReporter("RawInput.JerkSon");
        ItemParser ip = new ItemParser();
        String list = gr.toString();

        List<Item> itemList = ip.parseItemList(list);

        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }
}
