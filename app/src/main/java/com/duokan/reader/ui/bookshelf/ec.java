package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.widget.LinearLayout;

import com.duokan.c.j;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.PageHeaderView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ec extends LinearLayout {
    private final ei a;
    private final cr b;
    private final cu c;
    private final PageHeaderView d;
    private final gs e;
    private final eh f;
    private List g = null;
    private int h = 0;

    public ec(Context context, ei eiVar) {
        super(context);
        this.a = eiVar;
        this.b = (cr) MyContextWrapper.getFeature(context).queryFeature(cr.class);
        this.c = (cu) MyContextWrapper.getFeature(context).queryFeature(cu.class);
        this.f = new eh();
        setBackgroundColor(getResources().getColor(d.general__shared__f7f7f7));
        setOrientation(1);
        this.d = new PageHeaderView(getContext());
        this.d.setHasBackButton(false);
        this.d.setCenterTitle(String.format(getResources().getString(j.bookshelf__category_selection_view__move_d_books_to), new Object[]{Integer.valueOf(this.c.a())}));
        this.d.a(getResources().getString(j.general__shared__cancel)).setOnClickListener(new ed(this));
        addView(this.d, new LayoutParams(-1, -2));
        this.d.setClickable(true);
        this.e = new gs(context);
        this.g = getCategories();
        this.e.setAdapter(this.f);
        this.f.d();
        this.e.setEnabled(true);
        this.e.setOnItemClickListener(new ee(this));
        addView(this.e, new LayoutParams(-1, 0, 1.0f));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.h != getMeasuredWidth()) {
            this.h = getMeasuredWidth();
            this.e.setNumColumns(ds.a(getContext()));
        }
    }

    private List getCategories() {
        List<aa> arrayList = new ArrayList();
        Collection<aa> m = ai.a().m();
        if (this.b.e()) {
            for (aa aaVar : m) {
                if (!aaVar.az()) {
                    arrayList.add(aaVar);
                }
            }
        } else {
            arrayList.addAll(m);
        }
        for (aa aaVar2 : arrayList) {
            if (aaVar2.a(this.c.c())) {
                arrayList.remove(aaVar2);
                break;
            }
        }
        a((List) arrayList);
        return arrayList;
    }

    private void a(List list) {
        Collections.sort(list, new eg(this));
    }
}
