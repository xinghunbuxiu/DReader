package com.duokan.reader.ui.personal;

import com.duokan.core.app.y;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.cloud.fp;
import com.duokan.reader.ui.bookshelf.gp;
import com.duokan.reader.ui.bookshelf.gr;
import com.duokan.reader.ui.general.hd;

import java.util.List;

public class ip extends hd implements gr {
    private final ReaderFeature a = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    private final nf b;
    private final gp c = new gp(getContext());

    public ip(y yVar, boolean z) {
        super(yVar);
        this.b = new nf(getContext(), z);
        this.b.getRedeemView().setOnItemClickListener(new iq(this));
        setContentView(this.b);
        this.b.getRedeemView().setAdapter(this.c);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            a();
        }
    }

    protected void onDeactive() {
        super.onDeactive();
    }

    public void a() {
        this.b.getRedeemView().a();
    }

    public void a(int i, int i2, List list) {
        fp.a().a(true, i, i2, new ir(this, i, list));
    }
}
