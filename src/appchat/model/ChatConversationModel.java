package appchat.model;

import appchat.model.observer.ChatObservable;
import appchat.vue.console.ChatConsoleView;

public class ChatConversationModel extends ChatObservable<ChatMessage> {
	
	//ChatMessage cmsg;
	private String login;
	
	public void setLogin(String login){
		this.login=login;
	}
	
	public void sendMessage(String text){
		ChatMessage msg=new ChatMessage(login, text);
		notifyObservers(msg);
	}

	/*public void addObserver(ChatConsoleView view) {
		// TODO Auto-generated method stub
		
	}*/
}
