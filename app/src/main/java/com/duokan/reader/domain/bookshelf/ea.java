package com.duokan.reader.domain.bookshelf;

import android.graphics.Color;
import org.json.JSONException;
import org.json.JSONObject;

public class ea extends C0798a {
    /* renamed from: a */
    private int f3075a = Color.rgb(237, 88, 0);
    /* renamed from: b */
    private String f3076b;

    protected ea() {
    }

    /* renamed from: a */
    public AnnotationType mo956a() {
        return AnnotationType.COMMENT;
    }

    /* renamed from: m */
    public String m4384m() {
        return this.f3076b;
    }

    /* renamed from: e */
    public void m4380e(String str) {
        this.f3076b = str;
    }

    /* renamed from: n */
    public int m4385n() {
        return this.f3075a;
    }

    /* renamed from: a */
    public void m4379a(int i) {
        this.f3075a = i;
    }

    /* renamed from: l */
    public C0798a mo957l() {
        C0798a eaVar = new ea();
        eaVar.m3716a(m3720b());
        eaVar.m3721b(m3724c());
        eaVar.m3719a(m3729f());
        eaVar.m3725c(m3730g());
        eaVar.m3727d(m3731h());
        eaVar.m3722b(m3728e());
        eaVar.m3718a(m3726d());
        eaVar.m4379a(m4385n());
        eaVar.m4380e(m4384m());
        eaVar.m3723b(m3732i());
        return eaVar;
    }

    /* renamed from: j */
    public String mo1008j() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("note_text", this.f3076b);
            jSONObject.put("highlight_color", String.format("%d %d %d", new Object[]{Integer.valueOf(Color.red(this.f3075a)), Integer.valueOf(Color.green(this.f3075a)), Integer.valueOf(Color.blue(this.f3075a))}));
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    /* renamed from: f */
    public void m4381f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f3076b = jSONObject.optString("note_text");
            String[] split = jSONObject.optString("highlight_color", "237 88 0").split(" ");
            this.f3075a = Color.rgb(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue(), Integer.valueOf(split[2]).intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    public static String m4377g(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("note_text", str);
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
