package org.thereso.database;


import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Update;
public interface DataTables extends BaseQuery {

    @Update("CREATE TABLE IF NOT EXISTS airline" +
            "(" +
                "name TEXT NOT NULL PRIMARY KEY" +
            ")"
    )
    void createAirlineTable();

    @Update("CREATE TABLE IF NOT EXISTS flight" +
            "(" +
                "flight_number INTEGER NOT NULL PRIMARY KEY, " +
                "airline_name TEXT NOT NULL," +
                "flight_length INTEGER NOT NULL," +
                "date TEXT NOT NULL," +   //should be date object
                "origin TEXT NOT NULL," +
                "destination TEXT NOT NULL," +
                "departure_time TEXT NOT NULL," +// should be time object
                "FOREIGN KEY (airline_name) REFERENCES airline(name)ON DELETE CASCADE" +
            ")"
    )
    void createFlightTable();


    @Update("CREATE TABLE IF NOT EXISTS ticket" +
            "(" +
                "ticket_number INTEGER NOT NULL PRIMARY KEY, " +
                "passenger_id INTEGER NOT NULL, " +
                "flight_number INTEGER NOT NULL, " +
                "seat_number, " +
                "price INTEGER NOT NULL, " +
                "FOREIGN KEY (passenger_id) REFERENCES passenger(passenger_id)ON DELETE CASCADE, " +
                "FOREIGN KEY (flight_number) REFERENCES flight(flight_number)ON DELETE CASCADE , " +
                "FOREIGN KEY (seat_number) REFERENCES seat(seat_number)ON DELETE CASCADE" +
            ")"
    )
    void  createTickectTable();

    @Update("CREATE TABLE IF NOT EXISTS passenger" +
            "(" +
                "passenger_id INTEGER NOT NULL PRIMARY KEY, " +
                "name TEXT NOT NULL, " +
                "lastname TEXT NOT NULL, " +
                "address TEXT," +
                "contact, " +
            ")"
    )
    void createPassengerTable();


    @Update("CREATE TABLE IF NOT EXISTS seat" +
            "(" +
            "seat_number INTEGER NOT NULL PRIMARY KEY, " +
            "flight_number INTEGER NOT NULL, " +
            "is_booked INTEGER NOT NULL" +
            "FOREIGN KEY (flight_number) REFERENCES flight(flight_number)ON DELETE CASCADE " +
            ")"

    )
    void createSeatTable();

}
