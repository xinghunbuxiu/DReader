package com.duokan.reader.ui.personal;

import android.content.Context;

import com.duokan.c.j;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.ui.general.ap;

class ly extends ap {
    final /* synthetic */ lx a;

    ly(lx lxVar, Context context) {
        this.a = lxVar;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.a.a.a((DkCloudAnnotation[]) this.a.a.e.toArray(new DkCloudAnnotation[0]), j.personal__reading_note_info_header_view__clearing_notes, j.personal__reading_note_info_header_view__failed_to_clear_notes);
    }
}
