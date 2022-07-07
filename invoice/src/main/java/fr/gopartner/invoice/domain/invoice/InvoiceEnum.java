package fr.gopartner.invoice.domain.invoice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InvoiceEnum {
    INITIATED("Initiated"),

    DELIVERED("Delivered");



    private String value;

    InvoiceEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static InvoiceEnum fromValue(String value) {
        for (InvoiceEnum b : InvoiceEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        return null;
    }

}
