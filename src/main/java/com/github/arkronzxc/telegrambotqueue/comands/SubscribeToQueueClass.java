package com.github.arkronzxc.telegrambotqueue.comands;

import com.github.arkronzxc.telegrambotqueue.dao.BotDAO;
import com.github.arkronzxc.telegrambotqueue.models.Student;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class SubscribeToQueueClass extends AnonymizerCommand {
    private final BotDAO botDAO;

    public SubscribeToQueueClass(BotDAO botDAO) {
        super("subs", "патписка!");
        this.botDAO = botDAO;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage subsMessage;
        subsMessage = new SendMessage();
        subsMessage.setChatId(chat.getId());
        subsMessage.enableHtml(true);
        try {
            botDAO.subscribeToQueue(user);
            subsMessage.setText("Патписка оформлена. ауе!");
        } catch (IllegalArgumentException e) {
            subsMessage.setText("Введите в формате: Имя_Фамилия Группа Фамилия_Препода");
        }
        execute(absSender, subsMessage, user);
    }
}
