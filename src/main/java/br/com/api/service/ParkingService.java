package br.com.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.exception.ParkingNotFoundException;
import br.com.api.model.Parking;
import br.com.api.repository.ParkingRepository;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Parking> findAll() {
        return this.parkingRepository.findAll();
    }

@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public Parking findById(@NonNull String id) {
	return this.parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
}

@Transactional
public Parking create(Parking parking) {
	String id = getUUID();
	parking.setId(id);
	parking.setEntryDate(LocalDateTime.now());
	this.parkingRepository.save(parking);
	return parking;
}

    @Transactional
    public void delete(@NonNull String id) {
		Parking parking = this.parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
		if (parking != null) this.parkingRepository.deleteById(id);
    }

    @Transactional
    public Parking update(@NonNull String id, Parking parkingCreate) {
        Parking parking = this.parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
        parking.setColor(parkingCreate.getColor());
        parking.setState(parkingCreate.getState());
        parking.setModel(parkingCreate.getModel());
        parking.setLicense(parkingCreate.getLicense());
        this.parkingRepository.save(parking);
        return parking;
    }

    @Transactional
    public Parking checkOut(@NonNull String id) {
        Parking parking = this.parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
        parking.setExitDate(LocalDateTime.now());
        parking.setBill(ParkingCheckOut.getBill(parking));
        this.parkingRepository.save(parking);
        return parking;
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
