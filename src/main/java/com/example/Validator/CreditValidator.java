package com.example.Validator;

import com.example.Exception.InvalidCreditException;
import org.springframework.stereotype.Component;

@Component
public class CreditValidator {

    public void checkCreditAmountAndPurchaseCost(String creditAmount, String purchaseCost){
        Integer credit = Integer.valueOf(creditAmount);
        Integer cost = Integer.valueOf(purchaseCost);

        if(credit<5000){
            throw new InvalidCreditException("Минимальная сумма кредита - 5000 Руб.");
        }

        if(cost<10000){
            throw new InvalidCreditException("Минимальная стоимость покупки - 10000 Руб.");
        }

    }

}
