package T_Bot;

import org.telegram.telegrambots.ApiContextInitializer;
import ru.progwards.java1.telegrambot.ProgwardsTelegramBot;

public class Bot extends ProgwardsTelegramBot {


    public static void main(String[] args) {

        ApiContextInitializer.init();
        PizzaBot bot = new PizzaBot();
        bot.username = "Kotlasbot";
        bot.token = "923027476:AAHtJ0ee8c--5gueDBpjfB-0iRCMEV1U_yI";
        bot.start();
    }
}

