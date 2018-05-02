package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0254f;

/* renamed from: com.duokan.reader.ui.reading.z */
class C1474z implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1473y f11260a;

    C1474z(C1473y c1473y) {
        this.f11260a = c1473y;
    }

    public void onClick(View view) {
        if (this.f11260a.m13689n().isPlaying()) {
            this.f11260a.m13689n().pause();
            this.f11260a.f11177i.setImageResource(C0254f.general__shared__voice_pause_btn);
            this.f11260a.b.mo2428b();
            return;
        }
        this.f11260a.m13689n().start();
        this.f11260a.f11177i.setImageResource(C0254f.general__shared__voice_play_btn);
        this.f11260a.b.mo2429c();
    }
}
