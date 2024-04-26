package com.bilalkose.springmongodbexample.service;

import com.bilalkose.springmongodbexample.model.Bill;
import com.bilalkose.springmongodbexample.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public void addBill(Bill bill) {
        billRepository.insert(bill);
    }

    public void updateBill(Bill bill) {
        Bill savedBill = billRepository.findById(bill.getId())
                .orElseThrow( () -> new RuntimeException("Cannot find bill by ID: " + bill.getId()) );

        savedBill.setBillName(bill.getBillName());
        savedBill.setBillCategory(bill.getBillCategory());
        savedBill.setBillAmount(bill.getBillAmount());

        billRepository.save(bill);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBill(String name) {
        return billRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Bill by Name - %s", name)));
    }

    public void deleteBill(String id) {
        billRepository.deleteById(id);
    }
}
