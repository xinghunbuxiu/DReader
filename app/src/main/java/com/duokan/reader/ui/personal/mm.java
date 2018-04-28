package com.duokan.reader.ui.personal;

import android.content.Context;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.ui.general.ap;

class mm extends ap {
    /* renamed from: a */
    final /* synthetic */ ml f8954a;

    mm(ml mlVar, Context context) {
        this.f8954a = mlVar;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.f8954a.f8953a.m12298a((DkCloudAnnotation[]) this.f8954a.f8953a.e.toArray(new DkCloudAnnotation[0]), C0258j.personal__reading_note_info_header_view__clearing_notes, C0258j.personal__reading_note_info_header_view__failed_to_clear_notes);
    }
}
