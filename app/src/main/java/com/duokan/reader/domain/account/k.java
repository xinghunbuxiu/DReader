package com.duokan.reader.domain.account;

import android.app.Activity;
import android.os.Bundle;

import com.duokan.core.app.IActivityLife;
import com.duokan.core.sys.TaskHandler;

class k implements IActivityLife {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        TaskHandler.postDelayed(new l(this), 300);
    }

    public void onActivityDestroyed(Activity activity) {
    }
}
