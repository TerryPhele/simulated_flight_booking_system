package org.thereso;

import java.util.List;

public class Passenger {

    private int id_number;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private List<Ticket> myTickets; //store all tickets booked by this number for one airline


    /**
     * cancel the ticket booked
     * @param t
     */
    public  void cancelTicket( Ticket t){}


    /**
     * searches for all flight available for a given airline by calling method findFlights from the airline
     * @param a
     * @param date
     * @param time
     * @param origin
     */
    public  void searchFlights( Airline a, String date, double time, String origin){ }

    /**
     * it create a ticket and  book id by calling
     * @param f
     * @return
     */
    public Ticket bookFlight( Flight f){ return  null;}

    /**
     * determines if the user hold a tickets provided;
     * @param t
     * @return
     */
    public boolean holdsTicket( Ticket t){ return  false;}



    @Override
    public  boolean equals(Object obj){
        if(obj == null || obj.getClass() != getClass()) return  false;
        if( this == obj) return true;
        Passenger passenger = (Passenger)obj;
        return id_number == passenger.id_number && firstName.equalsIgnoreCase(passenger.firstName);
    }
    
    @Override
    public int hashCode(){
        int hash = firstName.hashCode();
        hash = 31 * hash + lastName.hashCode() + id_number;
        return hash;
    }
}
