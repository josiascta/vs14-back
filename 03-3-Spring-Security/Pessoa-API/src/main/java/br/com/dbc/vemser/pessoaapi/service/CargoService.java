package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.CargoEntity;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.CargoRepository;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;
    private final UsuarioRepository usuarioRepository;

    public CargoEntity adicionarUsuarioAoCargo(Integer idCargo, Integer idUsuario) {
        CargoEntity cargo = cargoRepository.findById(idCargo)
                .orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado"));

        UsuarioEntity usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        cargo.getUsuarios().add(usuario);
        return cargoRepository.save(cargo);
    }

    public CargoEntity findById(Integer idCargo) throws RegraDeNegocioException {
        return cargoRepository.findById(idCargo).orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
    }

    public List<CargoEntity> findAllById(List<Integer> idCargo) {
        return cargoRepository.findAllById(idCargo);
    }
}
