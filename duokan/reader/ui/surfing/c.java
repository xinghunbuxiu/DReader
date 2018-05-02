package com.duokan.reader.ui.surfing;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.PersonalPrefs.UserGender;
import com.duokan.reader.domain.statistics.a;

class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        if (this.a.h == null || view == this.a.h) {
            this.a.h = view;
            PersonalPrefs.a().b(UserGender.UNSPECIFIED.ordinal(), true);
            UmengManager.get().onEvent("ASK_GENDER_V2", "SKIP");
            a.k().b("skip");
            this.a.a();
        }
    }
}
