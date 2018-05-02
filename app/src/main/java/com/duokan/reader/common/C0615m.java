package com.duokan.reader.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.duokan.reader.common.m */
public class C0615m extends BroadcastReceiver implements ai {
    /* renamed from: a */
    private static final aj<C0615m> f2038a = new aj();
    /* renamed from: b */
    private final Context f2039b;
    /* renamed from: c */
    private boolean f2040c = true;
    /* renamed from: d */
    private final LinkedList<C0585n> f2041d = new LinkedList();

    protected C0615m(Context context) {
        this.f2039b = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        this.f2039b.registerReceiver(this, intentFilter);
    }

    public void onReceive(Context context, Intent intent) {
        if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
            this.f2040c = true;
            m2801c();
        } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
            this.f2040c = false;
            m2801c();
        }
    }

    /* renamed from: a */
    public static void m2800a(Context context) {
        f2038a.m709a(new C0615m(context));
    }

    /* renamed from: a */
    public static C0615m m2799a() {
        return (C0615m) f2038a.m707a();
    }

    /* renamed from: b */
    public boolean m2803b() {
        return this.f2040c;
    }

    /* renamed from: a */
    public void m2802a(C0585n c0585n) {
        this.f2041d.add(c0585n);
    }

    /* renamed from: c */
    private void m2801c() {
        Iterator it = this.f2041d.iterator();
        while (it.hasNext()) {
            ((C0585n) it.next()).mo779a();
        }
    }
}
