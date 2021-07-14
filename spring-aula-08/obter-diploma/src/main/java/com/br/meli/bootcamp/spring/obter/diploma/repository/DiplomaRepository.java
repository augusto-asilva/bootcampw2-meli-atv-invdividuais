package com.br.meli.bootcamp.spring.obter.diploma.repository;

import com.br.meli.bootcamp.spring.obter.diploma.dto.DiplomaResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DiplomaRepository {

    private static final Map<Integer, DiplomaResponseDTO> MAP = new HashMap();
    private static Integer idCounter = 0;

    public List<DiplomaResponseDTO> findAll() {
        return new ArrayList<>(MAP.values());
    }

    public DiplomaResponseDTO findById(Integer id) {
        return MAP.get(id);
    }

    public void insert(DiplomaResponseDTO diplomaResponseDTO) {
        MAP.put(this.idCounter, diplomaResponseDTO);
        this.idCounter++;
    }

    public boolean removeById(Integer id) {
        DiplomaResponseDTO removed = MAP.remove(id);
        if (removed != null) {
            return true;
        }
        return false;
    }

    public void update(Integer id, DiplomaResponseDTO novoDiplomaResponseDTO) {
        DiplomaResponseDTO diplomaResponseDTO = MAP.get(id);
        diplomaResponseDTO.setAlunoDto(novoDiplomaResponseDTO.getAlunoDto());
        diplomaResponseDTO.setAverage(novoDiplomaResponseDTO.getAverage());
        diplomaResponseDTO.setMessage(novoDiplomaResponseDTO.getMessage());
        diplomaResponseDTO.setWithHonor(novoDiplomaResponseDTO.isWithHonor());
    }
}
