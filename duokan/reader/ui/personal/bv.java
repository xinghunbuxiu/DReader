package com.duokan.reader.ui.personal;

import com.duokan.reader.ui.general.dj;

class bv implements dj {
    final /* synthetic */ bo a;
    final /* synthetic */ bu b;

    bv(bu buVar, bo boVar) {
        this.b = buVar;
        this.a = boVar;
    }

    public boolean onBack() {
        this.b.dismiss();
        return true;
    }
}
