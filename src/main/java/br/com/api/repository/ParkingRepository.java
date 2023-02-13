package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, String> {}
