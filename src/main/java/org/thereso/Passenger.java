package org.thereso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Passenger {

    private int id_number;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private List<Ticket> myTickets; //store all tickets booked by this number for one airline


    public  Passenger( int id_number, String firstName, String lastName, String address, String phone){
        this.id_number = id_number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.myTickets = new ArrayList<>();
    }
    /**
     * cancel the ticket booked
     * @param t
     */
    public  void cancelTicket( Ticket t, Airline a){
        if(holdsTicket(t)) {
            myTickets.remove(t);
            a.cancel(t);
            System.out.println("ticket cancelled successfully");
        }
        else System.out.println("You don't own such ticket");
    }


    /**
     * searches for all flight available for a given airline by calling method findFlights from the airline
     * @param a
     * @param date
     * @param time
     * @param origin
     */
    public  void searchFlights( Airline a, String date, double time, String origin){
        Collection<Flight> flights = a.findFlights(date,time, origin);
        int index = 1;
        System.out.printf("====Welcome to %s AirLine====", a);
        if( !flights.isEmpty()){
            System.out.println("====ALL FLIGHTS AVAILABLE===\n");
            System.out.printf("%15s %15s %15s %15s %15s %15s",
                    "AIRLINE", "FLIGHT", "ORIGIN", "DESTINATION", "DATE", "TIME OF DEPT");

            for( Flight flight : flights){
                System.out.println("-".repeat(100));
                System.out.printf("%3d %s",index,flight);
                System.out.println("-".repeat(100));
                index++;
            }

        }else{
            System.out.println("Unfortunately we have no flight available, sorry!");
        }


    }

    /**
     * it create a ticket and  book it by calling
     * @param f
     * @return
     */
    public void bookFlight( Airline a, Flight f){
        Ticket newTicket = a.book(this, f);
        if( newTicket != null) myTickets.add( newTicket);
    }

    /**
     * determines if the user hold a tickets provided;
     * @param t
     * @return
     */
    public boolean holdsTicket( Ticket t){
        return  myTickets.contains(t);
    }



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
    @Override
    public String toString(){
        return firstName + " " + lastName;
    }
}
