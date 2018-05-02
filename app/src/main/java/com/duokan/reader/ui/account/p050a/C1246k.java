package com.duokan.reader.ui.account.p050a;

import android.content.Context;
import com.duokan.core.app.ah;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.cm;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.reader.ui.account.a.k */
class C1246k implements C1241f {
    C1246k() {
    }

    /* renamed from: a */
    public ap mo1568a(cm cmVar, ah ahVar) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null) {
            return null;
        }
        ap apVar = new ap(topActivity);
        apVar.setTitle(DkApp.get().getString(C0247i.account__merge__title_auto_login, new Object[]{cmVar.m3447b()}));
        apVar.setPrompt(DkApp.get().getString(C0247i.account__merge__prompt_auto_login, new Object[]{cmVar.m3447b(), cmVar.m3447b()}));
        apVar.setOkLabelResid(C0247i.account__merge__merge_auto_login);
        apVar.setNoLabel(C0247i.account__merge__switch_auto_login);
        apVar.setCancelOnBack(false);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(ahVar);
        return apVar;
    }
}
