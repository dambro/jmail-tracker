package com.example.jmailtracker.validators;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class EmailValidator implements EmailValidatorI {

    private final static String VALID_PATTERN = "^(.+)@(\\S+)$";

    @Override
    public boolean validate(String email) {
        return Pattern.compile(VALID_PATTERN).matcher(email).matches();
    }

}
