package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.widget.LinearLayout;

import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.PageHeaderView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ek extends LinearLayout {
    /* renamed from: a */
    private final ep f6387a;
    /* renamed from: b */
    private final cw f6388b;
    /* renamed from: c */
    private final cz f6389c;
    /* renamed from: d */
    private final PageHeaderView f6390d;
    /* renamed from: e */
    private final gz f6391e;
    /* renamed from: f */
    private final eo f6392f;
    /* renamed from: g */
    private List<aa> f6393g = null;
    /* renamed from: h */
    private int f6394h = 0;

    public ek(Context context, ep epVar) {
        super(context);
        this.f6387a = epVar;
        this.f6388b = (cw) AppContext.getAppContext(context).queryFeature(cw.class);
        this.f6389c = (cz) AppContext.getAppContext(context).queryFeature(cz.class);
        this.f6392f = new eo();
        setBackgroundColor(getResources().getColor(C0252d.general__shared__f7f7f7));
        setOrientation(1);
        this.f6390d = new PageHeaderView(getContext());
        this.f6390d.setHasBackButton(false);
        this.f6390d.setCenterTitle(String.format(getResources().getString(C0258j.bookshelf__category_selection_view__move_d_books_to), new Object[]{Integer.valueOf(this.f6389c.mo1641a())}));
        this.f6390d.m10144a(getResources().getString(C0258j.general__shared__cancel)).setOnClickListener(new el(this));
        addView(this.f6390d, new LayoutParams(-1, -2));
        this.f6390d.setClickable(true);
        this.f6391e = new gz(context);
        this.f6393g = getCategories();
        this.f6391e.setAdapter(this.f6392f);
        this.f6392f.mo1691d();
        this.f6391e.setEnabled(true);
        this.f6391e.setOnItemClickListener(new em(this));
        addView(this.f6391e, new LayoutParams(-1, 0, 1.0f));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f6394h != getMeasuredWidth()) {
            this.f6394h = getMeasuredWidth();
            this.f6391e.setNumColumns(ea.m9503a(getContext()));
        }
    }

    private List<aa> getCategories() {
        List<aa> arrayList = new ArrayList();
        Collection<aa> m = ai.m3980a().m3938m();
        if (this.f6388b.m9445e()) {
            for (aa aaVar : m) {
                if (!aaVar.aB()) {
                    arrayList.add(aaVar);
                }
            }
        } else {
            arrayList.addAll(m);
        }
        for (aa aaVar2 : arrayList) {
            if (aaVar2.m3758a(this.f6389c.mo1658c())) {
                arrayList.remove(aaVar2);
                break;
            }
        }
        return arrayList;
    }
}
