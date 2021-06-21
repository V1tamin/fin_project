package model;

import java.util.Objects;

/**
 * @author Anton Lopatin on 20.06.2021
 */
public class Apartment {
    private int id;
    private int apartmentStatusId;
    private String price;
    private int places;
    private int requestId;
    private int bookingId;
    private String description;
    private String photoUrl;

    public Apartment() {}

    public Apartment(int id, int apartmentStatusId, String price, int places, int requestId, int bookingId, String description, String photoUrl) {
        this.id = id;
        this.apartmentStatusId = apartmentStatusId;
        this.price = price;
        this.places = places;
        this.requestId = requestId;
        this.bookingId = bookingId;
        this.description = description;
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApartmentStatusId() {
        return apartmentStatusId;
    }

    public void setApartmentStatusId(int apartmentStatusId) {
        this.apartmentStatusId = apartmentStatusId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartment)) return false;
        Apartment ac = (Apartment) o;
        return Objects.equals(id, ac.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", apartmentStatusId=" + apartmentStatusId +
                ", price='" + price + '\'' +
                ", places=" + places +
                ", requestId=" + requestId +
                ", bookingId=" + bookingId +
                ", description='" + description + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
