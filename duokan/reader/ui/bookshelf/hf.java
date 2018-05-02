package com.duokan.reader.ui.bookshelf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.ui.aw;
import com.duokan.reader.domain.bookshelf.aa;

import java.util.List;

class hf extends aw {
    final /* synthetic */ hd a;
    private List c;

    public hf(hd hdVar, List list) {
        this.a = hdVar;
        this.c = list;
    }

    public int c() {
        return this.c == null ? 0 : this.c.size();
    }

    public Object d(int i) {
        return this.c == null ? null : (aa) this.c.get(i);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        hg hgVar;
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.a.getContext());
            hgVar = new hg();
            view = from.inflate(h.bookshelf__modify_category_child_view, null);
            hgVar.a = (TextView) view.findViewById(g.bookshelf__modify_category_child_view__left_part);
            hgVar.b = (TextView) view.findViewById(g.bookshelf__modify_category_child_view__right_part);
            view.setTag(hgVar);
        } else {
            hgVar = (hg) view.getTag();
        }
        aa aaVar = (aa) d(i);
        hgVar.a.setText(aaVar.h() ? this.a.getContext().getString(j.bookshelf__shared__main_category) : aaVar.k());
        int length = aaVar.h() ? aaVar.d().length : aaVar.f();
        if (this.a.b.e()) {
            length -= aaVar.g();
        }
        hgVar.b.setText(String.format(this.a.getContext().getString(j.bookshelf__general_shared__book_count), new Object[]{Integer.valueOf(length)}));
        return view;
    }
}
