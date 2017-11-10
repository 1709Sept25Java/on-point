package com.revature.util;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class TextMessage {
	 public static final String ACCOUNT_SID = "AC58e89ff1208bb617f0e9d27742bab685";
	 public static final String AUTH_TOKEN = "97ea83e31e5c107fe161e463a4fd4beb";
	 public static final String FROM_NUMBER = "+13479604243";
	 public static Boolean sendTextNotification(String toNumber, String notification) {
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
