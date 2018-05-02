package com.duokan.reader.ui.account.p050a;

import android.content.Context;
import com.duokan.core.app.ah;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.AnonymousAccount;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.cm;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.reader.ui.account.a.m */
class C1248m implements C1241f {
    C1248m() {
    }

    /* renamed from: a */
    public ap mo1568a(cm cmVar, ah ahVar) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null) {
            return null;
        }
        AnonymousAccount anonymousAccount = (AnonymousAccount) C0709k.m3476a().m3502b(AnonymousAccount.class);
        ap apVar = new ap(topActivity);
        apVar.setTitle(DkApp.get().getString(C0247i.account__merge__title, new Object[]{cmVar.m3447b()}));
        apVar.setPrompt(DkApp.get().getString(C0247i.account__merge__prompt, new Object[]{anonymousAccount.mo836f().mo871a()}));
        apVar.setOkLabelResid(C0247i.account__merge__merge);
        apVar.setNoLabel(C0247i.account__merge__cancel);
        apVar.setCancelOnBack(false);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(ahVar);
        return apVar;
    }
}
