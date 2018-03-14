package crypto.tv.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;

@Component
public class Bot extends TelegramLongPollingBot {
    @PostConstruct
    public void init() throws TelegramApiException {
        sendApiMethod(new SendMessage(245480645l,"bot start"));
    }
    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage(update.getMessage().getChatId(),"her"+update.getMessage().getChatId());
        try {
            sendApiMethod(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "tradebeeperbot";
    }

    @Override
    public String getBotToken() {
        return "499086618:AAGtttl7ZsoTdSzNt7F1SDsH3d4SCnybTSs";
    }
}
