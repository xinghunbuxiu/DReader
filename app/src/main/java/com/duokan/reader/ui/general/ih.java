package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class ih implements OnClickListener {
    final /* synthetic */ SpirtMenuController a;
    private final int b;

    ih(SpirtMenuController spirtMenuController, int i, Runnable runnable) {
        this.a = spirtMenuController;
        this.b = i;
        spirtMenuController.g.add(runnable);
    }

    public void onClick(View view) {
        if (MenuState.SHOW == this.a.d) {
            this.a.f = (Runnable) this.a.g.get(this.b);
            this.a.requestBack();
        }
    }
}
