package com.duokan.reader.ui.store;

import com.duokan.reader.ui.general.ef;

class bt implements ef {
    final /* synthetic */ br a;

    bt(br brVar) {
        this.a = brVar;
    }

    public void a(int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            bl blVar = (bl) this.a.b.get(i2);
            this.a.deactivate((bl) this.a.b.get(i));
            this.a.activate(blVar);
            this.a.a();
        }
    }
}
