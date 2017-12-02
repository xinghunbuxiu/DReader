package com.duokan.reader.domain.bookshelf;

import android.graphics.Color;

import org.json.JSONException;
import org.json.JSONObject;

public class ef extends a {
    private int a = Color.rgb(237, 88, 0);
    private String b;

    protected ef() {
    }

    public AnnotationType a() {
        return AnnotationType.COMMENT;
    }

    public String m() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public int n() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public a l() {
        a efVar = new ef();
        efVar.a(b());
        efVar.b(c());
        efVar.a(f());
        efVar.c(g());
        efVar.d(h());
        efVar.b(e());
        efVar.a(d());
        efVar.a(n());
        efVar.e(m());
        efVar.b(i());
        return efVar;
    }

    public String j() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("note_text", this.b);
            jSONObject.put("highlight_color", String.format("%d %d %d", new Object[]{Integer.valueOf(Color.red(this.a)), Integer.valueOf(Color.green(this.a)), Integer.valueOf(Color.blue(this.a))}));
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    public void f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.optString("note_text");
            String[] split = jSONObject.optString("highlight_color", "237 88 0").split(" ");
            this.a = Color.rgb(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue(), Integer.valueOf(split[2]).intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String g(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("note_text", str);
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
