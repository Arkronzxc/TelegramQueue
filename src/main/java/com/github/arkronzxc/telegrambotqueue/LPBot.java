package com.github.arkronzxc.telegrambotqueue;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class LPBot extends TelegramLongPollingBot {

    private static final String BOT_TOKEN = "890760059:AAH6eJ2he_dTGEaHy6T26XWFubYLaygZZiU";
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        System.out.println(message.getText());
    }

    @Override
    public String getBotUsername() {
        return "PolytechQueue_bot";
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    private void sendMsg(String text, Message message){
        SendMessage response = new SendMessage();
        response.setChatId(message.getChatId());
        response.setText("Hello Mr. Penis " + message.getAuthorSignature());
/*        try{

        }catch (TelegramApiException e){
            System.out.println(e.getMessage());
        }*/
    }
}
