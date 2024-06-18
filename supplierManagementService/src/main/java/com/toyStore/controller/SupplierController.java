package com.toyStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyStore.model.Supplier;
import com.toyStore.service.SupplierService;

@RestController
@RequestMapping("/suppliers")

public class SupplierController {
	@Autowired
    private SupplierService supplierService;

    @PostMapping("/add")
    public ResponseEntity<?> addSupplier(@RequestBody Supplier supplier) {
        try {
            Supplier addedSupplier = supplierService.addSupplier(supplier);
            return new ResponseEntity<>(addedSupplier, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Supplier could not be added", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSupplierById(@PathVariable("id") Long id) {
        try {
            Supplier supplier = supplierService.getSupplierById(id);
            if (supplier != null) {
                return new ResponseEntity<>(supplier, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Supplier not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching the supplier", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSupplier(@PathVariable("id") Long id, @RequestBody Supplier supplier) {
        supplier.setId(id);
        supplierService.updateSupplier(supplier);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable("id") Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok().build();
    }

}
