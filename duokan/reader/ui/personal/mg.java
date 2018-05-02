package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.duokan.c.d;
import com.duokan.c.j;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.ITheme;

public class mg extends LinearLayout {
    jr a = new jr(getContext());

    public mg(Context context) {
        super(context);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(d.general__shared__eeeeee));
        View pageHeaderView = new PageHeaderView(getContext());
        pageHeaderView.setCenterTitle(j.personal__reading_notes_view__title);
        pageHeaderView.setHasBackButton(true);
        addView(pageHeaderView);
        ITheme sVar = (ITheme) MyContextWrapper.getFeature(getContext()).queryFeature(ITheme.class);
        this.a.a(0, 0, 0, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
        addView(this.a, new LayoutParams(-1, 0, 1.0f));
    }

    public DkWebListView getNoteSummaryListView() {
        return this.a;
    }
}
