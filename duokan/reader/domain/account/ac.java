package com.duokan.reader.domain.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ac extends BroadcastReceiver {
    final /* synthetic */ MiAccount a;

    ac(MiAccount miAccount) {
        this.a = miAccount;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.z();
    }
}
