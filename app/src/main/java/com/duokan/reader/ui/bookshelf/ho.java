package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.ui.BoxView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.ui.general.DkListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ho extends BoxView {
    /* renamed from: b */
    final /* synthetic */ hk f6562b;
    /* renamed from: c */
    private DkListView f6563c;

    public ho(hk hkVar, Context context) {
        this.f6562b = hkVar;
        super(context);
        View inflate = LayoutInflater.from(context).inflate(C0256h.bookshelf__modify_book_category_view, null);
        addView(inflate, new LayoutParams(-1, -2));
        inflate.findViewById(C0255g.bookshelf__modify_book_category_view__create_new_group).setOnClickListener(new hp(this, hkVar));
        this.f6563c = (DkListView) inflate.findViewById(C0255g.bookshelf__modify_book_category_view_list);
        Collection<aa> a = hkVar.f6555b.m9433a();
        List arrayList = new ArrayList();
        if (hkVar.f6555b.m9445e()) {
            for (aa aaVar : a) {
                if (!aaVar.aB()) {
                    arrayList.add(aaVar);
                }
            }
        } else {
            arrayList.addAll(a);
        }
        Object hmVar = new hm(hkVar, arrayList);
        this.f6563c.setAdapter(hmVar);
        this.f6563c.setOnItemClickListener(new hr(this, hkVar, arrayList));
        hmVar.mo1691d();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if ((i != i3 || i2 != i4) && !this.f6562b.f6556c) {
            setMaxHeight(Math.max(i, i2) / 2);
        }
    }
}
