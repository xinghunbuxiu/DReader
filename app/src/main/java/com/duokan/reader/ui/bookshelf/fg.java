package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.p024c.C0255g;

class fg {
    /* renamed from: a */
    ImageView f6442a;
    /* renamed from: b */
    TextView f6443b;
    /* renamed from: c */
    CheckBox f6444c;
    /* renamed from: d */
    View f6445d;
    /* renamed from: e */
    final /* synthetic */ fe f6446e;

    fg(fe feVar, View view) {
        this.f6446e = feVar;
        this.f6445d = view;
        this.f6442a = (ImageView) view.findViewById(C0255g.bookshelf__file_browser_item_view__more);
        this.f6443b = (TextView) view.findViewById(C0255g.bookshelf__file_browser_item_view__msg);
        this.f6444c = (CheckBox) view.findViewById(C0255g.bookshelf__file_browser_item_view__check);
        this.f6444c.setEnabled(false);
        this.f6444c.setClickable(false);
    }

    /* renamed from: a */
    void m9611a() {
        this.f6442a.setVisibility(0);
        this.f6443b.setVisibility(4);
        this.f6444c.setVisibility(4);
    }

    /* renamed from: b */
    void m9613b() {
        this.f6443b.setVisibility(0);
        this.f6442a.setVisibility(4);
        this.f6444c.setVisibility(4);
    }

    /* renamed from: a */
    void m9612a(boolean z) {
        this.f6444c.setChecked(z);
        this.f6444c.setVisibility(0);
        this.f6443b.setVisibility(4);
        this.f6442a.setVisibility(4);
    }
}
