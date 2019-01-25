package com.design.observermodel;

public class OnlineShop {
	public static void main(String[] args) {
		Product product = new Product();
		RegularBuyer regularBuyer = new RegularBuyer(product);
		PrivilegedBuyer privilegedBuyer = new PrivilegedBuyer(product);
 
		product.setPrice(10000);	//updates both
		regularBuyer.unSubscribe();
		product.setPrice(15000);	//updates only priviliged because regular unsubscribed
	}
}
