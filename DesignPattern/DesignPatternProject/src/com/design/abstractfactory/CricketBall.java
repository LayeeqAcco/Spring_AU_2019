package com.design.abstractfactory;

public class CricketBall implements Ball{
	private String color;
	private int size;
	
	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	public CricketBall(String color, int size) {
		this.color = color;
		this.size = size;
	}
}