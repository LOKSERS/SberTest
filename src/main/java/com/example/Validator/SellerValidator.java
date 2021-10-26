package com.example.Validator;

import com.example.Exception.InvalidInnException;
import com.example.Model.Seller;
import com.example.Model.SellerType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SellerValidator {

    public void checkSeller(Seller seller){

        if(seller.getSellerType().equals(SellerType.JURIDICAL)) {
            if (!checkInn(seller.getINN())) {
                throw new InvalidInnException("Не валидный ИНН");
            }
        }

    }


    private static boolean checkInn(String innStr) {

        final Integer[] MULT_N1 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        final Integer[] MULT_N2 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

        Boolean valid;
        Integer[] inn = stringToIntArray(innStr);

        Integer innSize = inn.length;

        switch (innSize) {
            case 12:
                Integer N1 = getChecksum(inn,MULT_N1);
                Integer N2 = getChecksum(inn,MULT_N2);

                valid = (inn[inn.length-1].equals(N2) && inn[inn.length-2].equals(N1));
                break;
            default:
                valid = false;
                break;
        }
        return valid;
    }

    private static Integer[] stringToIntArray(String src) {
        char[] chars = src.toCharArray();
        ArrayList<Integer> digits = new ArrayList<Integer>();
        for (char aChar : chars) {
            digits.add(Character.getNumericValue(aChar));
        }
        return digits.toArray(new Integer[digits.size()]);
    }

    private static Integer getChecksum(Integer[] digits, Integer[] multipliers) {
        int checksum = 0;
        for (int i=0; i<multipliers.length; i++) {
            checksum+=(digits[i]*multipliers[i]);
        }
        return (checksum % 11) % 10;
    }

}
