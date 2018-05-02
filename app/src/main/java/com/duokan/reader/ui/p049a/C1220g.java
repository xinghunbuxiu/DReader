package com.duokan.reader.ui.p049a;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.C0437t;
import com.duokan.reader.ui.general.be;
import org.apache.http.HttpStatus;

/* renamed from: com.duokan.reader.ui.a.g */
class C1220g implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1214a f5713a;

    C1220g(C1214a c1214a) {
        this.f5713a = c1214a;
    }

    public void onClick(View view) {
        if (this.f5713a.f5701f.size() >= HttpStatus.SC_OK) {
            be.m10287a(this.f5713a.getContext(), this.f5713a.getString(C0258j.discovery__edit_feed_view__book_upperlimit_tip), 0).show();
            return;
        }
        ((C0437t) this.f5713a.getContext().queryFeature(C0437t.class)).showPopup(new C1228n(this.f5713a.getContext(), new C1222h(this)));
    }
}
