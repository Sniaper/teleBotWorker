package net.sniaper.BotWorker.settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import net.sniaper.BotWorker.bot.ExchangeRatesBot;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;

@Configuration
public class BotConfig {
	
	@Bean
	public TelegramBotsApi telegrammBotsApi (ExchangeRatesBot ExBot) throws TelegramApiException {
		var api = new TelegramBotsApi(DefaultBotSession.class);
		api.registerBot(ExBot);
		return api;
	}
	
	@Bean
	public OkHttpClient okHttplient() {
		return new OkHttpClient();
	}
}
