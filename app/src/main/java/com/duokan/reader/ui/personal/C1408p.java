package com.duokan.reader.ui.personal;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;
import com.duokan.reader.ui.general.HeaderView;

/* renamed from: com.duokan.reader.ui.personal.p */
public class C1408p extends ActivatedController {
    /* renamed from: a */
    private final LinearLayout f9036a = ((LinearLayout) findViewById(C0255g.personal__bookshelf_style_view__simple));
    /* renamed from: b */
    private final LinearLayout f9037b = ((LinearLayout) findViewById(C0255g.personal__bookshelf_style_view__classic));
    /* renamed from: c */
    private final TextView f9038c = ((TextView) findViewById(C0255g.personal__bookshelf_style_view__simple_title));
    /* renamed from: d */
    private final TextView f9039d = ((TextView) findViewById(C0255g.personal__bookshelf_style_view__classic_title));
    /* renamed from: e */
    private final Button f9040e = ((Button) findViewById(C0255g.personal__bookshelf_style_view__receive));
    /* renamed from: f */
    private BookShelfType f9041f = ReaderEnv.get().getBookShelfType();

    public C1408p(IFeature mFeature) {
        super(mFeature);
        setContentView(C0256h.personal__bookshelf_style_view);
        ((HeaderView) findViewById(C0255g.personal__bookshelf_style_view__header)).setLeftTitle(C0258j.personal__bookshelf_style_view__header);
        if (BookShelfType.Simple == this.f9041f) {
            m12379a();
        } else {
            m12380b();
        }
        this.f9036a.setOnClickListener(new C1409q(this));
        this.f9037b.setOnClickListener(new C1410r(this));
        this.f9040e.setOnClickListener(new C1411s(this));
    }

    /* renamed from: a */
    private void m12379a() {
        this.f9036a.setBackgroundResource(C0254f.general__shared__layout_selected_bg);
        this.f9038c.setBackgroundResource(C0254f.general__shared__title_selected_bg);
        this.f9037b.setBackgroundResource(C0254f.general__shared__layout_unselected_bg);
        this.f9039d.setBackgroundResource(C0254f.general__shared__title_unselected_bg);
    }

    /* renamed from: b */
    private void m12380b() {
        this.f9036a.setBackgroundResource(C0254f.general__shared__layout_unselected_bg);
        this.f9038c.setBackgroundResource(C0254f.general__shared__title_unselected_bg);
        this.f9037b.setBackgroundResource(C0254f.general__shared__layout_selected_bg);
        this.f9039d.setBackgroundResource(C0254f.general__shared__title_selected_bg);
    }
}
