package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Passenger;
import miu.edu.cs544.eaproject.repository.PassengerRepository;
import miu.edu.cs544.eaproject.service.mapper.PassengerAndReservationsMapper;
import miu.edu.cs544.eaproject.service.mapper.PassengerReservationsMapper;
import miu.edu.cs544.eaproject.service.response.PassengerAndReservationsResponse;
import miu.edu.cs544.eaproject.service.response.PassengerReservationsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImp implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public Passenger getPassengerById(Integer id) {
        return this.passengerRepository.findById(id).get();
    }

    @Override
    public List<PassengerAndReservationsResponse> getPassengersAndReservationsByReservationsCreatedBy(Integer id) {
        return passengerRepository.findDistinctPassengersByReservationsCreatedBy(id).stream().map(PassengerAndReservationsMapper::mapToPassengerAndReservationsResponse).collect(Collectors.toList());
    }
}
