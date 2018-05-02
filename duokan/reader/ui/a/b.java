package com.duokan.reader.ui.a;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.OnScrollListener;

class b implements OnScrollListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.DRAG) {
            UTools.hideSoftInputFromWindow(this.a.getContext());
        }
    }

    public void a(Scrollable scrollable, boolean z) {
    }
}
