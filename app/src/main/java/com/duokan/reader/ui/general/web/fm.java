package com.duokan.reader.ui.general.web;

class fm implements Runnable {
    final /* synthetic */ fk a;

    fm(fk fkVar) {
        this.a = fkVar;
    }

    public void run() {
        this.a.f.b.pageController.web_notifyWeb(this.a.e, 0, "operation", Integer.valueOf(0));
    }
}
