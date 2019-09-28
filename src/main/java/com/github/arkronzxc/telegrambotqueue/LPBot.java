package com.github.arkronzxc.telegrambotqueue;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Level;

public class LPBot extends TelegramLongPollingBot {

    private static final String BOT_TOKEN = "890760059:AAH6eJ2he_dTGEaHy6T26XWFubYLaygZZiU";
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        System.out.println(message.getText());
        sendMsg("", message);
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
        response.enableMarkdown(true);
        response.setChatId(message.getChatId());
        response.setText("200 ok");
        response.setReplyToMessageId(message.getMessageId());
        try {
            execute(response);
        } catch (TelegramApiException e) {
//            log.log(Level.SEVERE, "Exception: ", e.toString());
        }
    }
}
