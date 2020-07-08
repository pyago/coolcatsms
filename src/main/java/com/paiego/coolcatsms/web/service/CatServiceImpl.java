package com.paiego.coolcatsms.web.service;

import com.paiego.coolcatsms.web.model.CatDto;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CatServiceImpl implements CatService {
    @Override
    public CatDto getCatById(UUID uuid) {
        // todo: just for testing we'll create a new random cat.
        return CatDto.builder()
            .id(UUID.randomUUID())
            .catName("Miles Davis")
            .build();
    }

    @Override
    public CatDto saveNewCat(CatDto catDto) {
        return CatDto.builder()
            .id(UUID.randomUUID())
            .build();
    }

    @Override
    public void updateCat(UUID catId, CatDto catDto) {
        log.info("deleteCat:" + catId);
    }

    @Override
    public void deleteCat(UUID catId) {
        log.info("deleteCat:" + catId);
    }
}
