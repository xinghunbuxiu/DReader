package com.duokan.reader.ui.personal;

import android.content.Context;

import com.duokan.c.j;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.ui.general.ap;

class mb extends ap {
    final /* synthetic */ DkCloudAnnotation a;
    final /* synthetic */ lv b;

    mb(lv lvVar, Context context, DkCloudAnnotation dkCloudAnnotation) {
        this.b = lvVar;
        this.a = dkCloudAnnotation;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.b.a(new DkCloudAnnotation[]{this.a}, j.personal__reading_note_info_header_view__deleting_one_note, j.personal__reading_note_info_header_view__failed_to_delete_one_note);
    }
}
