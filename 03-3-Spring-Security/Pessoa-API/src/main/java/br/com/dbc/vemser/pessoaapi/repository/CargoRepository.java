package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.CargoEntity;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<CargoEntity, Integer> {
}
