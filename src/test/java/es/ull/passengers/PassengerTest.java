package es.ull.passengers;

import es.ull.flights.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    Flight flight;
    Passenger passenger;

    @BeforeEach
    void setUp() {
        flight = new Flight("AA0000", 1);
        passenger = new Passenger("1", "Mario", "CN");
    }

    @Test
    @DisplayName("Getters of the passenger class should work.")
    void groupGettersAssertions() {
        flight.addPassenger(passenger);
        assertAll("Passenger characteristics",
                () -> assertEquals("1", passenger.getIdentifier()),
                () -> assertEquals("CN", passenger.getCountryCode()),
                () -> assertEquals("Mario", passenger.getName()),
                () -> assertEquals(flight, passenger.getFlight())
        );
    }

    @Test
    @DisplayName("Testing the joinFlight method")
    void exceptionJoinFlightTesting(){
        passenger.setFlight(flight);
        Throwable exception = assertThrows(RuntimeException.class, () -> passenger.joinFlight(flight));
        assertEquals("Cannot remove passenger" , exception.getMessage());
    }


}
