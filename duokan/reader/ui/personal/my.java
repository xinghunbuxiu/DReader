package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.af;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;

public class my extends ActivatedController implements SystemUiConditioner {
    private final boolean a;
    protected final ReaderFeature b = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));

    public my(IFeature featrue, boolean z) {
        super(featrue);
        this.a = z;
    }

    protected void onActive(boolean z) {
        this.b.addSystemUiConditioner(this);
        this.b.updateSystemUi(true);
    }

    protected void onDetachFromStub() {
        this.b.removeSystemUiConditioner(this);
    }

    public void chooseStatusBarStyle(af afVar) {
        if (isActive()) {
            afVar.a(Boolean.valueOf(this.a));
        }
    }

    public void chooseNavigationBarMode(af afVar) {
    }

    public void chooseNavigationBarColor(af afVar) {
    }
}
