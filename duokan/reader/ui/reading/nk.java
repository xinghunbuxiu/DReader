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

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.ui.general.DkListView;
import com.duokan.reader.ui.general.cd;
import com.duokan.reader.ui.general.ir;
import com.duokan.reader.ui.general.iu;
import com.duokan.reader.ui.ITheme;

import org.apache.http.HttpStatus;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class nk extends FrameLayout implements it {
    private final int a = Color.rgb(237, 108, 0);
    private final sh b;
    private final oc c;
    private final ni d;
    private final iu e;
    private final ir f;
    private final DkListView g;
    private final cd h;
    private final DkListView i;
    private final DkListView j;
    private final Comparator k = new nl(this);
    private h l = null;
    private g m = null;
    private boolean n = false;
    private final int o;
    private final View p;
    private final TextView q;
    private final View r;
    private final TextView s;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;

    public nk(Context context, sh shVar, oc ocVar) {
        super(context);
        this.b = shVar;
        this.c = ocVar;
        this.e = new iu(getContext());
        addView(this.e, new LayoutParams(-1, -1));
        this.o = UTools.getMinimumHeight(context, 65.0f);
        this.d = new ni(context);
        this.d.setPadding(UTools.getMinimumHeight(getContext(), 45.0f), UTools.getMinimumHeight(getContext(), 20.0f), UTools.getMinimumHeight(getContext(), 45.0f), 0);
        this.d.setLayoutParams(new ViewGroup.LayoutParams(-1, this.o));
        addView(this.d);
        LayoutInflater from = LayoutInflater.from(getContext());
        View view = (ImageView) from.inflate(com.duokan.c.h.reading__navigation_tab_view, this, false);
        view.setContentDescription(getResources().getString(j.reading__shared__toc));
        view.setImageResource(f.reading__navigation_view__toc);
        View view2 = (ImageView) from.inflate(com.duokan.c.h.reading__navigation_tab_view, this, false);
        view2.setContentDescription(getResources().getString(j.reading__shared__bookmarks));
        view2.setImageResource(f.reading__navigation_view__mark);
        View view3 = (ImageView) from.inflate(com.duokan.c.h.reading__navigation_tab_view, this, false);
        view3.setContentDescription(getResources().getString(j.reading__shared__annotations));
        view3.setImageResource(f.reading__navigation_view__note);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        this.g = new np(this, getContext());
        this.g.setSeekEnabled(true);
        this.g.setRowSpacing(0);
        linearLayout.addView(this.g, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        this.h = new od();
        this.h.b(true);
        this.g.setAdapter(this.h);
        this.h.a(new nq(this));
        this.g.setOnItemClickListener(new nr(this));
        this.p = LayoutInflater.from(context).inflate(com.duokan.c.h.reading__export_comments_view, linearLayout, false);
        this.q = (TextView) this.p.findViewById(com.duokan.c.g.reading__export_comments_view__text);
        this.q.setOnClickListener(new ns(this));
        this.p.setVisibility(8);
        linearLayout.addView(this.p);
        this.i = new DkListView(getContext());
        this.i.setAdapter(new nz());
        this.i.setOnItemClickListener(new nu(this));
        this.i.setOnItemLongPressListener(new nv(this));
        View linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        this.j = new DkListView(getContext());
        linearLayout2.addView(this.j, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        this.j.setAdapter(new ob());
        this.j.setOnItemClickListener(new nw(this));
        this.j.setOnItemLongPressListener(new nx(this));
        this.r = LayoutInflater.from(context).inflate(com.duokan.c.h.reading__export_comments_view, linearLayout2, false);
        this.s = (TextView) this.r.findViewById(com.duokan.c.g.reading__export_comments_view__text);
        this.s.setText(j.reading__export_comments_view__export);
        this.r.setOnClickListener(new nm(this));
        this.r.setVisibility(8);
        linearLayout2.addView(this.r);
        c();
        this.f = new ir(this.d, this.e, null);
        this.f.a(view, linearLayout);
        this.f.a(view2, this.i);
        if (this.b.G().q() != BookFormat.SBK) {
            this.f.a(view3, linearLayout2);
        }
        this.f.a(0);
        this.f.a(new nn(this));
        this.b.getDocument().a(new no(this));
    }

    public void a() {
        a(null, 0);
        if (this.l == null) {
            this.l = getDocument().h();
            this.n = false;
            for (int i = 0; i < this.l.c(); i++) {
                if (this.l.b()[i].i() > 0) {
                    this.n = true;
                    break;
                }
            }
        }
        a(true);
        b();
        if (this.b.b(2)) {
            this.d.setVisibility(8);
            this.d.a(0);
        } else {
            this.d.setVisibility(0);
        }
        c();
    }

    public void b() {
        if (this.l != null) {
            e();
            d();
        }
    }

    public void draw(Canvas canvas) {
        Drawable background = getBackground();
        if (background != null) {
            background.setBounds(0, 0, getWidth(), getHeight());
        }
        super.draw(canvas);
    }

    public void a(c cVar) {
        if (!this.b.K() && this.l != null && this.b.G() == cVar) {
            if (!cVar.k() && !cVar.j()) {
                return;
            }
            if (cVar.V() && cVar.U()) {
                this.q.setText(String.format(getResources().getString(j.reading__shared__downloading), new Object[]{Float.valueOf(cVar.m())}));
                return;
            }
            this.h.d();
            f();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ai.a().a((it) this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ai.a().b((it) this);
    }

    private void c() {
        int headerPaddingTop = ((ITheme) MyContextWrapper.getFeature(getContext()).queryFeature(ITheme.class)).getTheme().getHeaderPaddingTop();
        if (headerPaddingTop > 0 && this.d.getVisibility() == 8) {
            setPadding(0, headerPaddingTop, 0, 0);
        }
        headerPaddingTop = this.d.getVisibility() == 0 ? this.o : 0;
        this.g.b(0, headerPaddingTop, 0, 0);
        if (ReaderEnv.get().forHd()) {
            int b = UTools.getMinimumHeight(getContext(), 25.0f);
            int b2 = UTools.getMinimumHeight(getContext(), 30.0f);
            this.g.setPadding(0, headerPaddingTop, 0, b2);
            this.i.setPadding(b, headerPaddingTop, b, b2);
            this.j.setPadding(b, headerPaddingTop, b, b2);
            return;
        }
        b = UTools.getMinimumHeight(getContext(), 15.0f);
        this.g.setPadding(0, headerPaddingTop, 0, b);
        this.i.setPadding(b, headerPaddingTop, b, b);
        this.j.setPadding(b, headerPaddingTop, b, b);
    }

    private void a(boolean z) {
        int i = 0;
        if (this.l.c() < 1) {
            this.h.d();
            return;
        }
        g b;
        if (this.b.b(2)) {
            b = this.l.b(this.b.w().e());
        } else {
            b = this.l.b(this.b.Z());
        }
        if (b != null) {
            this.m = b;
            Rect rect = new Rect(0, this.g.getPaddingTop(), getWidth(), getHeight());
            if (this.n) {
                int i2;
                int i3 = 0;
                for (i2 = 0; i2 < this.l.c(); i2++) {
                    g gVar = this.l.b()[i2];
                    if (gVar.a(this.m)) {
                        g[] b2 = gVar.b();
                        int length = b2.length;
                        while (i < length && b2[i] != this.m) {
                            i3++;
                            i++;
                        }
                        if (!this.h.c(i2) && z) {
                            this.h.f(i2);
                        }
                        if (this.h.c(i2)) {
                            this.m = this.l.b()[i2];
                            this.h.d();
                            this.g.a(i2, rect, 17);
                            return;
                        }
                        this.h.d();
                        this.g.b(i3, rect, 17);
                        return;
                    }
                    i3 += gVar.a();
                }
                this.h.f(i2);
                if (this.h.c(i2)) {
                    this.h.d();
                    this.g.b(i3, rect, 17);
                    return;
                }
                this.m = this.l.b()[i2];
                this.h.d();
                this.g.a(i2, rect, 17);
                return;
            }
            this.h.d();
            this.g.b(this.m.c(), rect, 17);
        }
    }

    private void d() {
        int i = 0;
        a[] aq = this.b.G().aq();
        List linkedList = new LinkedList();
        for (a aVar : aq) {
            if (aVar instanceof ah) {
                linkedList.add((ah) aVar);
            }
        }
        Collections.sort(linkedList, this.k);
        List linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(this.l.b(((ah) linkedList.get(i)).d()));
            i++;
        }
        ((nz) this.i.getAdapter()).a(linkedList, linkedList2);
    }

    private void e() {
        int i = 0;
        a[] aq = this.b.G().aq();
        List linkedList = new LinkedList();
        for (a aVar : aq) {
            if (aVar instanceof ef) {
                linkedList.add((ef) aVar);
            }
        }
        Collections.sort(linkedList, this.k);
        List linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(this.l.b(((ef) linkedList.get(i)).d()));
            i++;
        }
        ((ny) this.j.getAdapter()).a(linkedList, linkedList2);
    }

    private n getDocument() {
        return this.b.getDocument();
    }

    private void a(Drawable drawable, int i) {
        setBackgroundColor(-1);
        this.t = Color.rgb(88, 88, 88);
        this.u = Color.rgb(92, 92, 92);
        this.w = Color.rgb(153, 153, 153);
        this.v = Color.rgb(HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT);
        this.s.setTextColor(this.u);
        this.q.setTextColor(this.u);
    }

    private void a(g gVar) {
        this.b.aP();
        if (this.b.b(2)) {
            if (gVar.k()) {
                this.b.w().a(gVar.f(), true);
            } else {
                this.b.w().a(this.b.w().c() - 1, true);
            }
        } else if (gVar.k()) {
            this.b.a(gVar);
        } else {
            this.b.av();
        }
    }

    private void f() {
        int i;
        c G = this.b.G();
        if (!(this.b instanceof bm) || !((bm) this.b).g_()) {
            this.p.setVisibility(8);
        } else if (G.V()) {
            if (G.X() || G.W()) {
                this.q.setText(j.reading__shared__download_pause);
            } else {
                this.q.setText(String.format(getResources().getString(j.reading__shared__downloading), new Object[]{Float.valueOf(G.m())}));
            }
            this.p.setVisibility(0);
        } else if (G.k()) {
            this.q.setText(j.reading__shared__serial_download);
            this.p.setVisibility(0);
        } else if (G.i() != BookState.NORMAL) {
            this.q.setText(j.reading__shared__linear_download);
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(8);
        }
        View view = this.r;
        if (this.j.getAdapter().c() > 0) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
    }
}
