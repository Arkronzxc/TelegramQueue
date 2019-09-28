package com.github.arkronzxc.telegrambotqueue.comands;

import com.github.arkronzxc.telegrambotqueue.dao.BotDAO;
import com.github.arkronzxc.telegrambotqueue.models.Student;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class RegClass extends AnonymizerCommand {

    private final BotDAO botDAO;

    public RegClass(BotDAO botDAO) {
        super("reg", "Создание акка.\n 1-имя юзера, 2-группа, 3-препод,\n");
        this.botDAO = botDAO;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage regMessage;
        regMessage = new SendMessage();
        regMessage.setChatId(chat.getId());
        regMessage.enableHtml(true);
        try {
            Student student = botDAO.createUser(strings[0], strings[1], strings[2], user);

            String stringBuilder = "<b>информация по студенту</b> \n" + "имя: " + student.getName() + "\n" +
                    "группа: " + student.getGroup() + "\n" +
                    "препод: " + student.getTeacher() + "\n";
            regMessage.setText(stringBuilder);
        } catch (IllegalArgumentException e){
            regMessage.setText("Введите в формате: Имя_Фамилия Группа Фамилия_Препода");
        }
        execute(absSender, regMessage, user);
    }
}
