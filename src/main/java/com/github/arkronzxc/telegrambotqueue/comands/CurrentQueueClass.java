package com.github.arkronzxc.telegrambotqueue.comands;

import com.github.arkronzxc.telegrambotqueue.dao.BotDAO;
import com.github.arkronzxc.telegrambotqueue.models.Student;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;

public class CurrentQueueClass extends AnonymizerCommand {
    private final BotDAO botDAO;

    public CurrentQueueClass(BotDAO botDAO) {
        super("currentQueue", "отображает ваше текущее положение в списке");
        this.botDAO = botDAO;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage currentQueueMessage;
        currentQueueMessage = new SendMessage();
        currentQueueMessage.setChatId(chat.getId());
        currentQueueMessage.enableHtml(true);
        try {
            List<Student> studentsQueue = botDAO.currentQueue(user);
            StringBuilder stringBuilder = new StringBuilder("Полная очередь\n");
            for(int i = 0;i < studentsQueue.size(); i++){
                stringBuilder.append(i).append("\\. ")
                        .append(studentsQueue.get(i).getName()).append("\n");
            }

            currentQueueMessage.setText(stringBuilder.toString());
        } catch (IllegalArgumentException e) {
            currentQueueMessage.setText("Какая то фигня");
        }
        execute(absSender, currentQueueMessage, user);
    }
}
