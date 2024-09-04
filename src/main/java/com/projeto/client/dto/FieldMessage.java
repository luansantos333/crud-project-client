package com.projeto.client.dto;

import java.time.Instant;

public class FieldMessage {

    private String fieldName;
    private String erroMessage;


    public FieldMessage(String fieldName, String erroMessage) {
        this.fieldName = fieldName;
        this.erroMessage = erroMessage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getErroMessage() {
        return erroMessage;
    }
}
