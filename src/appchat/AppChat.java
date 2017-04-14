package appchat;

import appchat.vue.console.ChatConsoleLoginView;
import appchat.vue.console.ChatConsoleTitleView;
import appchat.vue.console.ChatConsoleView;

import java.util.Scanner;

import appchat.controlleur.LoginControlleur;
import appchat.model.ChatConversationModel;
import appchat.vue.console.ChatConsoleConversationView;

public class AppChat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scanner=new Scanner(System.in)){
		
		//Vues
		ChatConsoleTitleView title=new ChatConsoleTitleView();
		ChatConsoleLoginView login=new ChatConsoleLoginView(scanner);
		ChatConsoleConversationView conv=new ChatConsoleConversationView();
		ChatConsoleView view=new ChatConsoleView(title, login, conv);
		
		//Modèle
		ChatConversationModel convModel=new ChatConversationModel();
		convModel.addObserver(conv);
		
		//Controlleur
		login.setAuthController(new LoginControlleur(login,convModel));
		/*login.setAuthController(()->{
			System.out.println("");
		});*/
		
		
		view.print();
		
		convModel.sendMessage("Bonjour");
		convModel.sendMessage("C'est oim");
		convModel.sendMessage("JPP");
		}
	}

}
