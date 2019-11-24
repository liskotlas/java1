//package T_Bot;
//
//import org.telegram.telegrambots.ApiContextInitializer;
//import ru.progwards.java1.telegrambot.ProgwardsTelegramBot;
//
//
//public class PizzaBot extends ProgwardsTelegramBot {
//
//       @Override
//    public String processMessage(String text) {
//        checkTags(text);
//        return "Под твой запрос подходит: \n" + extract();
//        return text;
//    }
//
//
//
//    public static void main(String[] args) {
//
//        ApiContextInitializer.init();
//        PizzaBot bot = new PizzaBot();
//        bot.username = "Kotlasbot";
//        bot.token = "923027476:AAHtJ0ee8c--5gueDBpjfB-0iRCMEV1U_yI";
//
//        bot.addTags("Пицца гавайская", "гавайск, пицц, ананас, куриц");
//        bot.addTags("Пицца маргарита", "маргарит, пицц, моцарелла, сыр, кетчуп, помидор");
//        bot.addTags("Пицца пеперони", "пеперони, пицц, салями, колбас, сыр, кетчуп, помидор");
//
//        bot.start();
//    }
//}
//
