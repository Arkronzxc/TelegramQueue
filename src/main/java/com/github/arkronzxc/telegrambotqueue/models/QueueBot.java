package com.github.arkronzxc.telegrambotqueue.models;

import java.util.ArrayList;
import java.util.List;

public class QueueBot {
    private List<Student> studentsQueue = new ArrayList<>();
    private String teacher;
    private String groupNumber;

    public QueueBot(String teacher, String groupNumber) {
        this.teacher = teacher;
        this.groupNumber = groupNumber;
    }

    public List<Student> getStudentsQueue() {
        return studentsQueue;
    }

    public void setStudentsQueue(List<Student> studentsQueue) {
        this.studentsQueue = studentsQueue;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }
}
