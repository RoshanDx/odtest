package com.od.responseModel;

import com.od.dto.transaction.TransactionDTO;
import com.od.dto.customer.MetaDTO;

public class UpdateOrderStatusResponseModel {

    private MetaDTO meta;
    private TransactionDTO transaction;

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }

    public TransactionDTO getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionDTO transaction) {
        this.transaction = transaction;
    }
}
