package dta.chat.model;

import dta.chat.domain.ChatMessage;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatSocket;
import dta.chat.model.socket.ChatSocketImpl;
import dta.chat.vue.console.ChatConsoleView;

public class ChatConversationModel extends ChatObservable<ChatMessage> {
	
	//ChatMessage cmsg;
	private String login;
	private ChatSocket chatSocket;
	
	public ChatConversationModel(ChatSocket chatSocket) {
		this.chatSocket=chatSocket;
	}

	public void setLogin(String login){
		this.login=login;
	}
	
	public void sendMessage(String text){
		ChatMessage msg=new ChatMessage(login, text);
		chatSocket.sendMessage(msg);
		notifyObservers(msg);
	}
	
	public void startListenning(){
		
		new Thread(()-> {
			while(true){
				ChatMessage message=chatSocket.readMessage();
			}
			
		}).start();

	}

	/*public void addObserver(ChatConsoleView view) {
		// TODO Auto-generated method stub
		
	}*/
}
