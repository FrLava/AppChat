package dta.chat.vue.console;

import dta.chat.domain.ChatMessage;
import dta.chat.model.observer.ChatObserver;

public class ChatConsoleConversationView extends ViewComposite implements ChatObserver<ChatMessage>{

	@Override
	public void printBefore() {
		// TODO Auto-generated method stub
		System.out.println("############################");
		System.out.println("#       Conversation       #");
		System.out.println("############################");
		System.out.println("");
		
	}

	@Override
	public void update(ChatMessage msg) {
		// TODO Auto-generated method stub
		System.out.println(msg.getLogin()+":"+msg.getText());
	}

}
