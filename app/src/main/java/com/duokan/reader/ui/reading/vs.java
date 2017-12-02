package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class vs implements OnClickListener {
    final /* synthetic */ vq a;

    vs(vq vqVar) {
        this.a = vqVar;
    }

    public void onClick(View view) {
        boolean z;
        boolean z2 = true;
        if (view.isSelected()) {
            z = false;
        } else {
            z = true;
        }
        view.setSelected(z);
        ReadingPrefs ae = this.a.a.ae();
        if (this.a.a.ae().J()) {
            z2 = false;
        }
        ae.e(z2);
        this.a.a.ae().Y();
    }
}
