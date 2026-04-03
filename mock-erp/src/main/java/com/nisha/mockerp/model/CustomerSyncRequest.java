package com.nisha.mockerp.model;

import java.util.List;

public class CustomerSyncRequest {
    private String correlationId;
    private String source;
    private String syncedAt;
    private Integer totalRecords;
    private List<SyncCustomerItem> customers;

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSyncedAt() {
        return syncedAt;
    }

    public void setSyncedAt(String syncedAt) {
        this.syncedAt = syncedAt;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<SyncCustomerItem> getCustomers() {
        return customers;
    }

    public void setCustomers(List<SyncCustomerItem> customers) {
        this.customers = customers;
    }
}