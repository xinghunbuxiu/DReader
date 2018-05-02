package com.duokan.reader.common.p037c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;

import com.duokan.core.sys.UThread;
import com.duokan.core.sys.p025a.IPermissionsResultListener;
import com.duokan.core.sys.p025a.Permissions;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


public class C0559f extends BroadcastReceiver implements IPermissionsResultListener {

    static final boolean f1839a = (!C0559f.class.desiredAssertionStatus());

    private static C0559f f1840b = null;

    private final Context context;

    private final ConnectivityManager connectivityManager;

    private final CopyOnWriteArrayList<C0563j> f1843e = new CopyOnWriteArrayList();

    private boolean f1844f = false;

    private final CopyOnWriteArrayList<C0562i> f1845g = new CopyOnWriteArrayList();

    private long f1846h = 0;

    private boolean f1847i = false;

    protected C0559f(Context context) {
        this.context = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (f1839a || this.connectivityManager != null) {
            this.context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            Permissions.getInstance().addPermissionsResultListener(this);
            return;
        }
        throw new AssertionError();
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f1844f) {
            UThread.post(new C0560g(this));
        }
    }


    private void m2474a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            m2475a(z, currentTimeMillis);
        } else {
            UThread.postDelayed(new C0561h(this, z, currentTimeMillis), 5000);
        }
    }


    private void m2475a(boolean z, long j) {
        if (j > this.f1846h) {
            if (this.f1847i != z) {
                m2477f();
            }
            this.f1847i = z;
            this.f1846h = j;
        }
    }


    private void m2477f() {
        Iterator it = this.f1845g.iterator();
        while (it.hasNext()) {
            ((C0562i) it.next()).mo949a(this);
        }
    }


    public InetAddress getInetAddress() {
        WifiManager wifiManager = (WifiManager) this.context.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager == null) {
            return null;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        if (connectionInfo.getIpAddress() == 0) {
            return null;
        }
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (connectionInfo.getIpAddress() & 255), (byte) ((connectionInfo.getIpAddress() >> 8) & 255), (byte) ((connectionInfo.getIpAddress() >> 16) & 255), (byte) ((connectionInfo.getIpAddress() >> 24) & 255)});
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static void m2470a(Context context) {
        if (!f1839a && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new AssertionError();
        } else if (f1839a || f1840b == null) {
            f1840b = new C0559f(context);
        } else {
            throw new AssertionError();
        }
    }


    public static C0559f m2476b() {
        if (f1839a || f1840b != null) {
            return f1840b;
        }
        throw new AssertionError();
    }


    public boolean m2484c() {
        return m2486e() && !m2485d();
    }


    public boolean m2485d() {
        NetworkInfo networkInfo = this.connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }


    public boolean m2486e() {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }


    public void m2481a(C0563j c0563j) {
        if (c0563j != null) {
            this.f1843e.addIfAbsent(c0563j);
        }
    }


    public void m2483b(C0563j c0563j) {
        if (c0563j != null) {
            this.f1843e.remove(c0563j);
        }
    }


    public void m2480a(C0562i c0562i) {
        if (c0562i != null) {
            this.f1845g.addIfAbsent(c0562i);
        }
    }


    public void m2482b(C0562i c0562i) {
        if (c0562i != null) {
            this.f1845g.remove(c0562i);
        }
    }


    private void m2478g() {
        Iterator it = this.f1843e.iterator();
        while (it.hasNext()) {
            C0563j c0563j = (C0563j) it.next();
            if (f1839a || c0563j != null) {
                c0563j.onConnectivityChanged(this);
            } else {
                throw new AssertionError();
            }
        }
    }

    public void onSuccess() {
        this.f1844f = true;
        onReceive(this.context, null);
    }

    public void onFail() {
    }
}
