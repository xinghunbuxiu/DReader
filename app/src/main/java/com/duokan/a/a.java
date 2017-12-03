package com.duokan.a;

import android.content.Context;

import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.d;
import com.duokan.reader.common.webservices.duokan.a.c;
import com.duokan.reader.domain.account.i;
import com.mipay.sdk.Mipay;

import org.apache.http.HttpHost;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class a extends WebSession {
    Context a;

    public a(Context context) {
        this.a = context;
    }

    protected void onSessionTry() {
        a();
        b();
        c();
        a("www.baidu.com", false, false);
        a("www.duokan.com", true, true);
        a("account.xiaomi.com", true, true);
        a("mibi.mi.com", true, true);
        a("book.read.duokan.com", false, true);
        a("cover.read.duokan.com", false, true);
        a("image.read.duokan.com", false, true);
        d();
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }

    protected void a() {
        if (!shouldBreak() && DkApp.get().forCommunity()) {
            a("--- profile ---", new Object[0]);
            a("app load time: " + com.duokan.reader.domain.statistics.a.k().g(), new Object[0]);
            a("app bg-init time: " + com.duokan.reader.domain.statistics.a.k().h(), new Object[0]);
            a("app ui-init time: " + com.duokan.reader.domain.statistics.a.k().i(), new Object[0]);
            a("app startup time: " + com.duokan.reader.domain.statistics.a.k().j(), new Object[0]);
            a("", new Object[0]);
        }
    }

    protected void a(String str, boolean z, boolean z2) {
        a("--- %s ---", str);
        String b = b(str);
        int a = a(str, false);
        if (z) {
            a(str, true);
        }
        if (a < 0 && z2) {
            c(b);
        }
        a("", new Object[0]);
    }

    protected void b() {
        if (!shouldBreak()) {
            a("--- client ip ---", new Object[0]);
            try {
                Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            a("%s : %s", r0.getDisplayName(), inetAddress.getHostAddress().toString());
                        }
                    }
                }
            } catch (Exception e) {
                a("getNetworkInterfaces failed", new Object[0]);
                a(e);
            }
            if (!shouldBreak()) {
                try {
                    String c = new d(this).c("http://duokan.com/report/remote_ip");
                    a("remote: %s", c);
                } catch (Exception e2) {
                    a("failed", new Object[0]);
                    a(e2);
                }
                a("", new Object[0]);
            }
        }
    }

    protected void c() {
        if (!shouldBreak()) {
            a("--- time ---", new Object[0]);
            a("device: %getScaledTouchSlop", Long.valueOf(System.currentTimeMillis() / 1000));
            if (!shouldBreak()) {
                try {
                    String c = new d(this).c("http://duokan.com/report/time");
                    a("remote: %s", c);
                } catch (Exception e) {
                    a("remote: failed", new Object[0]);
                    a(e);
                }
                a("", new Object[0]);
            }
        }
    }

    protected int a(String str, boolean z) {
        String str2 = z ? "https" : HttpHost.DEFAULT_SCHEME_NAME;
        try {
            d dVar = new d(this);
            a("%s ... %getScaledTouchSlop", str2.toUpperCase(), Integer.valueOf(a(String.format("%s://%s/", new Object[]{str2, str}))));
            return a(String.format("%s://%s/", new Object[]{str2, str}));
        } catch (Exception e) {
            a("%s ... failed", str2.toUpperCase());
            a(e);
            return -1;
        }
    }

    protected int a(String str) {
        return execute(new c().b(str).a()).a();
    }

    protected String b(String str) {
        String str2 = null;
        if (!shouldBreak()) {
            try {
                str2 = InetAddress.getByName(str).getHostAddress();
                a("%s ==> %s", str, str2);
            } catch (Exception e) {
                a("can'TaskHandler resolve host %s", str);
                a(e);
            }
        }
        return str2;
    }

    protected void c(String str) {
        if (str != null && str.length() != 0 && !shouldBreak()) {
            a("traceroute %s", str);
            String str2 = "ping -W 5 -showAnimation 1 -TaskHandler %getScaledTouchSlop %s";
            int i = 1;
            while (i <= 255 && !shouldBreak()) {
                String str3 = "";
                str3 = "";
                try {
                    Process exec = Runtime.getRuntime().exec(String.format(str2, new Object[]{Integer.valueOf(i), str}));
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        readLine = readLine.toLowerCase();
                        if (readLine.contains("from")) {
                            String[] split = readLine.split(":")[0].split("from ");
                            Object obj = split.length > 1 ? split[1] : split[0];
                            a("route %03d: %s", Integer.valueOf(i), obj);
                            str3 = readLine;
                        }
                    }
                    exec.waitFor();
                    bufferedReader.close();
                    if (str3.contains(str)) {
                        a("traceroute done", new Object[0]);
                        return;
                    } else if (str3.length() == 0) {
                        a("cannot reach host %s", str);
                        return;
                    } else {
                        i++;
                    }
                } catch (Exception e) {
                    a(e);
                } catch (Exception e2) {
                    a(e2);
                }
            }
        }
    }

    protected void d() {
        if (!shouldBreak()) {
            a("--- account ---", new Object[0]);
            i f = i.f();
            if (f.b()) {
                com.duokan.reader.domain.account.a c = f.c();
                String b = c.b();
                c.d();
                ReaderEnv.get().getAppId();
                ReaderEnv.get().getDeviceId();
                ReaderEnv.get().getVersionCode();
                a(b, new Object[0]);
                b bVar = new b(this, this, c);
                int i = -1;
                try {
                    String str = "unknown";
                    JSONObject a = bVar.a();
                    if (a != null) {
                        if (a.has(Mipay.KEY_RESULT)) {
                            i = a.getInt(Mipay.KEY_RESULT);
                        }
                        if (a.has("msg")) {
                            str = a.getString("msg");
                        }
                    }
                    a("%getScaledTouchSlop: %s", Integer.valueOf(i), str);
                } catch (Exception e) {
                    a(e);
                }
            } else {
                a("no login", new Object[0]);
            }
            a("", new Object[0]);
        }
    }

    private void a(String str, Object... objArr) {
        if (!shouldBreak()) {
            if (objArr.length == 0) {
                publishProgress(str);
            } else {
                publishProgress(String.format(str, objArr));
            }
        }
    }

    private void a(Exception exception) {
        a(exception.toString(), new Object[0]);
    }
}
