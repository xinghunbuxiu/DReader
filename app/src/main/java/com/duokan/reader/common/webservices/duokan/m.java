package com.duokan.reader.common.webservices.duokan;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;

import com.duokan.core.sys.o;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.mipay.sdk.Mipay;

import org.apache.http.cookie.SM;
import org.json.JSONObject;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;

import javax.crypto.Cipher;

public class m extends ad {
    static final /* synthetic */ boolean a = (!m.class.desiredAssertionStatus());

    public m(n nVar, a aVar) {
        super((WebSession) nVar, aVar);
    }

    public m(n nVar, ab abVar) {
        super((WebSession) nVar, abVar);
    }

    public b a(String str, String str2) {
        boolean z = true;
        com.duokan.reader.common.webservices.duokan.a.a a = a(true, a() + "/token/add", "token", Uri.encode(str));
        if (!TextUtils.isEmpty(str2)) {
            a(a, SM.COOKIE, String.format("i=%s;", new Object[]{h(str2)}));
        }
        JSONObject a2 = a(a(a));
        b bVar = new b();
        bVar.b = a2.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            z = false;
        }
        bVar.a = Boolean.valueOf(z);
        return bVar;
    }

    private String h(String str) {
        Key generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDirtFy+gjDzGKdYLLDZh6QfpmxeyWk0bLxatJA8/R9yW3IKCK0Y27R0muk83dr450hYn6hsCfAfZzqA5nDz6VfAJkpYq1fSL31cxaU/m9aO1QbWweuGiQCLXceM+SfJL7ZPN3ZRp7+HHrFC+0kwfeVrRGcMWe/uJBI2bzBuMrVvwIDAQAB", 0)));
        Cipher instance = Cipher.getInstance("RSA");
        byte[] bytes = String.format("%s,%s", new Object[]{String.valueOf(System.currentTimeMillis() / 1000), o.b(str, "md5")}).getBytes();
        instance.init(1, generatePublic);
        return Uri.encode(Base64.encodeToString(instance.doFinal(bytes), 0));
    }

    public b e(String str) {
        boolean z = true;
        com.duokan.reader.common.webservices.duokan.a.a a = a(true, a() + "/device/release", new String[0]);
        if (!TextUtils.isEmpty(str)) {
            a(a, SM.COOKIE, String.format("token=%s;", new Object[]{str}));
        }
        JSONObject a2 = a(a(a));
        b bVar = new b();
        bVar.b = a2.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            z = false;
        }
        bVar.a = Boolean.valueOf(z);
        return bVar;
    }

    public b f(String str) {
        boolean z = true;
        com.duokan.reader.common.webservices.duokan.a.a a = a(true, a() + "/device/release", new String[0]);
        if (!TextUtils.isEmpty(str)) {
            a(a, SM.COOKIE, String.format("user_id=%s;", new Object[]{str}));
        }
        JSONObject a2 = a(a(a));
        b bVar = new b();
        bVar.b = a2.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            z = false;
        }
        bVar.a = Boolean.valueOf(z);
        return bVar;
    }

    public b a(String str, boolean z) {
        boolean z2;
        JSONObject a = a(a(b(true, a() + (z ? "/accept" : "/refuse"), "token", Uri.encode(str))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        bVar.a = Boolean.valueOf(z2);
        return bVar;
    }

    public b a(String str, String... strArr) {
        boolean z = true;
        if (a || (strArr != null && strArr.length > 0)) {
            JSONObject a = a(a(b(true, a() + "/id/add", "message_id", TextUtils.join(",", strArr))));
            b bVar = new b();
            bVar.b = a.getInt(Mipay.KEY_RESULT);
            if (bVar.b != 0) {
                z = false;
            }
            bVar.a = Boolean.valueOf(z);
            return bVar;
        }
        throw new AssertionError();
    }

    private String a() {
        return p.i().t();
    }

    public b a(int[] iArr, String str) {
        JSONObject a = a(a(b(true, b() + "/box/remind/unread_count", "book_serial", "1", "message_type", a(iArr))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b == 0) {
            bVar.a = a;
        }
        return bVar;
    }

    public b a(String str, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("deletion_threshold");
        arrayList.add(str);
        if (iArr != null && iArr.length > 0) {
            arrayList.add("message_type");
            arrayList.add(a(iArr));
        }
        JSONObject a = a(a(a(true, b() + "/box/remind/unread_count", (String[]) arrayList.toArray(new String[0]))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        return bVar;
    }

    public b a(int i, int i2, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("start");
        arrayList.add(Integer.toString(i));
        arrayList.add("count");
        arrayList.add(Integer.toString(i2));
        if (iArr != null && iArr.length > 0) {
            arrayList.add("message_type");
            arrayList.add(a(iArr));
        }
        JSONObject a = a(a(b(true, b() + "/box/remind", (String[]) arrayList.toArray(new String[0]))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.c = "";
        if (bVar.b == 0) {
            bVar.c = Boolean.toString(a.getBoolean("more"));
            bVar.a = a.getJSONArray("messages");
        }
        return bVar;
    }

    public b g(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("message_id");
        arrayList.add(str);
        JSONObject a = a(a(a(true, b() + "/box/remove", (String[]) arrayList.toArray(new String[0]))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.c = a.optString(Mipay.KEY_MESSAGE);
        return bVar;
    }

    private String b() {
        return p.i().s();
    }

    private String a(int[] iArr) {
        Iterable arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return TextUtils.join(",", arrayList);
    }
}
