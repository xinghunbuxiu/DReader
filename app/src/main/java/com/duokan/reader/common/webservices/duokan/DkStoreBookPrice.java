package com.duokan.reader.common.webservices.duokan;

import java.io.Serializable;

public class DkStoreBookPrice implements Serializable {
    public String mBookTitle = null;
    public String mBookUuid = null;
    public int mNewPrice = 0;
    public int mPrice = 0;

    public boolean equals(Object obj) {
        if (!(obj instanceof DkStoreBookPrice)) {
            return super.equals(obj);
        }
        return this.mBookUuid.equals(((DkStoreBookPrice) obj).mBookUuid);
    }
}
