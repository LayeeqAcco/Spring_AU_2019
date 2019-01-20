package com.assignment.taxi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class PassengerQueueRunnable implements Runnable {
    TaxiStand lot;
    LinkedList<Passenger> passengerQueue;
    int queueNumber=0;
    
    public PassengerQueueRunnable(LinkedList<Passenger> queue, TaxiStand l) {
        passengerQueue = queue;
        lot = l;
    }

    @Override
    public void run() {
    	int num = 0;
        while(true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
            	System.out.println("Interruppted Exception Occurred");
            }
            
            LinkedList<Taxi> taxiQueue = lot.getTaxiQueue();
            CopyOnWriteArrayList<Taxi> taxiStand= lot.getTaxiStand();
            
            Iterator<Taxi> it = taxiStand.iterator();
            while(it.hasNext()) {
            	Taxi temp = it.next();
            	if(temp.getpassengerCount() > 0) {
            		temp.updateTime();
            		if(temp.getTime() >= 40) {
            			taxiStand.remove(temp);
            			System.out.println("Taxi "+temp.getTaxiId()+" leaves for destination: "+temp.getDestination() + " TIMEOUT");
            			if(!taxiQueue.isEmpty())
            				taxiStand.add(taxiQueue.removeFirst());
            		}
            	}
            }
            
            //sending back updated taxi stand and queue
            lot.setTaxiStand(taxiStand);
            lot.setTaxiQueue(taxiQueue);
            
            int pick = new Random().nextInt(Passenger.DESTINATION.values().length);
            Passenger p = new Passenger(num,Passenger.DESTINATION_VALUES[pick]);
            System.out.println("New passenger id=" + num +" with destination " + p.getDestination() + " arrives.");

            if(!lot.allocatePassenger(p)) {
                System.out.println("No cab found for passenger. Adding to Queue..");
                passengerQueue.add(p);
                System.out.println("Passeneger added to queue. Queue Length " + passengerQueue.size());
            }
            num = num + 1;
        }
    }
}
