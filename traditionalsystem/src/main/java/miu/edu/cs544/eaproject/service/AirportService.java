package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.service.response.AirportResponse;

import java.security.PublicKey;
import java.util.List;

public interface AirportService {
    List<AirportResponse> getAllAirports();

    AirportResponse getAirportById(Integer id);

    AirportResponse createOrUpdateAirport(Airport airport);

    void deleteAirportById(Integer id);
}
