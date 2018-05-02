package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.j;
import com.duokan.reader.domain.account.ab;

class ey extends j {
    final /* synthetic */ ab a;
    final /* synthetic */ ex b;

    ey(ex exVar, ab abVar) {
        this.b = exVar;
        this.a = abVar;
    }

    protected void onSessionTry() {
        new fn(this.a).destroy();
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
