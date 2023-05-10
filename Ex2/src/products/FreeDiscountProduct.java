package products;

import discount.FreeDiscountable;
import logic.ShopUtil;

public class FreeDiscountProduct extends BaseProduct implements FreeDiscountable{

	private int promoQuantity;
	private int freeQuantity;

	
	public FreeDiscountProduct(String name, int price,int PromoQ ,int freeQ) {
		super(name, price);
		setPromoQuantity(PromoQ);
		setFreeQuantity(freeQ);
	}

	public int calcFreeDiscountPieces(int totalQuantityBought) {
//		ShopUtil.calculateFreeDiscountPieces(getFreeQuantity(), getPromoQuantity(), totalQuantityBought);
		return ShopUtil.calculateFreeDiscountPieces(getFreeQuantity(), getPromoQuantity(), totalQuantityBought);
	}
	
	public int calculateDiscount(int quantity) {
		return calcFreeDiscountPieces(quantity)*getPrice();
	}
	
	public String toString() {
		return this.getProductName() + " (Price: " + this.getPrice() + ", Buy " + this.getPromoQuantity() + " Get " + this.getFreeQuantity() + " Free)";
	}
	
	public int getPromoQuantity() {
		return promoQuantity;
	}


	public void setPromoQuantity(int promoQuantity) {
		this.promoQuantity = (promoQuantity<1)?1:promoQuantity;
	}


	public int getFreeQuantity() {
		return freeQuantity;
	}


	public void setFreeQuantity(int freeQuantity) {
		this.freeQuantity = (freeQuantity<1)?1:freeQuantity;
	}
	
}
