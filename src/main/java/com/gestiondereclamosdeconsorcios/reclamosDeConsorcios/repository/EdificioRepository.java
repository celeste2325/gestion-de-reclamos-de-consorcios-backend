package com.gestiondereclamosdeconsorcios.reclamosDeConsorcios.repository;

import com.gestiondereclamosdeconsorcios.reclamosDeConsorcios.entity.Edificio;
import com.gestiondereclamosdeconsorcios.reclamosDeConsorcios.entity.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
    List<Edificio> findByNombre(String nombre);

    @Query(value = "Select i from Inquilino i inner join Unidad u on u.identificador = i.identificador where u.codigoEdificio =?1")
    List<Inquilino> getHabitantes(Integer codigo);

    @Query(value = "select uni.*, u.codigoEdificio from (select * from inquilinos union all  SELECT * from duenios) as uni inner join unidades u on uni.identificador = u.identificador inner join edificios e on e.codigo = u.codigoEdificio\n" +
            "where codigo=?1", nativeQuery = true)
    List<Object[]> getHabilitados(Integer codigo);
}
