package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.c.h;

class es extends av {
    final /* synthetic */ eq a;

    es(eq eqVar, Context context) {
        this.a = eqVar;
        super(context);
    }

    public View a(View view, ViewGroup viewGroup) {
        if (this.a.a.c() == 0) {
            return this.a.a.a(view, viewGroup);
        }
        return LayoutInflater.from(this.a.getContext()).inflate(h.personal__search_empty_view, viewGroup, false);
    }
}
