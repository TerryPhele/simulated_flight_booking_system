package org.thereso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Airline {

    private String name;
    private Collection<Flight> flights;

    public Airline( String name){
        this.name = name;
        flights = new ArrayList<>();
    }
    /**
     *  cancels the specified ticket from list of all tickets in booking
     * @param t
     */
    public void cancel( Ticket t){
        t.cancel();
    }

    /**
     * prints out a message on the screen about which passenger has been refunded and how much
     * @param t
     */
    public void issueRefund(Ticket t){
        System.out.printf( "Amount of R%f refunded to %s", t.getPrice(), t.getPassenger());
    }


    /**
     * searches for all flights available on this airline by date and time
     * @param date
     * @param time
     * @param flightOrigin
     * @return list of flights available for the given date and time( if time doesn't match any, just return all flights on this date)
     */
    public Collection<Flight> findFlights( String date, double time, String flightOrigin){
        Collection<Flight> exactFlights = flights.stream()
                .filter( flight -> flight.matches( date,time, flightOrigin))
                .toList();

        return ( !exactFlights.isEmpty()) ? exactFlights : getFlights();

    }

    /**
     * it generate the ticket based on passenger selection and return it so it can be stored in bookings
     * @param p passenger
     * @param f flight
     * @return ticket
     */
    public Ticket book( Passenger p, Flight f) {
        if (f.hasSpace()) {
            double a = f.getCost();
            Ticket newTicket = new Ticket(this, f, p, a);
            try{
                f.addTicket(newTicket);
                return  newTicket;
            }catch ( RuntimeException e){
                return  null;
            }
        }
        return null;
    }

    /**
     * calculates the amount of the flights and return the cost ( based on how many seats left)
     * @param f
     * @return
     */
    public double cost(Flight f){
        double amount;
        int totalBooked = (Math.floorDiv( f.getFilledSeats().size(), f.getSeats().length)) * 100;
        amount = ( totalBooked <= 60)? (double) (f.getFlightLength()/2 ) :  ( 1.2 * f.getFlightLength()/2);
        return  amount;
    }

    /**
     *Creates a flight for this AirLine and store it in a dataBase ( it is forever created )
     *
     * @param departureTime
     * @param numberOfSeats
     * @param origin
     * @param destination
     */
    public void createFlight( double departureTime,int numberOfSeats, int flightLength,  String date, String origin, String destination){
       Flight newFlight = new Flight( flightLength, numberOfSeats,
               this, date, origin, destination,departureTime);

       this.flights.add( newFlight );
    }



    /**
     * removes the flight from the database
     * @param f
     */
    public void removeFlight( Flight f){
        this.flights.remove( f );
    }

    public  String getName(){
        return  name;
    }

    private Collection<Flight> getFlights() {
        return flights;
    }

    @Override
    public  boolean equals(Object obj){
        if(obj == null || obj.getClass() != getClass()) return  false;
        if( this == obj) return true;
        Airline airline = (Airline) obj;
        return airline.name.equalsIgnoreCase( name);
    }

    @Override
    public int hashCode(){
        int hash = name.hashCode();
        hash = 31 * hash + 10;
        return hash;
    }

    @Override
    public  String toString(){
        return name.toUpperCase();
    }


}
