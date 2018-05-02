package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.UTools;

class hu implements OnClickListener {
    final /* synthetic */ ActivatedController a;
    final /* synthetic */ hp b;

    hu(hp hpVar, ActivatedController activatedControllerVar) {
        this.b = hpVar;
        this.a = activatedControllerVar;
    }

    public void onClick(View view) {
        UTools.showAnimation(this.a.getContentView(), new hv(this));
    }
}
