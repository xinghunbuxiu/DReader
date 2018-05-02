package com.duokan.reader.ui.account;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.ba;
import com.duokan.reader.ui.general.C1329do;

/* renamed from: com.duokan.reader.ui.account.g */
class C1255g implements ba {
    /* renamed from: a */
    final /* synthetic */ C1329do f5948a;
    /* renamed from: b */
    final /* synthetic */ C1253e f5949b;

    C1255g(C1253e c1253e, C1329do c1329do) {
        this.f5949b = c1253e;
        this.f5948a = c1329do;
    }

    /* renamed from: a */
    public void mo1588a() {
        this.f5948a.mo1780a();
    }

    /* renamed from: a */
    public void mo1589a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f5948a.mo1781a(this.f5949b.getContext().getResources().getString(C0258j.personal__miaccount_change_signature_view__failed));
        } else {
            this.f5948a.mo1781a(str);
        }
    }
}
