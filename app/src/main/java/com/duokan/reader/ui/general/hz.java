package com.duokan.reader.ui.general;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.j;
import com.duokan.reader.ReaderEnv;

public class hz {
    public static dr a(ActivatedController controller, boolean z, boolean z2) {
        if (ReaderEnv.get().forHd()) {
            return new fk(controller);
        }
        return new gr(controller, z, z2);
    }

    public static dq a(j jVar) {
        if (ReaderEnv.get().forHd()) {
            return new fj(jVar);
        }
        return new gq(jVar);
    }
}
