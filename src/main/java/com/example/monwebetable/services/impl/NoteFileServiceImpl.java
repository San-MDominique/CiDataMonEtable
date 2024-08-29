package com.example.monwebetable.services.impl;


import com.example.monwebetable.models.NoteFile;
import com.example.monwebetable.repositories.NoteFileRepository;
import com.example.monwebetable.services.DTO.NoteFileDTO;
import com.example.monwebetable.services.Mapper.NoteFileMappper;
import com.example.monwebetable.services.NoteFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteFileServiceImpl implements NoteFileService {
    private final NoteFileRepository noteFileRepository;
    private final NoteFileMappper noteFileMappper;
    @Override
    public NoteFileDTO save(NoteFileDTO noteFileDTO) {
        log.debug("Request to save NoteFile: {}", noteFileDTO);
        NoteFile noteFile = noteFileMappper.toEntity(noteFileDTO);
        noteFile = noteFileRepository.save(noteFile);
        return noteFileMappper.toDto(noteFile);
    }


    @Override
    public Optional<NoteFileDTO> findOne(Long id) {
        return noteFileRepository.findById(id).map(noteFile-> {
            return noteFileMappper.toDto(noteFile);
        });
    }

    @Override
    public NoteFileDTO upade(NoteFileDTO NoteFileDTO) {
        return findOne(NoteFileDTO.getId()).map(existingNoteFile -> {
            existingNoteFile.setNote(NoteFileDTO.getNote());
            existingNoteFile.setAnnée(NoteFileDTO.getAnnée());
            return save(existingNoteFile);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public List<NoteFileDTO> findAll() {
            return noteFileRepository.findAll().stream().map(notefile-> {
                return noteFileMappper.toDto(notefile);
            }).toList();
        }



    @Override
    public void delete(Long id) {
        if (!noteFileRepository.existsById(id)) {
            throw new IllegalArgumentException("NoteFile not found with id " + id);
        }
        noteFileRepository.deleteById(id);
    }
}
