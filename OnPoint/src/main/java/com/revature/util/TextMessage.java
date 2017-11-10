package com.revature.util;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class TextMessage {
	 public static final String ACCOUNT_SID = "";
	  public static final String AUTH_TOKEN = "";
	  
	  public static Boolean sendTextNotification(String toNumber, String notification) {
		  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		  try {
			  Message message = Message.creator(new PhoneNumber(toNumber),
				        new PhoneNumber("+"), 
				        notification).create();
			  message.getSid();
			  return true;
		  }
		  catch(Exception e) {
			  return false;
		  }
	  }
	  public static Boolean sendTextNotificationWithImage(String toNumber, String notification, String url) {
		  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		  try {
			  Message message = Message.creator(new PhoneNumber(toNumber),
				        new PhoneNumber("+"), 
				        notification)
					  .setMediaUrl(url)
					  .create();
			  message.getSid();
			  return true;
		  }
		  catch(Exception e) {
			  return false;
		  }
	  }
}
