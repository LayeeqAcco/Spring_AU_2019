package com.design.observermodel;

public class RegularBuyer implements Observer {
	 
	private Observable product;
 
	public RegularBuyer(Observable product) {
		this.product = product;
		this.product.register(this);
	}
 
	@Override
	public void update(double price) {
		System.out.println("New price received in RegularBuyer = " + price);
	}
 
	public void unSubscribe() {
		this.product.remove(this);
	}
 
}