package com.github.arkronzxc.telegrambotqueue.comands;

import com.github.arkronzxc.telegrambotqueue.dao.BotDAO;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class UnsubscribeFromQueueClass extends AnonymizerCommand{
    private final BotDAO botDAO;

    public UnsubscribeFromQueueClass(BotDAO botDAO) {
        super("unsubs", "Атписка!");
        this.botDAO = botDAO;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage unsubsMessage;
        unsubsMessage = new SendMessage();
        unsubsMessage.setChatId(chat.getId());
        unsubsMessage.enableHtml(true);
        try {
            botDAO.unsubscribeFromQueue(user);
            unsubsMessage.setText("Атписка оформлена.");
        } catch (IllegalArgumentException e) {
            unsubsMessage.setText("Введите в формате: Имя_Фамилия Группа Фамилия_Препода");
        }
        execute(absSender, unsubsMessage, user);
    }
}
