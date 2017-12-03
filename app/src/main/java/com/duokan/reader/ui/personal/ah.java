package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ui.general.iq;

class ah implements iq {
    final /* synthetic */ ae a;

    ah(ae aeVar) {
        this.a = aeVar;
    }

    public void a(int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            ActivatedController a = this.a.a(i);
            ActivatedController a2 = this.a.a(i2);
            this.a.deactivate(a);
            this.a.activate(a2);
        }
    }
}
