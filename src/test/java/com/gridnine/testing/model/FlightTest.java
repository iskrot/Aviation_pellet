package com.gridnine.testing.model;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.UniqueId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


public class FlightTest {
    List<Segment> segments =  List.of(new Segment(LocalDateTime.now(),LocalDateTime.now()),new Segment(LocalDateTime.now(),LocalDateTime.now()));
    Flight flight = new Flight(segments);

    @Test
    void getSegments() {
        Assertions.assertEquals(segments, flight.getSegments());
    }

    @Test
    void toStringTest() {
        Assertions.assertEquals(segments.stream().map(Object::toString)
                .collect(Collectors.joining(" ")), flight.toString());
    }
}