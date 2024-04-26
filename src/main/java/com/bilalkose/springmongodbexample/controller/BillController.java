package com.bilalkose.springmongodbexample.controller;

import com.bilalkose.springmongodbexample.model.Bill;
import com.bilalkose.springmongodbexample.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    public ResponseEntity addBill(@RequestBody Bill bill) {
        billService.addBill(bill);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateBill(@RequestBody Bill bill) {
        billService.updateBill(bill);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billService.getAllBills());
    }

    @GetMapping("/{name}")
    public ResponseEntity getBillByName(@PathVariable String name) {
        return ResponseEntity.ok(billService.getBill(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBill(@PathVariable String id) {
        billService.deleteBill(id);
        return ResponseEntity.noContent().build();
    }
}
