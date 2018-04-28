package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ui.general.ap;

class ml implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ mj f8953a;

    ml(mj mjVar) {
        this.f8953a = mjVar;
    }

    public void onClick(View view) {
        if (this.f8953a.f8951a.f8944f != null) {
            ap mmVar = new mm(this, DkApp.get().getTopActivity());
            mmVar.setTitle(C0258j.f425x310c83ad);
            mmVar.setPrompt(C0258j.personal__reading_note_info_header_view__clear_notes_prompt_text);
            mmVar.setOkLabelResid(C0258j.general__shared__confirm);
            mmVar.setCancelLabel(C0258j.general__shared__cancel);
            mmVar.show();
        }
    }
}
