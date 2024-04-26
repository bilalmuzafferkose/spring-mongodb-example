package com.bilalkose.springmongodbexample.repository;

import com.bilalkose.springmongodbexample.model.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface BillRepository extends MongoRepository<Bill, String> {
    /*
    veritabanında name alanı belirtilen isme sahip dokümanları döndürecektir. Metota geçirilen name parametresi, MongoDB sorgusundaki ?0 ile eşleşecektir. Bu sayede, findByName metodu çalıştırıldığında name parametresi ?0'a atanır ve MongoDB sorgusu doğru şekilde oluşturulur.
     */
    @Query("{'name': ?0}")
    Optional<Bill> findByName(String name);
}
