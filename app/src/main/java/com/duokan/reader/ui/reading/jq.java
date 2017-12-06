package com.duokan.reader.ui.reading;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;

class jq implements OnScrollListener {
    final /* synthetic */ jp a;

    jq(jp jpVar) {
        this.a = jpVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState != scrollState2) {
            for (int i = 0; i < this.a.d.getChildCount(); i++) {
                ko koVar = (ko) this.a.d.getChildAt(i);
                if (scrollState2 == ScrollState.IDLE && this.a.b) {
                    koVar.k();
                } else {
                    koVar.l();
                }
            }
        }
    }

    public void a(Scrollable scrollable, boolean z) {
    }
}
