package org.thereso;

public class Ticket {

    private int ticketNumber;
    private Airline myAirLine;
    private Flight myFlight;
    private Passenger myPassenger;
    private double price;

    public static int ticketCount;

    public Ticket( Airline airline, Flight flight, Passenger passenger, double price){
        ticketCount ++;
        myAirLine = airline;
        myFlight = flight;
        myPassenger = passenger;
        this.price = price;
        ticketNumber = ticketCount;
    }
    /**
     * removes this ticket from list of tickets in myPassenger and myFlight
     */
    public  void cancel(){
        this.myFlight.removeTicket(this);
    }

    public int getTicketNumber() {return ticketNumber;}

    public Airline getAirLine(){ return  myAirLine;}
    public  Flight getFlight(){ return  myFlight;}
    public  Passenger getPassenger() { return myPassenger;}
    public  double getPrice(){ return  price;}

    @Override
    public  boolean equals(Object obj){
        if(obj == null || obj.getClass() != getClass()) return  false;
        if( this == null && obj != null) return false;
        Ticket ticket = (Ticket)obj;
        return ticketNumber == ticket.ticketNumber && myPassenger == ticket.myPassenger &&
        myFlight == ticket.myFlight;
    }
    
    @Override
    public int hashCode(){
        int hash = myPassenger.hashCode();
        hash = 31 * hash + ticketNumber;
        return hash;
    }
}
