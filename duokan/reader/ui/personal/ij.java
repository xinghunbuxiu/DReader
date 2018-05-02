package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.ui.general.fa;

class ij implements OnClickListener {
    final /* synthetic */ ih a;

    ij(ih ihVar) {
        this.a = ihVar;
    }

    public void onClick(View view) {
        fa faVar = new fa(this.a.getContext());
        faVar.d(this.a.a.getMessage());
        faVar.a(j.personal__personal_redeem_info_view__prompt);
        faVar.b(j.personal__personal_redeem_info_view__save);
        faVar.a(new ik(this));
        faVar.show();
    }
}
