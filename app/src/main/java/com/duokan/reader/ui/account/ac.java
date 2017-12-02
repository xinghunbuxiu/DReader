package com.duokan.reader.ui.account;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderEnv;

class ac implements OnClickListener {
    final /* synthetic */ z a;

    ac(z zVar) {
        this.a = zVar;
    }

    public void onClick(View view) {
        ReaderEnv.get().setIsOnlyWifiSyncEvernote(!ReaderEnv.get().getIsOnlyWifiSyncEvernote());
        this.a.a();
    }
}
