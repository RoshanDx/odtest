package com.od.responseModel;

import com.od.dto.TransactionDTO;
import com.od.dto.customer.MetaDTO;
import com.od.model.Transaction;

public class CreateOrderResponseModel {

    private MetaDTO metaDTO;
    private TransactionDTO transaction;

    public MetaDTO getMetaDTO() {
        return metaDTO;
    }

    public void setMetaDTO(MetaDTO metaDTO) {
        this.metaDTO = metaDTO;
    }

    public TransactionDTO getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionDTO transaction) {
        this.transaction = transaction;
    }
}
