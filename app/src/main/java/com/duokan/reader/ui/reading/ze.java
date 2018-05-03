package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.eb;
import com.duokan.reader.ui.general.BubbleFloatingView;
import com.duokan.reader.ui.general.eq;
import com.duokan.reader.ui.general.ir;
import java.util.HashMap;
import org.apache.http.HttpStatus;

public class ze extends ActivatedController {
    /* renamed from: A */
    protected LayoutParams f11219A;
    /* renamed from: B */
    protected boolean f11220B = false;
    /* renamed from: C */
    protected int f11221C;
    /* renamed from: D */
    protected final HashMap<String, String> f11222D;
    /* renamed from: E */
    private final TranslationController f11223E = new TranslationController(getContext(), new zf(this), m15216h());
    /* renamed from: F */
    private final zw f11224F;
    /* renamed from: G */
    private String f11225G = null;
    /* renamed from: H */
    private Rect[] f11226H = null;
    /* renamed from: I */
    private ady f11227I;
    /* renamed from: a */
    protected final BubbleFloatingView f11228a;
    /* renamed from: b */
    protected final BoxView f11229b;
    /* renamed from: c */
    protected final View f11230c;
    /* renamed from: d */
    protected final LinearLayout f11231d;
    /* renamed from: e */
    protected final LinearLayout f11232e;
    /* renamed from: f */
    protected final LinearLayout f11233f;
    /* renamed from: g */
    protected final FrameLayout f11234g;
    /* renamed from: h */
    protected final TextView f11235h;
    /* renamed from: i */
    protected final TextView f11236i;
    /* renamed from: j */
    protected final TextView f11237j;
    /* renamed from: k */
    protected final TextView f11238k;
    /* renamed from: l */
    protected final TextView f11239l;
    /* renamed from: m */
    protected final TextView f11240m;
    /* renamed from: n */
    protected final TextView f11241n;
    /* renamed from: o */
    protected final ViewGroup f11242o;
    /* renamed from: p */
    protected final ImageView f11243p;
    /* renamed from: q */
    protected final TextView f11244q;
    /* renamed from: r */
    protected final TextView f11245r;
    /* renamed from: s */
    protected final ViewGroup f11246s;
    /* renamed from: t */
    protected final TextView f11247t;
    /* renamed from: u */
    protected final View f11248u;
    /* renamed from: v */
    protected final View f11249v;
    /* renamed from: w */
    protected final View f11250w;
    /* renamed from: x */
    protected final View f11251x;
    /* renamed from: y */
    protected final LayoutParams f11252y;
    /* renamed from: z */
    protected ir f11253z;

