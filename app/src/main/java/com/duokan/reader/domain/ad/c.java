package com.duokan.reader.domain.ad;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;

import com.duokan.reader.ReaderEnv;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;

import java.net.URLEncoder;
import java.security.Key;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class c {
    private static SecureRandom a = new SecureRandom();
    private final String b;

    public c(Context context) {
        if (a(context, "market://details/detailmini?id=com.duokan.reader")) {
            this.b = "market://details/detailmini";
        } else if (a(context, "market://details?id=com.duokan.reader")) {
            this.b = "market://details";
        } else {
            this.b = "";
        }
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.b) && ReaderEnv.get().onMiui();
    }

    public String a(String str) {
        String b = b();
        return this.b + "?" + "id=" + str + "&finishWhenDownload=true" + "&ref=" + "duokan" + "&back=true" + "&startDownload=true" + "&appClientId=" + "1004465" + "&appSignature=" + a(b, str) + "&nonce=" + URLEncoder.encode(b);
    }

    private static boolean a(Context context, String str) {
        try {
            if (context.getPackageManager().queryIntentActivities(Intent.parseUri(str, 0), 0).size() > 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private String a(String str, String str2) {
        return b("appClientId=1004465&nonce=" + str + "&id=" + str2 + "&ref=" + "duokan", "910100461465");
    }

    private String b() {
        long currentTimeMillis = (System.currentTimeMillis() / 1000) / 60;
        return String.format("%s:%s", new Object[]{(((System.currentTimeMillis() / 1000) * 1000000000) + ((long) a.nextInt(1000000000))) + "", currentTimeMillis + ""});
    }

    private String b(String str, String str2) {
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            List arrayList2 = new ArrayList();
            URLEncodedUtils.parse(arrayList2, new Scanner(str), HTTP.UTF_8);
            Collections.sort(arrayList2, new d(this));
            stringBuilder.append(URLEncodedUtils.format(arrayList2, HTTP.UTF_8));
        }
        arrayList.add(stringBuilder.toString());
        return a(a((TextUtils.join("\n", arrayList.toArray()) + "\n").getBytes(HTTP.UTF_8), str2.getBytes(HTTP.UTF_8)));
    }

    private String a(byte[] bArr) {
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

    private byte[] a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "HmacSHA256");
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(secretKeySpec);
        instance.update(bArr);
        return instance.doFinal();
    }
}
