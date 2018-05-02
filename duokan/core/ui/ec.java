package com.duokan.core.ui;

import android.view.View;

final class ec implements Runnable {
    final  View view;
    final int flag;

    /**
     *
     * @param view
     * @param flag  InputMethodManager.Flag
     */
    ec(View view, int flag) {
        this.view = view;
        this.flag = flag;
    }

    public void run() {
        Runnable edVar = new ed(this);
        if (this.view.getWindowToken() == null || this.view.isLayoutRequested()) {
            UTools.creatCallTask(this.view, edVar);
        } else {
            edVar.run();
        }
    }
}
