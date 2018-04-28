package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.bookshelf.in;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0911h;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.DkListView;
import com.duokan.reader.ui.general.cd;
import com.duokan.reader.ui.general.ib;
import com.duokan.reader.ui.general.ie;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpStatus;

public class nu extends FrameLayout implements in {
    /* renamed from: a */
    private final int f10699a = Color.rgb(237, 108, 0);
    /* renamed from: b */
    private final su f10700b;
    /* renamed from: c */
    private final om f10701c;
    /* renamed from: d */
    private final ns f10702d;
    /* renamed from: e */
    private final ie f10703e;
    /* renamed from: f */
    private final ib f10704f;
    /* renamed from: g */
    private final DkListView f10705g;
    /* renamed from: h */
    private final cd f10706h;
    /* renamed from: i */
    private final DkListView f10707i;
    /* renamed from: j */
    private final DkListView f10708j;
    /* renamed from: k */
    private final Comparator<C0798a> f10709k = new nv(this);
    /* renamed from: l */
    private C0911h f10710l = null;
    /* renamed from: m */
    private C0901g f10711m = null;
    /* renamed from: n */
    private boolean f10712n = false;
    /* renamed from: o */
    private final int f10713o;
    /* renamed from: p */
    private final View f10714p;
    /* renamed from: q */
    private final TextView f10715q;
    /* renamed from: r */
    private final View f10716r;
    /* renamed from: s */
    private final TextView f10717s;
    /* renamed from: t */
    private int f10718t = 0;
    /* renamed from: u */
    private int f10719u = 0;
    /* renamed from: v */
    private int f10720v = 0;
    /* renamed from: w */
    private int f10721w = 0;

