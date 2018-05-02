package com.duokan.reader.ui.general;

class ie implements Runnable {
    final /* synthetic */ SpirtMenuController a;

    ie(SpirtMenuController spirtMenuController) {
        this.a = spirtMenuController;
    }

    public void run() {
        this.a.d = MenuState.SHOW;
    }
}
