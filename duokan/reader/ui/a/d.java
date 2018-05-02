package com.duokan.reader.ui.a;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.jq;

class d implements OnClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        UTools.hideSoftInputFromWindow(this.a.getContext());
        this.a.l = new jq(this.a.getContext());
        this.a.l.a(this.a.getString(j.general__shared__committing));
        this.a.l.setCancelOnBack(false);
        TaskHandler.postDelayed(new e(this), 2000);
        this.a.l.show();
        this.a.a.a(this.a.a(true));
    }
}
