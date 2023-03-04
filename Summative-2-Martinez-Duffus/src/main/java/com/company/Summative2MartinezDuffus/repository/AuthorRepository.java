package com.company.Summative2MartinezDuffus.repository;

import com.company.Summative2MartinezDuffus.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
