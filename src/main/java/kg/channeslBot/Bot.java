package kg.channeslBot;
import kg.channeslBot.Parser.ParserTest2;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        String text = msg.getText();
        if (text.equals("/start")) {
            sendMsg(msg, "Что умеет делать этот бот?" + "\n" +
                    "Нажимая на кнопку: Каналы Telegram он вадаст вам категорию каналов телеграмм" + "\n" +
                    "Каналы будут выводится по количеству подписчиков по убыванию (20 каналов)");
        }else if (text.equals("Каналы Telegram")){
            sendMsg(msg,"Категория каналов для Telegram:" + "\n" +
                    "Новости и СМИ____________ /news" + "\n" +
                    "Блоги_____________________ /blogs" + "\n" +
                    "Технологии________________ /tech" + "\n" +
                    "Юмор________________ /entertainment" + "\n" +
                    "Политика и экономика_____ /economics" + "\n" +
                    "Криптоволюты______________ /crypto" + "\n" +
                    "Наука и образования_______ /education" + "\n" +
                    "Музыка___________________ /music" + "\n" +
                    "Лингвистика_______________ /language" + "\n" +
                    "Бизнесы и стартапы_________ /business" + "\n" +
                    "Психология_________ /psychology" + "\n" +
                    "Маркетинг и реклама___ /marketing" + "\n" +
                    "Карьера____________________ /career" + "\n" +
                    "Фильмы и сериалы_____________ /video" + "\n" +
                    "Литература___________________ /books" + "\n" +
                    "Здоровье и спорт_____________ /fitness" + "\n" +
                    "Путишествия и эмиграция______ /travel" + "\n" +
                    "Искусство и фото_____________ /art" + "\n" +
                    "Мода и красота_______________ /beauty" + "\n" +
                    "Медицина_____________________ /health" + "\n" +
                    "Игры и приложения______ /gaming" + "\n" +
                    "Еда и напитки________________ /food" + "\n" +
                    "Продажи______________________ /sales" + "\n" +
                    "Цитаты_______________________ /quotes" + "\n" +
                    "Рукоделие_____________ /handicraft" + "\n" +
                    "18+__________________________ /adult" + "\n" +
                    "Другое_______________________ /other" + "\n");
        }

        for (int i = 0; i < Channels.channelsTelegram().size(); i++)
            if (text.equals(Channels.channelsTelegram().get(i).toString())){
                for (int j = 1; j <= 10; j++)
                    sendMsg(msg, ParserTest2.getAllChannel(text).get(j).toString());
                sendMsg(msg,"Еще 10: " + text + "2");
            }else if (text.equals(Channels.channelsTelegram2(2).get(i).toString())) {//Сравниваю введенный текст с List <"/text" + "2"> b и бегу по ней
                for (int j = 11; j <= 20; j++)
                    sendMsg(msg, ParserTest2.getAllChannel(Channels.removeLastChar(text)).get(j).toString());//Вывожу парсинг каналы и удоляю 2 который присвоел
            }
//        else if (text.equals("кто такой рыся")){
//                sendMsg(msg,"Рыся Кот");
//            }
        if (text.equals("кто такой рыся")){
            sendMsg(msg,"рыся кот");
        }else if (text.equals("а айба")){
            sendMsg(msg,"А айба лох");
        }else if (text.equals("Курманбек")){
            sendMsg(msg,"Блять у меня нет идей");
        }
//             else if (text.equals("Hello")){
//                try {
//                    execute(Buttons.sendInlineKeyBoardMessage("/news"));
//                } catch (TelegramApiException e) {
//                    e.printStackTrace();
//                }
//            }
    }



    @SuppressWarnings("deprecation") // Означает то, что в новых версиях метод уберут или заменят
    private void sendMsg(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId()); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
        s.setText(text);
        try { //Чтобы не крашнулась программа при вылете Exception
            Buttons.setButtons(s);
            execute(s);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }






    @Override
    public String getBotUsername() {
        return "Telegram_channel_Bot";
    }

    @Override
    public String getBotToken() {
        return "1133739275:AAESbrWT4_xSyv_UkgYBzefx5PDBEKePYQs";
    }
}
