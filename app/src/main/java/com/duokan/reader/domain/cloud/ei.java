package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.ab;

class ei extends ek {
    public ei(ab abVar) {
        super(abVar, "UserPurchasedFictionsCache");
    }

    public void a() {
        upgradeVersion(5, new ej(this));
    }
}
