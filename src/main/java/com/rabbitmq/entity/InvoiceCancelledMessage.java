package com.rabbitmq.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rabbitmq.json.CustomLocalDateDeserializer;

import java.time.LocalDate;

public class InvoiceCancelledMessage {

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate cancelDate;

    private String invoiceNumber;

    private String reason;

    public InvoiceCancelledMessage() {
    }

    public InvoiceCancelledMessage(LocalDate cancelDate, String invoiceNumber, String reason) {
        this.cancelDate = cancelDate;
        this.invoiceNumber = invoiceNumber;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "InvoiceCancelledMessage{" +
                "cancelDate=" + cancelDate +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

    public LocalDate getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(LocalDate cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
