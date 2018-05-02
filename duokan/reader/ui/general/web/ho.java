package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.ui.bookshelf.ay;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.jq;
import com.mipay.sdk.Mipay;

import java.util.UUID;

class ho extends b {
    final /* synthetic */ jq a;
    final /* synthetic */ hn b;
    private a c = i.f().b(PersonalAccount.class);
    private com.duokan.reader.common.webservices.b d;

    ho(hn hnVar, jq jqVar) {
        this.b = hnVar;
        this.a = jqVar;
    }

    protected void onSessionTry() {
        this.d = new aa((WebSession) this, this.c).a(this.b.a.getBook().getBookUuid(), this.b.a.getRevision(), UUID.randomUUID().toString());
    }

    protected void onSessionSucceeded() {
        if (this.d.b == 0) {
            ay.a(this.b.b.a.f.b.pageController.getContext(), this.b.a.getEpubSize(), new hp(this));
            return;
        }
        this.b.b.a.f.b.pageController.web_notifyWeb(this.b.b.a.b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, this.d.c);
    }

    protected void onSessionFailed() {
        this.b.b.a.f.b.pageController.doShowToast(this.b.b.a.f.b.pageController.getContext().getString(j.general__shared__network_error));
    }

    protected void onSessionClosed() {
        this.a.dismiss();
        if (this.d != null && !TextUtils.isEmpty(this.d.c)) {
            ap apVar = new ap(this.b.b.a.f.b.pageController.getContext());
            apVar.setOkLabel(j.general__shared__iknow);
            apVar.setCancelOnBack(false);
            apVar.setCancelOnTouchOutside(false);
            apVar.setPrompt(this.d.c);
            apVar.show();
        }
    }
}
