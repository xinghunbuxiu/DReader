package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.InavOperater;
import com.duokan.reader.ui.surfing.af;

import java.io.File;
import java.util.List;

public class fc extends ActivatedController implements ff {
    public fc(IFeature featrue) {
        super(featrue);
        setContentView(new fh(getContext(), new fd(this)));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        ((af) getContext().queryFeature(af.class)).n();
    }

    protected void onDeactive() {
        super.onDeactive();
        ((af) getContext().queryFeature(af.class)).m();
    }

    protected boolean onBack() {
        if (((fh) getContentView()).a()) {
            return true;
        }
        return super.onBack();
    }

    public void a(String str) {
        List a = ai.a().a(new File(str));
        if (!a.isEmpty()) {
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).openBook((c) a.get(0));
        }
    }

    public void a() {
        ((InavOperater) MyContextWrapper.getFeature(getContext()).queryFeature(InavOperater.class)).pushPageSmoothly(new fr(getContext(), new fe(this)), null);
    }
}
