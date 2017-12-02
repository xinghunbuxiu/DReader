package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.c.h;
import com.duokan.reader.ui.bookshelf.ho;

class kp extends mq {
    final /* synthetic */ ko a;

    kp(ko koVar, Context context, ho hoVar) {
        this.a = koVar;
        super(context, hoVar);
    }

    public View a(View view, ViewGroup viewGroup) {
        if (this.a.getNormalAdapter().c() == 0) {
            return this.a.getNormalAdapter().a(view, viewGroup);
        }
        return LayoutInflater.from(this.a.getContext()).inflate(h.personal__search_empty_view, viewGroup, false);
    }
}
