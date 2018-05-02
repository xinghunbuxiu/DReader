package com.duokan.reader.domain.cloud.push;

class ae implements Runnable {
    final /* synthetic */ DkCloudPushMessage a;
    final /* synthetic */ z b;

    ae(z zVar, DkCloudPushMessage dkCloudPushMessage) {
        this.b = zVar;
        this.a = dkCloudPushMessage;
    }

    public void run() {
        if (this.b.j != null) {
            this.b.j.a(this.a);
        }
    }
}
