package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.domain.account.ab;

import java.util.Arrays;

class dd extends ef {
    final /* synthetic */ ab a;
    final /* synthetic */ dc b;
    private DkCloudPurchasedFiction d = null;

    dd(dc dcVar, ab abVar) {
        this.b = dcVar;
        this.a = abVar;
        super(dcVar.a.d);
    }

    protected void onSessionTry() {
        ei eiVar = new ei(this.a);
        eiVar.a();
        this.d = (DkCloudPurchasedFiction) eiVar.queryItem(this.b.a.a);
        if (this.d != null) {
            this.d.addPurchasedChapterIds(this.b.a.b);
            eiVar.updateItem(this.d);
        }
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(DkUserPurchasedFictionsManager.g())) {
            this.b.a.c.a(-1, "");
        } else if (this.d != null) {
            this.b.a.d.h.a(this.d);
            this.b.a.d.f();
            this.b.a.c.a(this.d);
        } else {
            this.b.a.d.a(this.b.a.a, this.b.a.c);
        }
    }

    protected void onSessionFailed() {
        this.b.a.c.a(-1, "");
    }

    protected boolean onSessionException(Exception exception, int i) {
        a.c().a(LogLevel.ERROR, "pm", String.format("unexpected error while marking a chapter purchased(bookUuid: %s, chapterIds: %s).", new Object[]{this.b.a.a, Arrays.deepToString(this.b.a.b.toArray(new String[0]))}), (Throwable) exception);
        return super.onSessionException(exception, i);
    }
}
