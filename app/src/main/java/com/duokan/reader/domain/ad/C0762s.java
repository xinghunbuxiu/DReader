package com.duokan.reader.domain.ad;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.miui.systemAdSolution.landingPage.ILandingPageService.Stub;

/* renamed from: com.duokan.reader.domain.ad.s */
class C0762s implements ServiceConnection {
    /* renamed from: a */
    final /* synthetic */ C0761r f2587a;

    C0762s(C0761r c0761r) {
        this.f2587a = c0761r;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2587a.f2585c = Stub.asInterface(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
