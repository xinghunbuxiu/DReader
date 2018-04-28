package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.ui.general.hp;

public class hk extends hp {
    /* renamed from: a */
    private an f6554a;
    /* renamed from: b */
    private cw f6555b = ((cw) AppContext.getAppContext(getContext()).queryFeature(cw.class));
    /* renamed from: c */
    private boolean f6556c;

    public hk(Context context, an anVar) {
        super(context);
        this.f6554a = anVar;
        m9766a(new ho(this, getContext()));
        this.f6556c = ReaderEnv.get().forHd();
    }
}
