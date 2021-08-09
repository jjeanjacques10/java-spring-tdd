package com.jjeanjacques10.tdd.service;

import com.jjeanjacques10.tdd.model.BookingModel;
import com.jjeanjacques10.tdd.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public int daysCalculatorWithDatabase(String name) {
        Optional<BookingModel> bookingModelOptional = bookingRepository.findByReserveName(name);

        return Period.between(bookingModelOptional.get().getCheckIn(),
                bookingModelOptional.get().getCheckOut()).getDays();
    }
}
