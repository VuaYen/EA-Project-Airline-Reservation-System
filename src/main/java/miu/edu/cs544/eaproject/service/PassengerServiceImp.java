package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Passenger;
import miu.edu.cs544.eaproject.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImp implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public Passenger getPassengerById(Integer id) {
        return this.passengerRepository.findById(id).get();
    }
}
