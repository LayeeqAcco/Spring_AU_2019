package com.assignment.taxi;

public class Taxi {
    private Passenger.DESTINATION destination;
    private int taxiId, passengerCount, currTime;
    private static int totalTaxis = 0;
    
    public Taxi(Passenger.DESTINATION destination) {
        
        this.destination = destination;
        this.taxiId = totalTaxis++;
        passengerCount = 0;
        currTime = 0;
        System.out.println("New Taxi " + taxiId + "arrives");
    }
    
    public Passenger.DESTINATION getDestination() {
        return destination;
    }

    public int getpassengerCount() {
        return passengerCount;
    }
    
    public void updateTime() {
		currTime = currTime + 3;
	}
	
	public int getTime() {
		return currTime;
	}
	
	public void setTime(int time) {
		this.currTime = time;
	}

	public int getTaxiId() {
		return taxiId;
	}
	
    public boolean isFull() {
        if(passengerCount<4)
            return false;
        else
            return true;
    }

    public boolean addPassenger() {
        if(isFull()){
            System.out.println("Taxi is full");
            return false;
        } else {
            passengerCount++;
            System.out.println("Passenger boards taxi to " + destination + "- passenger count " + passengerCount);
            return true;
        }
    }

    public boolean allocatePassenger(Passenger p) {
        System.out.println("New allocation: P-> " + p.getDestination() + " T-> " + this.destination);
    	if(destination == null) {
            System.out.println("Empty Taxi - set Destination " + p.getDestination());
            destination = p.getDestination();
            return addPassenger();
        } else {
            if(destination == p.getDestination()){
                System.out.println("Found taxi to " + destination);
                return addPassenger();
            } else {
                System.out.println("Unable to allocate passenger to this taxi");
                return false;
            }
        }
    }
}

