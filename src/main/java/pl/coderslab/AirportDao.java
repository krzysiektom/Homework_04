package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AirportDao {
    public static List<Airport> getList() {
        List<Airport> airports = new ArrayList<>();
        Path path1 = Paths.get("/home/krzysztof/workspace/Homework_04/src/airports.txt");
        try {
            for (String airport : Files.readAllLines(path1)) {
                String[] airportArray = airport.split(";");
                Airport airportTemp = new Airport(airportArray[0], airportArray[1], airportArray[2]);
                airports.add(airportTemp);
            }
        } catch (IOException e) {
            System.out.println("Błąd wczytania pliku");
        }
        return airports;
    }
}
