package com.duokan.reader.common.webservices.duokan;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.duokan.core.sys.C0366o;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;
import com.mipay.sdk.Mipay;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.Cipher;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.webservices.duokan.m */
public class C0639m extends ac {
    /* renamed from: a */
    static final /* synthetic */ boolean f2144a = (!C0639m.class.desiredAssertionStatus());

    public C0639m(WebSession webSession, C0672a c0672a) {
        super(webSession, c0672a);
    }

    public C0639m(WebSession webSession, al alVar) {
        super(webSession, alVar);
    }

    /* renamed from: a */
    public C0621a<Boolean> m2900a(String str, String str2) {
        boolean z = true;
        C0624a a = m555a(true, m2895a() + "/token/add", "token", Uri.encode(str));
        if (!TextUtils.isEmpty(str2)) {
            m560a(a, SM.COOKIE, String.format("i=%s;", new Object[]{m2898h(str2)}));
        }
        JSONObject a2 = m547a(mo376a(a));
        C0621a<Boolean> c0621a = new C0621a();
        c0621a.b = a2.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            z = false;
        }
        c0621a.f2058a = Boolean.valueOf(z);
        return c0621a;
    }

    /* renamed from: h */
    private String m2898h(String str) {
        Key generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDirtFy+gjDzGKdYLLDZh6QfpmxeyWk0bLxatJA8/R9yW3IKCK0Y27R0muk83dr450hYn6hsCfAfZzqA5nDz6VfAJkpYq1fSL31cxaU/m9aO1QbWweuGiQCLXceM+SfJL7ZPN3ZRp7+HHrFC+0kwfeVrRGcMWe/uJBI2bzBuMrVvwIDAQAB", 0)));
        Cipher instance = Cipher.getInstance("RSA");
        byte[] bytes = String.format("%s,%s", new Object[]{String.valueOf(System.currentTimeMillis() / 1000), C0366o.m1034b(str, "md5")}).getBytes();
        instance.init(1, generatePublic);
        return Uri.encode(Base64.encodeToString(instance.doFinal(bytes), 0));
    }

    /* renamed from: e */
    public C0621a<Boolean> m2905e(String str) {
        boolean z = true;
        C0624a a = m555a(true, m2895a() + "/device/release", new String[0]);
        if (!TextUtils.isEmpty(str)) {
            m560a(a, SM.COOKIE, String.format("token=%s;", new Object[]{str}));
        }
        JSONObject a2 = m547a(mo376a(a));
        C0621a<Boolean> c0621a = new C0621a();
        c0621a.b = a2.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            z = false;
        }
        c0621a.f2058a = Boolean.valueOf(z);
        return c0621a;
    }

    /* renamed from: f */
    public C0621a<Boolean> m2906f(String str) {
        boolean z = true;
        C0624a a = m555a(true, m2895a() + "/device/release", new String[0]);
        if (!TextUtils.isEmpty(str)) {
            m560a(a, SM.COOKIE, String.format("user_id=%s;", new Object[]{str}));
        }
        JSONObject a2 = m547a(mo376a(a));
        C0621a<Boolean> c0621a = new C0621a();
        c0621a.b = a2.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            z = false;
        }
        c0621a.f2058a = Boolean.valueOf(z);
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<Boolean> m2901a(String str, boolean z) {
        boolean z2;
        JSONObject a = m547a(mo376a(m562b(true, m2895a() + (z ? "/accept" : "/refuse"), "token", Uri.encode(str))));
        C0621a<Boolean> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        c0621a.f2058a = Boolean.valueOf(z2);
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<Boolean> m2903a(String str, String... strArr) {
        boolean z = true;
        if (f2144a || (strArr != null && strArr.length > 0)) {
            JSONObject a = m547a(mo376a(m562b(true, m2895a() + "/id/add", "message_id", TextUtils.join(",", strArr))));
            C0621a<Boolean> c0621a = new C0621a();
            c0621a.b = a.getInt(Mipay.KEY_RESULT);
            if (c0621a.b != 0) {
                z = false;
            }
            c0621a.f2058a = Boolean.valueOf(z);
            return c0621a;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private String m2895a() {
        return C0641o.m2934i().m2993t();
    }

    /* renamed from: a */
    public C0621a<JSONObject> m2904a(int[] iArr, String str) {
        JSONObject a = m547a(mo376a(m562b(true, m2897b() + "/box/remind/unread_count", "book_serial", "1", "message_type", m2896a(iArr))));
        C0621a<JSONObject> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            c0621a.f2058a = a;
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<Void> m2902a(String str, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("deletion_threshold");
        arrayList.add(str);
        if (iArr != null && iArr.length > 0) {
            arrayList.add("message_type");
            arrayList.add(m2896a(iArr));
        }
        JSONObject a = m547a(mo376a(m555a(true, m2897b() + "/box/remind/unread_count", (String[]) arrayList.toArray(new String[0]))));
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<JSONArray> m2899a(int i, int i2, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("start");
        arrayList.add(Integer.toString(i));
        arrayList.add("count");
        arrayList.add(Integer.toString(i2));
        if (iArr != null && iArr.length > 0) {
            arrayList.add("message_type");
            arrayList.add(m2896a(iArr));
        }
        JSONObject a = m547a(mo376a(m562b(true, m2897b() + "/box/remind", (String[]) arrayList.toArray(new String[0]))));
        C0621a<JSONArray> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.c = "";
        if (c0621a.b == 0) {
            c0621a.c = Boolean.toString(a.getBoolean("more"));
            c0621a.f2058a = a.getJSONArray("messages");
        }
        return c0621a;
    }

    /* renamed from: g */
    public C0621a<Void> m2907g(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("message_id");
        arrayList.add(str);
        JSONObject a = m547a(mo376a(m555a(true, m2897b() + "/box/remove", (String[]) arrayList.toArray(new String[0]))));
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.c = a.optString(Mipay.KEY_MESSAGE);
        return c0621a;
    }

    /* renamed from: b */
    private String m2897b() {
        return C0641o.m2934i().m2992s();
    }

    /* renamed from: a */
    private String m2896a(int[] iArr) {
        Iterable arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return TextUtils.join(",", arrayList);
    }
}
