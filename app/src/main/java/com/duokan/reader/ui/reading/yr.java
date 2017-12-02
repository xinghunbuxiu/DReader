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

import com.duokan.c.g;
import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.bitmap.a;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.eg;
import com.duokan.reader.ui.general.BubbleFloatingView;
import com.duokan.reader.ui.general.es;
import com.duokan.reader.ui.general.jh;

import org.apache.http.HttpStatus;

import java.util.HashMap;

public class yr extends e {
    protected LayoutParams A;
    protected boolean B = false;
    protected int C;
    protected final HashMap D;
    private final TranslationController E = new TranslationController(getContext(), new ys(this), h());
    private final zj F;
    private String G = null;
    private Rect[] H = null;
    private adl I;
    protected final BubbleFloatingView a;
    protected final BoxView b;
    protected final View c;
    protected final LinearLayout d;
    protected final LinearLayout e;
    protected final LinearLayout f;
    protected final FrameLayout g;
    protected final TextView h;
    protected final TextView i;
    protected final TextView j;
    protected final TextView k;
    protected final TextView l;
    protected final TextView m;
    protected final TextView n;
    protected final ViewGroup o;
    protected final ImageView p;
    protected final TextView q;
    protected final TextView r;
    protected final ViewGroup s;
    protected final TextView t;
    protected final View u;
    protected final View v;
    protected final View w;
    protected final View x;
    protected final LayoutParams y;
    protected jh z;

    public yr(y yVar, zj zjVar) {
        super(yVar);
        this.F = zjVar;
        this.a = new BubbleFloatingView(getContext());
        this.a.setVisibility(8);
        setContentView(this.a);
        LayoutInflater from = LayoutInflater.from(getContext());
        this.a.setCenterViewResource(h.reading__selection_bar_view);
        this.a.setUpArrow(f.reading__shared__arrow_top);
        this.a.setDownArrow(f.reading__shared__arrow_bottom);
        this.a.a(dv.b(getContext(), 15.0f), 0, dv.b(getContext(), 15.0f), 0);
        this.z = new jh(getContext(), null);
        this.A = new LayoutParams(-1, -1);
        this.A.gravity = 17;
        this.z.setLayoutParams(this.A);
        this.z.setScrollRightResource(f.general__shared__arrow_right_13dip_ffffff);
        this.z.setScrollLeftResource(f.general__shared__arrow_left_13dip_ffffff);
        this.b = (BoxView) this.a.getCenterView();
        this.b.getLayoutParams().width = Math.min(getResources().getDisplayMetrics().widthPixels, dv.b(getContext(), 360.0f));
        this.d = (LinearLayout) findViewById(g.reading__selection_bar_view__line1);
        this.e = (LinearLayout) findViewById(g.reading__selection_bar_view__line2);
        this.f = (LinearLayout) findViewById(g.reading__selection_bar_view__line_visible);
        this.g = (FrameLayout) findViewById(g.reading__selection_bar_view__bottom_panel);
        this.c = findViewById(g.reading__selection_bar_view__firstline);
        this.h = (TextView) from.inflate(h.reading__selection_bar_button_view, this.d, false);
        this.k = (TextView) from.inflate(h.reading__selection_bar_button_view, this.d, false);
        this.i = (TextView) from.inflate(h.reading__selection_bar_button_view, this.d, false);
        this.m = (TextView) from.inflate(h.reading__selection_bar_button_view, this.d, false);
        this.j = (TextView) from.inflate(h.reading__selection_bar_button_view, this.d, false);
        this.n = (TextView) from.inflate(h.reading__selection_bar_button_view, this.d, false);
        this.o = (ViewGroup) from.inflate(h.reading__selection_bar_excerpt_button_view, this.d, false);
        this.q = (TextView) from.inflate(h.reading__selection_bar_button_view, this.d, false);
        this.r = (TextView) from.inflate(h.reading__selection_bar_dict_button_view, this.d, false);
        this.l = (TextView) from.inflate(h.reading__selection_bar_dict_button_view, this.d, false);
        this.t = (TextView) from.inflate(h.reading__selection_bar_button_view, this.e, false);
        this.s = (ViewGroup) from.inflate(h.reading__selection_colors_view, this.e, false);
        this.u = this.s.getChildAt(0);
        this.v = this.s.getChildAt(1);
        this.w = this.s.getChildAt(2);
        this.x = this.s.getChildAt(3);
        this.h.setText(getString(j.reading__selection_bar_view__correct));
        this.k.setText(getString(j.reading__selection_bar_view__correct));
        this.i.setText(getString(j.reading__selection_bar_view__share));
        this.m.setText(getString(j.reading__selection_bar_view__share));
        this.j.setText(getString(j.reading__selection_bar_view__copy));
        this.n.setText(getString(j.reading__selection_bar_view__copy));
        this.q.setText(getString(j.reading__selection_bar_view__comment));
        this.r.setText(getString(j.reading__selection_bar_view__dict));
        this.l.setText(getString(j.reading__selection_bar_view__dict));
        this.t.setText(getString(j.reading__selection_bar_view__delete));
        this.p = (ImageView) this.o.getChildAt(0);
        this.g.addView(this.E.getContentView());
        this.y = new LayoutParams(-2, -2);
        this.y.setMargins(dv.b(getContext(), -25.0f), 0, 0, 0);
        this.D = new HashMap();
        this.h.setOnClickListener(new zb(this));
        this.k.setOnClickListener(new zc(this));
        this.i.setOnClickListener(new zd(this));
        this.m.setOnClickListener(new ze(this));
        this.j.setOnClickListener(new zf(this));
        this.n.setOnClickListener(new zg(this));
        this.q.setOnClickListener(new zh(this));
        this.r.setOnClickListener(new zi(this));
        this.l.setOnClickListener(new yt(this));
        this.t.setOnClickListener(new yu(this));
        this.s.setOnClickListener(new yv(this));
        this.u.setOnClickListener(new yx(this));
        this.v.setOnClickListener(new yy(this));
        this.w.setOnClickListener(new yz(this));
        this.x.setOnClickListener(new za(this));
        this.u.setClickable(false);
        this.v.setClickable(false);
        this.w.setClickable(false);
        this.x.setClickable(false);
        f();
    }

