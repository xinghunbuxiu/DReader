package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.statistics.C1163a;

class ek implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ dg f10078a;

    ek(dg dgVar) {
        this.f10078a = dgVar;
    }

    public void onClick(View view) {
        this.f10078a.f9993B.navigate("duokan-reader://store", null, false, null);
        C1163a.m8627k().m8648a("ending_page_recommendation_v3", "click", this.f10078a.getLabelPrefix() + "related_to_store_button", false);
    }
}
