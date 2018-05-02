package com.duokan.common;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build.VERSION;

@SuppressLint({"NewApi"})
/* renamed from: com.duokan.common.a */
public abstract class C0259a {
    /* renamed from: a */
    public static <Params, Progress, Result> void m568a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
    }
}
