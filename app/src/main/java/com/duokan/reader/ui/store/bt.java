package com.duokan.reader.ui.store;

import com.duokan.reader.ui.general.ee;

class bt implements ee {
    /* renamed from: a */
    final /* synthetic */ br f11385a;

    bt(br brVar) {
        this.f11385a = brVar;
    }

    /* renamed from: a */
    public void mo2536a(int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            bl blVar = (bl) this.f11385a.f11381b.get(i2);
            this.f11385a.deactivate((bl) this.f11385a.f11381b.get(i));
            this.f11385a.activate(blVar);
            this.f11385a.mo2562a();
        }
    }
}
