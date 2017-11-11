package com.revature.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class TextMessage {
	public static String ACCOUNT_SID;
	public static String AUTH_TOKEN;
	public static String FROM_NUMBER;
 
	private static void TwilioProperties() {
		Properties prop = new Properties();
		InputStream in;
		try {
			in = new FileInputStream("src/main/resources/twilio.properties");
			prop.load(in);
			ACCOUNT_SID = prop.getProperty("account_sid");
			AUTH_TOKEN = prop.getProperty("auth_token");
			FROM_NUMBER = prop.getProperty("phone");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	 public static Boolean sendTextNotification(String toNumber, String notification) {
		 TwilioProperties();
		  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		  try {
			  Message message = Message.creator(new PhoneNumber(toNumber),
				        new PhoneNumber(FROM_NUMBER), 
				        notification).create();
			  message.getSid();
			  return true;
		  }
		  catch(Exception e) {
			  return false;
		  }
	  }
	 
	  public static Boolean sendTextNotificationWithImage(String toNumber, String notification, String url) {
			 TwilioProperties();

		  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		  try {
			  Message message = Message.creator(new PhoneNumber(toNumber),
				        new PhoneNumber(FROM_NUMBER), 
				        notification)
					  .setMediaUrl(url)
					  .create();
			  message.getSid();
			  return true;
		  } catch(Exception e) {
			  return false;
		  }
	  }
}