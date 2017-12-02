package com.duokan.reader.domain.bookshelf;

import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;

import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;
import com.duokan.reader.ui.reading.PageAnimationMode;
import com.duokan.reader.ui.reading.ReadingOrientation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hh {
    static final /* synthetic */ boolean a = (!hh.class.desiredAssertionStatus());
    private int b;
    private PointF c;
    private boolean d;
    private float e;
    private RectF[] f;
    private PageScaleType g;
    private ReadingOrientation h;
    private PageAnimationMode i;

    public hh() {
        this.d = true;
        this.b = 0;
        this.e = 1.0f;
        this.c = new PointF(0.0f, 0.0f);
        this.f = new RectF[]{new RectF()};
        this.g = PageScaleType.MATCH_WIDTH;
        this.h = ReadingOrientation.PORTRAIT;
        this.i = PageAnimationMode.VSCROLL;
    }

    public boolean a() {
        return this.d;
    }

    public int b() {
        return this.b;
    }

    public float c() {
        return this.e;
    }

    public RectF[] d() {
        return this.f;
    }

    public PageScaleType e() {
        return this.g;
    }

    public ReadingOrientation f() {
        return this.h;
    }

    public PageAnimationMode g() {
        return this.i;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(float f) {
        this.e = f;
    }

    public void a(float f, float f2) {
        this.c.set(f, f2);
    }

    public void a(RectF[] rectFArr) {
        this.f = rectFArr;
    }

    public void a(PageScaleType pageScaleType) {
        this.g = pageScaleType;
    }

    public void a(ReadingOrientation readingOrientation) {
        this.h = readingOrientation;
    }

    public void a(PageAnimationMode pageAnimationMode) {
        this.i = pageAnimationMode;
    }

    public boolean h() {
        if (this.f == null || this.f.length < 1) {
            return true;
        }
        RectF rectF = this.f[0];
        if (rectF == null) {
            return true;
        }
        for (int i = 1; i < this.f.length; i++) {
            RectF rectF2 = this.f[i];
            if (rectF2 == null) {
                return false;
            }
            if (rectF2.left != rectF.left || rectF2.top != rectF.top || rectF2.right != rectF.right || rectF2.bottom != rectF.bottom) {
                return false;
            }
        }
        return true;
    }

    public boolean i() {
        if (this.f == null || this.f.length < 1) {
            return true;
        }
        RectF rectF = this.f[0];
        if (rectF == null) {
            return true;
        }
        if (rectF.left == 0.0f && rectF.top == 0.0f && rectF.right == 0.0f && rectF.bottom == 0.0f) {
            return true;
        }
        return false;
    }

    hh(JSONObject jSONObject) {
        this();
        try {
            this.d = jSONObject.getBoolean("valid");
            this.b = jSONObject.getInt("font_size");
            this.e = (float) jSONObject.getDouble("zoom_factor");
            JSONArray jSONArray = jSONObject.getJSONArray("left_top");
            this.c.set((float) jSONArray.getDouble(0), (float) jSONArray.getDouble(1));
            jSONArray = jSONObject.getJSONArray("content_margins");
            this.f = new RectF[(jSONArray.length() / 4)];
            for (int i = 0; i < this.f.length; i++) {
                this.f[i] = new RectF((float) jSONArray.getDouble((i * 4) + 0), (float) jSONArray.getDouble((i * 4) + 1), (float) jSONArray.getDouble((i * 4) + 2), (float) jSONArray.getDouble((i * 4) + 3));
            }
            Object string = jSONObject.getString("scale_type");
            this.g = TextUtils.isEmpty(string) ? PageScaleType.MATCH_WIDTH : PageScaleType.valueOf(string);
            string = jSONObject.getString("reading_orientation");
            this.h = TextUtils.isEmpty(string) ? ReadingOrientation.PORTRAIT : ReadingOrientation.valueOf(string);
            string = jSONObject.getString("page_animation");
            this.i = TextUtils.isEmpty(string) ? PageAnimationMode.VSCROLL : PageAnimationMode.valueOf(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("valid", this.d);
            jSONObject.put("font_size", Integer.toString(this.b));
            jSONObject.put("zoom_factor", Float.toString(this.e));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, (double) this.c.x);
            jSONArray.put(1, (double) this.c.y);
            jSONObject.put("left_top", jSONArray);
            jSONArray = new JSONArray();
            for (int i = 0; i < this.f.length; i++) {
                jSONArray.put((i * 4) + 0, (double) this.f[i].left);
                jSONArray.put((i * 4) + 1, (double) this.f[i].top);
                jSONArray.put((i * 4) + 2, (double) this.f[i].right);
                jSONArray.put((i * 4) + 3, (double) this.f[i].bottom);
            }
            jSONObject.put("content_margins", jSONArray);
            jSONObject.put("scale_type", this.g.toString());
            jSONObject.put("reading_orientation", this.h.toString());
            jSONObject.put("page_animation", this.i.toString());
        } catch (Exception e) {
            if (a) {
                e.printStackTrace();
            } else {
                throw new AssertionError();
            }
        }
        return jSONObject;
    }
}
