package com.duokan.core.ui;

import com.duokan.core.sys.AIdleOperation;

class ed implements Runnable {
    final ec a;

    ed(ec ecVar) {
        this.a = ecVar;
    }

    public void run() {
        if (this.a.view.requestFocus()) {
            AIdleOperation.addIdleStatus(new ee(this));
        }
    }
}
