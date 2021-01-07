package com.controlspending.personal.spends.service.implematetion;

import com.controlspending.personal.exception.NotFoundException;
import com.controlspending.personal.person.Person;
import com.controlspending.personal.spends.ISpendsRepository;
import com.controlspending.personal.spends.Spends;
import com.controlspending.personal.spends.service.ISpendsFindById;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpendsFindById implements ISpendsFindById {

    private final ISpendsRepository spendsRepository;

    public Spends findSpendById(Long id) {
        return spendsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));
    }
}
