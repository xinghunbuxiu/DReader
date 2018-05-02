package com.duokan.reader.domain.ad;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.duokan.reader.ReaderEnv;
import java.net.URLEncoder;
import java.security.Key;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;

/* renamed from: com.duokan.reader.domain.ad.c */
public class C0746c {
    /* renamed from: a */
    private static SecureRandom f2513a = new SecureRandom();
    /* renamed from: b */
    private final String f2514b;

    public C0746c(Context context) {
        if (C0746c.m3548a(context, "market://details/detailmini?id=com.duokan.reader")) {
            this.f2514b = "market://details/detailmini";
        } else if (C0746c.m3548a(context, "market://details?id=com.duokan.reader")) {
            this.f2514b = "market://details";
        } else {
            this.f2514b = "";
        }
    }

    /* renamed from: a */
    public boolean m3553a() {
        return !TextUtils.isEmpty(this.f2514b) && ReaderEnv.get().onMiui();
    }

    /* renamed from: a */
    public String m3552a(String str) {
        String b = m3550b();
        return this.f2514b + "?" + "id=" + str + "&finishWhenDownload=true" + "&ref=" + "duokan" + "&back=true" + "&startDownload=true" + "&appClientId=" + "1004465" + "&appSignature=" + m3546a(b, str) + "&nonce=" + URLEncoder.encode(b);
    }

    /* renamed from: a */
    private static boolean m3548a(Context context, String str) {
        try {
            if (context.getPackageManager().queryIntentActivities(Intent.parseUri(str, 0), 0).size() > 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    private String m3546a(String str, String str2) {
        return m3551b("appClientId=1004465&nonce=" + str + "&id=" + str2 + "&ref=" + "duokan", "910100461465");
    }

    /* renamed from: b */
    private String m3550b() {
        long currentTimeMillis = (System.currentTimeMillis() / 1000) / 60;
        return String.format("%s:%s", new Object[]{(((System.currentTimeMillis() / 1000) * 1000000000) + ((long) f2513a.nextInt(1000000000))) + "", currentTimeMillis + ""});
    }

    /* renamed from: b */
    private String m3551b(String str, String str2) {
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            List arrayList2 = new ArrayList();
            URLEncodedUtils.parse(arrayList2, new Scanner(str), HTTP.UTF_8);
            Collections.sort(arrayList2, new C0747d(this));
            stringBuilder.append(URLEncodedUtils.format(arrayList2, HTTP.UTF_8));
        }
        arrayList.add(stringBuilder.toString());
        return m3547a(m3549a((TextUtils.join("\n", arrayList.toArray()) + "\n").getBytes(HTTP.UTF_8), str2.getBytes(HTTP.UTF_8)));
    }

    /* renamed from: a */
    private String m3547a(byte[] bArr) {
        try {
            String encodeToString = Base64.encodeToString(bArr, 10);
            if (encodeToString.endsWith("=")) {
                return encodeToString.substring(0, encodeToString.length() - 1);
            }
            return encodeToString;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    private byte[] m3549a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "HmacSHA256");
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(secretKeySpec);
        instance.update(bArr);
        return instance.doFinal();
    }
}
