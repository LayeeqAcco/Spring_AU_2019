Three threads are run -> one for passengers, one for taxis, one for taxi stand(MAIN thread).
New passenger is generated with a random destination every 3 seconds.
New taxi arrives every 60 seconds.
(change these values in respective "Runnable" files in Thread.sleep(int) method)
Taxi Stand has capacity of 5 taxis.
If a new passenger cannot be assigned a taxi from the taxi stand, he/she is added to passengerQueue.

TaxiStand class has main method to run the simulation.