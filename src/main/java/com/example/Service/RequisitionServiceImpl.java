package com.example.Service;

import com.example.Exception.InvalidInnException;
import com.example.Exception.ReqNotExistException;
import com.example.Model.Customer;
import com.example.Model.Requisition;
import com.example.Model.Seller;
import com.example.Repo.CustomerRepository;
import com.example.Repo.RequisitionRepository;
import com.example.Repo.SellerRepository;
import com.example.Validator.RequisitionValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisitionServiceImpl implements RequisitionService {

    private final RequisitionValidator requisitionValidator;
    private final RequisitionRepository requisitionRepository;
    private final SellerRepository sellerRepository;
    private final CustomerRepository customerRepository;

    public RequisitionServiceImpl(RequisitionValidator requisitionValidator, RequisitionRepository requisitionRepository, SellerRepository sellerRepository, CustomerRepository customerRepository) {
        this.requisitionValidator = requisitionValidator;
        this.requisitionRepository = requisitionRepository;
        this.sellerRepository = sellerRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Requisition save(Requisition requisition) {
        requisitionValidator.validate(requisition);
        return requisitionRepository.save(requisition);
    }

    @Override
    public Requisition update(Long id, Requisition requisition) {
        requisitionValidator.validate(requisition);
        Requisition req = requisitionRepository.findById(id).orElseThrow(()-> new ReqNotExistException("Заявки с такм id не существует"));
        req.setBuyingObj(requisition.getBuyingObj());

        Seller seller = requisition.getSeller();
        if(sellerRepository.findByINN(seller.getINN())!=null){
            req.setSeller(sellerRepository.findByINN(seller.getINN()));
        }else {
            req.setSeller(seller);
        }

        Customer customer = req.getCustomer();
        if(customerRepository.findByPhoneNumber(customer.getPhoneNumber())!=null){
            req.setCustomer(customerRepository.findByPhoneNumber(customer.getPhoneNumber()));
        }else{
            req.setCustomer(customer);
        }

        req.setDate(requisition.getDate());
        req.setCreditAmount(requisition.getCreditAmount());
        req.setPurchaseCost(req.getPurchaseCost());
        return requisitionRepository.save(requisition);
    }

    @Override
    public void delete(Long id) {
        Requisition req = requisitionRepository.findById(id).orElseThrow(()-> new ReqNotExistException("Заявки с такм id не существует"));
        requisitionRepository.deleteById(id);
    }

    @Override
    public Requisition getById(Long id) {
        return requisitionRepository.findById(id).orElseThrow(()-> new ReqNotExistException("Заявки с такм id не существует"));
    }

    @Override
    public List<Requisition> getAll() {
        return requisitionRepository.findAll();
    }

    @Override
    public List<Requisition> findBySellerInn(String Inn) {
        return requisitionRepository.findBySeller_INN(Inn).orElseThrow(()-> new InvalidInnException("Заявки с данным ИНН - отсутствуют"));
    }
}
