package com.duokan.reader.ui.surfing;

import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.ui.store.br;

import java.util.Set;

class t extends br {
    final /* synthetic */ f a;

    t(f fVar, IFeature featrue) {
        this.a = fVar;
        super(featrue);
    }

    protected boolean b() {
        if (this.a.A > 0) {
            return false;
        }
        return super.b();
    }

    protected void a() {
        this.a.n.f().setVisibility(0);
        this.a.n.a(0);
        this.a.n.e().invalidate();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        Set c = PersonalPrefs.a().c();
        if (c != null && !this.a.z.equals(c)) {
            this.a.a(c);
        }
    }
}
