package com.duokan.reader.ui.a;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.PushHalfPage;

import org.apache.http.HttpStatus;

class g implements OnClickListener {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        if (this.a.f.size() >= HttpStatus.SC_OK) {
            be.a(this.a.getContext(), this.a.getString(j.discovery__edit_feed_view__book_upperlimit_tip), 0).show();
            return;
        }
        ((PushHalfPage) this.a.getContext().queryFeature(PushHalfPage.class)).showPopup(new n(this.a.getContext(), new h(this)));
    }
}
