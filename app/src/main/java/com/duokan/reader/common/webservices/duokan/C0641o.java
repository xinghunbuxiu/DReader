package com.duokan.reader.common.webservices.duokan;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.p027b.UrlTools;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.bookshelf.C0800c;

/* renamed from: com.duokan.reader.common.webservices.duokan.o */
public final class C0641o {
    /* renamed from: a */
    static final /* synthetic */ boolean f2145a;
    /* renamed from: b */
    private static final String[] f2146b = new String[]{"117.144.232.7", "117.144.232.9"};
    /* renamed from: c */
    private static C0641o f2147c = null;
    /* renamed from: A */
    private final C0559f f2148A;
    /* renamed from: d */
    private final ReaderEnv f2149d;
    /* renamed from: e */
    private int f2150e = 1;
    /* renamed from: f */
    private String f2151f = null;
    /* renamed from: g */
    private String f2152g = null;
    /* renamed from: h */
    private String f2153h = null;
    /* renamed from: i */
    private String f2154i = null;
    /* renamed from: j */
    private String f2155j = null;
    /* renamed from: k */
    private String f2156k = null;
    /* renamed from: l */
    private String f2157l = null;
    /* renamed from: m */
    private String f2158m = null;
    /* renamed from: n */
    private String f2159n = null;
    /* renamed from: o */
    private String f2160o = null;
    /* renamed from: p */
    private String f2161p = null;
    /* renamed from: q */
    private String f2162q = null;
    /* renamed from: r */
    private String f2163r = null;
    /* renamed from: s */
    private String f2164s = null;
    /* renamed from: t */
    private String f2165t = null;
    /* renamed from: u */
    private String f2166u = null;
    /* renamed from: v */
    private String f2167v = null;
    /* renamed from: w */
    private String f2168w = null;
    /* renamed from: x */
    private String f2169x = null;
    /* renamed from: y */
    private String f2170y = null;
    /* renamed from: z */
    private String f2171z = null;

