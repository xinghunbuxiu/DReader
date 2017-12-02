package com.duokan.reader.ui.reading;

import com.duokan.core.sys.t;

class qd implements Runnable {
    final /* synthetic */ qc a;

    qd(qc qcVar) {
        this.a = qcVar;
    }

    public void run() {
        t.a(new qe(this), 500);
    }
}
