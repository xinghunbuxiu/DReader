package com.duokan.reader.ui.account;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;

class cg implements OnCheckedChangeListener {
    /* renamed from: a */
    final /* synthetic */ bx f5922a;

    cg(bx bxVar) {
        this.f5922a = bxVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "pref_default_share_with_create_note", z);
        ReaderEnv.get().commitPrefs();
    }
}
