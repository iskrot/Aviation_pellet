package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class FlightFilter {
    public static List<Flight> filterToActualTime(List<Flight> flights){

        List<Flight> result = flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .toList().equals(flight.getSegments().stream()
                                .filter( segment -> LocalDateTime.now()
                                    .compareTo(segment.getDepartureDate()) <= 0)
                                .toList()))
                .toList();
        return result;
    }

    public static List<Flight> filterToCorrectSegments(List<Flight> flights){
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .toList().equals(flight.getSegments().stream()
                                .filter( segment -> segment.getArrivalDate()
                                        .compareTo(segment.getDepartureDate()) > 0)
                                .toList()))
                .toList();
    }

    public static List<Flight> filterToLongStayOnEarth(List<Flight> flights){
        List<Flight> result = new ArrayList<>();

        for(Flight flight: flights){
            boolean correct = true;
            for(int i = 1; i <flight.getSegments().size(); i++){
                if (Duration.between(flight.getSegments().get(i-1).getArrivalDate()
                        , flight.getSegments().get(i).getDepartureDate()).toHours() >  2){
                    correct = false;
                }
            }
            if (correct){
                result.add(flight);
            }
        }

        return result;
    }

}
