package kg.channeslBot.Parser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//https://www.worldometers.info/coronavirus/
public class ParserTest2 {
    public static Document getAllLink(String name){
        Document doc = null;
        try { doc = Jsoup.connect("https://tlgrm.ru/channels"+name).get(); }
        catch (IOException e) { e.printStackTrace(); }
        return doc;
    }
    public static List<Article> getAllChannel (String nameLink) {

        Document getPage = getAllLink(nameLink);
        List<Article> articleList = new LinkedList<>();
        List<String> nameList = new ArrayList<>();
        List<String> numberList = new ArrayList<>();
        List<String> linkList = new ArrayList<>();
        List<String> descriptionList = new ArrayList<>();

        Element tableChannel = getPage.select("div[class=channel-cards-container]").first();//Беру общий доступ каналов 1 потока
        Elements h3Name = tableChannel.select("div[class=channel-card__info]");//Беру таблицу где хранятся нужные мне вещи


        Elements name = h3Name.select("h3[class=channel-card__title]");
        Elements number = h3Name.select("span[class=channel-card__subscribers]");
        Elements link = h3Name.select("a[class=channel-card__username]");
        Elements description = tableChannel.select("div[class=channel-card__description]");//Беру где хранится описание
//
//            String name0 = name.text();
//            String number0 = number.text();
//            String link0 = link.attr("href");
//            String description0 = description.text();
//
//            articleList.add(new Article(name0,number0,link0,description0));

        name.forEach(table -> {
            Element nameElement = table;
            String name0 = nameElement.text();
            nameList.add(name0);
        });
        number.forEach(table -> {
            Element numberElement = table;
            String number0 = numberElement.text();
            numberList.add(number0);
        });
        link.forEach(table -> {
            Element linkElement = table;
            String link0 = linkElement.attr("href");
            StringBuffer stringBuffer = new StringBuffer(link0);
            stringBuffer.delete(0,26);
            String string = stringBuffer.toString();
            linkList.add(string);
        });
        description.forEach(table -> {
            Element descriptionElement = table;
            String description0 = descriptionElement.text();
            descriptionList.add(description0);
        });

        for (int i = 0; i < nameList.size()-1; i++) {
            articleList.add(new Article(nameList.get(i),numberList.get(i),linkList.get(i),descriptionList.get(i)));
        }
        return articleList;
    }
}
