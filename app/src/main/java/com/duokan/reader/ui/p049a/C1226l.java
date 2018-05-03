package com.duokan.reader.ui.p049a;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.ui.general.bz;

/* renamed from: com.duokan.reader.ui.a.l */
class C1226l implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ TextView f5720a;
    /* renamed from: b */
    final /* synthetic */ int f5721b;
    /* renamed from: c */
    final /* synthetic */ DkStoreAbsBook f5722c;
    /* renamed from: d */
    final /* synthetic */ C1214a f5723d;

    C1226l(C1214a c1214a, TextView textView, int i, DkStoreAbsBook dkStoreAbsBook) {
        this.f5723d = c1214a;
        this.f5720a = textView;
        this.f5721b = i;
        this.f5722c = dkStoreAbsBook;
    }

    public void onClick(View view) {
        bz bzVar = new bz(this.f5723d.getContext());
        if (!TextUtils.equals(this.f5720a.getText(), "")) {
            bzVar.m10329a(this.f5720a.getText());
        } else if (this.f5721b < this.f5723d.f5701f.size()) {
            bzVar.m10329a(String.format(this.f5723d.getString(C0258j.discovery__edit_feed_item_view__desc_default), new Object[]{((DkStoreAbsBook) this.f5723d.f5701f.get(this.f5721b)).getTitle()}));
        }
        bzVar.getDecorView().setPadding(0, AnimUtils.m1932b(this.f5723d.getContext(), 50.0f), 0, 0);
        bzVar.setGravity(119);
        bzVar.m10328a(new C1227m(this, bzVar));
    }
}
