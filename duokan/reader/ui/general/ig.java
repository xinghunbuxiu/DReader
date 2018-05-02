package com.duokan.reader.ui.general;

class ig implements Runnable {
    final /* synthetic */ SpirtMenuController a;

    ig(SpirtMenuController spirtMenuController) {
        this.a = spirtMenuController;
    }

    public void run() {
        this.a.d = MenuState.HIDE;
        this.a.requestBack();
        if (this.a.f != null) {
            this.a.f.run();
        }
    }
}
