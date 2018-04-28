package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0651y;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.ui.bookshelf.be;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.ja;
import com.mipay.sdk.Mipay;
import java.util.UUID;

class hw extends WebSession {
    /* renamed from: a */
    final /* synthetic */ ja f7953a;
    /* renamed from: b */
    final /* synthetic */ hv f7954b;
    /* renamed from: c */
    private C0672a f7955c = C0709k.m3476a().m3502b(PersonalAccount.class);
    /* renamed from: d */
    private C0621a<C0651y> f7956d;

    hw(hv hvVar, C0657i c0657i, ja jaVar) {
        this.f7954b = hvVar;
        this.f7953a = jaVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f7956d = new C0652z((WebSession) this, this.f7955c).m3060a(this.f7954b.f7951a.getBook().getBookUuid(), this.f7954b.f7951a.getRevision(), UUID.randomUUID().toString());
    }

    protected void onSessionSucceeded() {
        if (this.f7956d.b == 0) {
            be.m9188a(this.f7954b.f7952b.f7944a.f7943f.f7937b.f7581b.getContext(), this.f7954b.f7951a.getEpubSize(), new hx(this));
            return;
        }
        this.f7954b.f7952b.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7954b.f7952b.f7944a.f7939b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, this.f7956d.c);
    }

    protected void onSessionFailed() {
        this.f7954b.f7952b.f7944a.f7943f.f7937b.f7581b.doShowToast(this.f7954b.f7952b.f7944a.f7943f.f7937b.f7581b.getContext().getString(C0258j.general__shared__network_error));
    }

    protected void onSessionClosed() {
        this.f7953a.dismiss();
        if (this.f7956d != null && !TextUtils.isEmpty(this.f7956d.c)) {
            ap apVar = new ap(this.f7954b.f7952b.f7944a.f7943f.f7937b.f7581b.getContext());
            apVar.setOkLabelResid(C0258j.general__shared__iknow);
            apVar.setCancelOnBack(false);
            apVar.setCancelOnTouchOutside(false);
            apVar.setPrompt(this.f7956d.c);
            apVar.show();
        }
    }
}
