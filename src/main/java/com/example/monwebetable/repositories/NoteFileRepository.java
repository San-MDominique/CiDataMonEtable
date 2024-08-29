package com.example.monwebetable.repositories;

import com.example.monwebetable.models.NoteFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteFileRepository extends JpaRepository<NoteFile,Long> {
}