    public ze(IFeature mFeature, zw zwVar) {
        super(mFeature);
        this.f11224F = zwVar;
        this.f11228a = new BubbleFloatingView(getContext());
        this.f11228a.setVisibility(8);
        setContentView(this.f11228a);
        LayoutInflater from = LayoutInflater.from(getContext());
        this.f11228a.setCenterViewResource(C0256h.reading__selection_bar_view);
        this.f11228a.setUpArrow(C0254f.reading__shared__arrow_top);
        this.f11228a.setDownArrow(C0254f.reading__shared__arrow_bottom);
        this.f11228a.m9924a(AnimUtils.m1932b(getContext(), 15.0f), 0, AnimUtils.m1932b(getContext(), 15.0f), 0);
        this.f11253z = new ir(getContext(), null);
        this.f11219A = new LayoutParams(-1, -1);
        this.f11219A.gravity = 17;
        this.f11253z.setLayoutParams(this.f11219A);
        this.f11253z.setScrollRightResource(C0254f.general__shared__arrow_right_13dip_ffffff);
        this.f11253z.setScrollLeftResource(C0254f.general__shared__arrow_left_13dip_ffffff);
        this.f11229b = (BoxView) this.f11228a.getCenterView();
        this.f11229b.getLayoutParams().width = Math.min(getResources().getDisplayMetrics().widthPixels, AnimUtils.m1932b(getContext(), 360.0f));
        this.f11231d = (LinearLayout) findViewById(C0255g.reading__selection_bar_view__line1);
        this.f11232e = (LinearLayout) findViewById(C0255g.reading__selection_bar_view__line2);
        this.f11233f = (LinearLayout) findViewById(C0255g.reading__selection_bar_view__line_visible);
        this.f11234g = (FrameLayout) findViewById(C0255g.reading__selection_bar_view__bottom_panel);
        this.f11230c = findViewById(C0255g.reading__selection_bar_view__firstline);
        this.f11235h = (TextView) from.inflate(C0256h.reading__selection_bar_button_view, this.f11231d, false);
        this.f11238k = (TextView) from.inflate(C0256h.reading__selection_bar_button_view, this.f11231d, false);
        this.f11236i = (TextView) from.inflate(C0256h.reading__selection_bar_button_view, this.f11231d, false);
        this.f11240m = (TextView) from.inflate(C0256h.reading__selection_bar_button_view, this.f11231d, false);
        this.f11237j = (TextView) from.inflate(C0256h.reading__selection_bar_button_view, this.f11231d, false);
        this.f11241n = (TextView) from.inflate(C0256h.reading__selection_bar_button_view, this.f11231d, false);
        this.f11242o = (ViewGroup) from.inflate(C0256h.reading__selection_bar_excerpt_button_view, this.f11231d, false);
        this.f11244q = (TextView) from.inflate(C0256h.reading__selection_bar_button_view, this.f11231d, false);
        this.f11245r = (TextView) from.inflate(C0256h.reading__selection_bar_dict_button_view, this.f11231d, false);
        this.f11239l = (TextView) from.inflate(C0256h.reading__selection_bar_dict_button_view, this.f11231d, false);
        this.f11247t = (TextView) from.inflate(C0256h.reading__selection_bar_button_view, this.f11232e, false);
        this.f11246s = (ViewGroup) from.inflate(C0256h.reading__selection_colors_view, this.f11232e, false);
        this.f11248u = this.f11246s.getChildAt(0);
        this.f11249v = this.f11246s.getChildAt(1);
        this.f11250w = this.f11246s.getChildAt(2);
        this.f11251x = this.f11246s.getChildAt(3);
        this.f11235h.setText(getString(C0258j.reading__selection_bar_view__correct));
        this.f11238k.setText(getString(C0258j.reading__selection_bar_view__correct));
        this.f11236i.setText(getString(C0258j.reading__selection_bar_view__share));
        this.f11240m.setText(getString(C0258j.reading__selection_bar_view__share));
        this.f11237j.setText(getString(C0258j.reading__selection_bar_view__copy));
        this.f11241n.setText(getString(C0258j.reading__selection_bar_view__copy));
        this.f11244q.setText(getString(C0258j.reading__selection_bar_view__comment));
        this.f11245r.setText(getString(C0258j.reading__selection_bar_view__dict));
        this.f11239l.setText(getString(C0258j.reading__selection_bar_view__dict));
        this.f11247t.setText(getString(C0258j.reading__selection_bar_view__delete));
        this.f11243p = (ImageView) this.f11242o.getChildAt(0);
        this.f11234g.addView(this.f11223E.getContentView());
        this.f11252y = new LayoutParams(-2, -2);
        this.f11252y.setMargins(AnimUtils.m1932b(getContext(), -25.0f), 0, 0, 0);
        this.f11222D = new HashMap();
        this.f11235h.setOnClickListener(new zo(this));
        this.f11238k.setOnClickListener(new zp(this));
        this.f11236i.setOnClickListener(new zq(this));
        this.f11240m.setOnClickListener(new zr(this));
        this.f11237j.setOnClickListener(new zs(this));
        this.f11241n.setOnClickListener(new zt(this));
        this.f11244q.setOnClickListener(new zu(this));
        this.f11245r.setOnClickListener(new zv(this));
        this.f11239l.setOnClickListener(new zg(this));
        this.f11247t.setOnClickListener(new zh(this));
        this.f11246s.setOnClickListener(new zi(this));
        this.f11248u.setOnClickListener(new zk(this));
        this.f11249v.setOnClickListener(new zl(this));
        this.f11250w.setOnClickListener(new zm(this));
        this.f11251x.setOnClickListener(new zn(this));
        this.f11248u.setClickable(false);
        this.f11249v.setClickable(false);
        this.f11250w.setClickable(false);
        this.f11251x.setClickable(false);
        m15214f();
    }

    /* renamed from: a */
    public void mo2520a(String str, boolean z, ady ady) {
        this.f11227I = ady;
        this.f11231d.setVisibility(8);
        this.f11232e.setVisibility(8);
        this.f11233f.removeAllViews();
        this.f11233f.addView(this.f11231d);
        this.f11231d.removeAllViews();
        this.f11232e.removeAllViews();
        if (m15206a()) {
            this.f11222D.put("DictVisible", "TRUE");
            this.f11234g.setVisibility(0);
            this.f11230c.setVisibility(0);
            this.f11245r.setSelected(true);
            this.f11239l.setSelected(true);
            this.f11223E.m12610a(str, ady);
        } else {
            this.f11222D.put("DictVisible", "FALSE");
            this.f11234g.setVisibility(8);
            this.f11230c.setVisibility(8);
            this.f11245r.setSelected(false);
            this.f11239l.setSelected(false);
            ady.mo2220b();
            this.f11225G = str;
        }
        m15214f();
    }

