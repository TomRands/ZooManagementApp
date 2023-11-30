package com.example.zoo.controller;

import com.example.zoo.entities.Reptile;
import com.example.zoo.services.IReptileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@SuppressWarnings({"unused", "UnusedReturnValue"})
@Tag(name = "Reptile Api")
@RequestMapping("/reptiles")
public class ReptileController {

    private final IReptileService reptileService;

    @Autowired
    public ReptileController(IReptileService reptileService) {
        this.reptileService = reptileService;
    }

    @GetMapping
    public List<Reptile> getAllReptiles() {
        return reptileService.findAllReptiles();
    }

    @Operation(summary = "Get reptile by id", description = "Returns a reptile by id")
    @GetMapping("{reptileId}")
    public Reptile getReptile(@PathVariable UUID reptileId) {
        return reptileService.findReptileById(reptileId);
    }

    @Operation(summary = "Add a reptile", description = "Add a reptile")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reptile addReptile(@RequestBody @DateTimeFormat(pattern="dd-MM-yyyy") Reptile reptile) {
        return reptileService.addReptile(reptile);
    }

    @Operation(summary = "Update a reptile", description = "Update a reptile")
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reptile updateReptile(@RequestBody @DateTimeFormat(pattern="dd-MM-yyyy") Reptile reptile) {
        return reptileService.updateReptile(reptile);
    }

    @Operation(summary = "Delete a reptile by id", description = "Delete a reptile by id")
    @DeleteMapping("{reptileId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReptile(@PathVariable UUID reptileId) {
        reptileService.deleteReptile(reptileId);
    }
}