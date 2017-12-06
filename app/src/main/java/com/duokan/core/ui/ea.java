package com.duokan.core.ui;

import android.view.View;

import java.util.concurrent.Callable;

final class ea extends ep {
    final Callable a;

    ea(View view, Callable callable) {
        super(view);
        this.a = callable;

    }

    protected boolean a(View view) {
        try {
            return ((Boolean) this.a.call()).booleanValue();
        } catch (Exception e) {
            return true;
        }
    }
}
