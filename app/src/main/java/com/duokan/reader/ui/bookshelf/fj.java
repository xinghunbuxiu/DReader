package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.C0436e;
import com.duokan.reader.ui.surfing.al;
import java.io.File;
import java.util.List;

public class fj extends ActivatedController implements fm {
    public fj(IFeature mFeature) {
        super(mFeature);
        setContentView(new fo(getContext(), new fk(this)));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        ((al) getContext().queryFeature(al.class)).mo2558n();
    }

    protected void onDeactive() {
        super.onDeactive();
        ((al) getContext().queryFeature(al.class)).mo2557m();
    }

    protected boolean onBack() {
        if (((fo) getContentView()).m9633a()) {
            return true;
        }
        return super.onBack();
    }

    /* renamed from: a */
    public void mo1693a(String str) {
        List a = ai.m3980a().m3881a(new File(str));
        if (!a.isEmpty()) {
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).openBook((C0800c) a.get(0));
        }
    }

    /* renamed from: a */
    public void mo1692a() {
        ((C0436e) AppContext.getAppContext(getContext()).queryFeature(C0436e.class)).pushPageSmoothly(new fy(getContext(), new fl(this)), null);
    }
}
