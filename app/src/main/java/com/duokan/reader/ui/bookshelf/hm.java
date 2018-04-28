package com.duokan.reader.ui.bookshelf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.core.ui.aw;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.aa;
import java.util.List;

class hm extends aw {
    /* renamed from: a */
    final /* synthetic */ hk f6557a;
    /* renamed from: c */
    private List<aa> f6558c;

    public hm(hk hkVar, List<aa> list) {
        this.f6557a = hkVar;
        this.f6558c = list;
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f6558c == null ? 0 : this.f6558c.size();
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return this.f6558c == null ? null : (aa) this.f6558c.get(i);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        hn hnVar;
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.f6557a.getContext());
            hnVar = new hn();
            view = from.inflate(C0256h.bookshelf__modify_category_child_view, null);
            hnVar.f6559a = (TextView) view.findViewById(C0255g.bookshelf__modify_category_child_view__left_part);
            hnVar.f6560b = (TextView) view.findViewById(C0255g.bookshelf__modify_category_child_view__right_part);
            view.setTag(hnVar);
        } else {
            hnVar = (hn) view.getTag();
        }
        aa aaVar = (aa) mo509d(i);
        hnVar.f6559a.setText(aaVar.m3767h() ? this.f6557a.getContext().getString(C0258j.bookshelf__shared__main_category) : aaVar.m3770k());
        int length = aaVar.m3767h() ? aaVar.m3763d().length : aaVar.m3765f();
        if (this.f6557a.f6555b.m9445e()) {
            length -= aaVar.m3766g();
        }
        hnVar.f6560b.setText(String.format(this.f6557a.getContext().getString(C0258j.bookshelf__general_shared__book_count), new Object[]{Integer.valueOf(length)}));
        return view;
    }
}