    public nu(Context context, su suVar, om omVar) {
        super(context);
        this.f10700b = suVar;
        this.f10701c = omVar;
        this.f10703e = new ie(getContext());
        addView(this.f10703e, new LayoutParams(-1, -1));
        int pageHeaderPaddingTop = ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderPaddingTop();
        this.f10713o = ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderHeight();
        this.f10702d = new ns(context);
        this.f10702d.setPadding(dv.m1932b(getContext(), 45.0f), pageHeaderPaddingTop, dv.m1932b(getContext(), 45.0f), 0);
        this.f10702d.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f10713o));
        addView(this.f10702d);
        LayoutInflater from = LayoutInflater.from(getContext());
        View view = (ImageView) from.inflate(C0256h.reading__navigation_tab_view, this, false);
        view.setContentDescription(getResources().getString(C0258j.reading__shared__toc));
        view.setImageResource(C0254f.reading__navigation_view__toc);
        View view2 = (ImageView) from.inflate(C0256h.reading__navigation_tab_view, this, false);
        view2.setContentDescription(getResources().getString(C0258j.reading__shared__bookmarks));
        view2.setImageResource(C0254f.reading__navigation_view__mark);
        View view3 = (ImageView) from.inflate(C0256h.reading__navigation_tab_view, this, false);
        view3.setContentDescription(getResources().getString(C0258j.reading__shared__annotations));
        view3.setImageResource(C0254f.reading__navigation_view__note);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        this.f10705g = new nz(this, getContext());
        this.f10705g.setSeekEnabled(true);
        this.f10705g.setRowSpacing(0);
        linearLayout.addView(this.f10705g, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        this.f10706h = new on();
        this.f10706h.mo1755b(true);
        this.f10705g.setAdapter(this.f10706h);
        this.f10706h.m10346a(new oa(this));
        this.f10705g.setOnItemClickListener(new ob(this));
        this.f10714p = LayoutInflater.from(context).inflate(C0256h.reading__export_comments_view, linearLayout, false);
        this.f10715q = (TextView) this.f10714p.findViewById(C0255g.reading__export_comments_view__text);
        this.f10715q.setOnClickListener(new oc(this));
        this.f10714p.setVisibility(8);
        linearLayout.addView(this.f10714p);
        this.f10707i = new DkListView(getContext());
        this.f10707i.setAdapter(new oj());
        this.f10707i.setOnItemClickListener(new oe(this));
        this.f10707i.setOnItemLongPressListener(new of(this));
        View linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        this.f10708j = new DkListView(getContext());
        linearLayout2.addView(this.f10708j, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        this.f10708j.setAdapter(new ol());
        this.f10708j.setOnItemClickListener(new og(this));
        this.f10708j.setOnItemLongPressListener(new oh(this));
        this.f10716r = LayoutInflater.from(context).inflate(C0256h.reading__export_comments_view, linearLayout2, false);
        this.f10717s = (TextView) this.f10716r.findViewById(C0255g.reading__export_comments_view__text);
        this.f10717s.setText(C0258j.reading__export_comments_view__export);
        this.f10716r.setOnClickListener(new nw(this));
        this.f10716r.setVisibility(8);
        linearLayout2.addView(this.f10716r);
        m14773c();
        this.f10704f = new ib(this.f10702d, this.f10703e, null);
        this.f10704f.m10775a(view, linearLayout);
        this.f10704f.m10775a(view2, this.f10707i);
        if (this.f10700b.mo1992G().mo1039q() != BookFormat.SBK) {
            this.f10704f.m10775a(view3, linearLayout2);
        }
        this.f10704f.m10774a(0);
        this.f10704f.m10776a(new nx(this));
        this.f10700b.getDocument().m5910a(new ny(this));
    }

    /* renamed from: a */
    public void m14790a() {
        m14766a(null, 0);
        if (this.f10710l == null) {
            this.f10710l = getDocument().mo1240h();
            this.f10712n = false;
            for (int i = 0; i < this.f10710l.mo1269c(); i++) {
                if (this.f10710l.mo1268b()[i].mo1206i() > 0) {
                    this.f10712n = true;
                    break;
                }
            }
        }
        m14770a(true);
        m14792b();
        if (this.f10700b.mo2106b(2)) {
            this.f10702d.setVisibility(8);
            this.f10702d.m1319a(0);
        } else {
            this.f10702d.setVisibility(0);
        }
        m14773c();
    }

    /* renamed from: b */
    public void m14792b() {
        if (this.f10710l != null) {
            m14777e();
            m14774d();
        }
    }

    public void draw(Canvas canvas) {
        Drawable background = getBackground();
        if (background != null) {
            background.setBounds(0, 0, getWidth(), getHeight());
        }
        super.draw(canvas);
    }

    /* renamed from: a */
    public void mo1683a(C0800c c0800c) {
        if (!this.f10700b.mo1994K() && this.f10710l != null && this.f10700b.mo1992G() == c0800c) {
            if (!c0800c.mo1038k() && !c0800c.mo1037j()) {
                return;
            }
            if (c0800c.m4171X() && c0800c.m4170W()) {
                this.f10715q.setText(String.format(getResources().getString(C0258j.reading__shared__downloading), new Object[]{Float.valueOf(c0800c.m4240m())}));
                return;
            }
            this.f10706h.mo1691d();
            m14779f();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ai.m3980a().m3887a((in) this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ai.m3980a().m3910b((in) this);
    }

    /* renamed from: c */
    private void m14773c() {
        int headerPaddingTop = ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getHeaderPaddingTop();
        if (headerPaddingTop > 0 && this.f10702d.getVisibility() == 8) {
            setPadding(0, headerPaddingTop, 0, 0);
        }
        headerPaddingTop = this.f10702d.getVisibility() == 0 ? this.f10713o : 0;
        this.f10705g.m1124b(0, headerPaddingTop, 0, 0);
        if (ReaderEnv.get().forHd()) {
            int b = dv.m1932b(getContext(), 25.0f);
            int b2 = dv.m1932b(getContext(), 30.0f);
            this.f10705g.setPadding(0, headerPaddingTop, 0, b2);
            this.f10707i.setPadding(b, headerPaddingTop, b, b2);
            this.f10708j.setPadding(b, headerPaddingTop, b, b2);
            return;
        }
        b = dv.m1932b(getContext(), 15.0f);
        this.f10705g.setPadding(0, headerPaddingTop, 0, b);
        this.f10707i.setPadding(b, headerPaddingTop, b, b);
        this.f10708j.setPadding(b, headerPaddingTop, b, b);
    }

    /* renamed from: a */
    private void m14770a(boolean z) {
        int i = 0;
        if (this.f10710l.mo1269c() < 1) {
            this.f10706h.mo1691d();
            return;
        }
        C0901g b;
        if (this.f10700b.mo2106b(2)) {
            b = this.f10710l.mo1267b(this.f10700b.mo2181w().mo2294e());
        } else {
            b = this.f10710l.mo1267b(this.f10700b.mo2009Z());
        }
        if (b != null) {
            this.f10711m = b;
            Rect rect = new Rect(0, this.f10705g.getPaddingTop(), getWidth(), getHeight());
            if (this.f10712n) {
                int i2;
                int i3 = 0;
                for (i2 = 0; i2 < this.f10710l.mo1269c(); i2++) {
                    C0901g c0901g = this.f10710l.mo1268b()[i2];
                    if (c0901g.m5866a(this.f10711m)) {
                        C0901g[] b2 = c0901g.m5867b();
                        int length = b2.length;
                        while (i < length && b2[i] != this.f10711m) {
                            i3++;
                            i++;
                        }
                        if (!this.f10706h.mo1556c(i2) && z) {
                            this.f10706h.m10356f(i2);
                        }
                        if (this.f10706h.mo1556c(i2)) {
                            this.f10711m = this.f10710l.mo1268b()[i2];
                            this.f10706h.mo1691d();
                            this.f10705g.m1170a(i2, rect, 17);
                            return;
                        }
                        this.f10706h.mo1691d();
                        this.f10705g.m1126b(i3, rect, 17);
                        return;
                    }
                    i3 += c0901g.m5865a();
                }
                this.f10706h.m10356f(i2);
                if (this.f10706h.mo1556c(i2)) {
                    this.f10706h.mo1691d();
                    this.f10705g.m1126b(i3, rect, 17);
                    return;
                }
                this.f10711m = this.f10710l.mo1268b()[i2];
                this.f10706h.mo1691d();
                this.f10705g.m1170a(i2, rect, 17);
                return;
            }
            this.f10706h.mo1691d();
            this.f10705g.m1126b(this.f10711m.mo1200c(), rect, 17);
        }
    }

    /* renamed from: d */
    private void m14774d() {
        int i = 0;
        C0798a[] as = this.f10700b.mo1992G().as();
        List linkedList = new LinkedList();
        for (C0798a c0798a : as) {
            if (c0798a instanceof ah) {
                linkedList.add((ah) c0798a);
            }
        }
        Collections.sort(linkedList, this.f10709k);
        List linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(this.f10710l.mo1267b(((ah) linkedList.get(i)).m3726d()));
            i++;
        }
        ((oj) this.f10707i.getAdapter()).m14812a(linkedList, linkedList2);
    }

    /* renamed from: e */
    private void m14777e() {
        int i = 0;
        C0798a[] as = this.f10700b.mo1992G().as();
        List linkedList = new LinkedList();
        for (C0798a c0798a : as) {
            if (c0798a instanceof ea) {
                linkedList.add((ea) c0798a);
            }
        }
        Collections.sort(linkedList, this.f10709k);
        List linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(this.f10710l.mo1267b(((ea) linkedList.get(i)).m3726d()));
            i++;
        }
        ((oi) this.f10708j.getAdapter()).m14812a(linkedList, linkedList2);
    }

    private C0903n getDocument() {
        return this.f10700b.getDocument();
    }

    /* renamed from: a */
    private void m14766a(Drawable drawable, int i) {
        setBackgroundColor(-1);
        this.f10718t = Color.rgb(88, 88, 88);
        this.f10719u = Color.rgb(92, 92, 92);
        this.f10721w = Color.rgb(153, 153, 153);
        this.f10720v = Color.rgb(HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT);
        this.f10717s.setTextColor(this.f10719u);
        this.f10715q.setTextColor(this.f10719u);
    }

    /* renamed from: a */
    private void m14767a(C0901g c0901g) {
        this.f10700b.aP();
        if (this.f10700b.mo2106b(2)) {
            if (c0901g.mo1208k()) {
                this.f10700b.mo2181w().mo2289a(c0901g.mo1203f(), true);
            } else {
                this.f10700b.mo2181w().mo2288a(this.f10700b.mo2181w().mo2291c() - 1, true);
            }
        } else if (c0901g.mo1208k()) {
            this.f10700b.mo2027a(c0901g);
        } else {
            this.f10700b.av();
        }
    }

    /* renamed from: f */
    private void m14779f() {
        int i;
        C0800c G = this.f10700b.mo1992G();
        if (!(this.f10700b instanceof bm) || !((bm) this.f10700b).h_()) {
            this.f10714p.setVisibility(8);
        } else if (G.m4171X()) {
            if (G.m4173Z() || G.m4172Y()) {
                this.f10715q.setText(C0258j.reading__shared__download_pause);
            } else {
                this.f10715q.setText(String.format(getResources().getString(C0258j.reading__shared__downloading), new Object[]{Float.valueOf(G.m4240m())}));
            }
            this.f10714p.setVisibility(0);
        } else if (G.mo1038k()) {
            this.f10715q.setText(C0258j.reading__shared__serial_download);
            this.f10714p.setVisibility(0);
        } else if (G.m4233i() != BookState.NORMAL) {
            this.f10715q.setText(C0258j.reading__shared__linear_download);
            this.f10714p.setVisibility(0);
        } else {
            this.f10714p.setVisibility(8);
        }
        View view = this.f10716r;
        if (this.f10708j.getAdapter().mo506c() > 0) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
    }
}
