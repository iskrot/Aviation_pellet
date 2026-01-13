package com.gridnine.testing.model;

import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class SegmentTest {
    LocalDateTime departureDate = LocalDateTime.now();

    LocalDateTime arrivalDate = LocalDateTime.now();

    Segment segment = new Segment(departureDate, arrivalDate);

    @Test
    void getDepartureDateTest() {
        Assertions.assertEquals(departureDate, segment.getDepartureDate());
    }

    @Test
    void getArrivalDate() {
        Assertions.assertEquals(arrivalDate,segment.getArrivalDate());
    }

    @Test
    void toStringTest() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        Assertions.assertEquals('[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
            + ']', segment.toString());
    }
}