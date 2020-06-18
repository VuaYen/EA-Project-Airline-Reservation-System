package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airport;

import java.security.PublicKey;
import java.util.List;

public interface AirportService {
    List<Airport> getAllAirports();

    Airport getAirportById(Integer id);

    Airport createOrUpdateAirport(Airport airport);

    void deleteAirportById(Integer id);
}
