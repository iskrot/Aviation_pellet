package com.gridnine.testing.service;


import com.gridnine.testing.service.FlightFilter;
import org.junit.jupiter.api.Assertions;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class FlightFilterTest {
    @Test
    void filterToActualTimeTest(){
        LocalDateTime realTime = LocalDateTime.now();
        Flight correct =
                new Flight(List.of(new Segment(realTime.plusDays(1), realTime.plusDays(1)),
                        new Segment(realTime.plusDays(1), realTime.plusDays(1))));
        Flight dontCorrect =
                new Flight(List.of(new Segment(realTime.minusDays(1), realTime.plusDays(1)),
                        new Segment(realTime.plusDays(1), realTime.plusDays(1))));
        List correctList = List.of(correct);
        List dontCorrectList = List.of(correct, dontCorrect);

        List result = FlightFilter.filterToActualTime(dontCorrectList);

        Assertions.assertEquals(result, correctList);
    }

    @Test
    void filterToCorrectSegments(){
        LocalDateTime realTime = LocalDateTime.now();
        Flight correct =
                new Flight(List.of(new Segment(realTime.plusDays(1), realTime.plusDays(2)),
                        new Segment(realTime.plusDays(3), realTime.plusDays(4))));
        Flight dontCorrect =
                new Flight(List.of(new Segment(realTime.plusDays(2), realTime.plusDays(1)),
                        new Segment(realTime.plusDays(4), realTime.plusDays(3))));
        List correctList = List.of(correct);
        List dontCorrectList = List.of(correct, dontCorrect);

        List result = FlightFilter.filterToCorrectSegments(dontCorrectList);

        Assertions.assertEquals(result, correctList);
    }

    @Test
    void filterToLongStayOnEarth(){
        LocalDateTime realTime = LocalDateTime.now();
        Flight correct =
                new Flight(List.of(new Segment(realTime.plusDays(1), realTime.plusDays(1).plusHours(1)),
                        new Segment(realTime.plusDays(1).plusHours(2), realTime.plusDays(1).plusHours(4))));
        Flight dontCorrect =
                new Flight(List.of(new Segment(realTime.minusDays(1), realTime.plusDays(1).plusHours(3)),
                        new Segment(realTime.plusDays(2), realTime.plusDays(3))));
        List correctList = List.of(correct);
        List dontCorrectList = List.of(correct, dontCorrect);

        List result = FlightFilter.filterToLongStayOnEarth(dontCorrectList);

        Assertions.assertEquals(result, correctList);
    }

}
