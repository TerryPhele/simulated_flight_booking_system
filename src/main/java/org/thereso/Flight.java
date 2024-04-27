package org.thereso;

import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Flight {

    private int flightNumber;
    private Seat[] seats; //will be numbers at first, but i prefer using object [ int id, char seatNumber ]
    private Collection<Seat> filledSeats;
    private  int numberOfSeats;
    private int flightLength;
    private Airline airline;
    private String date;
    private  String origin;
    private String destination;
    private double departureTime;
    private List<Ticket> ticketsBooked;
    public static  int flightCount = 0; //helps in giving unique number to the flight


    public Flight( int flightLength,int numberOfSeats, Airline airline, String date, String origin,
                   String destination, double departureTime){

        flightCount++;
        this.flightNumber = flightCount;
        this.flightLength = flightLength;
        this.airline = airline;
        this.date = date;
        this.origin = origin;
        this.departureTime = departureTime;
        this.destination = destination;
        this.numberOfSeats = numberOfSeats;
        this.seats = Seat.generateSeats(this);
        this.filledSeats = new ArrayList<>();
        this.ticketsBooked = new ArrayList<>();

    }
    /**
     * checks if this flight  date, time and origin matches the given date
     * @param date
     * @param time
     * @param origin
     * @return
     */
    public boolean matches( String date, double time, String origin){
        return  this.date.equalsIgnoreCase( date) && this.origin.equalsIgnoreCase(origin) &&
                this.departureTime == time;
    }


    /**
     * checks if there is any available seat
     * @return
     */
    public  boolean hasSpace(){
      return  Arrays.stream( seats).anyMatch( seat -> !filledSeats.contains(seat));
    }

    /**
     * add tickets to the list of tickets....store it in a database also for persistence
     * @param t
     */
    public  void addTicket(Ticket t){
        if( !holdsTicket(t)) {
            this.ticketsBooked.add(t);
            System.out.println("successfully booked");
        }
        else {
            throw  new RuntimeException("ticket booking unsuccessful");
        }
    }

    /**
     * verify if the ticket is there already...to confirm  if booking succeeded/ or when passenger request to cancel
     * @param t
     * @return
     */
    public boolean holdsTicket( Ticket t){
        return  ticketsBooked.contains(t);
    }

    /**
     * delete the canceled ticket
     * @param t
     */
    public  void removeTicket( Ticket t){
        if( holdsTicket(t))
            this.ticketsBooked.remove( t );
        else
            System.out.println("ticket not exists.");
    }

    /**
     * generate cost based on this.Airline method that calculates the cost for the ticket
     * @return
     */
    public  double getCost(){
        return  airline.cost(this);
    }

    public  int getFlightNumber(){
        return  this.flightNumber;
    }
    public Collection<Seat> getFilledSeats(){
        return  this.filledSeats;
    }

    public  Seat[] getSeats(){
        return  this.seats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public  int getFlightLength(){
        return  this.flightLength;
    }

    public Airline getAirline() {
        return airline;
    }

    public String getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public double getDepartureTime() {
        return departureTime;
    }

    public List<Ticket> getTicketsBooked() {
        return ticketsBooked;
    }

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

    @Override
    public  String toString(){
        return String.format("%15s %15d %15s %15s %15s %15f", airline.toString().toLowerCase(), flightNumber, origin,
                destination, date, departureTime);
    }
}
