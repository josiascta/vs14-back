package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.Pet;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PetService {

    private final PetRepository petRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public PetDTO create(PetCreateDTO dto) throws Exception {

        Pet petEntity = objectMapper.convertValue(dto, Pet.class);
        petEntity = petRepository.save(petEntity);
        PetDTO petDTO = objectMapper.convertValue(petEntity, PetDTO.class);
        return petDTO;
    }

    public List<PetDTO> list() {
        return petRepository.findAll()
                .stream()
                .map(pet -> objectMapper.convertValue(pet, PetDTO.class)
                )
                .collect(Collectors.toList());
    }


    public PetDTO update(Integer id, PetCreateDTO petAtualizar) throws Exception {

        Pessoa pessoaEntity = objectMapper.convertValue(pessoaService.findById(id), Pessoa.class);
        Pet pet = getPet(id);

        pet.setNome(petAtualizar.getNome());
        pet.setTipoPet(petAtualizar.getTipoPet());
        pet.setPessoa(pessoaEntity);
        
        petRepository.save(pet);

        PetDTO petDTO = objectMapper.convertValue(pet, PetDTO.class);
        return petDTO;
    }

    public void delete(Integer id) throws Exception {
        Pet petRecuperado = getPet(id);
        petRepository.delete(petRecuperado);
    }


    public PetDTO findById(Integer id) throws Exception {
        return objectMapper.convertValue(getPet(id), PetDTO.class);
    }

    private Pet getPet(Integer id) throws RegraDeNegocioException {

        Pet petRecuperado = petRepository.findAll().stream()
                .filter(pet -> pet.getIdPet().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado!"));
        return petRecuperado;
    }
}
