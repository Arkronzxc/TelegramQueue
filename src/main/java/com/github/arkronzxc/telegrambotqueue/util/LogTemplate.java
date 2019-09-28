package com.github.arkronzxc.telegrambotqueue.util;

public enum LogTemplate {

    COMMAND_SUCCESS ("Success with user {}, command {}"),
    COMMAND_EXCEPTION ("Error with user {}, command {}, error {}");

    private String logTemplate;

    LogTemplate(String logTemplate){
        this.logTemplate = logTemplate;
    }

    public String getLogTemplate() {
        return logTemplate;
    }
}
