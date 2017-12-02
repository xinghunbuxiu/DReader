package com.duokan.reader.ui.personal;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.duokan.c.d;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.e;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.ar;

import java.util.ArrayList;

public class ig extends LinearLayout {
    private final ar a = new ar(getContext());

    public ig(e eVar) {
        super(eVar.getContext());
        setOrientation(1);
        setBackgroundResource(d.general__shared__eeeeee);
        View pageHeaderView = new PageHeaderView(getContext());
        addView(pageHeaderView);
        pageHeaderView.setLeftTitle(j.personal__message_view__title);
        addView(this.a, new LayoutParams(-1, -1));
    }

    public void setTabTitles(ArrayList arrayList) {
        this.a.a(arrayList, h.general__shared__left_tab_view_2, h.general__shared__right_tab_view_2, h.personal__comment_tab_view_2);
    }

    public void setTabViews(ArrayList arrayList) {
        this.a.setViews(arrayList);
    }

    public ar getPagerView() {
        return this.a;
    }
}
