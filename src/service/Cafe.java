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
		Beverage beverage=null;//Beverage 변수
		ArrayList<String> toppingList=new ArrayList<String>();//토핑 목록이 저장될 ArrayList
		Scanner s=new Scanner(System.in);//콘솔 입력
		
		
		
		
		//카페 안내 및 메뉴 출력
		System.out.println("반갑습니다. 카페에 오신 것을 환영합니다.");
		System.out.println("-----------------------");
		System.out.println("커피 종류     |    가격");
		System.out.println("-----------------------");
		System.out.println("Decaf              1500");
		System.out.println("HouseBlend  	   2000");
		System.out.println("DarkRoast          2500");
		System.out.println("Espresso           3000");
		System.out.println("CafeMocha          2700");
		System.out.println("CafeLatte          3500");
		System.out.println("-----------------------");
		System.out.println("커피 토핑     |    가격");
		System.out.println("-----------------------");
		System.out.println("Milk               500");
		System.out.println("Mocha              700");
		System.out.println("Soy                1000");
		System.out.println("Whip               1500");
		System.out.println("-----------------------");
		
		//커피 종류 주문 - (조건)커피 종류는 제거할 수 없음
		boolean typeFlag=false;//커피 종류 주문이 잘못되었을 때, 다시 주문 가능
		System.out.print("커피 종류를 선택하세요 : ");
		do{
			String coffeeType=s.next();//커피 종류 입력
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
				toppingList.add("Mocha");//toppingList에 Mocha 추가
				typeFlag=false;
			}else if(coffeeType.equals("CafeLatte")){//Espresso+Milk
				beverage=new Espresso();
				toppingList.add("Milk");//toppingList에 Milk 추가
				typeFlag=false;
			}else{
				System.out.println("잘못된 커피 종류 주문입니다. 다시 입력바랍니다.");
				typeFlag=true;
			}
		}while(typeFlag);
		
		//커피 토핑 주문
		String coffeeTopping="";
		boolean toppingFlag=true;//커피 토핑 주문 지속 여부 판단
		System.out.println("커피 토핑을 입력하세요." +
				"\n주문을 마치시면 'Exit'를 입력하세요." +
				"\n커피 토핑을 제거하실 때는 앞에 Remove를 입력하시면 됩니다.(예)RemoveMilk)" +
				"\n중복 토핑이 있을 시 하나만 삭제됩니다.(Milk를 2회 선택 후 RemoveMilk를 1회 경우 Milk 하나는 남아있게 됩니다.)");
		
		do{
			coffeeTopping=s.next();//커피 토핑 주문 입력
			if(coffeeTopping.equals("Exit") || coffeeTopping.equals("exit") || coffeeTopping.equals("EXIT")){//커피 주문을 마치면,
				toppingFlag=false;//주문 여부 변경
			}else if(coffeeTopping.equals("Milk") || coffeeTopping.equals("Mocha") || coffeeTopping.equals("Soy") || coffeeTopping.equals("Whip")){//커피 토핑 선택
				toppingList.add(coffeeTopping);//입력한 커피 토핑을 toppingList에 추가
			}else if(coffeeTopping.equals("RemoveMilk")){
				cd.removeTopping(toppingList,"Milk");
			}else if(coffeeTopping.equals("RemoveMocha")){
				cd.removeTopping(toppingList,"Mocha");
			}else if(coffeeTopping.equals("RemoveSoy")){
				cd.removeTopping(toppingList,"Soy");
			}else if(coffeeTopping.equals("RemoveWhip")){
				cd.removeTopping(toppingList,"Whip");
			}else{
				System.out.println("잘못된 커피 토핑 주문입니다.");
			}
		}while(toppingFlag);
		
		//최종 주문 상태를 반영
		for(int i=0;i<toppingList.size();i++){//toppingList 내의 항목의 목록과 비용을 모두 더한다.
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
		System.out.println("주문하신 커피는 "+beverage.getDescription()+" 입니다.");
		System.out.println("총 금액은 "+beverage.cost()+"원입니다.");
	}
	

	
	
	
}
