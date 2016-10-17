package service;

import java.util.ArrayList;
import java.util.Scanner;

import coffee.DarkRoast;
import coffee.Decaf;
import coffee.Espresso;
import coffee.HouseBlend;
import decoration.Milk;
import decoration.Mocha;
import decoration.Soy;
import decoration.Whip;

public class Cafe {

	private static CondimentDecorator cd;
	
	public Cafe(CondimentDecorator cd) {
		super();
		this.cd = cd;
	}

	public static void main(String[] args) {
		Beverage beverage=null;//Beverage ����
		ArrayList<String> toppingList=new ArrayList<String>();//���� ����� ����� ArrayList
		Scanner s=new Scanner(System.in);//�ܼ� �Է�
		
		
		
		
		//ī�� �ȳ� �� �޴� ���
		System.out.println("�ݰ����ϴ�. ī�信 ���� ���� ȯ���մϴ�.");
		System.out.println("-----------------------");
		System.out.println("Ŀ�� ����     |    ����");
		System.out.println("-----------------------");
		System.out.println("Decaf              1500");
		System.out.println("HouseBlend  	   2000");
		System.out.println("DarkRoast          2500");
		System.out.println("Espresso           3000");
		System.out.println("CafeMocha          2700");
		System.out.println("CafeLatte          3500");
		System.out.println("-----------------------");
		System.out.println("Ŀ�� ����     |    ����");
		System.out.println("-----------------------");
		System.out.println("Milk               500");
		System.out.println("Mocha              700");
		System.out.println("Soy                1000");
		System.out.println("Whip               1500");
		System.out.println("-----------------------");
		
		//Ŀ�� ���� �ֹ� - (����)Ŀ�� ������ ������ �� ����
		boolean typeFlag=false;//Ŀ�� ���� �ֹ��� �߸��Ǿ��� ��, �ٽ� �ֹ� ����
		System.out.print("Ŀ�� ������ �����ϼ��� : ");
		do{
			String coffeeType=s.next();//Ŀ�� ���� �Է�
			if(coffeeType.equals("Decaf")){//Decaf
				beverage=new Decaf();
				typeFlag=false;
			}else if(coffeeType.equals("HouseBlend")){//HouseBlend
				beverage=new HouseBlend();
				typeFlag=false;
			}else if(coffeeType.equals("DarkRoast")){//DarkRoast
				beverage=new DarkRoast();
				typeFlag=false;
			}else if(coffeeType.equals("Espresso")){//Espresso
				beverage=new Espresso();
				typeFlag=false;
			}else if(coffeeType.equals("CafeMocha")){//HouseBlend+Mocha
				beverage=new HouseBlend();
				toppingList.add("Mocha");//toppingList�� Mocha �߰�
				typeFlag=false;
			}else if(coffeeType.equals("CafeLatte")){//Espresso+Milk
				beverage=new Espresso();
				toppingList.add("Milk");//toppingList�� Milk �߰�
				typeFlag=false;
			}else{
				System.out.println("�߸��� Ŀ�� ���� �ֹ��Դϴ�. �ٽ� �Է¹ٶ��ϴ�.");
				typeFlag=true;
			}
		}while(typeFlag);
		
		//Ŀ�� ���� �ֹ�
		String coffeeTopping="";
		boolean toppingFlag=true;//Ŀ�� ���� �ֹ� ���� ���� �Ǵ�
		System.out.println("Ŀ�� ������ �Է��ϼ���." +
				"\n�ֹ��� ��ġ�ø� 'Exit'�� �Է��ϼ���." +
				"\nĿ�� ������ �����Ͻ� ���� �տ� Remove�� �Է��Ͻø� �˴ϴ�.(��)RemoveMilk)" +
				"\n�ߺ� ������ ���� �� �ϳ��� �����˴ϴ�.(Milk�� 2ȸ ���� �� RemoveMilk�� 1ȸ ��� Milk �ϳ��� �����ְ� �˴ϴ�.)");
		
		do{
			coffeeTopping=s.next();//Ŀ�� ���� �ֹ� �Է�
			if(coffeeTopping.equals("Exit") || coffeeTopping.equals("exit") || coffeeTopping.equals("EXIT")){//Ŀ�� �ֹ��� ��ġ��,
				toppingFlag=false;//�ֹ� ���� ����
			}else if(coffeeTopping.equals("Milk") || coffeeTopping.equals("Mocha") || coffeeTopping.equals("Soy") || coffeeTopping.equals("Whip")){//Ŀ�� ���� ����
				toppingList.add(coffeeTopping);//�Է��� Ŀ�� ������ toppingList�� �߰�
			}else if(coffeeTopping.equals("RemoveMilk")){
				cd.removeTopping(toppingList,"Milk");
			}else if(coffeeTopping.equals("RemoveMocha")){
				cd.removeTopping(toppingList,"Mocha");
			}else if(coffeeTopping.equals("RemoveSoy")){
				cd.removeTopping(toppingList,"Soy");
			}else if(coffeeTopping.equals("RemoveWhip")){
				cd.removeTopping(toppingList,"Whip");
			}else{
				System.out.println("�߸��� Ŀ�� ���� �ֹ��Դϴ�.");
			}
		}while(toppingFlag);
		
		//���� �ֹ� ���¸� �ݿ�
		for(int i=0;i<toppingList.size();i++){//toppingList ���� �׸��� ��ϰ� ����� ��� ���Ѵ�.
			if(toppingList.get(i).equals("Milk")){
				beverage=new Milk(beverage);
			}else if(toppingList.get(i).equals("Mocha")){
				beverage=new Mocha(beverage);
			}else if(toppingList.get(i).equals("Soy")){
				beverage=new Soy(beverage);
			}else if(toppingList.get(i).equals("Whip")){
				beverage=new Whip(beverage);
			}
		}
		System.out.println("�ֹ��Ͻ� Ŀ�Ǵ� "+beverage.getDescription()+" �Դϴ�.");
		System.out.println("�� �ݾ��� "+beverage.cost()+"���Դϴ�.");
	}
	

	
	
	
}
