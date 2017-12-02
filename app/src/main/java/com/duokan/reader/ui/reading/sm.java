package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.document.z;

class sm implements OnClickListener {
    final /* synthetic */ si a;

    sm(si siVar) {
        this.a = siVar;
    }

    public void onClick(View view) {
        z a = this.a.f.a(this.a.l - 1);
        if (a == null) {
            ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).prompt(this.a.getString(j.reading__search_next_view__search_reach_first_match));
            return;
        }
        this.a.a.b(this.a.f.a(this.a.l).a, DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT);
        this.a.a.a(a.a, DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT);
        this.a.a.d(a.a);
        this.a.l = this.a.l - 1;
    }
}
