package com.duokan.reader.ui.bookshelf;

import android.content.Context;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.ui.general.ia;

public class hd extends ia {
    private an a;
    private cr b = ((cr) MyContextWrapper.getFeature(getContext()).queryFeature(cr.class));
    private boolean c;

    public hd(Context context, an anVar) {
        super(context);
        this.a = anVar;
        a(new hh(this, getContext()));
        this.c = ReaderEnv.get().forHd();
    }
}
