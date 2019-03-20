package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    private Pattern pattern;
    private Matcher matcher;

    public List<Item> parseItemList(String valueToParse) {
        List<Item> returnList = new ArrayList<>();
        String[] stringArray = valueToParse.split("##");
        for(String string : stringArray){
            try {returnList.add(parseSingleItem(string));}
            catch (ItemParseException e ){}
        }
        return returnList;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        String replace = singleItem.toLowerCase();

        String name = getValue("(NAME)([:@^*%]?)(\\w+)", replace);
        Double price = Double.valueOf(getValue("(price?)([:@^*%]?)(\\d+\\.\\d{1,2})", replace));
        String type = getValue("(type)([:@^*%]?)(\\w+)", replace);
        String expiration = getValue("(expiRatiOn)([:@^*%]?)(\\d/.*)", replace);

        return new Item(name, price, type, expiration);
    }

    private String getValue(String string, String sentence) throws ItemParseException {
        pattern = Pattern.compile(string, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(sentence);
        if (matcher.find()) {
            return matcher.group(3);
        } else {
            throw new ItemParseException();
        }
    }
}

