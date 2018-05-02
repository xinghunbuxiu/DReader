package com.duokan.reader.ui.general;

class js implements Runnable {
    final /* synthetic */ jq a;

    js(jq jqVar) {
        this.a = jqVar;
    }

    public void run() {
        if (this.a.f == this) {
            super.dismiss();
            this.a.f = null;
        }
    }
}
