package com.github.arkronzxc.telegrambotqueue.dao;

import com.github.arkronzxc.telegrambotqueue.models.QueueBot;
import com.github.arkronzxc.telegrambotqueue.models.Student;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.*;

public class BotDAO {

    private Map<Map.Entry<String, String>, QueueBot> queueBotMap = new HashMap<>();
    private List<String> teachersNames = new ArrayList<>();
    private List<String> groupsNames = new ArrayList<>();
    private Map<User, Student> studentsNames = new HashMap<>();

    public BotDAO() {
        teachersNames.add("Первый");
        teachersNames.add("Второй");
        groupsNames.add("123");
    }

    public Student createUser(String username, String group, String teacherName, User telegramUser) {
        if (!teachersNames.contains(teacherName) || !groupsNames.contains(group)) {
            throw new IllegalArgumentException("Incorrect data");
        }
        Student newStudent;
        if (!studentsNames.containsKey(telegramUser)) {
            newStudent = new Student(telegramUser, username, group, teacherName);
            studentsNames.put(telegramUser, newStudent);
        } else {
            newStudent = studentsNames.get(telegramUser);

            newStudent.setGroup(group);
            newStudent.setTeacher(teacherName);
            newStudent.setName(username);

        }
        return newStudent;
    }

    public List<Student> currentQueue(User telegramUser) {
        Student student = studentsNames.get(telegramUser);
        return getQueueByTgUser(student).getStudentsQueue();
    }

    public void subscribeToQueue(User telegramUser) {
        Student student = studentsNames.get(telegramUser);
        getQueueByTgUser(student).getStudentsQueue().add(student);
    }

    public void unsubscribeFromBot(User telegramUser){
        Student student = studentsNames.remove(telegramUser);
        getQueueByTgUser(student).getStudentsQueue().remove(student);
    }

    public void unsubscribeFromQueue(User telegramUser) {
        Student student = studentsNames.get(telegramUser);
        getQueueByTgUser(student).getStudentsQueue().remove(student);
    }

    public Student getInfoAboutMe(User telegramUser) {
        Student student = studentsNames.get(telegramUser);
        if(student == null){
            throw new IllegalArgumentException("Login Please");
        }
        return student;
    }

    private QueueBot getQueueByTgUser(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Login Please");
        }
        QueueBot queueBot = queueBotMap.get(new AbstractMap.SimpleEntry<>
                (student.getGroup(), student.getTeacher()));
        if (queueBot == null) {
            throw new IllegalArgumentException("Queue noy found");
        }
        return queueBot;
    }
}
