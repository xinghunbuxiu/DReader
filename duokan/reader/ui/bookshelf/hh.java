package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.ui.BoxView;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.ui.general.DkListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class hh extends BoxView {
    final /* synthetic */ hd b;
    private DkListView c;

    public hh(hd hdVar, Context context) {
        this.b = hdVar;
        super(context);
        View inflate = LayoutInflater.from(context).inflate(h.bookshelf__modify_book_category_view, null);
        addView(inflate, new LayoutParams(-1, -2));
        inflate.findViewById(g.bookshelf__modify_book_category_view__create_new_group).setOnClickListener(new hi(this, hdVar));
        this.c = (DkListView) inflate.findViewById(g.bookshelf__modify_book_category_view_list);
        Collection<aa> a = hdVar.b.a();
        List arrayList = new ArrayList();
        if (hdVar.b.e()) {
            for (aa aaVar : a) {
                if (!aaVar.az()) {
                    arrayList.add(aaVar);
                }
            }
        } else {
            arrayList.addAll(a);
        }
        Object hfVar = new hf(hdVar, arrayList);
        this.c.setAdapter(hfVar);
        this.c.setOnItemClickListener(new hk(this, hdVar, arrayList));
        hfVar.d();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if ((i != i3 || i2 != i4) && !this.b.c) {
            setMaxHeight(Math.max(i, i2) / 2);
        }
    }
}
