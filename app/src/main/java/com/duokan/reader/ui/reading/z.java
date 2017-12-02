package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.f;

class z implements OnClickListener {
    final /* synthetic */ y a;

    z(y yVar) {
        this.a = yVar;
    }

    public void onClick(View view) {
        if (this.a.n().isPlaying()) {
            this.a.n().pause();
            this.a.i.setImageResource(f.general__shared__voice_pause_btn);
            this.a.b.b();
            return;
        }
        this.a.n().start();
        this.a.i.setImageResource(f.general__shared__voice_play_btn);
        this.a.b.c();
    }
}
