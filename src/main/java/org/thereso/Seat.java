package org.thereso;

public class Seat {

    private int seat_number;
    private int flightNumber;
    private boolean is_booked;
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
        hash = 31 * hash + flightNumber;
        return hash;
    }
}
