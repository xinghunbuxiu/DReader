package com.duokan.p022a;

import android.content.Context;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.statistics.C1163a;
import com.mipay.sdk.Mipay;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import org.apache.http.HttpHost;
import org.json.JSONObject;


public class C0236a extends WebSession {
    
    Context context;

    public C0236a(Context context) {
        this.context = context;
    }

    protected void onSessionTry() {
        m538a();
        m541b();
        m542c();
        m539a("www.baidu.com", false, false);
        m539a("www.duokan.com", true, true);
        m539a("account.xiaomi.com", true, true);
        m539a("mibi.mi.com", true, true);
        m539a("book.read.duokan.com", false, true);
        m539a("cover.read.duokan.com", false, true);
        m539a("image.read.duokan.com", false, true);
        m544d();
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }

    
    protected void m538a() {
        if (!shouldBreak() && DkApp.get().forCommunity()) {
            m535a("--- profile ---", new Object[0]);
            m535a("app load time: " + C1163a.m8627k().m8661g(), new Object[0]);
            m535a("app OnItemLongPressListener-init time: " + C1163a.m8627k().m8662h(), new Object[0]);
            m535a("app ui-init time: " + C1163a.m8627k().m8663i(), new Object[0]);
            m535a("app startup time: " + C1163a.m8627k().m8664j(), new Object[0]);
            m535a("", new Object[0]);
        }
    }

    
    protected void m539a(String str, boolean z, boolean z2) {
        m535a("--- %s ---", str);
        String b = m540b(str);
        int a = m537a(str, false);
        if (z) {
            m537a(str, true);
        }
        if (a < 0 && z2) {
            m543c(b);
        }
        m535a("", new Object[0]);
    }

    
    protected void m541b() {
        if (!shouldBreak()) {
            m535a("--- client ip ---", new Object[0]);
            try {
                Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            m535a("%s : %s", r0.getDisplayName(), inetAddress.getHostAddress().toString());
                        }
                    }
                }
            } catch (Exception e) {
                m535a("getNetworkInterfaces failed", new Object[0]);
                m534a(e);
            }
            if (!shouldBreak()) {
                try {
                    String c = new C0237c(this).m553c("http://duokan.com/report/remote_ip");
                    m535a("remote: %s", c);
                } catch (Exception e2) {
                    m535a("failed", new Object[0]);
                    m534a(e2);
                }
                m535a("", new Object[0]);
            }
        }
    }

    
    protected void m542c() {
        if (!shouldBreak()) {
            m535a("--- time ---", new Object[0]);
            m535a("device: %d", Long.valueOf(System.currentTimeMillis() / 1000));
            if (!shouldBreak()) {
                try {
                    String c = new C0237c(this).m553c("http://duokan.com/report/time");
                    m535a("remote: %s", c);
                } catch (Exception e) {
                    m535a("remote: failed", new Object[0]);
                    m534a(e);
                }
                m535a("", new Object[0]);
            }
        }
    }

    
    protected int m537a(String str, boolean z) {
        String str2 = z ? "https" : HttpHost.DEFAULT_SCHEME_NAME;
        try {
            C0237c c0237c = new C0237c(this);
            m535a("%s ... %d", str2.toUpperCase(), Integer.valueOf(m536a(String.format("%s://%s/", new Object[]{str2, str}))));
            return m536a(String.format("%s://%s/", new Object[]{str2, str}));
        } catch (Exception e) {
            m535a("%s ... failed", str2.toUpperCase());
            m534a(e);
            return -1;
        }
    }

    
    protected int m536a(String str) {
        return execute(new C0626c().m2856b(str).m2851a()).mo812a();
    }

    
    protected String m540b(String str) {
        String str2 = null;
        if (!shouldBreak()) {
            try {
                str2 = InetAddress.getByName(str).getHostAddress();
                m535a("%s ==> %s", str, str2);
            } catch (Exception e) {
                m535a("can't resolve host %s", str);
                m534a(e);
            }
        }
        return str2;
    }

    
    protected void m543c(String str) {
        if (str != null && str.length() != 0 && !shouldBreak()) {
            m535a("traceroute %s", str);
            String str2 = "ping -W 5 -c 1 -t %d %s";
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
                            m535a("route %03d: %s", Integer.valueOf(i), obj);
                            str3 = readLine;
                        }
                    }
                    exec.waitFor();
                    bufferedReader.close();
                    if (str3.contains(str)) {
                        m535a("traceroute done", new Object[0]);
                        return;
                    } else if (str3.length() == 0) {
                        m535a("cannot reach host %s", str);
                        return;
                    } else {
                        i++;
                    }
                } catch (Exception e) {
                    m534a(e);
                } catch (Exception e2) {
                    m534a(e2);
                }
            }
        }
    }

    
    protected void m544d() {
        if (!shouldBreak()) {
            m535a("--- account ---", new Object[0]);
            C0709k a = C0709k.m3476a();
            if (a.m3507c()) {
                C0672a d = a.m3508d();
                String b = d.mo832b();
                d.mo834d();
                ReaderEnv.get().getAppId();
                ReaderEnv.get().getDeviceId();
                ReaderEnv.get().getVersionCode();
                m535a(b, new Object[0]);
                C0238b c0238b = new C0238b(this, this, d);
                int i = -1;
                try {
                    String str = "unknown";
                    JSONObject a2 = c0238b.m566a();
                    if (a2 != null) {
                        if (a2.has(Mipay.KEY_RESULT)) {
                            i = a2.getInt(Mipay.KEY_RESULT);
                        }
                        if (a2.has("msg")) {
                            str = a2.getString("msg");
                        }
                    }
                    m535a("%d: %s", Integer.valueOf(i), str);
                } catch (Exception e) {
                    m534a(e);
                }
            } else {
                m535a("no login", new Object[0]);
            }
            m535a("", new Object[0]);
        }
    }

    
    private void m535a(String str, Object... objArr) {
        if (!shouldBreak()) {
            if (objArr.length == 0) {
                publishProgress(str);
            } else {
                publishProgress(String.format(str, objArr));
            }
        }
    }

    
    private void m534a(Exception exception) {
        m535a(exception.toString(), new Object[0]);
    }
}
