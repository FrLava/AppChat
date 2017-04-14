package appchat.controlleur;

import java.util.ArrayList;
import java.util.List;

import appchat.model.ChatConversationModel;
import appchat.vue.console.ChatConsoleLoginView;

public class LoginControlleur implements ChatAuthController {

	List<String> listLoginValid=new ArrayList<>();
	
	private ChatConsoleLoginView loginView;
	private ChatConversationModel convModel;
	
	public LoginControlleur(ChatConsoleLoginView loginView, ChatConversationModel model) {
		// TODO Auto-generated constructor stub
		this.loginView=loginView;
		this.convModel=model;
		
		listLoginValid.add("Franc");
		listLoginValid.add("Marc");
		listLoginValid.add("Moutaleb");
	}
	@Override
	public void authenticate() {
		// TODO Auto-generated method stub
		String login=loginView.askLogin();	
		
		if(listLoginValid.contains(login)){
			loginView.sayWelcome(login);
			convModel.setLogin(login);
		}
		else
			loginView.sayAccessDenied(login);
				
	}

}
