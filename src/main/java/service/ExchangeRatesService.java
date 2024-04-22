package service;

import net.sniaper.BotWorker.exceptionChek.ServiceException;

public interface ExchangeRatesService {
	
	String getUSDExchangeRate() throws ServiceException;
	
	String getEURExchangeRate() throws ServiceException;
	
}
