package com.duokan.reader.ui.surfing;

import com.duokan.core.app.IFeature;
import com.duokan.reader.ui.store.C1501n;
import com.duokan.reader.ui.store.bq;

class ah extends C1501n {
    /* renamed from: c */
    final /* synthetic */ C1522i f11512c;

    ah(C1522i c1522i, IFeature mFeature, bq bqVar) {
        this.f11512c = c1522i;
        super(mFeature, bqVar);
    }

    /* renamed from: g */
    protected void mo2544g(int i) {
        super.mo2544g(i);
        this.f11512c.f11549q.getContentView().invalidate();
    }
}
