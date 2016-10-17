package service;

import java.util.ArrayList;

public abstract class CondimentDecorator extends Beverage {
	public abstract String getDescription();
	
	//커피 토핑 제거 메서드
	public static void removeTopping(ArrayList<String> toppingList, String topping){
		//toppingList 내에 매개변수로 들어온 토핑에 대한 항목을 제거한다.
		for(int i=0;i<toppingList.size();i++){
			if(toppingList.get(i).equals(topping)){
				toppingList.remove(i);
				return;
			}//if
		}//for
	}
	
	
}
