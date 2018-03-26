package crypto.tv;

import crypto.tv.bot.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.LongPollingBot;

@SpringBootApplication
public class TvApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TvApplication.class, args);
		SpringApplication.run(Bot.class,args);

	}
}
