package com.example.Controller;

import com.example.Exception.InvalidCreditException;
import com.example.Exception.InvalidDateException;
import com.example.Exception.InvalidInnException;
import com.example.Model.*;
import com.example.Service.RequisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/req")
public class ReqController {

    RequisitionService requisitionService;

    @Autowired
    public ReqController(RequisitionService requisitionService) {
        this.requisitionService = requisitionService;
    }


    @PostMapping("/create")
    public Requisition create(@RequestBody Requisition requisition){
        System.out.println(requisition);
        Requisition save;
        try {
            save = requisitionService.save(requisition);
        }catch (Exception exc){
           throw new ResponseStatusException(
                   HttpStatus.NOT_ACCEPTABLE, exc.getMessage(), exc);
        }
        return save;
    }

    @PatchMapping("/update")
    public Requisition update(@RequestParam Long id,@RequestBody Requisition requisition){
        Requisition update;
        try {
            update = requisitionService.update(id,requisition);
        }catch (Exception exc){
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, exc.getMessage(), exc);
        }
        System.out.println(update);
        return update;
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        requisitionService.delete(id);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @GetMapping("/get")
    public Requisition getByRequisitionId(@RequestParam Long id){
        return requisitionService.getById(id);
    }

    @GetMapping("/getByInn")
    public List<Requisition> getByInn(@RequestParam String Inn){
        return requisitionService.findBySellerInn(Inn);
    }


    @GetMapping
    public List<Requisition> getAll(){
        return requisitionService.getAll();
    }


}
