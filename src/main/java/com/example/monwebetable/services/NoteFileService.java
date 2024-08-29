package com.example.monwebetable.services;

import com.example.monwebetable.models.NoteFile;
import com.example.monwebetable.services.DTO.NoteFileDTO;

import java.util.List;
import java.util.Optional;

public interface NoteFileService {
    NoteFileDTO save(NoteFileDTO noteFile);
    Optional<NoteFileDTO> findOne(Long id);
    NoteFileDTO upade(NoteFileDTO noteFile);

    List<NoteFileDTO> findAll();


    void delete(Long id);
}
