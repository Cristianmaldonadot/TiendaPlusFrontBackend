package com.tiendaplus.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendaplus.model.DireccionEntity;

@Repository
public interface IDireccionEntity extends JpaRepository<DireccionEntity, Long> {

}
