/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init;

import com.model.Emails;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Emails, String> {

    @Override
    public void initialize(Emails paramA) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isValid(String emailNo, ConstraintValidatorContext ctx) {
        // TODO Auto-generated method stub
        if (emailNo == null) {
            return false;
        } else return emailNo.matches("[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@infosupport\\.nl");
    }
}
