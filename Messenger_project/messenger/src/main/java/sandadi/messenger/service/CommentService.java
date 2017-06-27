package sandadi.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import sandadi.messenger.database.Database;
import sandadi.messenger.model.Comment;
import sandadi.messenger.model.ErrorMessage;
import sandadi.messenger.model.Message;

public class CommentService {

	private HashMap<Long, Message> messages = Database.messages;

	public CommentService(){
		//messages.get(message)
	}
	public List<Comment> getAllComments(long messageID) {
		Message message = messages.get(messageID);
		ErrorMessage errorMessage = new ErrorMessage("Not Found",
				404,"Not yet Implemented");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage)
					.build();
		if(message == null)
		{
			throw new WebApplicationException(response);
		}
		Map<Long, Comment> comments = message.getComments();

		return new ArrayList<Comment>(comments.values());
	}

	public Comment addComment(long messageID, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageID).getComments();
		comment.setId(comments.size() + 1);
		comment.setCreated(new Date());
		comments.put(comment.getId(), comment);
		return comments.get(comment.getId());
	}

	public Comment updateComment(long messageID, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageID).getComments();
		if(!comments.containsKey(comment.getId()))
				return null;
		comments.put(comment.getId(), comment);
		return comments.get(comment.getId());
	}
	
	public void removeComment(long messageID,long commentID){
		Map<Long,Comment> comments = messages.get(messageID)
										.getComments();
		comments.remove(commentID);
	}
}
