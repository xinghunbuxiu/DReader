package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.c.g;

class ez {
    ImageView a;
    TextView b;
    CheckBox c;
    View d;
    final /* synthetic */ ex e;

    ez(ex exVar, View view) {
        this.e = exVar;
        this.d = view;
        this.a = (ImageView) view.findViewById(g.bookshelf__file_browser_item_view__more);
        this.b = (TextView) view.findViewById(g.bookshelf__file_browser_item_view__msg);
        this.c = (CheckBox) view.findViewById(g.bookshelf__file_browser_item_view__check);
        this.c.setEnabled(false);
        this.c.setClickable(false);
    }

    void a() {
        this.a.setVisibility(0);
        this.b.setVisibility(4);
        this.c.setVisibility(4);
    }

    void b() {
        this.b.setVisibility(0);
        this.a.setVisibility(4);
        this.c.setVisibility(4);
    }

    void a(boolean z) {
        this.c.setChecked(z);
        this.c.setVisibility(0);
        this.b.setVisibility(4);
        this.a.setVisibility(4);
    }
}
