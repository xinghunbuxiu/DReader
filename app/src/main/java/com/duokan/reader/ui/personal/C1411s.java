package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0252d;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;

/* renamed from: com.duokan.reader.ui.personal.s */
class C1411s implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1408p f9044a;

    C1411s(C1408p c1408p) {
        this.f9044a = c1408p;
    }

    public void onClick(View view) {
        this.f9044a.f9040e.setBackgroundColor(this.f9044a.getResources().getColor(C0252d.general__shared__cccccc));
        this.f9044a.f9040e.setClickable(false);
        ReaderEnv.get().setBookShelfType(this.f9044a.f9041f);
        ((ReaderFeature) this.f9044a.getContext().queryFeature(ReaderFeature.class)).navigate("duokan-reader://bookshelf", null, false, null);
    }
}
