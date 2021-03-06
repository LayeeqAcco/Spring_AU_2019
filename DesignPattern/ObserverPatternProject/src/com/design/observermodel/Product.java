package com.design.observermodel;

import java.util.ArrayList;
import java.util.List;

public class Product implements Observable {
	 
	private List<Observer> observers = new ArrayList<> ();
	private double price;
 
	@Override
	public void register(Observer o) {
		this.observers.add(o);
	}
 
	@Override
	public void remove(Observer o) {
		if (!observers.isEmpty()) {
			observers.remove(o);
		}
	}
 
	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update(price);
		}
	}
 
	public void setPrice(double price) {
		this.price = price;
		this.notifyObservers();
	}
 
}