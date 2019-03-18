package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    private Pattern pattern;
    private Matcher matcher;
    public List<Item> parseItemList(String valueToParse) {
        return null;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        String name = getValue("name",singleItem);
        Double price = Double.valueOf(getValue("price",singleItem));
        String type;
        String expiration;

        //String replace = singleItem.replaceAll("##", "");
        //String[] split = replace.split("[:@^*%;]");

//        String namePattern = "(name?)([:@^*%;]?)(\\w+)";
//        String pricePattern = "(name?)([:@^*%;]?)(\\w+)";
//        pattern = Pattern.compile(namePattern, Pattern.CASE_INSENSITIVE);
//        matcher = pattern.matcher(singleItem);
//
//        while(matcher.find()){
//            name = matcher.group(3);
//        }


        return new Item(name,price,"", "");
    }

    private String getValue(String string, String sentence){
        String result = "";
        String somePattern = "("+string+"?)([:@^*%;]?)(\\w+)";
        pattern = Pattern.compile(somePattern, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(sentence);

        while(matcher.find()){
            result = matcher.group(3);
        }
        return result;
    }

    private Double getDoubleValue(String string, String sentence){
        String result = "";
        String somePattern = "("+string+"?)([:@^*%;]?)(\\w+)";
        pattern = Pattern.compile(somePattern, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(sentence);

        while(matcher.find()){
            result = matcher.group(3);
        }
        return 0.0;
    }


    public static void main(String[] args) throws ItemParseException{
        ItemParser ip = new ItemParser();
        //ip.parseSingleItem("naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##");

        Item item = ip.parseSingleItem("naMe@SOMETHING;price:3.23;type:Food^expiration:1/04/2016##");
        System.out.println(item.toString());
    }
}
