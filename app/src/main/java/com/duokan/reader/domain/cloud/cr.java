package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.util.Arrays;

class cr extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3830a;
    /* renamed from: b */
    final /* synthetic */ cq f3831b;
    /* renamed from: c */
    private DkCloudPurchasedFiction f3832c = null;

    cr(cq cqVar, C0657i c0657i, al alVar) {
        this.f3831b = cqVar;
        this.f3830a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        dt dtVar = new dt(this.f3830a);
        dtVar.m5468a();
        this.f3832c = (DkCloudPurchasedFiction) dtVar.queryItem(this.f3831b.f3829a.f3825a);
        if (this.f3832c != null) {
            this.f3832c.addPurchasedChapterIds(this.f3831b.f3829a.f3826b);
            dtVar.updateItem(this.f3832c);
        }
    }

    protected void onSessionSucceeded() {
        if (!this.f3830a.m3365a(DkUserPurchasedFictionsManager.m5092g())) {
            this.f3831b.f3829a.f3827c.mo729a(-1, "");
        } else if (this.f3832c != null) {
            this.f3831b.f3829a.f3828d.f3616h.m5460a(this.f3832c);
            this.f3831b.f3829a.f3828d.m5091f();
            this.f3831b.f3829a.f3827c.mo730a(this.f3832c);
        } else {
            this.f3831b.f3829a.f3828d.m5097a(this.f3831b.f3829a.f3825a, this.f3831b.f3829a.f3827c);
        }
    }

    protected void onSessionFailed() {
        this.f3831b.f3829a.f3827c.mo729a(-1, "");
    }

    protected boolean onSessionException(Exception exception, int i) {
        C0328a.m757c().m748a(LogLevel.ERROR, "pm", String.format("unexpected error while marking a chapter purchased(bookUuid: %s, chapterIds: %s).", new Object[]{this.f3831b.f3829a.f3825a, Arrays.deepToString(this.f3831b.f3829a.f3826b.toArray(new String[0]))}), (Throwable) exception);
        return super.onSessionException(exception, i);
    }
}
