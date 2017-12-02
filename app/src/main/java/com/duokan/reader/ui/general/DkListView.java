package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;

import com.duokan.core.ui.GridItemsView;
import com.duokan.core.ui.dv;

public class DkListView extends GridItemsView {
    public DkListView(Context context) {
        this(context, null);
    }

    public DkListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setNumColumns(1);
        setThumbEnabled(true);
        setMaxOverScrollHeight(dv.g(getContext()));
    }
}
