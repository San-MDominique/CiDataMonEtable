package com.example.monwebetable.services.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class NoteFileDTO {
    private Long id;
    private String note;
    private String année;
}
