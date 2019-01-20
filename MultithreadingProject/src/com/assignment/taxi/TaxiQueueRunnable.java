package com.assignment.taxi;

import java.util.LinkedList;

public class TaxiQueueRunnable implements Runnable {

    private LinkedList<Taxi> taxiQueue;
    private TaxiStand taxiStand;

    public TaxiQueueRunnable(LinkedList<Taxi> q, TaxiStand l){
        taxiQueue = q;
        taxiStand = l;
    }

    @Override
    public void run() {
        System.out.println("Starting taxiQueue Thread...");
        while(true) {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ie) {
            	System.out.println("Interruppted Exception Occurred");
            }
            
            Taxi temp = new Taxi(null);
            if(taxiStand.addTaxi(temp))
            	System.out.println("Taxi added to Stand");
            else System.out.println("Taxi added to Queue");
        }
    }
}
