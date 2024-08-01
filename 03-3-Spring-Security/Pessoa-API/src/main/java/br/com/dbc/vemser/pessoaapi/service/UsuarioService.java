package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.UsuarioCreateDTO;
import br.com.dbc.vemser.pessoaapi.entity.CargoEntity;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final CargoService cargoService;
    private final ObjectMapper objectMapper;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public boolean cadastrarUsuário(UsuarioCreateDTO usuarioCreateDTO) throws RegraDeNegocioException {

        UsuarioEntity usuarioEntity = objectMapper.convertValue(usuarioCreateDTO, UsuarioEntity.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        usuarioEntity.setSenha(bCryptPasswordEncoder.encode(usuarioEntity.getPassword()));
        Set<CargoEntity> cargoEntitySet = new HashSet<>();

        for(Integer i : usuarioCreateDTO.getCargos()){
            cargoEntitySet.add(cargoService.findById(i));
        }
        usuarioEntity.setCargos(cargoEntitySet);
        usuarioRepository.save(usuarioEntity);
        return true;
    }

    public Integer getIdLoggedUser() {
        Integer findUserId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findUserId;
    }

    public Optional<UsuarioEntity> getLoggedUser() throws RegraDeNegocioException {
        return findById(getIdLoggedUser());
    }


}
