package com.duokan.reader.ui.general;

class id implements Runnable {
    final /* synthetic */ SpirtMenuController a;

    id(SpirtMenuController spirtMenuController) {
        this.a = spirtMenuController;
    }

    public void run() {
        this.a.d = MenuState.TOSHOW;
    }
}
