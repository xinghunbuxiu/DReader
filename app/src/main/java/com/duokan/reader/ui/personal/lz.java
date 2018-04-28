package com.duokan.reader.ui.personal;

import com.duokan.reader.ui.general.dj;

class lz implements dj {
    /* renamed from: a */
    final /* synthetic */ ly f8918a;

    lz(ly lyVar) {
        this.f8918a = lyVar;
    }

    public boolean onBack() {
        if (this.f8918a.f8915a == null || !this.f8918a.f8915a.m11529j()) {
            return this.f8918a.requestDetach();
        }
        return true;
    }
}
