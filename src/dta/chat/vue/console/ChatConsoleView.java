package dta.chat.vue.console;

public class ChatConsoleView extends ViewComposite{

	public ChatConsoleView(ChatConsoleTitleView titleView,ChatConsoleLoginView loginView,ChatConsoleConversationView convView) {
		this.addChild(titleView);
		this.addChild(loginView);
		this.addChild(convView);
	}
	
	@Override
	public void printBefore() {
		// TODO Auto-generated method stub
		
		
	}

}
