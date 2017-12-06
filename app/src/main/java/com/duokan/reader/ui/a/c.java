package com.duokan.reader.ui.a;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.ui.UTools;

class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        UTools.PostTask(this.a.e);
    }
}
