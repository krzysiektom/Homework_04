package pl.coderslab;

import java.time.ZonedDateTime;

public class Flight {
    private String departure;
    private String arrival;
    ZonedDateTime arrivalTime;
    double price;

    public Flight(String departure, String arrival, ZonedDateTime arrivalTime, double price) {
        this.departure = departure;
        this.arrival = arrival;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public ZonedDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(ZonedDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", price=" + price +
                '}';
    }
}
