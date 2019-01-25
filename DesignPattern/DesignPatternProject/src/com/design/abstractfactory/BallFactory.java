package com.design.abstractfactory;

public class BallFactory {
	public static Ball ballProducer(BallAbstractFactory ball) {
		return ball.getBall("blue", 10);
	}
}
