package com.duokan.reader.common.webservices.duokan;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.classc;

public final class p {
    static final /* synthetic */ boolean a;
    private static final String[] b = new String[]{"117.144.232.7", "117.144.232.9"};
    private static p c = null;
    private final ReaderEnv d;
    private int e = 1;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private String l = null;
    private String m = null;
    private String n = null;
    private String o = null;
    private String p = null;
    private String q = null;
    private String r = null;
    private String s = null;
    private String t = null;
    private String u = null;
    private String v = null;
    private String w = null;
    private String x = null;
    private String y = null;
    private final classc.ConnectivityReceiver z;

    static {
        boolean z;
        if (p.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        a = z;
    }

    private p(ReaderEnv readerEnv, classc.ConnectivityReceiver connectivity) {
        this.d = readerEnv;
        this.z = connectivity;
        this.e = this.d.getPrefInt(PrivatePref.STORE, "server_config_key", 1);
        a(this.e);
    }

    public String a() {
        return Q() + "/phone/";
    }

    public String b() {
        return m("/hs/market/comic");
    }

    public String c() {
        return m("/hs/market/fiction");
    }

    public String d() {
        return m("/hs/market/publish");
    }

    public String e() {
        return m("/hs/market/category");
    }

    public String f() {
        return m("/hs/market/search_startup");
    }

    public String a(String str, String str2) {
        return m("/hs/search/" + Uri.encode(str) + (TextUtils.isEmpty(str2) ? "" : "?from=" + str2));
    }

    public final String a(String str) {
        return m("/hs/user/v4/task" + l(str));
    }

    public final String b(String str) {
        return m("/hs/user/cart" + l(str));
    }

    public final String c(String str) {
        if (c.m(str)) {
            return m("/hs/book/catalog/fiction/" + str);
        }
        return m("/hs/book/catalog/comic/" + str);
    }

    public final String g() {
        return this.y;
    }

    public final String a(String[] strArr) {
        String str = "/subtle/event/share/dist/index.html#page=book&id=";
        str = "/subtle/event/share/dist/index.html#page=list&id=";
        str = T() + this.p + (strArr.length == 1 ? "/subtle/event/share/dist/index.html#page=book&id=" : "/subtle/event/share/dist/index.html#page=list&id=");
        String str2 = str;
        for (String str3 : strArr) {
            str2 = str2 + str3 + ",";
        }
        return str2.substring(0, str2.length() - 1);
    }

    public final String h() {
        return T() + "www.duokan.com/download/";
    }

    public static void a(ReaderEnv readerEnv, classc.ConnectivityReceiver connectivity) {
        if (a || c == null) {
            c = new p(readerEnv, connectivity);
            return;
        }
        throw new AssertionError();
    }

    public static p i() {
        if (a || c != null) {
            return c;
        }
        throw new AssertionError();
    }

    public void j() {
        if (this.z.e()) {
            new q(this).open();
        }
    }

    public Pair b(String[] strArr) {
        if (!this.z.e() || strArr.length == 0) {
            return null;
        }
        for (String str : strArr) {
            if (str.contains("market.mi-img.com") || str.contains("market.xiaomi.com")) {
                return new Pair(str, g(str, P()));
            }
        }
        return null;
    }

    public boolean k() {
        return this.e == 1;
    }

    public boolean l() {
        return !k();
    }

    public void a(int i) {
        this.e = i;
        switch (this.e) {
            case 2:
                this.p = "www.n.duokan.com";
                this.f = "www.n.duokan.com/sync";
                this.g = "www.n.duokan.com";
                this.h = "www.n.duokan.com/store/v0";
                this.i = "www.n.duokan.com/dk_id/api";
                this.j = "apps.n.duokan.com";
                this.k = "www.n.duokan.com/message/v0";
                this.l = "www.n.duokan.com/push/v0";
                this.m = "www.n.duokan.com/dk_id/api/xiaomi_web_reg";
                this.n = "login.dushu.xiaomi.com/android-client-login";
                this.o = "www.n.duokan.com/dk_id/api/exchange";
                this.q = "http://www.n.duokan.com/pictures4";
                this.r = "http://www.n.duokan.com/promotion_day";
                this.s = "http://10.232.46.34/";
                this.t = "http://www.miui.com/api.php?mod=dkfeedback";
                this.u = "http://update.n.duokan.com/DuoKanServer/servlet/android";
                this.v = "http://api.MyTask.xiaomi.com";
                this.w = "http://api.MyTask.xiaomi.com/u/api";
                this.y = "http://www.n.duokan.com/extra/v0/font";
                return;
            case 3:
                this.p = "www.in.duokan.com";
                this.f = "www.in.duokan.com/sync";
                this.g = "www.in.duokan.com";
                this.h = "www.in.duokan.com/store/v0";
                this.i = "www.in.duokan.com/dk_id/api";
                this.j = "apps.in.duokan.com";
                this.k = "www.in.duokan.com/message/v0";
                this.l = "www.in.duokan.com/push/v0";
                this.m = "www.in.duokan.com/dk_id/api/xiaomi_web_reg";
                this.n = "login.dushu.xiaomi.com/android-client-login";
                this.o = "www.in.duokan.com/dk_id/api/exchange";
                this.q = "http://www.in.duokan.com/pictures4";
                this.r = "http://www.in.duokan.com/promotion_day";
                this.s = "http://faq.in.duokan.com/";
                this.t = "http://10.105.20.20:8080/api.php?mod=dkfeedback";
                this.u = "http://update.in.duokan.com/DuoKanServer/servlet/android";
                this.v = "http://api.MyTask.xiaomi.com";
                this.w = "http://api.MyTask.xiaomi.com/u/api";
                this.y = "http://www.in.duokan.com/extra/v0/font";
                return;
            default:
                this.p = "www.duokan.com";
                this.f = "www.duokan.com/sync";
                this.g = "www.duokan.com";
                this.h = "www.duokan.com/store/v0";
                this.i = "www.duokan.com/dk_id/api";
                this.j = "apps.duokan.com";
                this.k = "www.duokan.com/message/v0";
                this.l = "www.duokan.com/push/v0";
                this.m = "www.duokan.com/dk_id/api/xiaomi_web_reg";
                this.n = "login.dushu.xiaomi.com/android-client-login";
                this.o = "www.duokan.com/dk_id/api/exchange";
                this.q = "http://www.duokan.com/pictures4";
                this.r = "http://www.duokan.com/promotion_day";
                this.s = "http://dkfaq_v2.setDrawable.xiaomi.com/";
                this.t = "http://www.miui.com/api.php?mod=dkfeedback";
                this.u = "http://update.duokan.com/DuoKanServer/servlet/android";
                this.v = "http://api.MyTask.xiaomi.com";
                this.w = "http://api.MyTask.xiaomi.com/u/api";
                this.y = "http://www.duokan.com/extra/v0/font";
                return;
        }
    }

    public int m() {
        return this.e;
    }

    public String n() {
        return this.p;
    }

    public String o() {
        return this.f;
    }

    public String p() {
        return this.g;
    }

    public String q() {
        return this.h;
    }

    public String r() {
        return this.i;
    }

    public String s() {
        return this.k;
    }

    public String t() {
        return this.l;
    }

    public String u() {
        return this.o;
    }

    public String v() {
        return this.q;
    }

    public String w() {
        return this.r;
    }

    public String x() {
        return this.u;
    }

    public String y() {
        Object S = S();
        return !TextUtils.isEmpty(S) ? S : this.p;
    }

    public String z() {
        return Q();
    }

    public String b(String str, String str2) {
        return z() + "/hs/market/fiction_topic/" + str + l(str2);
    }

    public final String c(String str, String str2) {
        return z() + "/hs/market/topic/" + str + l(str2);
    }

    public final synchronized String d(String str, String str2) {
        return z() + "/hs/market/eagle/" + str + l(str2);
    }

    public final synchronized String e(String str, String str2) {
        return z() + "/hs/market/author/" + str + l(str2);
    }

    public final String d(String str) {
        return z() + "/hs/market/right/" + str;
    }

    public final String a(String str, int i, String str2, String str3) {
        return z() + "/hs/book/" + str + "?source=" + i + "&source_id=" + str2 + "&native_immersive=1&_t=" + str3;
    }

    public final String e(String str) {
        return z() + "/hs/store/free" + l(str);
    }

    public final String f(String str) {
        return z() + "/hs/store/discount" + l(str);
    }

    public final String A() {
        return z() + "/phone/#path=/hs/user/award/virtual&invalid=0";
    }

    public final String B() {
        return z() + "/phone/#path=/hs/user/v4/coin";
    }

    public final String C() {
        return z() + "/phone/#path=/hs/user/award/real&invalid=0";
    }

    public final synchronized String f(String str, String str2) {
        return z() + "/phone/#path=/hs/market/reward&native_transparent=1&id=" + str + "&_t=" + str2;
    }

    public final synchronized String D() {
        return z() + "/phone/#path=/hs/market/recharge&native_transparent=1";
    }

    public final String E() {
        return z() + "/phone/#path=/hs/market/subscribeList";
    }

    public final String g(String str) {
        return z() + "/hs/feed/" + str;
    }

    public final String F() {
        return z() + "/phone/#path=/hs/user/feed";
    }

    public final String G() {
        return z() + "/phone/#path=/hs/user/feed_collect";
    }

    public final String h(String str) {
        return z() + "/hs/comment/feed/" + str;
    }

    public final String i(String str) {
        return z() + "/hs/comment/book/" + str;
    }

    public final String j(String str) {
        return z() + "/hs/comment/detail/" + str;
    }

    public final String H() {
        return z() + "/phone/#path=/hs/user/wish";
    }

    public String I() {
        return z() + "/phone/#path=/hs/user/note";
    }

    public String J() {
        return z() + "/phone/#path=/hs/user/experience";
    }

    public final String K() {
        return z() + "/phone/#path=/hs/market/retroactive&native_transparent=1&native_pullrefresh=0";
    }

    public final String L() {
        return z() + "/phone/#path=/hs/user/merge&native_transparent=1";
    }

    public final String M() {
        return z() + "/dk_id/api/wx/login";
    }

    public final String N() {
        return this.s;
    }

    public final String O() {
        return this.t;
    }

    private String l(String str) {
        return TextUtils.isEmpty(str) ? "" : "?track=" + str;
    }

    public void k(String str) {
        this.d.setPrefString(PrivatePref.STORE, "server_config_url", str);
        this.d.commitPrefs();
    }

    private String m(String str) {
        return a.a(a.a(Q() + "/phone/"), "path=" + str).toString();
    }

    private String Q() {
        return T() + R();
    }

    private String R() {
        Object S = S();
        return !TextUtils.isEmpty(S) ? S : this.p;
    }

    private String S() {
        if (k() || TextUtils.isEmpty(this.d.getPrefString(PrivatePref.STORE, "server_config_url", ""))) {
            return "";
        }
        String prefString = this.d.getPrefString(PrivatePref.STORE, "server_config_url", "");
        if (prefString.startsWith("http://")) {
            return prefString.substring("http://".length());
        }
        if (prefString.startsWith("https://")) {
            return prefString.substring("https://".length());
        }
        return prefString;
    }

    private String T() {
        return k() ? "https://" : "http://";
    }

    public String P() {
        String[] strArr;
        if (this.z.d()) {
            strArr = (String[]) this.d.getMarketCDNIpOnWifi().toArray(new String[0]);
        } else {
            strArr = (String[]) this.d.getMarketCDNIpOnWap().toArray(new String[0]);
        }
        if (strArr.length > 0) {
            return strArr[(int) (Math.random() * ((double) strArr.length))];
        }
        return b[(int) (Math.random() * ((double) b.length))];
    }

    private String g(String str, String str2) {
        boolean z;
        boolean z2 = true;
        WebLog c = WebLog.c();
        if (TextUtils.isEmpty(str)) {
            z = false;
        } else {
            z = true;
        }
        c.b(z);
        WebLog c2 = WebLog.c();
        if (TextUtils.isEmpty(str2)) {
            z2 = false;
        }
        c2.b(z2);
        return str.replace(Uri.parse(str).getEncodedAuthority(), str2);
    }
}
