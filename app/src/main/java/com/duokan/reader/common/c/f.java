package com.duokan.reader.common.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;

import com.duokan.core.diagnostic.LogLevel;

import java.net.InetAddress;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class f extends BroadcastReceiver {
    static final /* synthetic */ boolean a = (!f.class.desiredAssertionStatus());
    private static f b = null;
    private final Context c;
    private final ConnectivityManager d;
    private final CopyOnWriteArrayList e = new CopyOnWriteArrayList();

    protected f(Context context) {
        this.c = context;
        this.d = (ConnectivityManager) context.getSystemService("connectivity");
        if (a || this.d != null) {
            this.c.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            return;
        }
        throw new AssertionError();
    }

    public void onReceive(Context context, Intent intent) {
        if (!e()) {
            a.c().c(LogLevel.EVENT, "net", "network disconnected");
        } else if (d()) {
            a.c().c(LogLevel.EVENT, "net", "network connected(wifi)");
        } else {
            a.c().c(LogLevel.EVENT, "net", "network connected(mobile)");
        }
        f();
    }

    public InetAddress a() {
        WifiManager wifiManager = (WifiManager) this.c.getSystemService("wifi");
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
        } catch (Throwable th) {
            return null;
        }
    }

    public static void a(Context context) {
        if (!a && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new AssertionError();
        } else if (a || b == null) {
            b = new f(context);
        } else {
            throw new AssertionError();
        }
    }

    public static f b() {
        if (a || b != null) {
            return b;
        }
        throw new AssertionError();
    }

    public boolean c() {
        return e() && !d();
    }

    public boolean d() {
        NetworkInfo networkInfo = this.d.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public boolean e() {
        NetworkInfo activeNetworkInfo = this.d.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.e.addIfAbsent(gVar);
        }
    }

    public void b(g gVar) {
        if (gVar != null) {
            this.e.remove(gVar);
        }
    }

    private void f() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (a || gVar != null) {
                gVar.onConnectivityChanged(this);
            } else {
                throw new AssertionError();
            }
        }
    }
}
