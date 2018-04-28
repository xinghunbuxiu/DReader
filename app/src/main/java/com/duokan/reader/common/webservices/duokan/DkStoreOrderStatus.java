package com.duokan.reader.common.webservices.duokan;

import java.io.Serializable;

public enum DkStoreOrderStatus implements Serializable {
    UNKOWN,
    UNPAID,
    PAID,
    CANCELLED,
    FROZEN,
    PRICE_CHANGED
}
