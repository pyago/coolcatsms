package com.paiego.coolcatsms.web.controller;

import com.paiego.coolcatsms.web.model.CatDto;
import com.paiego.coolcatsms.web.service.CatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RequestMapping("api/v1/cat")
@RestController
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping({"/{catId}"})
    public ResponseEntity<CatDto> getCat(@PathVariable UUID catId) {
        log.info("getCat:" + catId);
        return new ResponseEntity<>(catService.getCatById(catId), HttpStatus.OK);
    }

    @PostMapping // POST - Create new Cat
    public ResponseEntity handlePost(@RequestBody CatDto catDto) {
        catService.saveNewCat(catDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "api/v1/cat/" + catDto.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{catId}"})
    public ResponseEntity handlePut(@PathVariable UUID catId, @RequestBody CatDto catDto) {
        catService.updateCat(catId, catDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping({"/{catId}"})
    public void handleDelete(@PathVariable UUID catId) {
        catService.deleteCat(catId);
    }
}
