package com.duokan.reader.domain.ad;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.miui.systemAdSolution.landingPage.ILandingPageService.Stub;

class s implements ServiceConnection {
    final /* synthetic */ r a;

    s(r rVar) {
        this.a = rVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.c = Stub.asInterface(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
