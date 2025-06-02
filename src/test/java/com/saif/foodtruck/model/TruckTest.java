package com.saif.foodtruck.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TruckTest {

    private Truck truck;

    @BeforeEach
    void setUp() {
        truck = new Truck();
    }

    @Test
    void testGetProcessedCoords_Location2Present_ValidCoordinates_Double() {
        Location location2 = new Location();
        location2.setCoordinates(new ArrayList<>(Arrays.asList(-122.40, 37.78)));
        truck.setLocation2(location2);

        assertEquals("37.78", truck.getProcessedLatitude());
        assertEquals("-122.4", truck.getProcessedLongitude()); // Double auto-converts to string
    }

    @Test
    void testGetProcessedCoords_Location2Present_ValidCoordinates_String() {
        Location location2 = new Location();
        location2.setCoordinates(new ArrayList<>(Arrays.asList("-122.405", "37.785")));
        truck.setLocation2(location2);

        assertEquals("37.785", truck.getProcessedLatitude());
        assertEquals("-122.405", truck.getProcessedLongitude());
    }

    @Test
    void testGetProcessedCoords_Location2Present_CoordinatesNull() {
        Location location2 = new Location();
        location2.setCoordinates(null); // Coordinates list is null
        truck.setLocation2(location2);
        truck.setLatitude("37.70");
        truck.setLongitude("-122.30");

        assertEquals("37.70", truck.getProcessedLatitude());
        assertEquals("-122.30", truck.getProcessedLongitude());
    }

    @Test
    void testGetProcessedCoords_Location2Present_CoordinatesEmpty() {
        Location location2 = new Location();
        location2.setCoordinates(new ArrayList<>()); // Empty coordinates list
        truck.setLocation2(location2);
        truck.setLatitude("37.701");
        truck.setLongitude("-122.301");

        assertEquals("37.701", truck.getProcessedLatitude());
        assertEquals("-122.301", truck.getProcessedLongitude());
    }

    @Test
    void testGetProcessedCoords_Location2Present_CoordinatesSizeOne() {
        Location location2 = new Location();
        location2.setCoordinates(new ArrayList<>(Arrays.asList(-122.40))); // Only one element
        truck.setLocation2(location2);
        truck.setLatitude("37.702");
        truck.setLongitude("-122.302");

        // Latitude should fallback as index 1 is out of bounds
        assertEquals("37.702", truck.getProcessedLatitude());
        // Longitude should also fallback, because the condition is size > 1 for latitude,
        // and !isEmpty for longitude. If size is 1, it means latitude cannot be fetched.
        // The current implementation in Truck.java:
        // For latitude: location2.getCoordinates().size() > 1
        // For longitude: !location2.getCoordinates().isEmpty()
        // So, if size is 1, longitude will be taken from location2, latitude will fallback.
        assertEquals("-122.4", truck.getProcessedLongitude());
        // Correction from thought process: The original prompt stated:
        // "If location2 is null or coordinates is null or doesn't have enough elements, it should fall back"
        // For getProcessedLatitude, "enough elements" means 2.
        // For getProcessedLongitude, "enough elements" means 1.
        // So, if there's one element, getProcessedLongitude should use it.
        // The implementation for getProcessedLongitude is: `!location2.getCoordinates().isEmpty()` and then `get(0)`
        // The implementation for getProcessedLatitude is: `location2.getCoordinates().size() > 1` and then `get(1)`
        // This means if size is 1:
        // Longitude will be `String.valueOf(location2.getCoordinates().get(0))`
        // Latitude will be `getLatitude()` (fallback)
        // This test case confirms this understanding.
    }
    
    @Test
    void testGetProcessedCoords_Location2Present_CoordinatesSizeOne_VerifyLatitudeFallback() {
        Location location2 = new Location();
        location2.setCoordinates(new ArrayList<>(Arrays.asList(-122.40))); 
        truck.setLocation2(location2);
        truck.setLatitude("37.702"); // Fallback latitude
        truck.setLongitude("-122.302"); // Fallback longitude (should not be used for longitude)

        assertEquals("37.702", truck.getProcessedLatitude(), "Latitude should fallback if coordinates size is 1");
        assertEquals("-122.4", truck.getProcessedLongitude(), "Longitude should be taken from coordinates(0) if size is 1");
    }


    @Test
    void testGetProcessedCoords_Location2Null() {
        truck.setLocation2(null);
        truck.setLatitude("37.71");
        truck.setLongitude("-122.31");

        assertEquals("37.71", truck.getProcessedLatitude());
        assertEquals("-122.31", truck.getProcessedLongitude());
    }

    @Test
    void testGetProcessedCoords_Location2Present_MalformedStringCoordinates() {
        Location location2 = new Location();
        location2.setCoordinates(new ArrayList<>(Arrays.asList("-122.invalid", "37.invalid")));
        truck.setLocation2(location2);
        truck.setLatitude("37.72");  // Fallback latitude
        truck.setLongitude("-122.32"); // Fallback longitude

        // The getters return the string as is, or convert number to string. They don't validate format.
        assertEquals("37.invalid", truck.getProcessedLatitude());
        assertEquals("-122.invalid", truck.getProcessedLongitude());
    }
    
    @Test
    void testGetProcessedCoords_Location2Present_NumberAndMalformedStringCoordinates() {
        Location location2 = new Location();
        // Longitude is a valid number, Latitude is a malformed string
        location2.setCoordinates(new ArrayList<>(Arrays.asList(123.45, "37.invalid")));
        truck.setLocation2(location2);
        truck.setLatitude("37.72");
        truck.setLongitude("-122.32");

        assertEquals("37.invalid", truck.getProcessedLatitude());
        assertEquals("123.45", truck.getProcessedLongitude());
    }


    @Test
    void testGetProcessedCoords_FallbackFieldsNull_And_Location2Null() {
        truck.setLocation2(null);
        truck.setLatitude(null);
        truck.setLongitude(null);

        assertNull(truck.getProcessedLatitude());
        assertNull(truck.getProcessedLongitude());
    }

    @Test
    void testGetProcessedCoords_FallbackFieldsNull_And_Location2EmptyCoords() {
        Location location2 = new Location();
        location2.setCoordinates(new ArrayList<>());
        truck.setLocation2(location2);
        truck.setLatitude(null);
        truck.setLongitude(null);

        assertNull(truck.getProcessedLatitude());
        assertNull(truck.getProcessedLongitude());
    }
    
    @Test
    void testGetProcessedCoords_FallbackFieldsNull_And_Location2InsufficientCoords() {
        Location location2 = new Location();
        location2.setCoordinates(new ArrayList<>(Arrays.asList(-122.99))); // Only one element
        truck.setLocation2(location2);
        truck.setLatitude(null); // Fallback is null
        truck.setLongitude(null); // Fallback is null, but this should not be used for longitude here

        assertNull(truck.getProcessedLatitude(), "Latitude should be null as fallback is null and coords are insufficient");
        assertEquals("-122.99", truck.getProcessedLongitude(), "Longitude should be taken from coords(0)");
    }
}