    /* renamed from: a */
    protected boolean m15206a() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, "Dict", false);
    }

    /* renamed from: b */
    public void m15208b(int i) {
        this.f11248u.setSelected(false);
        this.f11249v.setSelected(false);
        this.f11250w.setSelected(false);
        this.f11251x.setSelected(false);
        switch (i) {
            case 0:
                this.f11248u.setSelected(true);
                return;
            case 1:
                this.f11249v.setSelected(true);
                return;
            case 2:
                this.f11250w.setSelected(true);
                return;
            case 3:
                this.f11251x.setSelected(true);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public void m15207b() {
        this.f11248u.setSelected(false);
        this.f11249v.setSelected(false);
        this.f11250w.setSelected(false);
        this.f11251x.setSelected(false);
    }

    /* renamed from: c */
    public void m15211c() {
        if (this.f11234g.getVisibility() == 8) {
            this.f11222D.put("Action1", "DICT-OPEN");
            if (this.f11225G != null) {
                this.f11234g.getLayoutParams().height = m15201d(this.f11226H);
                this.f11223E.m12610a(this.f11225G, this.f11227I);
                this.f11225G = null;
            }
            this.f11234g.setVisibility(0);
            this.f11230c.setVisibility(0);
            this.f11245r.setSelected(true);
            ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "Dict", true);
            ReaderEnv.get().commitPrefs();
            return;
        }
        this.f11222D.put("Action1", "DICT-CLOSE");
        this.f11234g.setVisibility(8);
        this.f11230c.setVisibility(8);
        this.f11245r.setSelected(false);
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "Dict", false);
        ReaderEnv.get().commitPrefs();
    }

    /* renamed from: d */
    public void m15212d() {
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
        Animation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation2.setDuration(200);
        this.f11231d.setVisibility(8);
        this.f11233f.removeAllViews();
        this.f11232e.setVisibility(0);
        if (this.f11232e.getParent() != null) {
            ((ViewGroup) this.f11232e.getParent()).removeView(this.f11232e);
        }
        this.f11233f.addView(this.f11232e);
        this.f11231d.startAnimation(translateAnimation);
        this.f11232e.startAnimation(translateAnimation2);
    }

    /* renamed from: a */
    public void m15203a(View view, int i) {
        Animation translateAnimation = new TranslateAnimation(0, (float) (-i), 0, 0.0f, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(200);
        view.startAnimation(translateAnimation);
    }

    /* renamed from: b */
    public void m15209b(View view, int i) {
        Animation translateAnimation = new TranslateAnimation(0, (float) ((-i) + 3), 0, 0.0f, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(200);
        view.startAnimation(translateAnimation);
    }

    /* renamed from: a */
    public void m15205a(Rect... rectArr) {
        this.f11226H = rectArr;
        m15200c(rectArr);
    }

    /* renamed from: b */
    public void m15210b(Rect... rectArr) {
        m15200c(rectArr);
        this.f11234g.getLayoutParams().height = m15201d(rectArr);
    }

    /* renamed from: c */
    private void m15200c(Rect... rectArr) {
        this.f11234g.getLayoutParams().height = -2;
        this.f11229b.setMaxHeight(m15202e(rectArr));
        this.f11228a.setVisibility(0);
        this.f11228a.m9926a(rectArr, false, (int) HttpStatus.SC_MULTIPLE_CHOICES);
        this.f11223E.m12609a();
    }

    /* renamed from: d */
    private int m15201d(Rect... rectArr) {
        return (m15202e(rectArr) * 2) / 3;
    }

    /* renamed from: e */
    private int m15202e(Rect... rectArr) {
        int b = AnimUtils.m1932b(getContext(), 15.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = (displayMetrics.heightPixels / 2) - b;
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        for (Rect rect2 : rectArr) {
            if (rect.isEmpty()) {
                rect.set(rect2);
            } else {
                rect.union(rect2);
            }
        }
        int i2 = rect.top - b;
        int height = rect.height() - b;
        b = (displayMetrics.heightPixels - rect.bottom) - b;
        AnimUtils.f1198g.clearAnimation(rect);
        return Math.min(Math.max(Math.max(i2, height), b), i);
    }

    /* renamed from: e */
    public void m15213e() {
        this.f11228a.setVisibility(8);
        this.f11223E.m12611b();
    }

    /* renamed from: f */
    protected void m15214f() {
        Drawable drawable = getDrawable(C0254f.reading__annotation_edit_view__placeholder_normal);
        eq eqVar = new eq(new ColorDrawable(eb.m4386a().m4389b()));
        Bitmap c = C0544a.m2447c(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(c);
        eqVar.m10568a(drawable);
        eqVar.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        eqVar.draw(canvas);
        eqVar.m10568a(null);
        this.f11243p.setImageBitmap(c);
    }

    /* renamed from: g */
    protected boolean m15215g() {
        C0800c G = m15216h().mo1992G();
        return G.ak() && G.m4242o() != BookType.SERIAL;
    }

    /* renamed from: h */
    protected su m15216h() {
        return (su) getContext().queryFeature(su.class);
    }

    /* renamed from: i */
    public HashMap<String, String> m15217i() {
        return this.f11222D;
    }
}
