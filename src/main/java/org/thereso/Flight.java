package org.thereso;

import jdk.dynalink.beans.StaticClass;

import java.util.List;

public class Flight {

    private int flightNumber;
    private int[] seats; //will be numbers at first, but i prefer using object [ int id, char seatNumber ]
    private int[] filledSeats;
    private int flightLength;
    private Airline airline;
    private String date;
    private  String origin;
    private String destination;
    private double departureTime;
    private List<Ticket> ticketsBooked;
    public static  int flightCount = 0; //helps in giving unique number to the flight


    /**
     * checks if this flight  date, time and origin matches the given date
     * @param date
     * @param time
     * @param origin
     * @return
     */
    public boolean matches( String date, double time, String origin){ return  false;}


    /**
     * checks if there is any available seat
     * @return
     */
    public  boolean hasSpace(){ return  false;}

    /**
     * add tickets to the list of tickets....store it in a database also for persistence
     * @param t
     */
    public  void addTicket(Ticket t){}

    /**
     * verify if the ticket is there already...to confirm the if booking succeeded/ or when passenger request to cancel
     * @param t
     * @return
     */
    public boolean holdsTicket( Ticket t){ return  false;}

    /**
     * delete the canceled ticket
     * @param t
     */
    public  void removeTicket( Ticket t){
        this.ticketsBooked.remove( t );
    }

    /**
     * generate cost based on this.Airline method that calculates the cost for the ticket
     * @return
     */
    public  double getCost(){ return  0.0d;}
    @Override
    public  boolean equals(Object obj){
        if(obj == null || obj.getClass() != getClass()) return  false;
        if( this == obj) return true;
        Flight flight = (Flight)obj;
        return flightNumber == flight.flightNumber && airline.equals(flight.airline);
    }

    @Override
    public int hashCode(){
        int hash = airline.hashCode();
        hash = 31 * hash + flightNumber;
        return hash;
    }
}
