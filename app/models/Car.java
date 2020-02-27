package models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.ebean.Finder;

import javax.persistence.*;
import java.util.List;

// Car model java class
@Entity
public class Car extends Vehicle{
    private int noOfSeats;
    private boolean withAC;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Schedule> reservations;

    public static Finder<String, Car> find = new Finder<String, Car>(Car.class);

    public Car(String plateNumber, String make, String model, int noOfSeats, boolean withAC, Transmission transmission) {
        super(plateNumber, make, model);
        this.noOfSeats = noOfSeats;
        this.withAC = withAC;
        this.transmission = transmission;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public boolean isWithAC() {
        return withAC;
    }

    public void setWithAC(boolean withAC) {
        this.withAC = withAC;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public List<Schedule> getReservations() {
        return reservations;
    }

    public void setReservations(List<Schedule> reservations) {
        this.reservations = reservations;
    }
}
