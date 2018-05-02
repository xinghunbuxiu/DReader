package com.duokan.reader.ui.personal;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;
import com.duokan.reader.ui.general.HeaderView;

public class w extends ActivatedController {
    private final LinearLayout a = ((LinearLayout) findViewById(g.personal__bookshelf_style_view__simple));
    private final LinearLayout b = ((LinearLayout) findViewById(g.personal__bookshelf_style_view__classic));
    private final TextView c = ((TextView) findViewById(g.personal__bookshelf_style_view__simple_title));
    private final TextView d = ((TextView) findViewById(g.personal__bookshelf_style_view__classic_title));
    private final Button e = ((Button) findViewById(g.personal__bookshelf_style_view__receive));
    private BookShelfType f = ReaderEnv.get().getBookShelfType();

    public w(IFeature featrue) {
        super(featrue);
        setContentView(h.personal__bookshelf_style_view);
        ((HeaderView) findViewById(g.personal__bookshelf_style_view__header)).setLeftTitle(j.personal__bookshelf_style_view__header);
        if (BookShelfType.Simple == this.f) {
            a();
        } else {
            b();
        }
        this.a.setOnClickListener(new x(this));
        this.b.setOnClickListener(new IFeature(this));
        this.e.setOnClickListener(new z(this));
    }

    private void a() {
        this.a.setBackgroundResource(f.general__shared__layout_selected_bg);
        this.c.setBackgroundResource(f.general__shared__title_selected_bg);
        this.b.setBackgroundResource(f.general__shared__layout_unselected_bg);
        this.d.setBackgroundResource(f.general__shared__title_unselected_bg);
    }

    private void b() {
        this.a.setBackgroundResource(f.general__shared__layout_unselected_bg);
        this.c.setBackgroundResource(f.general__shared__title_unselected_bg);
        this.b.setBackgroundResource(f.general__shared__layout_selected_bg);
        this.d.setBackgroundResource(f.general__shared__title_selected_bg);
    }
}
