package com.duokan.reader.ui.personal;

import com.duokan.reader.ui.general.dj;

class ll implements dj {
    final /* synthetic */ lk a;

    ll(lk lkVar) {
        this.a = lkVar;
    }

    public boolean onBack() {
        if (this.a.a == null || !this.a.a.j()) {
            return this.a.requestDetach();
        }
        return true;
    }
}
