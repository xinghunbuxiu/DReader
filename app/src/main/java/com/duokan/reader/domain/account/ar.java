package com.duokan.reader.domain.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ar extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ MiAccount f2370a;

    ar(MiAccount miAccount) {
        this.f2370a = miAccount;
    }

    public void onReceive(Context context, Intent intent) {
        this.f2370a.m3192y();
    }
}
