package com.duokan.reader.ui.personal;

import android.graphics.Color;

import com.duokan.reader.ui.general.ib;

class ar implements ib {
    final /* synthetic */ am a;

    ar(am amVar) {
        this.a = amVar;
    }

    public void a(int i) {
        this.a.j = i;
        this.a.c.setText(this.a.b[i]);
        this.a.c.setTextColor(Color.parseColor("#7d7d7d"));
    }
}
