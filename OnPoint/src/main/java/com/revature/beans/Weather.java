package com.revature.beans;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("weather")
@Scope("prototype")
@Entity 
@Table(name="OP_WEATHER")

@NamedQueries({
	@NamedQuery(
			name = "namedQueryGetWeatherPreference",
			query = "from Weather w where w.u_id = :id" //use class name and not table 
			)
})
public class Weather {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="opWeatherSequence")
	@SequenceGenerator(allocationSize=1,name="opWeatherSequence",sequenceName="SQ_OP_WEATHER_PK")
	@Column(name="WEATHER_ID")
	private int id;
	
	@Column(name="USER_ID", nullable = false)
	private int u_id;
	
	@Column(name="MIN_TEMP")
	private double minTemp;
	
	@Column(name="MAX_TEMP")
	private double maxTemp;
	
	@Column(name="SNOW")
	private double snow;
	
	@Column(name="RAIN")
	private double rain;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public double getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}
	public double getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}
	public double getSnow() {
		return snow;
	}
	public void setSnow(double snow) {
		this.snow = snow;
	}
	public double getRain() {
		return rain;
	}
	public void setRain(double rain) {
		this.rain = rain;
	}
	public Weather() {
		super();
	}
	
	public Weather(int id, int u_id, double minTemp, double maxTemp, double snow, double rain) {
		super();
		this.id = id;
		this.u_id = u_id;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.snow = snow;
		this.rain = rain;
	}
	@Override
	public String toString() {
		return "Weather [id=" + id + ", u_id=" + u_id + ", minTemp=" + minTemp + ", maxTemp=" + maxTemp + ", snow="
				+ snow + ", rain=" + rain + "]";
	}
	
	
	
}
