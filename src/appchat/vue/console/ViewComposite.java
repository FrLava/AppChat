package appchat.vue.console;

import java.util.ArrayList;
import java.util.List;

public abstract class ViewComposite {
	
	private List<ViewComposite> children =new ArrayList<>();
	
	protected void addChild(ViewComposite child){
		this.children.add(child);
	}
	
	public abstract void printBefore();
	
	public void print(){
		printBefore();
		children.forEach((child)->child.print());
		/*ou
		//children.forEach(ViewComposite::print);
		//ou java 7
		for(ViewComposite child : children){
			child.print();
		}*/
	}
	
}
