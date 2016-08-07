/**
 * 
 */
package org.riks.restresearch.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.riks.restresearch.messenger.DatabaseClass;
import org.riks.restresearch.messenger.model.Message;

/**
 * @author Siddharth
 *
 */
public class MessageService {
	
	public MessageService(){
		addMessage(new Message(1L,"Hello World!!!", "Rikin Patel"));
		addMessage(new Message(2L, "Hello Jersey!!!", "Rikin Patel"));
	}

	public List<Message> getAllMessages(){
		return new ArrayList<Message>(DatabaseClass.getMessage().values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> returnVal = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message:DatabaseClass.message.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				returnVal.add(message);
			}
		}
		return returnVal;
	}
	
	public List<Message> getAllMessagesByPage(int start, int size){
		List<Message> returnVal = new ArrayList<Message>(DatabaseClass.message.values());
		if(start+size>returnVal.size()) return new ArrayList<Message>();
		return returnVal.subList(start, start+size);
		
	}
	
	public Message addMessage(Message message){
		return DatabaseClass.message.put(message.getId(), message);
	}
	
	public Message getMessage(long id){
		return DatabaseClass.message.get(id);
	}
	
	public Message removeMessage(long id){
		return DatabaseClass.message.remove(id);
	}
	
	public Message updateMessage(Message message){
		if(message.getId()>0){
			DatabaseClass.message.replace(message.getId(), message);
			return message;
		}
		return null;
	}
	
}
