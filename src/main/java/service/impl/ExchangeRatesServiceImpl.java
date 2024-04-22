package service.impl;

import java.io.StringReader;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.xml.sax.InputSource;

import net.sniaper.BotWorker.client.CbrClient;
import net.sniaper.BotWorker.exceptionChek.ServiceException;
import service.ExchangeRatesService;


@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService{
	
	@Autowired
	private CbrClient client;

	@Override
	public String getUSDExchangeRate() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEURExchangeRate() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	

	private static String extactCurrencyValueFromXML(String xml, String xpathExpresion) throws ServiceException {
		var source = new InputSource(new StringReader(xml));
		try {
			var xpath = XPathFactory.newInstance().newXPath();
			var document = (Document) xpath.evaluate("/", source, XPathConstants.NODE);
			return xpath.evaluate(xpathExpresion, document);
		}catch (XPathExpressionException e) {
			throw new ServiceException("Не удалось распарсить XML", e);
		}

	}

}
