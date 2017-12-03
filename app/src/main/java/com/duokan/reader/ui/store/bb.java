package com.duokan.reader.ui.store;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

public class bb extends ActivatedController implements ap {
    private final ReaderFeature a;
    private final bc b;
    private DkStoreFictionDetail c = null;

    public bb(IFeature featrue, DkStoreFictionDetail dkStoreFictionDetail, boolean z) {
        super(featrue);
        this.a = (ReaderFeature) featrue.queryFeature(ReaderFeature.class);
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
