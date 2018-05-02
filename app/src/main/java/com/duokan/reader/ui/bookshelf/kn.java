package com.duokan.reader.ui.bookshelf;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.BaseActivity;
import com.duokan.reader.common.p034a.C0512b;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public abstract class kn extends he {
    /* renamed from: a */
    private final int f6675a;
    /* renamed from: c */
    protected final C0512b f6676c;
    /* renamed from: d */
    protected final ConcurrentHashMap<String, kr> f6677d;
    /* renamed from: e */
    protected final BroadcastReceiver f6678e;
    /* renamed from: f */
    protected final BroadcastReceiver f6679f;
    /* renamed from: g */
    protected final BroadcastReceiver f6680g;

    /* renamed from: e */
    protected abstract void mo1721e();

    public kn(IFeature mFeature) {
        this(mFeature, 12121);
    }

    public kn(IFeature mFeature, int i) {
        super(mFeature);
        this.f6677d = new ConcurrentHashMap();
        this.f6678e = new ko(this);
        this.f6679f = new kp(this);
        this.f6680g = new kq(this);
        this.f6676c = new C0512b(i);
        m9494b(false);
        BaseActivity mActivity = (BaseActivity) getActivity();
        this.f6675a = mActivity.getScreenTimeout();
        mActivity.setScreenTimeout(Integer.MAX_VALUE);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        m9879g();
    }

    protected void onDeactive() {
        super.onDeactive();
        m9880h();
    }

    protected boolean onBack() {
        this.f6676c.m2224b();
        ((BaseActivity) getActivity()).setScreenTimeout(this.f6675a);
        return super.onBack();
    }

    /* renamed from: a */
    protected String m9877a(InputStream inputStream) {
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

    /* renamed from: g */
    protected void m9879g() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addDataScheme("file");
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter2.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter2.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        intentFilter2.addDataScheme("file");
        getContext().registerReceiver(this.f6679f, intentFilter);
        getContext().registerReceiver(this.f6680g, intentFilter2);
        getContext().registerReceiver(this.f6678e, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
    }

    /* renamed from: h */
    protected void m9880h() {
        getContext().unregisterReceiver(this.f6679f);
        getContext().unregisterReceiver(this.f6680g);
        getContext().unregisterReceiver(this.f6678e);
    }
}
