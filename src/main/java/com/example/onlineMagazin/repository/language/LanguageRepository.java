package com.example.onlineMagazin.repository.language;

import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long>, AbstractRepository {
}
