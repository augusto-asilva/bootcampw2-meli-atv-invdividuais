package com.br.meli.bootcamp.spring.obter.diploma.service;

import com.br.meli.bootcamp.spring.obter.diploma.dto.AlunoDTO;
import com.br.meli.bootcamp.spring.obter.diploma.dto.DiplomaResponseDTO;
import com.br.meli.bootcamp.spring.obter.diploma.repository.DiplomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;

@Service
public class DiplomaService {

    private DiplomaRepository REPOSITORY = new DiplomaRepository();

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static Validator validator = factory.getValidator();

    public List<DiplomaResponseDTO> getAll() {
        return REPOSITORY.findAll();
    }

    public DiplomaResponseDTO getById(Integer id) {
        return REPOSITORY.findById(id);
    }

    public boolean post(AlunoDTO alunoDTO) {
        if (analyzeNotes(alunoDTO)) {
            double mediaAluno = calculateAverage(alunoDTO);
            alunoDTO.setMedia(mediaAluno);
            DiplomaResponseDTO diplomaResponseDTO = new DiplomaResponseDTO(mediaAluno, alunoDTO);
            boolean withHonor = getDiplomaWithHonor(mediaAluno);
            diplomaResponseDTO.setWithHonor(withHonor);
            REPOSITORY.insert(diplomaResponseDTO);
            return true;
        }
        return false;
    }

    public boolean delete(Integer id) {
        return REPOSITORY.removeById(id);
    }

    public boolean put(Integer id, AlunoDTO alunoDTO) {
        if (analyzeNotes(alunoDTO)) {
            double mediaAluno = calculateAverage(alunoDTO);
            alunoDTO.setMedia(mediaAluno);
            DiplomaResponseDTO novoDiplomaResponseDTO = new DiplomaResponseDTO(mediaAluno, alunoDTO);
            boolean withHonor = getDiplomaWithHonor(mediaAluno);
            novoDiplomaResponseDTO.setWithHonor(withHonor);
            REPOSITORY.update(id, novoDiplomaResponseDTO);
            return true;
        }
        return false;
    }

    public boolean analyzeNotes(AlunoDTO alunoDTO) {
        Set<ConstraintViolation<AlunoDTO>> violations = validator.validate(alunoDTO);
        if (violations.isEmpty()) {
            return true;
        }
        return false;
    }

    public double calculateAverage(AlunoDTO alunoDTO) {
        OptionalDouble media = alunoDTO.getDisciplinas().stream()
                .mapToDouble(d -> Double.valueOf(d.getNota())).average();

        if (media.isPresent()) {
            return media.getAsDouble();
        }

        return -0.0;
    }

    public boolean getDiplomaWithHonor(double avg) {
        if (avg > 9) {
            return true;
        }
        return false;
    }
}
