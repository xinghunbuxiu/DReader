package com.duokan.reader.ui.reading;

import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;

import com.duokan.b.i;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.ui.general.be;

class h implements is {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void a(c cVar) {
        this.a.k = this.a.a.getResources().getString(i.reading__shared__add_to_bookshelf_done);
        this.a.l = true;
        this.a.j = new AlphaAnimation(((float) this.a.e.getAlpha()) / 255.0f, 0.0f);
        this.a.j.setAnimationListener(new i(this));
        this.a.j.setDuration(500);
        this.a.j.setInterpolator(new LinearInterpolator());
        this.a.invalidateSelf();
    }

    public void a(String str) {
        be.a(this.a.a, (CharSequence) str, 0).show();
    }
}
