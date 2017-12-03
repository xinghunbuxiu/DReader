package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class ee implements OnClickListener {
    final /* synthetic */ de a;

    ee(de deVar) {
        this.a = deVar;
    }

    public void onClick(View view) {
        this.a.A.navigate("duokan-reader://store", null, false, null);
        a.k().a("ending_page_recommendation_v3", "click", this.a.getLabelPrefix() + "related_to_store_button", false);
    }
}
