package com.roam.roaming.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="wishlist", schema = "roam")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="name")
    public String name;

    @Column(name="location")
    public String location;

    @Column(name="date")
    public String date;

    @Column(name="note")
    public String note;
    public String image;

    public WishList(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WishList)) return false;
        WishList wishList = (WishList) o;
        return id == wishList.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
