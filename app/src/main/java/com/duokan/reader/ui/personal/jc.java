package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.cloud.DkCloudRedeemFund;
import com.duokan.reader.domain.cloud.ex;
import com.duokan.reader.ui.bookshelf.gw;
import com.duokan.reader.ui.bookshelf.gy;
import com.duokan.reader.ui.general.gs;
import java.util.List;

public class jc extends gs implements gy {
    /* renamed from: a */
    private final ReaderFeature f8763a = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    /* renamed from: b */
    private final nt f8764b;
    /* renamed from: c */
    private final gw f8765c = new gw(getContext());

    public jc(IFeature mFeature, boolean z) {
        super(mFeature);
        this.f8764b = new nt(getContext(), z);
        this.f8764b.getRedeemView().setOnItemClickListener(new jd(this));
        setContentView(this.f8764b);
        this.f8764b.getRedeemView().setAdapter(this.f8765c);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            m12041a();
        }
    }

    protected void onDeactive() {
        super.onDeactive();
    }

    /* renamed from: a */
    public void m12041a() {
        this.f8764b.getRedeemView().m9954a();
    }

    /* renamed from: a */
    public void mo1929a(int i, int i2, List<DkCloudRedeemFund> list) {
        ex.m5516a().m5525a(true, i, i2, new je(this, i, list));
    }
}
