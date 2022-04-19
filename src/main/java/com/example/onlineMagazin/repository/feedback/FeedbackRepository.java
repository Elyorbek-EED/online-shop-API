package com.example.onlineMagazin.repository.feedback;

import com.example.onlineMagazin.entity.feedback.Feedback;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>, AbstractRepository {
}
