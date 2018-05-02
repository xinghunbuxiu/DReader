package com.duokan.reader.ui.personal;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;
import com.duokan.reader.ReaderEnv.BookshelfItemStyle;
import com.duokan.reader.ui.bookshelf.he;

/* renamed from: com.duokan.reader.ui.personal.t */
public class C1412t extends he {
    /* renamed from: a */
    private final LinearLayout f9045a;
    /* renamed from: b */
    private final LinearLayout f9046b;
    /* renamed from: c */
    private final TextView f9047c;
    /* renamed from: d */
    private final TextView f9048d;
    /* renamed from: e */
    private final LinearLayout f9049e;
    /* renamed from: f */
    private BookShelfType f9050f = ReaderEnv.get().getBookShelfType();

    public C1412t(IFeature mFeature) {
        super(mFeature);
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.personal__bookshelf_popup_style_view, null, false);
        this.f9045a = (LinearLayout) inflate.findViewById(C0255g.personal__bookshelf_popup_style_view__simple);
        this.f9046b = (LinearLayout) inflate.findViewById(C0255g.personal__bookshelf_popup_style_view__classic);
        this.f9047c = (TextView) inflate.findViewById(C0255g.personal__bookshelf_popup_style_view__simple_title);
        this.f9048d = (TextView) inflate.findViewById(C0255g.personal__bookshelf_popup_style_view__classic_title);
        this.f9049e = (LinearLayout) inflate.findViewById(C0255g.personal__bookshelf_popup_style_view__show_read_progress);
        if (BookShelfType.Simple == this.f9050f) {
            m12389e();
        } else {
            m12390f();
        }
        this.f9045a.setOnClickListener(new C1413u(this));
        this.f9046b.setOnClickListener(new C1414v(this));
        this.f9049e.setOnClickListener(new C1415w(this));
        this.f9049e.setSelected(ReaderEnv.get().getBookshelfItemStyle() != BookshelfItemStyle.SIMPLE);
        m9490a(inflate);
    }

    /* renamed from: e */
    private void m12389e() {
        this.f9045a.setBackgroundResource(C0254f.general__shared__layout_selected_bg);
        this.f9047c.setBackgroundResource(C0254f.general__shared__title_selected_bg);
        this.f9046b.setBackgroundResource(C0254f.general__shared__layout_unselected_bg);
        this.f9048d.setBackgroundResource(C0254f.general__shared__title_unselected_bg);
    }

    /* renamed from: f */
    private void m12390f() {
        this.f9045a.setBackgroundResource(C0254f.general__shared__layout_unselected_bg);
        this.f9047c.setBackgroundResource(C0254f.general__shared__title_unselected_bg);
        this.f9046b.setBackgroundResource(C0254f.general__shared__layout_selected_bg);
        this.f9048d.setBackgroundResource(C0254f.general__shared__title_selected_bg);
    }
}
