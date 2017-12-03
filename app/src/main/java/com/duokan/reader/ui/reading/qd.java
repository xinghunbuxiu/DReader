package com.duokan.reader.ui.reading;

import com.duokan.core.sys.TaskHandler;

class qd implements Runnable {
    final /* synthetic */ qc a;

    qd(qc qcVar) {
        this.a = qcVar;
    }

    public void run() {
        TaskHandler.postDelayed(new qe(this), 500);
    }
}
