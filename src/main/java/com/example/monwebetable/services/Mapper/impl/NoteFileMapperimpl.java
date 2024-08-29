package com.example.monwebetable.services.Mapper.impl;

import com.example.monwebetable.models.NoteFile;
import com.example.monwebetable.services.DTO.NoteFileDTO;
import com.example.monwebetable.services.Mapper.NoteFileMappper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoteFileMapperimpl implements NoteFileMappper {
        private final ModelMapper modelMapper;
    @Override
    public NoteFileDTO toDto(NoteFile entity) {
        return modelMapper.map(entity, NoteFileDTO.class);
    }

    @Override
    public NoteFile toEntity(NoteFileDTO dto) {
        return modelMapper.map(dto, NoteFile.class);
    }
}
