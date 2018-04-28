package com.duokan.reader.ui.store;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

public class bb extends ActivatedController implements ap {
    /* renamed from: a */
    private final ReaderFeature f11354a;
    /* renamed from: b */
    private final bc f11355b;
    /* renamed from: c */
    private DkStoreFictionDetail f11356c = null;

    public bb(IFeature mFeature, DkStoreFictionDetail dkStoreFictionDetail, boolean z) {
        super(mFeature);
        this.f11354a = (ReaderFeature) mFeature.queryFeature(ReaderFeature.class);
        this.f11356c = dkStoreFictionDetail;
        this.f11355b = new bc(getContext());
        setContentView(this.f11355b);
        this.f11355b.m15312a(this.f11356c, this.f11356c.getToc());
        this.f11355b.m15313a(z);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            ((ao) getContext().queryFeature(ao.class)).mo1834b(this.f11356c.getFiction().getBookUuid(), this);
        }
    }

    protected void onDetachFromStub() {
        ((ao) getContext().queryFeature(ao.class)).mo1833a(this.f11356c.getFiction().getBookUuid(), this);
        super.onDetachFromStub();
    }

    /* renamed from: a */
    public void mo2528a(DkStoreFictionDetail dkStoreFictionDetail) {
        this.f11356c = dkStoreFictionDetail;
        this.f11355b.m15312a(this.f11356c, this.f11356c.getToc());
    }
}
