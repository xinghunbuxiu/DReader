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
import com.duokan.core.diagnostic.WebLog;

import java.net.InetAddress;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectivityReceiver extends BroadcastReceiver {
    static final boolean assertionStatus = (!ConnectivityReceiver.class.desiredAssertionStatus());
    private static ConnectivityReceiver connectivityReceiver = null;
    private final Context context;
    private final ConnectivityManager connectivityManager;
    private final CopyOnWriteArrayList<IConnectChanged> connectChangeds = new CopyOnWriteArrayList();

    protected ConnectivityReceiver(Context context) {
        this.context = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (assertionStatus || this.connectivityManager != null) {
            this.context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            return;
        }
        throw new AssertionError();
    }

    public void onReceive(Context context, Intent intent) {
        if (!isNetConnected()) {
            WebLog.c().c(LogLevel.EVENT, "net", "network disconnected");
        } else if (isWifiConnected()) {
            WebLog.c().c(LogLevel.EVENT, "net", "network connected(wifi)");
        } else {
            WebLog.c().c(LogLevel.EVENT, "net", "network connected(mobile)");
        }
        notifyConnectChanged();
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
        } catch (Throwable th) {
            return null;
        }
    }

    public static void init(Context context) {
        if (!assertionStatus && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new AssertionError();
        } else if (assertionStatus || connectivityReceiver == null) {
            connectivityReceiver = new ConnectivityReceiver(context);
        } else {
            throw new AssertionError();
        }
    }

    /**
     * 获取当前连接监听
     *
     * @return
     */
    public static ConnectivityReceiver getConnectReceive() {
        if (assertionStatus || connectivityReceiver != null) {
            return connectivityReceiver;
        }
        throw new AssertionError();
    }

    public boolean isMobileConnect() {
        return isNetConnected() && !isWifiConnected();
    }

    public boolean isWifiConnected() {
        NetworkInfo networkInfo = this.connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public boolean isNetConnected() {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public void addConnectLister(IConnectChanged connectChanged) {
        if (connectChanged != null) {
            this.connectChangeds.addIfAbsent(connectChanged);
        }
    }

    public void removeConnectLister(IConnectChanged gVar) {
        if (gVar != null) {
            this.connectChangeds.remove(gVar);
        }
    }

    private void notifyConnectChanged() {
        Iterator<IConnectChanged> it = this.connectChangeds.iterator();
        while (it.hasNext()) {
            IConnectChanged connectChanged = it.next();
            if (assertionStatus || connectChanged != null) {
                connectChanged.onConnectivityChanged(this);
            } else {
                throw new AssertionError();
            }
        }
    }
}
