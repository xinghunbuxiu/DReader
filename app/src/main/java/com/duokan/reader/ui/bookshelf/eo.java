package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.ViewGroup;
import com.duokan.core.ui.aj;
import com.duokan.reader.domain.bookshelf.an;

class eo extends aj {
    /* renamed from: a */
    final /* synthetic */ ek f6398a;

    private eo(ek ekVar) {
        this.f6398a = ekVar;
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f6398a.f6393g.size() + 1;
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        if (i < 0 || i >= this.f6398a.f6393g.size()) {
            return null;
        }
        return this.f6398a.f6393g.get(i);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        an anVar = (an) mo509d(i);
        if (anVar == null) {
            return new C1282a(this.f6398a.getContext());
        }
        if (view == null || (view instanceof C1282a)) {
            view = new de(this.f6398a.getContext());
        } else {
            view = (de) view;
        }
        view.setItemData(anVar);
        return view;
    }
}
