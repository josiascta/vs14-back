package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ProfessorDTO;
import br.com.dbc.vemser.pessoaapi.entity.Professor;
import br.com.dbc.vemser.pessoaapi.repository.ProfessorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ObjectMapper objectMapper;

    public List<ProfessorDTO> list() {
        return professorRepository.findAll()
                .stream()
                .map(this::getProfessorDTO)
                .collect(Collectors.toList());
    }

    private ProfessorDTO getProfessorDTO(Professor professor) {
        return objectMapper.convertValue(professor, ProfessorDTO.class);
    }
}
