package com.od.responseModel;

import com.od.dto.transaction.TransactionDTO;
import com.od.dto.customer.MetaDTO;

import java.util.ArrayList;
import java.util.List;

public class SearchOrderResponseModel {
    private MetaDTO meta;
    private List<TransactionDTO> transactions = new ArrayList<>();

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }
}
