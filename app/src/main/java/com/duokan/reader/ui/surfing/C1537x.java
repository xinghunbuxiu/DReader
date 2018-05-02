package com.duokan.reader.ui.surfing;

import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.ui.store.br;
import java.util.Set;

/* renamed from: com.duokan.reader.ui.surfing.x */
class C1537x extends br {
    /* renamed from: a */
    final /* synthetic */ C1522i f11591a;

    C1537x(C1522i c1522i, IFeature mFeature) {
        this.f11591a = c1522i;
        super(mFeature);
    }

    /* renamed from: b */
    protected boolean mo2563b() {
        if (this.f11591a.f11530D > 0) {
            return false;
        }
        return super.mo2563b();
    }

    /* renamed from: a */
    protected void mo2562a() {
        this.f11591a.f11549q.m15341f().setVisibility(0);
        this.f11591a.f11549q.m15332a(0);
        this.f11591a.f11549q.m15340e().invalidate();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        Set c = PersonalPrefs.m5175a().m5219c();
        if (c != null && !this.f11591a.f11529C.equals(c)) {
            this.f11591a.m15486a(c);
        }
    }
}
