package com.duokan.reader.domain.account;

import android.app.Activity;
import android.os.Bundle;

import com.duokan.core.app.a;
import com.duokan.core.sys.t;

class k implements a {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        t.a(new l(this), 300);
    }

    public void onActivityDestroyed(Activity activity) {
    }
}
