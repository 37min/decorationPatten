package service;

import java.util.ArrayList;

public abstract class CondimentDecorator extends Beverage {
	public abstract String getDescription();
	
	//Ŀ�� ���� ���� �޼���
	public static void removeTopping(ArrayList<String> toppingList, String topping){
		//toppingList ���� �Ű������� ���� ���ο� ���� �׸��� �����Ѵ�.
		for(int i=0;i<toppingList.size();i++){
			if(toppingList.get(i).equals(topping)){
				toppingList.remove(i);
				return;
			}//if
		}//for
	}
	
	
}
