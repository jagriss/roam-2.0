package com.roam.roaming.models;
import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
