package com.example.Validator;

import com.example.Model.Requisition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequisitionValidator {

    @Autowired
    public RequisitionValidator(DataValidator dataValidator, SellerValidator sellerValidator, CreditValidator creditValidator) {
        this.dataValidator = dataValidator;
        this.sellerValidator = sellerValidator;
        this.creditValidator =creditValidator;
    }

    DataValidator dataValidator;
    SellerValidator sellerValidator;
    CreditValidator creditValidator;

    public void validate(Requisition requisition){
        dataValidator.checkData(requisition.getDate());
        creditValidator.checkCreditAmountAndPurchaseCost(requisition.getCreditAmount(), requisition.getPurchaseCost());
        sellerValidator.checkSeller(requisition.getSeller());
    }

}
