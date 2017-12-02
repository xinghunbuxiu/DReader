package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.e;
import com.duokan.core.app.x;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.surfing.af;

import java.io.File;
import java.util.List;

public class fc extends e implements ff {
    public fc(y yVar) {
        super(yVar);
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
        ((com.duokan.reader.ui.e) x.a(getContext()).queryFeature(com.duokan.reader.ui.e.class)).pushPageSmoothly(new fr(getContext(), new fe(this)), null);
    }
}
