package net.sniaper.BotWorker.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
public class ExchangeRatesBot extends TelegramLongPollingBot{
	
	public ExchangeRatesBot(@Value("$(bot.token)") String botToken) {
		super(botToken);
	}

	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBotUsername() {
		return "my_work_app";
	}
	
}
