package com.duokan.reader.domain.document.p045a;

/* renamed from: com.duokan.reader.domain.document.a.aa */
class aa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0926w f4223a;

    aa(C0926w c0926w) {
        this.f4223a = c0926w;
    }

    public void run() {
        this.f4223a.f4389k = true;
        if (this.f4223a.f4387i.m5807c()) {
            this.f4223a.m6221d();
            this.f4223a.f4388j = false;
        } else if (this.f4223a.m6203T() && this.f4223a.f4393o == null && this.f4223a.f4394p == null && !this.f4223a.m6149h().isEmpty()) {
            float h = this.f4223a.m6223e();
            this.f4223a.f4394p = this.f4223a.m6209a(this.f4223a.m6198O(), h);
        }
        if (this.f4223a.f4386h != null) {
            this.f4223a.f4386h.mo1221a(null, this.f4223a);
        }
        this.f4223a.invalidateSelf();
    }
}
