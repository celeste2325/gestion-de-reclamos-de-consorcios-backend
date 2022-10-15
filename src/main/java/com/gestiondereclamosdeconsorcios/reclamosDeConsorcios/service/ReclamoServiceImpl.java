package com.gestiondereclamosdeconsorcios.reclamosDeConsorcios.service;

import com.gestiondereclamosdeconsorcios.reclamosDeConsorcios.entity.Reclamo;
import com.gestiondereclamosdeconsorcios.reclamosDeConsorcios.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReclamoServiceImpl implements ReclamoService {

    @Autowired
    ReclamoRepository reclamoRepository;

    @Override
    @Transactional
    public void createReclamo(Reclamo newReclamo) {
        newReclamo.getImagenesByIdReclamo().forEach(
                imagen -> {
                    imagen.setDataFoto(imagen.getCastBlob().getBytes());
                }
        );
        this.reclamoRepository.save(newReclamo);
    }

    @Override
    public List<Reclamo> getAll() {
        return this.reclamoRepository.findAll();
    }

    @Override
    public Reclamo updateEstado(Reclamo newReclamo, Integer id) {
        return this.reclamoRepository.findById(id).map(reclamo -> {
            reclamo.setEstado(newReclamo.getEstado());
            return this.reclamoRepository.save(reclamo);
        }).get();
    }

    @Override
    public List<Reclamo> getAllByEstado(String estado) {
        return this.reclamoRepository.getByEstado(estado);
    }

    @Override
    public Optional<Reclamo> getById(Integer id) {
        return this.reclamoRepository.findById(id);
    }
}
