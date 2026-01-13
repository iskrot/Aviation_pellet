package com.gridnine.testing;



import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightBuilder;
import com.gridnine.testing.service.FlightFilter;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> result = FlightBuilder.createFlights();

        System.out.println("не отфильтрованная версия");
        System.out.println(result);
        System.out.println();

        result = FlightFilter.filterToActualTime(result);

        System.out.println("результат после первого этапа фильтрации");
        System.out.println(result);
        System.out.println();

        result = FlightFilter.filterToCorrectSegments(result);

        System.out.println("результат после второго этапа фильтрации");
        System.out.println(result);
        System.out.println();

        result = FlightFilter.filterToLongStayOnEarth(result);

        System.out.println("результат после финального этапа фильтрации");
        System.out.println(result);


    }
}