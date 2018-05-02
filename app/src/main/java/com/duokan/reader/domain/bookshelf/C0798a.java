package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.epub.C0936c;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.domain.document.p045a.C0898a;
import com.duokan.reader.domain.document.p045a.C0904d;
import com.duokan.reader.domain.document.sbk.C0965b;
import com.duokan.reader.domain.document.sbk.C0969f;
import com.duokan.reader.domain.document.txt.C0986b;
import com.duokan.reader.domain.document.txt.C1000p;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.bookshelf.a */
public abstract class C0798a {
    /* renamed from: a */
    private long f2679a;
    /* renamed from: b */
    private long f2680b;
    /* renamed from: c */
    private long f2681c;
    /* renamed from: d */
    private long f2682d;
    /* renamed from: e */
    private av f2683e;
    /* renamed from: f */
    private av f2684f;
    /* renamed from: g */
    private String f2685g;
    /* renamed from: h */
    private String f2686h;

    /* renamed from: a */
    public abstract AnnotationType mo956a();

    /* renamed from: l */
    public abstract C0798a mo957l();

    protected C0798a() {
    }

    /* renamed from: b */
    public long m3720b() {
        return this.f2679a;
    }

    /* renamed from: a */
    public void m3716a(long j) {
        this.f2679a = j;
    }

    /* renamed from: c */
    public long m3724c() {
        return this.f2680b;
    }

    /* renamed from: b */
    public void m3721b(long j) {
        this.f2680b = j;
    }

    /* renamed from: d */
    public av m3726d() {
        return this.f2683e;
    }

    /* renamed from: a */
    public void m3718a(av avVar) {
        this.f2683e = avVar;
    }

    /* renamed from: e */
    public av m3728e() {
        return this.f2684f;
    }

    /* renamed from: b */
    public void m3722b(av avVar) {
        this.f2684f = avVar;
    }

    /* renamed from: f */
    public String m3729f() {
        return this.f2685g;
    }

    /* renamed from: a */
    public String m3715a(boolean z) {
        if (z) {
            return DkUtils.chs2chtText(m3729f());
        }
        return m3729f();
    }

    /* renamed from: a */
    public void m3719a(String str) {
        this.f2685g = str;
    }

    /* renamed from: g */
    public long m3730g() {
        return this.f2681c;
    }

    /* renamed from: c */
    public void m3725c(long j) {
        this.f2681c = j;
    }

    /* renamed from: h */
    public long m3731h() {
        return this.f2682d;
    }

    /* renamed from: d */
    public void m3727d(long j) {
        this.f2682d = j;
    }

    /* renamed from: i */
    public String m3732i() {
        return this.f2686h;
    }

    /* renamed from: b */
    public void m3723b(String str) {
        this.f2686h = str;
    }

    /* renamed from: a */
    public static C0798a m3711a(AnnotationType annotationType, String str) {
        if (annotationType == AnnotationType.BOOKMARK) {
            return C0798a.m3712c(str);
        }
        if (annotationType == AnnotationType.COMMENT) {
            return C0798a.m3713d(str);
        }
        return null;
    }

    /* renamed from: c */
    public static C0798a m3712c(String str) {
        C0798a ahVar = new ah();
        ahVar.m3725c(System.currentTimeMillis());
        ahVar.m3727d(System.currentTimeMillis());
        if (TextUtils.isEmpty(str)) {
            str = UUID.randomUUID().toString();
        }
        ahVar.m3723b(str);
        return ahVar;
    }

    /* renamed from: d */
    public static C0798a m3713d(String str) {
        C0798a eaVar = new ea();
        eaVar.m3725c(System.currentTimeMillis());
        eaVar.m3727d(System.currentTimeMillis());
        if (TextUtils.isEmpty(str)) {
            str = UUID.randomUUID().toString();
        }
        eaVar.m3723b(str);
        return eaVar;
    }

    /* renamed from: a */
    public void m3717a(BookFormat bookFormat, String str) {
        if (TextUtils.isEmpty(str)) {
            switch (C0799b.f2800a[bookFormat.ordinal()]) {
                case 1:
                    this.f2683e = C0952s.m6987a(0, 0, 0);
                    this.f2684f = C0952s.m6987a(0, 0, 0);
                    return;
                case 2:
                    this.f2683e = C0969f.m7162a(0, 0, 0);
                    this.f2684f = C0969f.m7162a(0, 0, 0);
                    return;
                case 3:
                    this.f2683e = C1000p.m7689b(0);
                    this.f2684f = C1000p.m7689b(0);
                    return;
                case 4:
                    this.f2683e = C0904d.m5963a(0, 0, 0);
                    this.f2684f = C0904d.m5963a(0, 0, 0);
                    return;
                default:
                    return;
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            JSONObject jSONObject2 = jSONArray.getJSONObject(1);
            switch (C0799b.f2800a[bookFormat.ordinal()]) {
                case 1:
                    this.f2683e = C0936c.m6768a(jSONObject);
                    this.f2684f = C0936c.m6768a(jSONObject2);
                    return;
                case 2:
                    this.f2683e = C0965b.m7132a(jSONObject);
                    this.f2684f = C0965b.m7132a(jSONObject2);
                    return;
                case 3:
                    this.f2683e = C0986b.m7530a(jSONObject);
                    this.f2684f = C0986b.m7530a(jSONObject2);
                    return;
                case 4:
                    this.f2683e = C0898a.m5785a(jSONObject);
                    this.f2684f = C0898a.m5785a(jSONObject2);
                    return;
                default:
                    return;
            }
        } catch (JSONException e) {
        }
    }

    /* renamed from: j */
    public String mo1008j() {
        return "";
    }

    /* renamed from: k */
    public String m3734k() {
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(0, this.f2683e.mo1193f());
            jSONArray.put(1, this.f2684f.mo1193f());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }
}
