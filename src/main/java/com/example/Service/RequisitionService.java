package com.example.Service;

import com.example.Model.Requisition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequisitionService {

    Requisition save(Requisition requisition);

    Requisition update(Long id, Requisition requisition);

    void delete(Long id);

    Requisition getById(Long id);

    List<Requisition> getAll();

    List<Requisition> findBySellerInn(String Inn);

}
