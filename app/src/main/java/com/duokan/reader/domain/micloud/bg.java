package com.duokan.reader.domain.micloud;

import android.content.Context;

import com.duokan.reader.common.async.work.k;
import com.duokan.reader.common.async.work.q;

import java.util.concurrent.ThreadPoolExecutor;

public abstract class bg extends k {
    private final String a;
    private final String b;

    public bg(Context context, String str, String str2, q qVar, ThreadPoolExecutor threadPoolExecutor) {
        super(context, qVar, threadPoolExecutor);
        this.a = str;
        this.b = str2;
    }

    public final String j() {
        return this.a;
    }

    public final String k() {
        return this.b;
    }
}