    static {
        boolean z;
        if (C0641o.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f2145a = z;
    }

    private C0641o(ReaderEnv readerEnv, C0559f c0559f) {
        this.f2149d = readerEnv;
        this.f2148A = c0559f;
        this.f2150e = this.f2149d.getPrefInt(PrivatePref.STORE, "server_config_key", 1);
        m2959a(this.f2150e);
    }

    /* renamed from: a */
    public String m2952a() {
        return m2927P() + "/phone/";
    }

    /* renamed from: b */
    public String m2961b() {
        return m2936m("/hs/market/comic");
    }

    /* renamed from: c */
    public String m2964c() {
        return m2936m("/hs/market/fiction");
    }

    /* renamed from: d */
    public String m2967d() {
        return m2936m("/hs/market/publish");
    }

    /* renamed from: e */
    public String m2970e() {
        return m2936m("/hs/market/category");
    }

    /* renamed from: f */
    public String m2973f() {
        return m2936m("/hs/market/search_startup");
    }

    /* renamed from: a */
    public String m2955a(String str, String str2) {
        return m2936m("/hs/search/" + Uri.encode(str) + (TextUtils.isEmpty(str2) ? "" : "?from=" + str2));
    }

    /* renamed from: a */
    public final String m2957a(boolean z, String str) {
        return m2936m("/hs/user/v4/task" + (z ? "" : "&no_checkin=1") + m2935l(str));
    }

    /* renamed from: a */
    public final String m2953a(String str) {
        return m2936m("/hs/user/ad-wall" + m2935l(str));
    }

    /* renamed from: b */
    public final String m2962b(String str) {
        return m2936m("/hs/user/cart" + m2935l(str));
    }

    /* renamed from: c */
    public final String m2965c(String str) {
        if (C0800c.m4142n(str)) {
            return m2936m("/hs/book/catalog/fiction/" + str);
        }
        return m2936m("/hs/book/catalog/comic/" + str);
    }

    /* renamed from: g */
    public final String m2976g() {
        return this.f2170y;
    }

    /* renamed from: a */
    public final String m2958a(String[] strArr) {
        String str = "/subtle/event/share/dist/index.html#page=book&id=";
        str = "/subtle/event/share/dist/index.html#page=list&id=";
        str = m2930S() + this.f2161p + (strArr.length == 1 ? "/subtle/event/share/dist/index.html#page=book&id=" : "/subtle/event/share/dist/index.html#page=list&id=");
        String str2 = str;
        for (String str3 : strArr) {
            str2 = str2 + str3 + ",";
        }
        return str2.substring(0, str2.length() - 1);
    }

    /* renamed from: h */
    public final String m2978h() {
        return m2930S() + "www.duokan.com/download/";
    }

    /* renamed from: a */
    public static void m2932a(ReaderEnv readerEnv, C0559f c0559f) {
        if (f2145a || f2147c == null) {
            f2147c = new C0641o(readerEnv, c0559f);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: i */
    public static C0641o m2934i() {
        if (f2145a || f2147c != null) {
            return f2147c;
        }
        throw new AssertionError();
    }

    /* renamed from: j */
    public void m2982j() {
        if (this.f2148A.m2486e()) {
            new C0642p(this).open();
        }
    }

    /* renamed from: b */
    public Pair<String, String> m2960b(String[] strArr) {
        if (!this.f2148A.m2486e() || strArr.length == 0) {
            return null;
        }
        for (String str : strArr) {
            if (str.contains("market.mi-img.com") || str.contains("market.xiaomi.com")) {
                return new Pair(str, m2933g(str, m2951O()));
            }
        }
        return null;
    }

    /* renamed from: k */
    public boolean m2984k() {
        return this.f2150e == 1;
    }

    /* renamed from: l */
    public boolean m2985l() {
        return !m2984k();
    }

    /* renamed from: a */
    public void m2959a(int i) {
        this.f2150e = i;
        switch (this.f2150e) {
            case 2:
                this.f2161p = "www.n.duokan.com";
                this.f2151f = "www.n.duokan.com/sync";
                this.f2152g = "www.n.duokan.com";
                this.f2153h = "www.n.duokan.com/store/v0";
                this.f2154i = "www.n.duokan.com/dk_id/api";
                this.f2155j = "apps.n.duokan.com";
                this.f2156k = "www.n.duokan.com/message/v0";
                this.f2157l = "www.n.duokan.com/push/v0";
                this.f2158m = "www.n.duokan.com/dk_id/api/xiaomi_web_reg";
                this.f2159n = "login.dushu.xiaomi.com/android-client-login";
                this.f2160o = "www.n.duokan.com/dk_id/api/exchange";
                this.f2162q = "http://www.n.duokan.com/pictures4";
                this.f2163r = "http://www.n.duokan.com/promotion_day";
                this.f2164s = "http://10.232.46.34/";
                this.f2165t = "http://www.miui.com/api.php?mod=dkfeedback";
                this.f2166u = "http://update.n.duokan.com/DuoKanServer/servlet/android";
                this.f2167v = "http://api.ad.xiaomi.com";
                this.f2168w = "http://api.ad.xiaomi.com/u/api";
                this.f2170y = "http://www.n.duokan.com/extra/v0/font";
                this.f2171z = "https://ttsh5.openspeech.cn/tts-h5/speaker/3#hidebar=1";
                return;
            case 3:
                this.f2161p = "www.in.duokan.com";
                this.f2151f = "www.in.duokan.com/sync";
                this.f2152g = "www.in.duokan.com";
                this.f2153h = "www.in.duokan.com/store/v0";
                this.f2154i = "www.in.duokan.com/dk_id/api";
                this.f2155j = "apps.in.duokan.com";
                this.f2156k = "www.in.duokan.com/message/v0";
                this.f2157l = "www.in.duokan.com/push/v0";
                this.f2158m = "www.in.duokan.com/dk_id/api/xiaomi_web_reg";
                this.f2159n = "login.dushu.xiaomi.com/android-client-login";
                this.f2160o = "www.in.duokan.com/dk_id/api/exchange";
                this.f2162q = "http://www.in.duokan.com/pictures4";
                this.f2163r = "http://www.in.duokan.com/promotion_day";
                this.f2164s = "http://faq.in.duokan.com/";
                this.f2165t = "http://10.105.20.20:8080/api.php?mod=dkfeedback";
                this.f2166u = "http://update.in.duokan.com/DuoKanServer/servlet/android";
                this.f2167v = "http://api.ad.xiaomi.com";
                this.f2168w = "http://api.ad.xiaomi.com/u/api";
                this.f2170y = "http://www.in.duokan.com/extra/v0/font";
                this.f2171z = "http://testlx.openspeech.cn/tts-h5/speaker/3#hidebar=1";
                return;
            default:
                this.f2161p = "www.duokan.com";
                this.f2151f = "www.duokan.com/sync";
                this.f2152g = "www.duokan.com";
                this.f2153h = "www.duokan.com/store/v0";
                this.f2154i = "www.duokan.com/dk_id/api";
                this.f2155j = "apps.duokan.com";
                this.f2156k = "www.duokan.com/message/v0";
                this.f2157l = "www.duokan.com/push/v0";
                this.f2158m = "www.duokan.com/dk_id/api/xiaomi_web_reg";
                this.f2159n = "login.dushu.xiaomi.com/android-client-login";
                this.f2160o = "www.duokan.com/dk_id/api/exchange";
                this.f2162q = "http://www.duokan.com/pictures4";
                this.f2163r = "http://www.duokan.com/promotion_day";
                this.f2164s = "http://www.duokan.com/subtle/event/FAQ/common-faq.html";
                this.f2165t = "http://www.miui.com/api.php?mod=dkfeedback";
                this.f2166u = "http://update.duokan.com/DuoKanServer/servlet/android";
                this.f2167v = "http://api.ad.xiaomi.com";
                this.f2168w = "http://api.ad.xiaomi.com/u/api";
                this.f2170y = "http://www.duokan.com/extra/v0/font";
                this.f2171z = "https://ttsh5.openspeech.cn/tts-h5/speaker/3#hidebar=1";
                return;
        }
    }

    /* renamed from: m */
    public int m2986m() {
        return this.f2150e;
    }

    /* renamed from: n */
    public String m2987n() {
        return this.f2161p;
    }

    /* renamed from: o */
    public String m2988o() {
        return this.f2151f;
    }

    /* renamed from: p */
    public String m2989p() {
        return this.f2152g;
    }

    /* renamed from: q */
    public String m2990q() {
        return this.f2153h;
    }

    /* renamed from: r */
    public String m2991r() {
        return this.f2154i;
    }

    /* renamed from: s */
    public String m2992s() {
        return this.f2156k;
    }

    /* renamed from: t */
    public String m2993t() {
        return this.f2157l;
    }

    /* renamed from: u */
    public String m2994u() {
        return this.f2160o;
    }

    /* renamed from: v */
    public String m2995v() {
        return this.f2162q;
    }

    /* renamed from: w */
    public String m2996w() {
        return this.f2163r;
    }

    /* renamed from: x */
    public String m2997x() {
        return this.f2166u;
    }

    /* renamed from: y */
    public String m2998y() {
        Object R = m2929R();
        return !TextUtils.isEmpty(R) ? R : this.f2161p;
    }

    /* renamed from: z */
    public String m2999z() {
        return m2927P();
    }

    /* renamed from: b */
    public String m2963b(String str, String str2) {
        return m2999z() + "/hs/market/fiction_topic/" + str + m2935l(str2);
    }

    /* renamed from: c */
    public final String m2966c(String str, String str2) {
        return m2999z() + "/hs/market/topic/" + str + m2935l(str2);
    }

    /* renamed from: d */
    public final synchronized String m2969d(String str, String str2) {
        return m2999z() + "/hs/market/eagle/" + str + m2935l(str2);
    }

    /* renamed from: e */
    public final synchronized String m2972e(String str, String str2) {
        return m2999z() + "/hs/market/author/" + str + m2935l(str2);
    }

    /* renamed from: d */
    public final String m2968d(String str) {
        return m2999z() + "/hs/market/right/" + str;
    }

    /* renamed from: a */
    public final String m2954a(String str, int i, String str2, String str3) {
        return m2999z() + "/hs/book/" + str + "?source=" + i + "&source_id=" + str2 + "&native_immersive=1&_t=" + str3;
    }

    /* renamed from: e */
    public final String m2971e(String str) {
        return m2999z() + "/hs/store/free" + m2935l(str);
    }

    /* renamed from: f */
    public final String m2974f(String str) {
        return m2999z() + "/hs/store/discount" + m2935l(str);
    }

    /* renamed from: A */
    public final String m2937A() {
        return m2999z() + "/phone/#path=/hs/user/award/virtual&invalid=0";
    }

    /* renamed from: B */
    public final String m2938B() {
        return m2999z() + "/phone/#path=/hs/user/v4/coin";
    }

    /* renamed from: C */
    public final String m2939C() {
        return m2999z() + "/phone/#path=/hs/user/award/real&invalid=0";
    }

    /* renamed from: f */
    public final synchronized String m2975f(String str, String str2) {
        return m2999z() + "/phone/#path=/hs/market/reward&native_transparent=1&id=" + str + "&_t=" + str2;
    }

    /* renamed from: a */
    public final synchronized String m2956a(String str, String str2, String str3, String str4, String str5) {
        return m2999z() + "/phone/?path=/hs/market/pay/tts&open_id=" + Uri.encode(str) + "&pack_id=" + str2 + "&res_id=" + str3 + "&device=" + Uri.encode(str4) + "&price=" + str5 + "&native_transparent=1&native_pullrefresh=0";
    }

    /* renamed from: D */
    public final String m2940D() {
        return m2999z() + "/phone/#path=/hs/market/subscribeList";
    }

    /* renamed from: g */
    public final String m2977g(String str) {
        return m2999z() + "/hs/feed/" + str;
    }

    /* renamed from: E */
    public final String m2941E() {
        return m2999z() + "/phone/#path=/hs/user/feed";
    }

    /* renamed from: F */
    public final String m2942F() {
        return m2999z() + "/phone/#path=/hs/user/feed_collect";
    }

    /* renamed from: h */
    public final String m2979h(String str) {
        return m2999z() + "/hs/comment/feed/" + str;
    }

    /* renamed from: i */
    public final String m2980i(String str) {
        return m2999z() + "/hs/comment/book/" + str;
    }

    /* renamed from: j */
    public final String m2981j(String str) {
        return m2999z() + "/hs/comment/detail/" + str;
    }

    /* renamed from: G */
    public final String m2943G() {
        return m2999z() + "/phone/#path=/hs/user/wish";
    }

    /* renamed from: H */
    public String m2944H() {
        return m2999z() + "/phone/#path=/hs/user/note";
    }

    /* renamed from: I */
    public String m2945I() {
        return m2999z() + "/phone/#path=/hs/user/experience";
    }

    /* renamed from: J */
    public final String m2946J() {
        return m2999z() + "/phone/#path=/hs/market/retroactive&native_transparent=1&native_pullrefresh=0";
    }

    /* renamed from: K */
    public final String m2947K() {
        return m2999z() + "/dk_id/api/wx/login";
    }

    /* renamed from: L */
    public final String m2948L() {
        return this.f2164s;
    }

    /* renamed from: M */
    public final String m2949M() {
        return this.f2165t;
    }

    /* renamed from: N */
    public final String m2950N() {
        return this.f2171z;
    }

    /* renamed from: l */
    private String m2935l(String str) {
        return TextUtils.isEmpty(str) ? "" : "?track=" + str;
    }

    /* renamed from: k */
    public void m2983k(String str) {
        this.f2149d.setPrefString(PrivatePref.STORE, "server_config_url", str);
        this.f2149d.commitPrefs();
    }

    /* renamed from: m */
    private String m2936m(String str) {
        return UrlTools.encodedFragment(UrlTools.parse(m2927P() + "/phone/"), "path=" + str).toString();
    }

    /* renamed from: P */
    private String m2927P() {
        return m2930S() + m2928Q();
    }

    /* renamed from: Q */
    private String m2928Q() {
        Object R = m2929R();
        return !TextUtils.isEmpty(R) ? R : this.f2161p;
    }

    /* renamed from: R */
    private String m2929R() {
        if (m2984k() || TextUtils.isEmpty(this.f2149d.getPrefString(PrivatePref.STORE, "server_config_url", ""))) {
            return "";
        }
        String prefString = this.f2149d.getPrefString(PrivatePref.STORE, "server_config_url", "");
        if (prefString.startsWith("http://")) {
            return prefString.substring("http://".length());
        }
        if (prefString.startsWith("https://")) {
            return prefString.substring("https://".length());
        }
        return prefString;
    }

    /* renamed from: S */
    private String m2930S() {
        return m2984k() ? "https://" : "http://";
    }

    /* renamed from: O */
    public String m2951O() {
        String[] strArr;
        if (this.f2148A.m2485d()) {
            strArr = (String[]) this.f2149d.getMarketCDNIpOnWifi().toArray(new String[0]);
        } else {
            strArr = (String[]) this.f2149d.getMarketCDNIpOnWap().toArray(new String[0]);
        }
        if (strArr.length > 0) {
            return strArr[(int) (Math.random() * ((double) strArr.length))];
        }
        return f2146b[(int) (Math.random() * ((double) f2146b.length))];
    }

    /* renamed from: g */
    private String m2933g(String str, String str2) {
        boolean z;
        boolean z2 = true;
        WebLog c = WebLog.init();
        if (TextUtils.isEmpty(str)) {
            z = false;
        } else {
            z = true;
        }
        c.w(z);
        WebLog c2 = WebLog.init();
        if (TextUtils.isEmpty(str2)) {
            z2 = false;
        }
        c2.w(z2);
        return str.replace(Uri.parse(str).getEncodedAuthority(), str2);
    }
}
