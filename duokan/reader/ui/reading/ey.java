package com.duokan.reader.ui.reading;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.b.o;

class ey implements OnClickListener {
    final /* synthetic */ o a;
    final /* synthetic */ et b;

    ey(et etVar, o oVar) {
        this.b = etVar;
        this.a = oVar;
    }

    public void onClick(View view) {
        if (this.a.e()) {
            if (this.b.a) {
                this.b.a("FONT_URI_SYSTEM");
            } else {
                this.b.b("FONT_URI_SYSTEM");
            }
        } else if (this.b.a) {
            this.b.a(Uri.fromFile(this.a.d()).toString());
        } else {
            this.b.b(Uri.fromFile(this.a.d()).toString());
        }
        this.b.b();
    }
}
