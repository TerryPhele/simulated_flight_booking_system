package org.thereso;

import java.util.List;

public class Airline {

    private String name;
    private List<Flight> flights;


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
        System.out.printf( "Amount of R%d refunded to %s", );
    }


    /**
     * searches for all flights available on this airline by date and time
     * @param date
     * @param time
     * @param flightOrigin
     * @return list of flights available for the given date and time( if time doesn't match any, just return all flights on this date)
     */
    public List<Flight> findFlights( String date, double time, String flightOrigin){ return  null;}

    /**
     * it generate the ticket based on passenger selection and return it so it can be stored in bookings
     * @param p passenger
     * @param f flight
     * @return ticket
     */
    public Ticket book( Passenger p, Flight f){ return null;}

    /**
     * calculates the amount of the flights and return the cost ( based on how many seats left)
     * @param f
     * @return
     */
    public double cost(Flight f){ return  0.0d;}

    /**
     *Creates a flight for this AirLine and store it in a dataBase ( it is forever created )
     *
     * @param time
     * @param numberOfSeats
     * @param origin
     * @param destination
     */
    public void createFlight( double time, int numberOfSeats, String origin, String destination){

    }



    /**
     * removes the flight from the database
     * @param flightNumber
     */
    public void removeFlight( int flightNumber){

    }

    public  String getName(){ return  name;}

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


}
