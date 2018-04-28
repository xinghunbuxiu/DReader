package com.duokan.reader.ui.personal;

import android.content.Context;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.ui.general.ap;

class mp extends ap {
    /* renamed from: a */
    final /* synthetic */ DkCloudAnnotation f8957a;
    /* renamed from: b */
    final /* synthetic */ mj f8958b;

    mp(mj mjVar, Context context, DkCloudAnnotation dkCloudAnnotation) {
        this.f8958b = mjVar;
        this.f8957a = dkCloudAnnotation;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.f8958b.m12298a(new DkCloudAnnotation[]{this.f8957a}, C0258j.personal__reading_note_info_header_view__deleting_one_note, C0258j.f426xb7e4e3bd);
    }
}
