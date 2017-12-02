package com.duokan.reader;

import com.duokan.reader.domain.account.oauth.ThirdWeiXin;

public class DkReaderPhone extends DkReader {
    public boolean supportWxPay() {
        return ThirdWeiXin.isWeiXinPaySupported(this);
    }

    public int supportAdSdkVersion() {
        return 2017021600;
    }
}
