package dta.chat.model.socket;

import dta.chat.domain.ChatMessage;
import dta.chat.exception.ChatClientException;

public interface ChatSocket extends AutoCloseable {
	
	void sendMessage(ChatMessage msg) throws ChatClientException;
	ChatMessage readMessage() throws ChatClientException;
}
