package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.ViewGroup;

import com.duokan.core.ui.aj;
import com.duokan.reader.domain.bookshelf.an;

class eh extends aj {
    final /* synthetic */ ec a;

    private eh(ec ecVar) {
        this.a = ecVar;
    }

    public int c() {
        return this.a.g.size() + 1;
    }

    public Object d(int i) {
        if (i < 0 || i >= this.a.g.size()) {
            return null;
        }
        return this.a.g.get(i);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        an anVar = (an) d(i);
        if (anVar == null) {
            return new a(this.a.getContext());
        }
        if (view == null || (view instanceof a)) {
            view = new cz(this.a.getContext());
        } else {
            view = (cz) view;
        }
        view.setItemData(anVar);
        return view;
    }
}
