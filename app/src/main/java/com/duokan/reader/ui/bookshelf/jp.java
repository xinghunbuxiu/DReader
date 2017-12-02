package com.duokan.reader.ui.bookshelf;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

import com.duokan.core.app.m;
import com.duokan.core.app.y;
import com.duokan.reader.common.a.b;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public abstract class jp extends gx {
    private final int a;
    protected final b c;
    protected final ConcurrentHashMap d;
    protected final BroadcastReceiver e;
    protected final BroadcastReceiver f;
    protected final BroadcastReceiver g;

    protected abstract void c();

    public jp(y yVar) {
        this(yVar, 12121);
    }

    public jp(y yVar, int i) {
        super(yVar);
        this.d = new ConcurrentHashMap();
        this.e = new jq(this);
        this.f = new jr(this);
        this.g = new js(this);
        this.c = new b(i);
        b(false);
        m mVar = (m) getActivity();
        this.a = mVar.getScreenTimeout();
        mVar.setScreenTimeout(Integer.MAX_VALUE);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        g();
    }

    protected void onDeactive() {
        super.onDeactive();
        h();
    }

    protected boolean onBack() {
        this.c.b();
        ((m) getActivity()).setScreenTimeout(this.a);
        return super.onBack();
    }

    protected String a(InputStream inputStream) {
        int i = 0;
        ArrayList arrayList = new ArrayList(1024);
        String str = "\r\n\r\n";
        int i2 = 0;
        while (i2 < "\r\n\r\n".length()) {
            char read = inputStream.read();
            if (read == '￿') {
                break;
            }
            arrayList.add(Byte.valueOf((byte) read));
            i2 = read == "\r\n\r\n".charAt(i2) ? i2 + 1 : 0;
        }
        byte[] bArr = new byte[arrayList.size()];
        while (i < arrayList.size()) {
            bArr[i] = ((Byte) arrayList.get(i)).byteValue();
            i++;
        }
        return new String(bArr, "utf-8");
    }

    protected void g() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addDataScheme("file");
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter2.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter2.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        intentFilter2.addDataScheme("file");
        getContext().registerReceiver(this.f, intentFilter);
        getContext().registerReceiver(this.g, intentFilter2);
        getContext().registerReceiver(this.e, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
    }

    protected void h() {
        getContext().unregisterReceiver(this.f);
        getContext().unregisterReceiver(this.g);
        getContext().unregisterReceiver(this.e);
    }
}
