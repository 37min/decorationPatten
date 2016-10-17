package service;

public abstract class Beverage {
		protected String description="";

		public String getDescription(){
			return description;
		}
		//비용은 메서드 오버라이딩 대상
		public abstract int cost();
}
