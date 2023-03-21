package com.roam.roaming.data;

import com.roam.roaming.models.Travels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelsRepository extends JpaRepository<Travels, Integer> {
}
