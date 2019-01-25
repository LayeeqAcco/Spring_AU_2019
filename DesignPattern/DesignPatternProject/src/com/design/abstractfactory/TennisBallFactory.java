package com.design.abstractfactory;

public class TennisBallFactory extends BallAbstractFactory {

	@Override
	Ball getBall(String color, int size) {
		System.out.println("getting tennis ball");
		return new TennisBall(color,size);
	}

}
