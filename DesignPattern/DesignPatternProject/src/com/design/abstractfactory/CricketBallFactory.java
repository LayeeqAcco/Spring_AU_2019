package com.design.abstractfactory;

public class CricketBallFactory extends BallAbstractFactory{

	@Override
	public Ball getBall(String color, int size) {
		System.out.println("getting cricket ball");
		return new CricketBall(color,size);
	}
	
}
