package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.cloud.push.b;

class ix implements OnClickListener {
    final /* synthetic */ it a;

    ix(it itVar) {
        this.a = itVar;
    }

    public void onClick(View view) {
        boolean z;
        b a = b.a();
        if (ReaderEnv.get().getReceivePushes()) {
            z = false;
        } else {
            z = true;
        }
        a.a(z, new iy(this));
        this.a.a();
    }
}
