package com.paiego.coolcatsms.web.service;

import com.paiego.coolcatsms.web.model.CatDto;

import java.util.UUID;

public interface CatService {
    CatDto getCatById(UUID uuid);
    CatDto saveNewCat(CatDto catDto);
    void updateCat(UUID catId, CatDto catDto);
    void deleteCat(UUID catID);
}
