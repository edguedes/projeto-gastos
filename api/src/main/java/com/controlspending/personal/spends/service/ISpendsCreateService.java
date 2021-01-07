package com.controlspending.personal.spends.service;

import com.controlspending.personal.spends.dto.SpendsCreateDTO;

public interface ISpendsCreateService {

    void create(SpendsCreateDTO spendsDTO, Long idPerson);
}
