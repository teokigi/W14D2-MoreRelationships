package com.example.codeclan.MoreRelationships.repository;

import com.example.codeclan.MoreRelationships.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
