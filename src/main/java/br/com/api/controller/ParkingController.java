package br.com.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.controller.dto.ParkingCreateDTO;
import br.com.api.controller.dto.ParkingDTO;
import br.com.api.controller.mapper.ParkingMapper;
import br.com.api.model.Parking;
import br.com.api.service.ParkingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/parking")
@Tag(name = "Parking Controller")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @Operation(summary = "Find all parkings")
    public ResponseEntity<List<ParkingDTO>> findAll() {
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> parkingListDTO = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(parkingListDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find one parking")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
        Parking parking = parkingService.findById(id);
        ParkingDTO parkingDTO = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(parkingDTO);
    }

    @PostMapping
    @Operation(summary = "Create one parking")
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO parkingCreateDTO) {
        Parking parkingCreate = parkingMapper.toParkingCreate(parkingCreateDTO);
        Parking parking = parkingService.create(parkingCreate);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
