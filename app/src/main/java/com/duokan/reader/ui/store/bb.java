package com.duokan.reader.ui.store;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

public class bb extends e implements ap {
    private final ReaderFeature a;
    private final bc b;
    private DkStoreFictionDetail c = null;

    public bb(y yVar, DkStoreFictionDetail dkStoreFictionDetail, boolean z) {
        super(yVar);
        this.a = (ReaderFeature) yVar.queryFeature(ReaderFeature.class);
        this.c = dkStoreFictionDetail;
        this.b = new bc(getContext());
        setContentView(this.b);
        this.b.a(this.c, this.c.getToc());
        this.b.a(z);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            ((ao) getContext().queryFeature(ao.class)).b(this.c.getFiction().getBookUuid(), this);
        }
    }

    protected void onDetachFromStub() {
        ((ao) getContext().queryFeature(ao.class)).a(this.c.getFiction().getBookUuid(), this);
        super.onDetachFromStub();
    }

    public void a(DkStoreFictionDetail dkStoreFictionDetail) {
        this.c = dkStoreFictionDetail;
        this.b.a(this.c, this.c.getToc());
    }
}
