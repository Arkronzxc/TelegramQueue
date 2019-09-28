package com.github.arkronzxc.telegrambotqueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class MainBot {

    private static final Logger LOG = LogManager.getLogger(MainBot.class);

/*    private static String PROXY_HOST = " 216.144.230.233";//хост прокси
    private static Integer PROXY_PORT = 15993;
    private static String PROXY_USER = "trytoguesstheusername";//юзернейм для авторизации в прокси
    private static String PROXY_PASSWORD = "tipidorda";//пароль для авторизации в прокси*/

/*    private static String PROXY_HOST = "rocketparty.app";//хост прокси
    private static Integer PROXY_PORT = 1080;
    private static String PROXY_USER = "trytoguesstheusername";//юзернейм для авторизации в прокси
    private static String PROXY_PASSWORD = "tipidorda";//пароль для авторизации в прокси*/



    public static void main(String[] args) {
        /* try {*/

        LOG.info("Initializing API context...");


//            TelegramBotsApi botsApi = new TelegramBotsApi();

        LOG.info("Configuring bot options...");
//            DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
        try {
//                ApiContextInitializer.init();
            /*Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(PROXY_USER, PROXY_PASSWORD.toCharArray());
                }
            });*/



            ApiContextInitializer.init();
            TelegramBotsApi botsApi = new TelegramBotsApi();

            DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);

/*            botOptions.setProxyHost(PROXY_HOST);
            botOptions.setProxyPort(PROXY_PORT);
            botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);*/

            botsApi.registerBot(new Bot(botOptions));
//            botsApi.registerBot(new LPBot());
            System.out.println("Бот зарегестрирован...");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

        /*    LOG.info("Registering Anonymizer...");
            botsApi.registerBot(new Bot(botOptions));

            LOG.info("Anonymizer bot is ready for work!");

        } catch (TelegramApiRequestException e) {
            LOG.error("Error while initializing bot!", e);
        }*/
}

