package com.duokan.reader.ui.reading;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.sys.AIdleOperation;
import com.duokan.core.ui.UTools;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.document.epub.s;
import com.duokan.reader.domain.document.txt.p;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.DkLabelView.ContentMode;
import com.duokan.reader.ui.general.cd;

import org.apache.http.HttpStatus;

class od extends cd {
    static final /* synthetic */ boolean c = (!nk.class.desiredAssertionStatus());
    final int a;
    final /* synthetic */ nk d;
    private boolean e;

    private od(nk nkVar) {
        this.d = nkVar;
        this.a = Color.rgb(HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT);
        this.e = false;
    }

    public /* synthetic */ Object b(int i, int i2) {
        return c(i, i2);
    }

    public /* synthetic */ Object i(int i) {
        return k(i);
    }

    public View a(View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.d.getContext()).inflate(h.reading__toc_empty_view, viewGroup, false);
        ((ImageView) inflate.findViewById(g.reading__toc_empty_view__icon)).setColorFilter(Color.argb((int) Math.round(25.5d), Color.red(this.d.u), Color.green(this.d.u), Color.blue(this.d.u)), Mode.SRC_IN);
        ((TextView) inflate.findViewById(g.reading__toc_empty_view__no_toc)).setTextColor(Color.argb((int) Math.round(102.0d), Color.red(this.d.u), Color.green(this.d.u), Color.blue(this.d.u)));
        return inflate;
    }

    public int c() {
        if (this.d.n) {
            return super.c();
        }
        return h(0);
    }

    public int a() {
        if (this.d.n) {
            return this.d.l.c();
        }
        return 0;
    }

    public int h(int i) {
        if (this.d.n) {
            return this.d.l.b()[i].a();
        }
        return this.d.l.c();
    }

    public com.duokan.reader.domain.document.g k(int i) {
        if (this.d.n) {
            return this.d.l.b()[i];
        }
        if (c) {
            return null;
        }
        throw new AssertionError();
    }

    public com.duokan.reader.domain.document.g c(int i, int i2) {
        if (this.d.n) {
            return this.d.l.b()[i].b()[i2];
        }
        return this.d.l.b()[i2];
    }

    private View a(com.duokan.reader.domain.document.g gVar, int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null || view.getId() != g.reading__toc_item_view__root) {
            view = LayoutInflater.from(this.d.getContext()).inflate(h.reading__toc_item_view, viewGroup, false);
        }
        DkLabelView dkLabelView = (DkLabelView) view.findViewById(g.reading__toc_item_view__title);
        dkLabelView.setText(this.d.b.T() ? DkUtils.chs2chtText(gVar.e()) : gVar.e());
        view.findViewById(g.reading__toc_item_view__divider).setBackgroundColor(this.d.v);
        ImageView imageView = (ImageView) view.findViewById(g.reading__toc_item_view__lock);
        imageView.setVisibility(8);
        boolean z2;
        if (this.d.b.G().k()) {
            aaq com_duokan_reader_ui_reading_aaq = (aaq) this.d.b;
            long c = (long) gVar.c();
            String a = com_duokan_reader_ui_reading_aaq.a(c);
            if (com_duokan_reader_ui_reading_aaq.j(c).b(Boolean.valueOf(true)) || com_duokan_reader_ui_reading_aaq.d(a)) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(f.reading__toc_item_view__lock_icon);
            }
            z2 = imageView.getVisibility() != 0 && gVar.k();
            int h = gVar.h();
            if (h > 0) {
                dkLabelView.setPadding((h * ((int) dkLabelView.getTextSize())) + UTools.closeAnimation(this.d.getContext(), 45.0f), 0, 0, 0);
            } else {
                dkLabelView.setPadding(0, 0, 0, 0);
            }
            if (this.d.m == gVar) {
                dkLabelView.setTextColor(this.d.a);
            } else if (com_duokan_reader_ui_reading_aaq.d(a)) {
                dkLabelView.setTextColor(this.d.u);
            } else {
                dkLabelView.setTextColor(this.a);
            }
        } else if (this.d.getDocument() instanceof p) {
            if (this.d.m == gVar) {
                dkLabelView.setTextColor(this.d.a);
            } else {
                dkLabelView.setTextColor(this.d.u);
            }
            z2 = true;
        } else if (this.d.getDocument() instanceof d) {
            r1 = gVar.h();
            if (r1 > 0) {
                dkLabelView.setPadding((r1 * ((int) dkLabelView.getTextSize())) + UTools.closeAnimation(this.d.getContext(), 45.0f), 0, 0, 0);
            } else {
                dkLabelView.setPadding(0, 0, 0, 0);
            }
            if (!gVar.k()) {
                dkLabelView.setTextColor(this.a);
            } else if (this.d.m == gVar) {
                dkLabelView.setTextColor(this.d.a);
            } else {
                dkLabelView.setTextColor(this.d.u);
            }
            z2 = gVar.k();
        } else if (this.d.getDocument() instanceof s) {
            s sVar = (s) this.d.b.getDocument();
            fv fvVar = (fv) this.d.b.G();
            if (fvVar.P() && !gVar.k()) {
                imageView.setVisibility(0);
                imageView.setImageResource(f.reading__toc_item_view__lock_icon);
            } else if (!sVar.e(((com.duokan.reader.domain.document.epub.f) gVar).l()) || fvVar.aX()) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(f.reading__toc_item_view__lock_icon);
            }
            boolean z3 = imageView.getVisibility() != 0 && gVar.k();
            r1 = gVar.h();
            if (r1 > 0) {
                dkLabelView.setPadding((r1 * ((int) dkLabelView.getTextSize())) + UTools.closeAnimation(this.d.getContext(), 45.0f), 0, 0, 0);
            } else {
                dkLabelView.setPadding(0, 0, 0, 0);
            }
            if (fvVar.s() == BookPackageType.EPUB_OPF) {
                av d = sVar.d(((com.duokan.reader.domain.document.epub.f) gVar).l());
                if (this.d.m == gVar) {
                    dkLabelView.setTextColor(this.d.a);
                } else if (d == null || d.i()) {
                    dkLabelView.setTextColor(this.d.u);
                } else {
                    dkLabelView.setTextColor(this.a);
                }
            } else if (!gVar.k()) {
                dkLabelView.setTextColor(this.a);
            } else if (this.d.m == gVar) {
                dkLabelView.setTextColor(this.d.a);
            } else {
                dkLabelView.setTextColor(this.d.u);
            }
            z2 = z3;
        } else if (c) {
            z2 = false;
        } else {
            throw new AssertionError();
        }
        dkLabelView = (DkLabelView) view.findViewById(g.reading__toc_item_view__page_num);
        if (this.d.b.L() <= 0 || !r1) {
            dkLabelView.setVisibility(8);
        } else {
            dkLabelView.setContentMode(ContentMode.NUM);
            dkLabelView.setTextColor(this.d.w);
            if (this.d.getDocument() instanceof s) {
                Document_a g = gVar.g();
                if (g.b()) {
                    dkLabelView.setText(String.valueOf(this.d.b.b(g)));
                } else {
                    dkLabelView.setText("");
                    this.d.getDocument().d(g);
                    if (!this.e) {
                        this.e = true;
                        AIdleOperation.addIdleStatus(new oe(this));
                    }
                }
            } else {
                dkLabelView.setText(String.valueOf(this.d.b.b(gVar.f())));
            }
            dkLabelView.setVisibility(0);
        }
        return view;
    }

    public View a(int i, boolean z, View view, ViewGroup viewGroup) {
        com.duokan.reader.domain.document.g k = k(i);
        View a = a(k, i, false, view, viewGroup);
        ImageView imageView = (ImageView) a.findViewById(g.reading__toc_item_view__expand);
        imageView.setVisibility(0);
        if (k.a() > 0) {
            CharSequence string;
            imageView.setImageResource(f.general__shared__expandable_group_black_indicator);
            imageView.setSelected(z);
            if (z) {
                string = this.d.getResources().getString(com.duokan.c.j.reading__shared__collapse);
            } else {
                string = this.d.getResources().getString(com.duokan.c.j.reading__shared__expand);
            }
            imageView.setContentDescription(string);
            imageView.setOnClickListener(new og(this, i));
        } else {
            imageView.setImageResource(f.reading__toc_item_view__dot);
            imageView.setContentDescription("");
            imageView.setOnClickListener(null);
        }
        return a;
    }

    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        View a = a(c(i, i2), i2, true, view, viewGroup);
        a.findViewById(g.reading__toc_item_view__expand).setVisibility(8);
        return a;
    }

    public void j(int i) {
        this.d.g.b(i);
        this.d.g.scrollBy(0, -this.d.g.getPaddingTop());
        this.d.g.e();
    }
}
