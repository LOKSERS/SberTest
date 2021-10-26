package com.example.Validator;

import com.example.Exception.InvalidDateException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataValidator {

    public void checkData(LocalDate requisitonDate){

        if(requisitonDate.isAfter(LocalDate.now())&&requisitonDate.isBefore(LocalDate.now().plusMonths(2))) {
            throw new InvalidDateException("Минимальный срок кредита - 2 месяца");
        }

        if(requisitonDate.isBefore(LocalDate.now())){
            throw new InvalidDateException("Не валидная дата.");
        }
    }

}
