package appchat.vue.console;

import java.util.Scanner;

import appchat.controlleur.ChatAuthController;
import appchat.controlleur.LoginControlleur;

public class ChatConsoleLoginView extends ViewComposite{

	private Scanner scanner;
	private ChatAuthController logctrl;
	
	public ChatConsoleLoginView(Scanner scanner){
		this.scanner=scanner;
	}
	
	public String askLogin(){
		System.out.println("Veuillez saisir votre pseudo");
		String saisie=this.scanner.nextLine();
		return saisie;
	}
	
	public void sayWelcome(String login){
		System.out.println("Bienvenu : "+login);
	}

	public void sayAccessDenied(String login){
		System.out.println("Acces denied : "+login);
	}
	
	public void setAuthController(ChatAuthController logctrl){
		this.logctrl=logctrl;
		//logctrl.authenticate();
	}
	
	@Override
	public void printBefore() {
		// TODO Auto-generated method stub
		System.out.println("############################");
		System.out.println("#     Authentification     #");
		System.out.println("############################");
		System.out.println("");
		this.logctrl.authenticate();
		//this.setAuthController();
		/*System.out.println("Veuillez saisir votre pseudo");
		String saisie=this.scanner.nextLine();
		System.out.println("Bienvenue "+saisie);
		System.out.println("");*/
	}

}
