package com.assignment.taxi;

public class Passenger {

    public static enum DESTINATION {
        WHITEFIELD, SARJAPUR, KRPURAM, INDIRANAGAR, MGROAD, HEBBAL, JAYANAGAR, PEENYA, HSRLAYOUT, KORAMANGLA
    }
    public static final DESTINATION[] DESTINATION_VALUES = DESTINATION.values();

    private DESTINATION destination;
    private int passId;
    
    public Passenger(int id, DESTINATION dest){
        passId = id;
        destination = dest;
    }
    
    public DESTINATION getDestination() {
        return destination;
    }
    //set destination .......??
    public int getPassId() {
    	return passId;
    }
}

