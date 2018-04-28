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

public class hb {
    /* renamed from: a */
    static final /* synthetic */ boolean f3288a = (!hb.class.desiredAssertionStatus());
    /* renamed from: b */
    private int f3289b;
    /* renamed from: c */
    private PointF f3290c;
    /* renamed from: d */
    private boolean f3291d;
    /* renamed from: e */
    private float f3292e;
    /* renamed from: f */
    private RectF[] f3293f;
    /* renamed from: g */
    private PageScaleType f3294g;
    /* renamed from: h */
    private ReadingOrientation f3295h;
    /* renamed from: i */
    private PageAnimationMode f3296i;

    public hb() {
        this.f3291d = true;
        this.f3289b = 0;
        this.f3292e = 1.0f;
        this.f3290c = new PointF(0.0f, 0.0f);
        this.f3293f = new RectF[]{new RectF()};
        this.f3294g = PageScaleType.MATCH_WIDTH;
        this.f3295h = ReadingOrientation.PORTRAIT;
        this.f3296i = PageAnimationMode.VSCROLL;
    }

    /* renamed from: a */
    public boolean m4620a() {
        return this.f3291d;
    }

    /* renamed from: b */
    public int m4621b() {
        return this.f3289b;
    }

    /* renamed from: c */
    public float m4622c() {
        return this.f3292e;
    }

    /* renamed from: d */
    public RectF[] m4623d() {
        return this.f3293f;
    }

    /* renamed from: e */
    public PageScaleType m4624e() {
        return this.f3294g;
    }

    /* renamed from: f */
    public ReadingOrientation m4625f() {
        return this.f3295h;
    }

    /* renamed from: g */
    public PageAnimationMode m4626g() {
        return this.f3296i;
    }

    /* renamed from: a */
    public void m4618a(boolean z) {
        this.f3291d = z;
    }

    /* renamed from: a */
    public void m4614a(int i) {
        this.f3289b = i;
    }

    /* renamed from: a */
    public void m4612a(float f) {
        this.f3292e = f;
    }

    /* renamed from: a */
    public void m4613a(float f, float f2) {
        this.f3290c.set(f, f2);
    }

    /* renamed from: a */
    public void m4619a(RectF[] rectFArr) {
        this.f3293f = rectFArr;
    }

    /* renamed from: a */
    public void m4615a(PageScaleType pageScaleType) {
        this.f3294g = pageScaleType;
    }

    /* renamed from: a */
    public void m4617a(ReadingOrientation readingOrientation) {
        this.f3295h = readingOrientation;
    }

    /* renamed from: a */
    public void m4616a(PageAnimationMode pageAnimationMode) {
        this.f3296i = pageAnimationMode;
    }

    /* renamed from: h */
    public boolean m4627h() {
        if (this.f3293f == null || this.f3293f.length < 1) {
            return true;
        }
        RectF rectF = this.f3293f[0];
        if (rectF == null) {
            return true;
        }
        for (int i = 1; i < this.f3293f.length; i++) {
            RectF rectF2 = this.f3293f[i];
            if (rectF2 == null) {
                return false;
            }
            if (rectF2.left != rectF.left || rectF2.top != rectF.top || rectF2.right != rectF.right || rectF2.bottom != rectF.bottom) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: i */
    public boolean m4628i() {
        if (this.f3293f == null || this.f3293f.length < 1) {
            return true;
        }
        RectF rectF = this.f3293f[0];
        if (rectF == null) {
            return true;
        }
        if (rectF.left == 0.0f && rectF.top == 0.0f && rectF.right == 0.0f && rectF.bottom == 0.0f) {
            return true;
        }
        return false;
    }

    hb(JSONObject jSONObject) {
        this();
        try {
            this.f3291d = jSONObject.getBoolean("valid");
            this.f3289b = jSONObject.getInt("font_size");
            this.f3292e = (float) jSONObject.getDouble("zoom_factor");
            JSONArray jSONArray = jSONObject.getJSONArray("left_top");
            this.f3290c.set((float) jSONArray.getDouble(0), (float) jSONArray.getDouble(1));
            jSONArray = jSONObject.getJSONArray("content_margins");
            this.f3293f = new RectF[(jSONArray.length() / 4)];
            for (int i = 0; i < this.f3293f.length; i++) {
                this.f3293f[i] = new RectF((float) jSONArray.getDouble((i * 4) + 0), (float) jSONArray.getDouble((i * 4) + 1), (float) jSONArray.getDouble((i * 4) + 2), (float) jSONArray.getDouble((i * 4) + 3));
            }
            Object string = jSONObject.getString("scale_type");
            this.f3294g = TextUtils.isEmpty(string) ? PageScaleType.MATCH_WIDTH : PageScaleType.valueOf(string);
            string = jSONObject.getString("reading_orientation");
            this.f3295h = TextUtils.isEmpty(string) ? ReadingOrientation.PORTRAIT : ReadingOrientation.valueOf(string);
            string = jSONObject.getString("page_animation");
            this.f3296i = TextUtils.isEmpty(string) ? PageAnimationMode.VSCROLL : PageAnimationMode.valueOf(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    JSONObject m4629j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("valid", this.f3291d);
            jSONObject.put("font_size", Integer.toString(this.f3289b));
            jSONObject.put("zoom_factor", Float.toString(this.f3292e));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, (double) this.f3290c.x);
            jSONArray.put(1, (double) this.f3290c.y);
            jSONObject.put("left_top", jSONArray);
            jSONArray = new JSONArray();
            for (int i = 0; i < this.f3293f.length; i++) {
                jSONArray.put((i * 4) + 0, (double) this.f3293f[i].left);
                jSONArray.put((i * 4) + 1, (double) this.f3293f[i].top);
                jSONArray.put((i * 4) + 2, (double) this.f3293f[i].right);
                jSONArray.put((i * 4) + 3, (double) this.f3293f[i].bottom);
            }
            jSONObject.put("content_margins", jSONArray);
            jSONObject.put("scale_type", this.f3294g.toString());
            jSONObject.put("reading_orientation", this.f3295h.toString());
            jSONObject.put("page_animation", this.f3296i.toString());
        } catch (Exception e) {
            if (f3288a) {
                e.printStackTrace();
            } else {
                throw new AssertionError();
            }
        }
        return jSONObject;
    }
}
