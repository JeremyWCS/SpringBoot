package com.wildcodeschool.quetespring.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.quetespring.springBoot.entities.School;

@Repository
public interface SchoolDao extends JpaRepository<School, Long> {
}