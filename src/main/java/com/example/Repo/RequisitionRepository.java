package com.example.Repo;

import com.example.Model.Requisition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequisitionRepository extends JpaRepository<Requisition, Long> {

    Optional<List<Requisition>> findBySeller_INN(String INN);

    Optional<List<Requisition>> findBySeller_Id(Long id);

    Optional<List<Requisition>> findByCustomer_Id(Long id);


}