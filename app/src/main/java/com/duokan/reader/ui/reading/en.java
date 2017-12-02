package com.duokan.reader.ui.reading;

import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.b.e;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.b.b;
import com.duokan.reader.domain.b.m;
import com.duokan.reader.domain.b.o;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.TabView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class en extends ek {
    private boolean a = true;
    private final sh b = ((sh) getContext().queryFeature(sh.class));
    private final HeaderView c = ((HeaderView) findViewById(f.reading__custom_font_list_view__header));
    private final TabView d;
    private final LinearLayout e;
    private final View f;
    private final View g;
    private final ArrayList h = new ArrayList();
    private final boolean i;
    private o j = null;
    private TextView k = null;

    public en(y yVar, boolean z) {
        super(yVar);
        this.c.setLeftTitle(i.reading__custom_font_list_view__dk_title);
        this.c.a(getContext().getResources().getDrawable(e.reading__custom_font_list_view__add_font_dark)).setOnClickListener(new eo(this));
        this.d = (TabView) findViewById(f.reading__custom_font_list_view__tab);
        this.k = (TextView) findViewById(f.reading__custom_font_list_view__defautl_font);
        this.e = (LinearLayout) findViewById(f.reading__custom_font_list_view__list);
        this.i = z;
        this.f = findViewById(f.reading__custom_font_list_view__default_panel);
        this.g = findViewById(f.reading__custom_font_list_view__scrollview);
        if (this.a) {
            this.d.a(0);
        } else {
            this.d.a(1);
        }
        d();
        this.d.setOnDelayedSelectionChangeListener(new ep(this));
        this.f.setOnClickListener(new eq(this));
    }

    public void a() {
        d();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.i) {
            ((sh) getContext().queryFeature(sh.class)).aA();
        }
    }

    private void d() {
        this.h.clear();
        this.h.addAll(Arrays.asList(b.b().e()));
        this.k.setText(this.a ? i.reading__custom_font_list_view__default : i.reading__custom_font_list_view__default_en);
        Collections.sort(this.h, new er(this));
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (mVar.b().equals("fzlth.ttf")) {
                this.j = (o) mVar;
                this.h.remove(this.j);
                break;
            }
        }
        this.g.scrollTo(0, 0);
        this.e.removeAllViewsInLayout();
        LayoutInflater from = LayoutInflater.from(getContext());
        Iterator it2 = this.h.iterator();
        while (it2.hasNext()) {
            mVar = (m) it2.next();
            if ((this.a || !mVar.c()) && (!this.a || mVar.c())) {
                View inflate = from.inflate(g.reading__custom_font_view, this.e, false);
                this.e.addView(inflate);
                inflate.setOnClickListener(new es(this, (o) mVar));
            }
        }
        b();
    }

    protected void b() {
        boolean z = false;
        super.b();
        this.d.setVisibility(8);
        boolean z2 = false;
        for (int i = 0; i < this.e.getChildCount(); i++) {
            if (a(this.e.getChildAt(i), (o) this.h.get(i))) {
                z2 = true;
            }
        }
        View findViewById = this.f.findViewById(f.reading__custom_font_view__as_default);
        if (this.a) {
            if (this.b.ae().W().equals("FONT_URI_DEFAULT")) {
                z = true;
            }
            findViewById.setSelected(z);
        } else {
            if (this.b.ae().X().equals("FONT_URI_DEFAULT")) {
                z = true;
            }
            findViewById.setSelected(z);
        }
        if (!z2 && this.a) {
            findViewById.setSelected(true);
        }
    }

    private boolean a(View view, o oVar) {
        boolean z = true;
        TextView textView = (TextView) view.findViewById(f.reading__custom_font_view__font_name);
        View findViewById = view.findViewById(f.reading__custom_font_view__as_default);
        try {
            Typeface createFromFile;
            if (oVar.e()) {
                createFromFile = Typeface.createFromFile(ReaderEnv.get().getSystemFontFileZh());
            } else {
                createFromFile = Typeface.createFromFile(oVar.d());
            }
            textView.setTypeface(createFromFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        textView.setText(oVar.a());
        if (oVar.e()) {
            if (this.a) {
                boolean z2;
                if (this.b.ae().W().equals("FONT_URI_SYSTEM")) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                findViewById.setSelected(z2);
            } else {
                if (!this.b.ae().X().equals("FONT_URI_SYSTEM")) {
                    z = false;
                }
                findViewById.setSelected(z);
            }
        } else if (this.a) {
            if (!this.b.ae().W().equals(Uri.fromFile(oVar.d()).toString())) {
                z = false;
            }
            findViewById.setSelected(z);
        } else {
            if (!this.b.ae().X().equals(Uri.fromFile(oVar.d()).toString())) {
                z = false;
            }
            findViewById.setSelected(z);
        }
        return findViewById.isSelected();
    }

    private void a(String str) {
        this.b.ae().d(str);
        this.b.aA();
    }

    private void b(String str) {
        this.b.ae().e(str);
        this.b.aA();
    }

    protected int c() {
        return g.reading__custom_font_list_view;
    }
}
