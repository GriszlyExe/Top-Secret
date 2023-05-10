package products;

import discount.PercentDiscountable;
import discount.Sellable;
import logic.ShopUtil;

public class PercentDiscountProduct extends BaseProduct implements PercentDiscountable{
	
	private double percent;
	
	public PercentDiscountProduct(String name, int price ,double percent) {
		super(name, price);
		setPercent(percent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcDiscountPerPiece() {
		// TODO Auto-generated method stub
		return ShopUtil.calculateDiscountUsingPercent(getPrice(),getPercent());
	}

	public int calculateDiscount(int quantity) {
		return quantity*calcDiscountPerPiece();
	}
	
	public String toString() {
		return this.getProductName() + " (Price: " + this.getPrice() +", "+ this.getPercent() + "% Off)";
	}
	
	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		if (percent>100) {
			this.percent = 100;
		}else if(percent<0){
			this.percent = 0;
		}else {
			this.percent = percent;
		}
	}
	
	
}
