package com.revature.dao;

import com.revature.beans.Weather;

public interface WeatherDao {

	public Weather namedQueryGetWeatherPreference(int id); 
	
	public int addWeather(Weather w);
	
	public void updateWeather(Weather w);
	
	public void deleteWeather(Weather w);
}
