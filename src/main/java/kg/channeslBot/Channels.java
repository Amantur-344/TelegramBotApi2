package kg.channeslBot;

import java.util.ArrayList;
import java.util.List;

public class Channels {
    public static List channelsTelegram(){
        List<String> list = new ArrayList<>();
        list.add("/news");
        list.add("/blogs");
        list.add("/tech");
        list.add("/entertainment");
        list.add("/economics");
        list.add("/crypto");
        list.add("/education");
        list.add("/music");
        list.add("/language");
        list.add("/business");
        list.add("/psychology");
        list.add("/marketing");
        list.add("/career");
        list.add("/video");
        list.add("/books");
        list.add("/fitness");
        list.add("/travel");
        list.add("/art");
        list.add("/beauty");
        list.add("/health");
        list.add("/gaming");
        list.add("/food");
        list.add("/sales");
        list.add("/quotes");
        list.add("/handicraft");
        list.add("/adult");
        list.add("/other");

        return list;
    }
    public static List channelsTelegram2(int number){
        List<String> list = new ArrayList<>();
        list.add("/news" + number);
        list.add("/blogs" + number);
        list.add("/tech" + number);
        list.add("/entertainment" +number);
        list.add("/economics" + number);
        list.add("/crypto" + number);
        list.add("/education" + number);
        list.add("/music" + number);
        list.add("/language" + number);
        list.add("/business" + number);
        list.add("/psychology" + number);
        list.add("/marketing" + number);
        list.add("/career" + number);
        list.add("/video" + number);
        list.add("/books" + number);
        list.add("/fitness" + number);
        list.add("/travel" + number);
        list.add("/art" + number);
        list.add("/beauty" + number);
        list.add("/health" + number);
        list.add("/gaming" + number);
        list.add("/food" + number);
        list.add("/sales" + number);
        list.add("/quotes" + number);
        list.add("/handicraft" + number);
        list.add("/adult" + number);
        list.add("/other" + number);

        return list;
    }

    public static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }
}
