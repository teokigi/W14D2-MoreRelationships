package com.example.codeclan.MoreRelationships.repository;

import com.example.codeclan.MoreRelationships.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
