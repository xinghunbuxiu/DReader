package com.duokan.reader.ui.reading;

import android.content.Context;

import com.duokan.core.ui.bd;
import com.duokan.reader.ui.general.DkListView;

class np extends DkListView {
    final /* synthetic */ nk b;

    np(nk nkVar, Context context) {
        this.b = nkVar;
        super(context);
    }

    protected bd n() {
        bd n = super.n();
        n.setClipChildren(false);
        return n;
    }
}
