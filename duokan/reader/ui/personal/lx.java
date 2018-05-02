package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ui.general.ap;

class lx implements OnClickListener {
    final /* synthetic */ lv a;

    lx(lv lvVar) {
        this.a = lvVar;
    }

    public void onClick(View view) {
        if (this.a.a.f != null) {
            ap lyVar = new ly(this, DkApp.get().getTopActivity());
            lyVar.setTitle(j.personal__reading_note_info_header_view__clear_notes_prompt_title);
            lyVar.setPrompt(j.personal__reading_note_info_header_view__clear_notes_prompt_text);
            lyVar.setOkLabel(j.general__shared__confirm);
            lyVar.setCancelLabel(j.general__shared__cancel);
            lyVar.show();
        }
    }
}
