package com.vp.priprema.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vp.priprema.model.Rent;

public interface RentRepository
	extends JpaRepository<Rent, Long> {

}
