package com.od.responseModel;

import com.od.dto.transaction.TransactionDTO;
import com.od.dto.customer.MetaDTO;

import java.util.ArrayList;
import java.util.List;

public class SearchOrderResponseModel {
    private MetaDTO metaDTO;
    private List<TransactionDTO> transactions = new ArrayList<>();

    public MetaDTO getMetaDTO() {
        return metaDTO;
    }

    public void setMetaDTO(MetaDTO metaDTO) {
        this.metaDTO = metaDTO;
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }
}
