package com.example.onlineMagazin.repository.status;

import com.example.onlineMagazin.entity.status.Status;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long>, AbstractRepository {
}
