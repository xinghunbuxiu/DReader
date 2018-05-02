package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.b.i;

class kd implements OnClickListener {
    final /* synthetic */ jy a;

    kd(jy jyVar) {
        this.a = jyVar;
    }

    public void onClick(View view) {
        if (this.a.f == null) {
            this.a.f = new ia(this.a.getContext());
            this.a.f.b(i.general__web_window_view__sys_client);
            this.a.f.b(i.general__web_window_view__copy);
            this.a.f.a(new ke(this));
        }
        this.a.f.show();
    }
}
