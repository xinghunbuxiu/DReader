package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.ip;

class hp implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ hk f6564a;
    /* renamed from: b */
    final /* synthetic */ ho f6565b;

    hp(ho hoVar, hk hkVar) {
        this.f6565b = hoVar;
        this.f6564a = hkVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_SHELF_CREATEGROUP", "FromList");
        this.f6565b.f6562b.dismiss();
        new ip(this.f6565b.getContext(), this.f6565b.getContext().getString(C0258j.bookshelf__general_shared__new_category_name), "", new hq(this)).show();
    }
}
