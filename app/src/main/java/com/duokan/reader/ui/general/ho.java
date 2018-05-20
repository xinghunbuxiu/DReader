package com.duokan.reader.ui.general;

import com.duokan.core.ui.BaseDialog;
import com.duokan.reader.ReaderEnv;

public class ho {
    /* renamed from: a */
    public static dq m10751a(BaseDialog dialog) {
        if (ReaderEnv.get().forHd()) {
            return new fh(dialog);
        }
        return new gk(dialog);
    }
}
