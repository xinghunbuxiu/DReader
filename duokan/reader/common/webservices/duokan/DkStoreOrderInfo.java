package com.duokan.reader.common.webservices.duokan;

import java.io.Serializable;

public class DkStoreOrderInfo implements Serializable {
    public String mBookUuid = null;
    public String[] mDiscountName = new String[0];
    public float[] mDiscountValue = new float[0];
    public String[] mFreeBookUuids = new String[0];
    public String[] mIllegalBookUuids = new String[0];
    public DkStoreOrderStatus mOrderStatus = DkStoreOrderStatus.UNKOWN;
    public OrderType mOrderType = OrderType.NORMAL;
    public String mOrderUuid = null;
    public String[] mPaidBookUuids = new String[0];
    public String mPaymentEnvelop = "";
    public String mPaymentId = "";
    public String mPaymentMothodName = "";
    public String mPaymentSenderSign = "";
    public int mPrice = 0;
    public DkStoreBookPrice[] mTransBooks = new DkStoreBookPrice[0];

    public enum OrderType implements Serializable {
        GIFT,
        REDEEM,
        NORMAL
    }
}
