package com.duokan.reader.ui.reading;

import com.duokan.core.sys.TaskHandler;

class um implements Runnable {
    final /* synthetic */ ul a;

    um(ul ulVar) {
        this.a = ulVar;
    }

    public void run() {
        TaskHandler.postDelayed(new un(this), 500);
    }
}
