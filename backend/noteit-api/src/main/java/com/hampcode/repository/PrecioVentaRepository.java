package com.hampcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.model.PrecioVenta;

@Repository
public interface PrecioVentaRepository extends JpaRepository<PrecioVenta,Long>{

}
