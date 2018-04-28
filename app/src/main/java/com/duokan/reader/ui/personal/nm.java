package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.af;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.SystemUiMode;

public class nm extends ActivatedController implements SystemUiConditioner {
    /* renamed from: a */
    private final boolean f8204a;
    /* renamed from: b */
    protected final ReaderFeature f8205b = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));

    public nm(IFeature mFeature, boolean z) {
        super(mFeature);
        this.f8204a = z;
    }

    protected void onActive(boolean z) {
        this.f8205b.addSystemUiConditioner(this);
        this.f8205b.updateSystemUi(true);
    }

    protected void onDetachFromStub() {
        this.f8205b.removeSystemUiConditioner(this);
    }

    public void chooseStatusBarStyle(af<Boolean> afVar) {
        if (isActive()) {
            afVar.mo975a(Boolean.valueOf(this.f8204a));
        }
    }

    public void chooseNavigationBarMode(af<SystemUiMode> afVar) {
    }

    public void chooseNavigationBarColor(af<Integer> afVar) {
    }
}
