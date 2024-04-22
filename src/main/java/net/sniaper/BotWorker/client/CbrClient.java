package net.sniaper.BotWorker.client;

import java.io.IOException;

import javax.sql.rowset.serial.SerialException;

import org.glassfish.grizzly.http.server.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;

@Component
public class CbrClient {
	
	@Autowired
	private OkHttpClient client;
	
	@Value("${cbr.link.xml}")
	private String url;
	
	public String getCurrencyRatesXML() throws SerialException{
		var request = new okhttp3.Request.Builder()
				.url(url)
				.build();
		try (var responce = client.newCall(request).execute();){
			var body = responce.body();
			return body == null ? null : body.string();
		} catch (IOException e) {
			throw new SerialException("Ошибка получения курса валют");
		}
	}
}
