package com.duokan.reader.ui.personal;

import android.view.View;
import android.widget.LinearLayout;

import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.ar;
import java.util.ArrayList;

public class it extends LinearLayout {
    /* renamed from: a */
    private final ar f8747a = new ar(getContext());

    public it(ActivatedController c0303e) {
        super(c0303e.getContext());
        setOrientation(1);
        setBackgroundResource(C0252d.general__shared__eeeeee);
        View pageHeaderView = new PageHeaderView(getContext());
        addView(pageHeaderView);
        pageHeaderView.setLeftTitle(C0258j.personal__message_view__title);
        addView(this.f8747a, new LayoutParams(-1, -1));
    }

    public void setTabTitles(ArrayList<String> arrayList) {
        this.f8747a.m10235a((ArrayList) arrayList, C0256h.general__shared__left_tab_view_2, C0256h.general__shared__right_tab_view_2, C0256h.personal__comment_tab_view_2);
    }

    public void setTabViews(ArrayList<View> arrayList) {
        this.f8747a.setViews(arrayList);
    }

    public ar getPagerView() {
        return this.f8747a;
    }
}
