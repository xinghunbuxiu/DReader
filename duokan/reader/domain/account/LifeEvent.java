package com.duokan.reader.domain.account;

import android.app.Activity;
import android.os.Bundle;

import com.duokan.core.app.IActivityLife;
import com.duokan.core.sys.TaskHandler;

class LifeEvent implements IActivityLife {
    final i a;

    LifeEvent(i iVar) {
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
//    class l implements Runnable {
//        final /* synthetic */ LifeEvent parse;
//
//        l(LifeEvent kVar) {
//            this.parse = kVar;
//        }
//
//        public void run() {
//            Resp resp = new Resp();
//            resp.code = null;
//            this.parse.parse.parse(resp);
//        }
//    }

}
