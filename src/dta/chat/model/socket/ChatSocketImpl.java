package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.domain.ChatMessage;
import dta.chat.exception.ChatClientException;
//Classe Adapteur
public class ChatSocketImpl implements ChatSocket {

	private ClientSocket clientSocket;
	
	public ChatSocketImpl(String hostname, Integer port) {
		// TODO Auto-generated constructor stub
		try {
			clientSocket=new ClientSocket(hostname, port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ChatClientException("Problème de connexion au serveur",e);
		}
	}
	
	@Override
	public void close() throws ChatClientException {
		// TODO Auto-generated method stub
		try {
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ChatClientException("Problème de communication",e);
		}
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		// TODO Auto-generated method stub
		try {
			clientSocket.sendObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ChatClientException("Pas de message",e);
		}

	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		// TODO Auto-generated method stub
		try {
			return (ChatMessage) clientSocket.readObject();
	
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ChatClientException("Rien à envoyer",e); 
		}
		
	}

}
