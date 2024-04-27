package org.thereso;


public class Seat {

    private int seat_number;
    private Flight myFlight;
    private boolean is_booked;
    private static int countSeat = 0;

    public Seat( Flight flight){
        countSeat ++;
        seat_number = countSeat;
        this.myFlight = flight;
        is_booked = false;
    }

    public static Seat[] generateSeats( Flight flight){
        Seat[] seats = new Seat[ flight.getNumberOfSeats() ];
        for( int x = 0 ; x < seats.length; x++){
            seats[x] = new Seat(flight);
        }
        countSeat = 0;
        return  seats;
    }


    @Override
    public  boolean equals(Object obj){
        if(obj == null || obj.getClass() != getClass()) return  false;
        if( this == obj) return true;
        Seat seat = (Seat)obj;
        return seat_number == seat.seat_number;
    }

    @Override
    public int hashCode(){
        int hash = seat_number;
        hash = 31 * hash + myFlight.hashCode();
        return hash;
    }
    @Override
    public String toString(){
        return "Seat_"+ String.valueOf(seat_number).toUpperCase();
    }
}
