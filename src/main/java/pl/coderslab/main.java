package pl.coderslab;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Airport> airports=AirportDao.getList();
        System.out.println(Arrays.deepToString(airports.toArray()));
    }
}
