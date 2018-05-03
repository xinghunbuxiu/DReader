package com.duokan.reader.ui.reading;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.ui.AnimUtils;
import com.duokan.kernel.DkUtils;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.epub.C0938f;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.document.p045a.C0904d;
import com.duokan.reader.domain.document.txt.C1000p;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.DkLabelView.ContentMode;
import com.duokan.reader.ui.general.cd;
import org.apache.http.HttpStatus;

class on extends cd {
    /* renamed from: c */
    static final /* synthetic */ boolean f10745c = (!nu.class.desiredAssertionStatus());
    /* renamed from: a */
    final int f10746a;
    /* renamed from: d */
    final /* synthetic */ nu f10747d;
    /* renamed from: e */
    private boolean f10748e;

    private on(nu nuVar) {
        this.f10747d = nuVar;
        this.f10746a = Color.rgb(HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT);
        this.f10748e = false;
    }

    /* renamed from: b */
    public /* synthetic */ Object mo2456b(int i, int i2) {
        return m14827c(i, i2);
    }

    /* renamed from: i */
    public /* synthetic */ Object mo2458i(int i) {
        return mo2460k(i);
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f10747d.getContext()).inflate(C0256h.reading__toc_empty_view, viewGroup, false);
        ((ImageView) inflate.findViewById(C0255g.reading__toc_empty_view__icon)).setColorFilter(Color.argb((int) Math.round(25.5d), Color.red(this.f10747d.f10719u), Color.green(this.f10747d.f10719u), Color.blue(this.f10747d.f10719u)), Mode.SRC_IN);
        ((TextView) inflate.findViewById(C0255g.reading__toc_empty_view__no_toc)).setTextColor(Color.argb((int) Math.round(102.0d), Color.red(this.f10747d.f10719u), Color.green(this.f10747d.f10719u), Color.blue(this.f10747d.f10719u)));
        return inflate;
    }

    /* renamed from: c */
    public int mo506c() {
        if (this.f10747d.f10712n) {
            return super.mo506c();
        }
        return mo2457h(0);
    }

    /* renamed from: a */
    public int mo486a() {
        if (this.f10747d.f10712n) {
            return this.f10747d.f10710l.mo1269c();
        }
        return 0;
    }

    /* renamed from: h */
    public int mo2457h(int i) {
        if (this.f10747d.f10712n) {
            return this.f10747d.f10710l.mo1268b()[i].m5865a();
        }
        return this.f10747d.f10710l.mo1269c();
    }

    /* renamed from: k */
    public C0901g mo2460k(int i) {
        if (this.f10747d.f10712n) {
            return this.f10747d.f10710l.mo1268b()[i];
        }
        if (f10745c) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public C0901g m14827c(int i, int i2) {
        if (this.f10747d.f10712n) {
            return this.f10747d.f10710l.mo1268b()[i].m5867b()[i2];
        }
        return this.f10747d.f10710l.mo1268b()[i2];
    }

    /* renamed from: a */
    private View m14819a(C0901g c0901g, int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null || view.getId() != C0255g.reading__toc_item_view__root) {
            view = LayoutInflater.from(this.f10747d.getContext()).inflate(C0256h.reading__toc_item_view, viewGroup, false);
        }
        DkLabelView dkLabelView = (DkLabelView) view.findViewById(C0255g.reading__toc_item_view__title);
        dkLabelView.setText(this.f10747d.f10700b.mo2003T() ? DkUtils.chs2chtText(c0901g.mo1202e()) : c0901g.mo1202e());
        view.findViewById(C0255g.reading__toc_item_view__divider).setBackgroundColor(this.f10747d.f10720v);
        ImageView imageView = (ImageView) view.findViewById(C0255g.reading__toc_item_view__lock);
        imageView.setVisibility(8);
        boolean z2;
        if (this.f10747d.f10700b.mo1992G().mo1038k()) {
            abd abd = (abd) this.f10747d.f10700b;
            long c = (long) c0901g.mo1200c();
            String a = abd.mo2356a(c);
            if (abd.mo2197j(c).m862b(Boolean.valueOf(true)) || abd.mo2192c(a)) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(C0254f.reading__toc_item_view__lock_icon);
            }
            z2 = imageView.getVisibility() != 0 && c0901g.mo1208k();
            int h = c0901g.mo1205h();
            if (h > 0) {
                dkLabelView.setPadding((h * ((int) dkLabelView.getTextSize())) + AnimUtils.m1932b(this.f10747d.getContext(), 45.0f), 0, 0, 0);
            } else {
                dkLabelView.setPadding(0, 0, 0, 0);
            }
            if (this.f10747d.f10711m == c0901g) {
                dkLabelView.setTextColor(this.f10747d.f10699a);
            } else if (abd.mo2192c(a)) {
                dkLabelView.setTextColor(this.f10747d.f10719u);
            } else {
                dkLabelView.setTextColor(this.f10746a);
            }
        } else if (this.f10747d.getDocument() instanceof C1000p) {
            if (this.f10747d.f10711m == c0901g) {
                dkLabelView.setTextColor(this.f10747d.f10699a);
            } else {
                dkLabelView.setTextColor(this.f10747d.f10719u);
            }
            z2 = true;
        } else if (this.f10747d.getDocument() instanceof C0904d) {
            r1 = c0901g.mo1205h();
            if (r1 > 0) {
                dkLabelView.setPadding((r1 * ((int) dkLabelView.getTextSize())) + AnimUtils.m1932b(this.f10747d.getContext(), 45.0f), 0, 0, 0);
            } else {
                dkLabelView.setPadding(0, 0, 0, 0);
            }
            if (!c0901g.mo1208k()) {
                dkLabelView.setTextColor(this.f10746a);
            } else if (this.f10747d.f10711m == c0901g) {
                dkLabelView.setTextColor(this.f10747d.f10699a);
            } else {
                dkLabelView.setTextColor(this.f10747d.f10719u);
            }
            z2 = c0901g.mo1208k();
        } else if (this.f10747d.getDocument() instanceof C0952s) {
            C0952s c0952s = (C0952s) this.f10747d.f10700b.getDocument();
            fp fpVar = (fp) this.f10747d.f10700b.mo1992G();
            if (fpVar.m4165R() && !c0901g.mo1208k()) {
                imageView.setVisibility(0);
                imageView.setImageResource(C0254f.reading__toc_item_view__lock_icon);
            } else if (!c0952s.m7068e(((C0938f) c0901g).mo1432l()) || fpVar.aZ()) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(C0254f.reading__toc_item_view__lock_icon);
            }
            boolean z3 = imageView.getVisibility() != 0 && c0901g.mo1208k();
            r1 = c0901g.mo1205h();
            if (r1 > 0) {
                dkLabelView.setPadding((r1 * ((int) dkLabelView.getTextSize())) + AnimUtils.m1932b(this.f10747d.getContext(), 45.0f), 0, 0, 0);
            } else {
                dkLabelView.setPadding(0, 0, 0, 0);
            }
            if (fpVar.m4247s() == BookPackageType.EPUB_OPF) {
                av d = c0952s.m7064d(((C0938f) c0901g).mo1432l());
                if (this.f10747d.f10711m == c0901g) {
                    dkLabelView.setTextColor(this.f10747d.f10699a);
                } else if (d == null || d.mo1073i()) {
                    dkLabelView.setTextColor(this.f10747d.f10719u);
                } else {
                    dkLabelView.setTextColor(this.f10746a);
                }
            } else if (!c0901g.mo1208k()) {
                dkLabelView.setTextColor(this.f10746a);
            } else if (this.f10747d.f10711m == c0901g) {
                dkLabelView.setTextColor(this.f10747d.f10699a);
            } else {
                dkLabelView.setTextColor(this.f10747d.f10719u);
            }
            z2 = z3;
        } else if (f10745c) {
            z2 = false;
        } else {
            throw new AssertionError();
        }
        dkLabelView = (DkLabelView) view.findViewById(C0255g.reading__toc_item_view__page_num);
        if (this.f10747d.f10700b.mo1995L() <= 0 || !z2) {
            dkLabelView.setVisibility(8);
        } else {
            dkLabelView.setContentMode(ContentMode.NUM);
            dkLabelView.setTextColor(this.f10747d.f10721w);
            if (this.f10747d.getDocument() instanceof C0952s) {
                C0896a g = c0901g.mo1204g();
                if (g.m5777b()) {
                    dkLabelView.setText(String.valueOf(this.f10747d.f10700b.mo2093b(g)));
                } else {
                    dkLabelView.setText("");
                    this.f10747d.getDocument().mo1233d(g);
                    if (!this.f10748e) {
                        this.f10748e = true;
                        UIdleHandler.addIdleHandler(new oo(this));
                    }
                }
            } else {
                dkLabelView.setText(String.valueOf(this.f10747d.f10700b.mo2093b(c0901g.mo1203f())));
            }
            dkLabelView.setVisibility(0);
        }
        return view;
    }

    /* renamed from: a */
    public View mo2455a(int i, boolean z, View view, ViewGroup viewGroup) {
        C0901g k = mo2460k(i);
        View a = m14819a(k, i, false, view, viewGroup);
        ImageView imageView = (ImageView) a.findViewById(C0255g.reading__toc_item_view__expand);
        imageView.setVisibility(0);
        if (k.m5865a() > 0) {
            CharSequence string;
            imageView.setImageResource(C0254f.general__shared__expandable_group_black_indicator);
            imageView.setSelected(z);
            if (z) {
                string = this.f10747d.getResources().getString(C0258j.reading__shared__collapse);
            } else {
                string = this.f10747d.getResources().getString(C0258j.reading__shared__expand);
            }
            imageView.setContentDescription(string);
            imageView.setOnClickListener(new oq(this, i));
        } else {
            imageView.setImageResource(C0254f.reading__toc_item_view__dot);
            imageView.setContentDescription("");
            imageView.setOnClickListener(null);
        }
        return a;
    }

    /* renamed from: a */
    public View mo2454a(int i, int i2, View view, ViewGroup viewGroup) {
        View a = m14819a(m14827c(i, i2), i2, true, view, viewGroup);
        a.findViewById(C0255g.reading__toc_item_view__expand).setVisibility(8);
        return a;
    }

    /* renamed from: j */
    public void mo2459j(int i) {
        this.f10747d.f10705g.mo451b(i);
        this.f10747d.f10705g.scrollBy(0, -this.f10747d.f10705g.getPaddingTop());
        this.f10747d.f10705g.m1138e();
    }
}
