package com.roam.roaming.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="travels", schema = "roam")
public class Travels {
    @Id
    @GeneratedValue
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

//    public Places(String name, String location, String date){
//        this.name = name;
//        this.location = location;
//        this.date = date;
//    }

    public Travels(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
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

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Travels)) return false;
        Travels travels = (Travels) o;
        return id == travels.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
