package com.github.arkronzxc.telegrambotqueue.models;

import org.telegram.telegrambots.meta.api.objects.User;

public final class Student {
    private User telegramUser;
    private String name;
    private String group;
    private String teacher;

    public Student(User telegramUser, String name, String group, String teacher) {
        this.telegramUser = telegramUser;
        this.name = name;
        this.group = group;
        this.teacher = teacher;
    }

    public User getTelegramUser() {
        return telegramUser;
    }

    public void setTelegramUser(User telegramUser) {
        this.telegramUser = telegramUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}