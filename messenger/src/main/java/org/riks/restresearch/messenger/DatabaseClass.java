/**
 * 
 */
package org.riks.restresearch.messenger;

import java.util.HashMap;
import java.util.Map;

import org.riks.restresearch.messenger.model.Message;
import org.riks.restresearch.messenger.model.Profile;

/**
 * @author Siddharth
 *
 */
public class DatabaseClass {

	public static Map<Long, Message> message = new HashMap<Long, Message>();
	public static Map<String, Profile> profile = new HashMap<String, Profile>();
	
	public static Map<Long, Message> getMessage(){
		return message;
	}
	
	public static Map<String, Profile> getProfile(){
		return profile;
	}
	
}
