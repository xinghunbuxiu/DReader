package com.duokan.reader.ui.general;

import com.duokan.core.app.e;
import com.duokan.core.ui.j;
import com.duokan.reader.ReaderEnv;

public class hz {
    public static dr a(e eVar, boolean z, boolean z2) {
        if (ReaderEnv.get().forHd()) {
            return new fk(eVar);
        }
        return new gr(eVar, z, z2);
    }

    public static dq a(j jVar) {
        if (ReaderEnv.get().forHd()) {
            return new fj(jVar);
        }
        return new gq(jVar);
    }
}
