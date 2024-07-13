package com.alura.forohub.controller;

import com.alura.forohub.domain.response.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/responses")
@SecurityRequirement(name = "bearer-key")
public class ResponseController {
    @Autowired
    ResponseRepository responseRepository;

    @Autowired
    ResponseService responseService;

    @PostMapping
    @Transactional
    public ResponseEntity<ShowResponseData> registerResponse(@RequestBody @Valid RegisterResponseData data) {
        var response = responseService.registerResponse(data);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<ShowResponseData>> listResponses(@PageableDefault(size = 4) Pageable pagination) {
        return ResponseEntity.ok(responseRepository.findAll(pagination).map(ShowResponseData::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowResponseData> getResponse(@PathVariable Long id) {
        Response response = responseRepository.getReferenceById(id);
        var responseData = new ShowResponseData(response);
        return ResponseEntity.ok(responseData);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateResponse(@RequestBody @Valid UpdateResponseData updatedData) {
        Response response = responseRepository.getReferenceById(updatedData.id());
        response.updateData(updatedData);
        var responseData = new ShowResponseData(response);
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteResponse(@PathVariable Long id) {
        responseRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

