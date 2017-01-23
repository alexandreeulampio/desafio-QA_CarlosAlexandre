package codeKata;

public class Pricing_rules {
	private String product;
	private int unitPrice;
	private int numberForSpecialPrice = 0;
	private int specialPrice = 0;
	private boolean hasDesconto;
	
	public boolean isHasSpecialPrice() {
		return hasDesconto;
	}

	public void setHasSpecialPrice(boolean hasSpecialPrice) {
		this.hasDesconto = hasSpecialPrice;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setQuantityForSpecialPrice(int quantityForSpecialPrice) {
		this.numberForSpecialPrice = quantityForSpecialPrice;
	}

	public void setSpecialPrice(int specialPrice) {
		this.specialPrice = specialPrice;
	}

	public Pricing_rules(String product, int unitPrice, int quantityForSpecialPrice, int specialPrice) {
		this.product = product;
		this.unitPrice = unitPrice;
		this.numberForSpecialPrice = quantityForSpecialPrice;
		this.specialPrice = specialPrice;
		this.hasDesconto = true;
	}
	
	public Pricing_rules(String product, int unitPrice) {
		this.product = product;
		this.unitPrice = unitPrice;
		this.hasDesconto = false;
	}
		
	public boolean isSpecialPrice() {
	    return hasDesconto;
	}
	
		
	public String getProduct() {
	    return product;
	}
		
	public int getUnitPrice() {
	    return unitPrice;
	}
		
	public int getQuantityForSpecialPrice() {
	    return numberForSpecialPrice;
	}
		
	public int getSpecialPrice() {
		return specialPrice;
    }				
}