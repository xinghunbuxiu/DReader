package com.duokan.reader.domain.cloud.push;

class ad implements Runnable {
    /* renamed from: a */
    final /* synthetic */ DkCloudPushMessage f4098a;
    /* renamed from: b */
    final /* synthetic */ C0880y f4099b;

    ad(C0880y c0880y, DkCloudPushMessage dkCloudPushMessage) {
        this.f4099b = c0880y;
        this.f4098a = dkCloudPushMessage;
    }

    public void run() {
        if (this.f4099b.f4169j != null) {
            this.f4099b.f4169j.mo1176a(this.f4098a);
        }
    }
}
