package com.github.arkronzxc.telegrambotqueue.comands;

import com.github.arkronzxc.telegrambotqueue.dao.BotDAO;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class UnsubscribeFromBotClass extends AnonymizerCommand{
    private final BotDAO botDAO;

    public UnsubscribeFromBotClass(BotDAO botDAO) {
        super("unreg", "Конец регистрации");
        this.botDAO = botDAO;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage unregMessage;
        unregMessage = new SendMessage();
        unregMessage.setChatId(chat.getId());
        unregMessage.enableHtml(true);
        try {
            botDAO.unsubscribeFromBot(user);
            unregMessage.setText("Конец регистрации");
        } catch (IllegalArgumentException e) {
            unregMessage.setText("Введите в формате: Имя_Фамилия Группа Фамилия_Препода");
        }
        execute(absSender, unregMessage, user);
    }
}
