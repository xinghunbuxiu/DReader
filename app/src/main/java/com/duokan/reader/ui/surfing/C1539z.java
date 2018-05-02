package com.duokan.reader.ui.surfing;

import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.ui.general.web.StorePageController;

/* renamed from: com.duokan.reader.ui.surfing.z */
class C1539z implements ad {
    /* renamed from: a */
    final /* synthetic */ String f11595a;
    /* renamed from: b */
    final /* synthetic */ C1522i f11596b;

    C1539z(C1522i c1522i, String str) {
        this.f11596b = c1522i;
        this.f11595a = str;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        m15548a();
        if (!TextUtils.isEmpty(this.f11595a)) {
            ((ReaderFeature) AppContext.getAppContext(this.f11596b.getContext()).queryFeature(ReaderFeature.class)).navigate(this.f11595a, null, true, null);
        }
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
        m15548a();
    }

    /* renamed from: a */
    private void m15548a() {
        Editor edit = PersonalPrefs.m5175a().m5244t().edit();
        edit.remove(StorePageController.PAY_CONTINUE);
        edit.apply();
    }
}
