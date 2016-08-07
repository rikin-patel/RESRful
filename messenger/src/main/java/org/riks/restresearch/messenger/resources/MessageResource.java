/**
 * 
 */
package org.riks.restresearch.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.riks.restresearch.messenger.model.Message;
import org.riks.restresearch.messenger.service.MessageService;

/**
 * @author Siddharth
 *
 */
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	private MessageService service = new MessageService();

	@GET
	public List<Message> getMessages(@QueryParam("year")int year,
			@QueryParam("start") int start,
			@QueryParam("size") int size){
		if(year>0){
			return service.getAllMessagesForYear(year);
		}
		if(start>=0 && size>0){
			return service.getAllMessagesByPage(start, size);
		}
		return service.getAllMessages();
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		return service.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long id){
		return service.removeMessage(id);
	}
	
	@POST
	public Message addMessage(Message message){
		return service.addMessage(message);
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id){
		return service.getMessage(id);
	}
}
