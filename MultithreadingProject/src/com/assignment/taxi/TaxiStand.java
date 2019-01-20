package com.assignment.taxi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaxiStand {
    private int size = 5;
    private CopyOnWriteArrayList<Taxi> taxiStand;
    private LinkedList<Taxi> taxiQueue;
    private LinkedList<Passenger> passengerQueue;

    public TaxiStand(int capacity, LinkedList<Taxi> q, LinkedList<Passenger> pq) {
        size = capacity;
        taxiQueue = q;
        passengerQueue = pq;
        //taxiStand = new LinkedList<Taxi>();
        taxiStand = new CopyOnWriteArrayList<Taxi>();
        for(int i=0; i<size ; i++){
            taxiStand.add(new Taxi(null));
        }
        System.out.println("Creating a TaxiStand with capacity " + size);
    }

    public LinkedList<Taxi> getTaxiQueue(){
    	return taxiQueue;
    }
    
    public CopyOnWriteArrayList<Taxi> getTaxiStand(){
    	return taxiStand;
    }
    
    public void setTaxiQueue(LinkedList<Taxi> temp) {
    	taxiQueue = temp;
    }
    
    public void setTaxiStand(CopyOnWriteArrayList<Taxi> temp) {
    	taxiStand = temp;
    }
    
    public boolean addTaxi(Taxi c){
        if(taxiStand.size() < 5) {
        	//adding directly to stand since space available
        	taxiStand.add(c);
        	return true;
        }
        //adding to queue since taxi stand is full
        taxiQueue.add(c);
        return false;
    }

    public boolean isFull(){
        return (taxiStand.size()<size) ? false : true;
    }
    
    public boolean isEmpty() {
        return (taxiStand.size()==0) ? true : false;
    }

    public boolean allocatePassenger(Passenger p) {
        Passenger pass = passengerQueue.poll(); //remove head and store
        Iterator<Taxi> it = taxiStand.iterator();
        boolean done = false;
        
        while(it.hasNext()) {
        	Taxi temp = it.next();
        	if(temp.isFull()) {
        		taxiStand.remove(temp);
        		System.out.println("Taxi leaves for destination: "+ temp.getDestination());
        		if(!taxiQueue.isEmpty()) {
        			//adding first taxi in taxiQueue to taxiStand if any taxi is present in taxiQueue
        			taxiStand.add(taxiQueue.removeFirst());
        		}
        	}
        	else if((pass!=null) && pass.getDestination()==temp.getDestination()) {
        		//destination match to existing taxi
        		passengerQueue.removeFirst();
        		temp.allocatePassenger(pass);
        		done = true;
        	}
        	
        	else if(temp.allocatePassenger(p)) {
        		done = true;
        	}
        	
        	if(done) break;
        }
        
        if(!done) {
        	System.out.println("Passenger added to queue");
        	passengerQueue.add(p);
        }
        return done;
    }

    public void processPassengerQueue(){
        System.out.println("Starting to process passengerQueue with " + passengerQueue.size() + " passengers");
        
		
        System.out.println("After processing passengerQueue " + passengerQueue.size() + " passengers remain in queue");
    }

    public void printStatus() {
        ListIterator<Taxi> standIterator = taxiStand.listIterator();
        int position=0;
        while(standIterator.hasNext()) {
            Taxi taxi = standIterator.next();
            position++;
            System.out.println(position + ". Taxi to " + taxi.getDestination() + " passengers=" + taxi.getpassengerCount());
        }
    }
    public static void main(String[] args) {
        System.out.println("Starting simulaion...");
        LinkedList<Taxi> taxiQueue = new LinkedList<Taxi>();
        LinkedList<Passenger> passengerQueue = new LinkedList<Passenger>();
        TaxiStand lot = new TaxiStand(5, taxiQueue, passengerQueue);

        TaxiQueueRunnable taxiCreator = new TaxiQueueRunnable(taxiQueue, lot);
        PassengerQueueRunnable passengerCreator = new PassengerQueueRunnable(passengerQueue, lot);

        Thread taxiThread = new Thread(taxiCreator);
        Thread passThread = new Thread(passengerCreator);
        taxiThread.start();
        passThread.start();
    }
}
