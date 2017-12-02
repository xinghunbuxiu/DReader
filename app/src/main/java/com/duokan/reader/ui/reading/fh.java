package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;

import com.duokan.core.app.e;

class fh implements OnLongClickListener {
    final /* synthetic */ fd a;

    fh(fd fdVar) {
        this.a = fdVar;
    }

    public boolean onLongClick(View view) {
        this.a.a.a(1, 0);
        this.a.a.a(ReadingTheme.CUSTOM);
        for (int i = 0; i < this.a.b.getChildCount(); i++) {
            this.a.b.getChildAt(i).setVisibility(8);
        }
        this.a.b.setPadding(0, 0, 0, 0);
        e faVar = new fa(this.a.getContext());
        this.a.b.addView(faVar.getContentView(), new LayoutParams(-1, -2));
        this.a.addSubController(faVar);
        this.a.activate(faVar);
        return true;
    }
}
