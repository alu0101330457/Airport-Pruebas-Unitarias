package es.ull.flights;

import es.ull.passengers.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {

     Flight flight;
     Passenger passenger;
     Passenger passenger1;

    @BeforeEach
    void setUp() {
        flight = new Flight("AA0000", 1);
        passenger = new Passenger("1", "Mario", "CN");
        passenger1 =  new Passenger("2", "David", "CN");
    }

    @Test
    @DisplayName("Getters of the flight class should work.")
    void groupGettersAssertions() {
        assertAll("Flight characteristics",
                () -> assertEquals("AA0000", flight.getFlightNumber()),
                () -> assertEquals(0, flight.getNumberOfPassengers())
        );
    }


    @Test
    @DisplayName("The flight should allow add a passenger into the aircraft.")
    void addPassengerTesting() {
        assertEquals(true, flight.addPassenger(passenger));
    }

    @Test
    @DisplayName("The flight's constructor must throw an exception because of invalid flight number.")
    void exceptionFlightNumberTesting() {
        Throwable exception = assertThrows(RuntimeException.class, () -> new Flight("A1", 1));
        assertEquals("Invalid flight number", exception.getMessage());
    }

    @Test
    @DisplayName("The flight must throw an exception if there is no seat for the passenger.")
    void exceptionPassengerTesting() {
        flight.addPassenger(passenger);
        Throwable exception = assertThrows(RuntimeException.class, () -> flight.addPassenger(passenger1));
        assertEquals("Not enough seats for flight AA0000" , exception.getMessage());
    }

    @Test
    @DisplayName("The flight should allow us to remove a passenger.")
    void successfulRemoveTesting(){
        flight.addPassenger(passenger);
        assertEquals(true,flight.removePassenger(passenger));
    }

    @Test
    @DisplayName("The flight shouldn't allow us to remove an non existent passenger.")
    void failRemoveTesting(){
        flight.addPassenger(passenger);
        assertEquals(false,flight.removePassenger(passenger1));
    }


}
