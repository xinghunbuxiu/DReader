package com.duokan.reader.ui.personal;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;
import com.duokan.reader.ReaderEnv.BookshelfItemStyle;
import com.duokan.reader.ui.bookshelf.gx;

public class aa extends gx {
    private final LinearLayout a;
    private final LinearLayout b;
    private final TextView c;
    private final TextView d;
    private final LinearLayout e;
    private BookShelfType f = ReaderEnv.get().getBookShelfType();

    public aa(y yVar) {
        super(yVar);
        View inflate = LayoutInflater.from(getContext()).inflate(h.personal__bookshelf_popup_style_view, null, false);
        this.a = (LinearLayout) inflate.findViewById(g.personal__bookshelf_popup_style_view__simple);
        this.b = (LinearLayout) inflate.findViewById(g.personal__bookshelf_popup_style_view__classic);
        this.c = (TextView) inflate.findViewById(g.personal__bookshelf_popup_style_view__simple_title);
        this.d = (TextView) inflate.findViewById(g.personal__bookshelf_popup_style_view__classic_title);
        this.e = (LinearLayout) inflate.findViewById(g.personal__bookshelf_popup_style_view__show_read_progress);
        if (BookShelfType.Simple == this.f) {
            c();
        } else {
            d();
        }
        this.a.setOnClickListener(new ab(this));
        this.b.setOnClickListener(new ac(this));
        this.e.setOnClickListener(new ad(this));
        this.e.setSelected(ReaderEnv.get().getBookshelfItemStyle() != BookshelfItemStyle.SIMPLE);
        a(inflate);
    }

    private void c() {
        this.a.setBackgroundResource(f.general__shared__layout_selected_bg);
        this.c.setBackgroundResource(f.general__shared__title_selected_bg);
        this.b.setBackgroundResource(f.general__shared__layout_unselected_bg);
        this.d.setBackgroundResource(f.general__shared__title_unselected_bg);
    }

    private void d() {
        this.a.setBackgroundResource(f.general__shared__layout_unselected_bg);
        this.c.setBackgroundResource(f.general__shared__title_unselected_bg);
        this.b.setBackgroundResource(f.general__shared__layout_selected_bg);
        this.d.setBackgroundResource(f.general__shared__title_selected_bg);
    }
}