    public void a(String str, boolean z, adl com_duokan_reader_ui_reading_adl) {
        this.I = com_duokan_reader_ui_reading_adl;
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.removeAllViews();
        this.f.addView(this.d);
        this.d.removeAllViews();
        this.e.removeAllViews();
        if (a()) {
            this.D.put("DictVisible", "TRUE");
            this.g.setVisibility(0);
            this.c.setVisibility(0);
            this.r.setSelected(true);
            this.l.setSelected(true);
            this.E.a(str, com_duokan_reader_ui_reading_adl);
        } else {
            this.D.put("DictVisible", "FALSE");
            this.g.setVisibility(8);
            this.c.setVisibility(8);
            this.r.setSelected(false);
            this.l.setSelected(false);
            com_duokan_reader_ui_reading_adl.b();
            this.G = str;
        }
        f();
    }

    protected boolean a() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, "Dict", false);
    }

    public void b(int i) {
        this.u.setSelected(false);
        this.v.setSelected(false);
        this.w.setSelected(false);
        this.x.setSelected(false);
        switch (i) {
            case 0:
                this.u.setSelected(true);
                return;
            case 1:
                this.v.setSelected(true);
                return;
            case 2:
                this.w.setSelected(true);
                return;
            case 3:
                this.x.setSelected(true);
                return;
            default:
                return;
        }
    }

    public void b() {
        this.u.setSelected(false);
        this.v.setSelected(false);
        this.w.setSelected(false);
        this.x.setSelected(false);
    }

    public void c() {
        if (this.g.getVisibility() == 8) {
            this.D.put("Action1", "DICT-OPEN");
            if (this.G != null) {
                this.g.getLayoutParams().height = d(this.H);
                this.E.a(this.G, this.I);
                this.G = null;
            }
            this.g.setVisibility(0);
            this.c.setVisibility(0);
            this.r.setSelected(true);
            ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "Dict", true);
            ReaderEnv.get().commitPrefs();
            return;
        }
        this.D.put("Action1", "DICT-CLOSE");
        this.g.setVisibility(8);
        this.c.setVisibility(8);
        this.r.setSelected(false);
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "Dict", false);
        ReaderEnv.get().commitPrefs();
    }

    public void d() {
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
        Animation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation2.setDuration(200);
        this.d.setVisibility(8);
        this.f.removeAllViews();
        this.e.setVisibility(0);
        if (this.e.getParent() != null) {
            ((ViewGroup) this.e.getParent()).removeView(this.e);
        }
        this.f.addView(this.e);
        this.d.startAnimation(translateAnimation);
        this.e.startAnimation(translateAnimation2);
    }

    public void a(View view, int i) {
        Animation translateAnimation = new TranslateAnimation(0, (float) (-i), 0, 0.0f, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(200);
        view.startAnimation(translateAnimation);
    }

    public void b(View view, int i) {
        Animation translateAnimation = new TranslateAnimation(0, (float) ((-i) + 3), 0, 0.0f, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(200);
        view.startAnimation(translateAnimation);
    }

    public void a(Rect... rectArr) {
        this.H = rectArr;
        c(rectArr);
    }

    public void b(Rect... rectArr) {
        c(rectArr);
        this.g.getLayoutParams().height = d(rectArr);
    }

    private void c(Rect... rectArr) {
        this.g.getLayoutParams().height = -2;
        this.b.setMaxHeight(e(rectArr));
        this.a.setVisibility(0);
        this.a.a(rectArr, false, (int) HttpStatus.SC_MULTIPLE_CHOICES);
        this.E.a();
    }

    private int d(Rect... rectArr) {
        return (e(rectArr) * 2) / 3;
    }

    private int e(Rect... rectArr) {
        int b = dv.b(getContext(), 15.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = (displayMetrics.heightPixels / 2) - b;
        Rect rect = (Rect) dv.g.a();
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
        dv.g.a(rect);
        return Math.min(Math.max(Math.max(i2, height), b), i);
    }

    public void e() {
        this.a.setVisibility(8);
        this.E.b();
    }

    protected void f() {
        Drawable drawable = getDrawable(f.reading__annotation_edit_view__placeholder_normal);
        es esVar = new es(new ColorDrawable(eg.a().b()));
        Bitmap c = a.c(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(c);
        esVar.a(drawable);
        esVar.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        esVar.draw(canvas);
        esVar.a(null);
        this.p.setImageBitmap(c);
    }

    protected boolean g() {
        c G = h().G();
        return G.ai() && G.o() != BookType.SERIAL;
    }

    protected sh h() {
        return (sh) getContext().queryFeature(sh.class);
    }

    public HashMap i() {
        return this.D;
    }
}
