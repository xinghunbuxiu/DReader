package com.duokan.reader.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;

import java.util.Iterator;
import java.util.LinkedList;

public class m extends BroadcastReceiver implements ah {
    private static final ai a = new ai();
    private final Context b;
    private boolean c = true;
    private final LinkedList d = new LinkedList();

    protected m(Context context) {
        this.b = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        this.b.registerReceiver(this, intentFilter);
    }

    public void onReceive(Context context, Intent intent) {
        if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
            this.c = true;
            c();
        } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
            this.c = false;
            c();
        }
    }

    public static void a(Context context) {
        a.a(new m(context));
    }

    public static m a() {
        return (m) a.a();
    }

    public boolean b() {
        return this.c;
    }

    public void a(n nVar) {
        this.d.add(nVar);
    }

    private void c() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((n) it.next()).a();
        }
    }
}
