package dta.chat;

import java.util.Scanner;

import dta.chat.controlleur.LoginControlleur;
import dta.chat.model.ChatConversationModel;
import dta.chat.model.socket.ChatSocket;
import dta.chat.model.socket.ChatSocketImpl;
import dta.chat.vue.console.ChatConsoleConversationView;
import dta.chat.vue.console.ChatConsoleLoginView;
import dta.chat.vue.console.ChatConsoleTitleView;
import dta.chat.vue.console.ChatConsoleView;

public class AppChat {

	private static final int SERVER_PORT = 1800;
	private static final String SERVER_HOST = "ns377570.ip-5-196-89.eu";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scanner=new Scanner(System.in)){
		
		//Vues
		ChatConsoleTitleView title=new ChatConsoleTitleView();
		ChatConsoleLoginView login=new ChatConsoleLoginView(scanner);
		ChatConsoleConversationView conv=new ChatConsoleConversationView();
		ChatConsoleView view=new ChatConsoleView(title, login, conv);
		
		//Socket de communication
		ChatSocket chatSocket=new ChatSocketImpl(SERVER_HOST,SERVER_PORT);
		
		//Modèle
		ChatConversationModel convModel=new ChatConversationModel(chatSocket);
		convModel.addObserver(conv);
		
		//Controlleur
		login.setAuthController(new LoginControlleur(login,convModel));
		/*login.setAuthController(()->{
			System.out.println("");
		});*/
		
		
		view.print();
		for(;;){
			Scanner scanner1=new Scanner(System.in);
			String message=scanner1.nextLine();
			convModel.sendMessage(message);
		}
		
		//convModel.sendMessage("C'est oim");
		//convModel.sendMessage("JPP");
		}
	}

}
