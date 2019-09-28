package com.github.arkronzxc.telegrambotqueue.comands;

import com.github.arkronzxc.telegrambotqueue.util.LogLevel;
import com.github.arkronzxc.telegrambotqueue.util.LogTemplate;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AnonymizerCommand extends BotCommand {

    final Logger log = LogManager.getLogger(getClass());

    AnonymizerCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    void execute(AbsSender sender, SendMessage message, User user) {
        try {
            sender.execute(message);
            log.log(Level.getLevel(LogLevel.INFO.name()), LogTemplate.COMMAND_SUCCESS.getLogTemplate(), user.getId(), getCommandIdentifier());
        } catch (TelegramApiException e) {
            log.error(LogTemplate.COMMAND_EXCEPTION.getLogTemplate(), user.getId(), getCommandIdentifier(), e);
        }
    }
}

