package com.duokan.reader.domain.social.message;

import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.domain.account.i;

import org.apache.http.HttpStatus;

public class bb extends DkMessagesManager implements ah {
    private static final int[] a = new int[]{13};
    private static final ai b = new ai();

    private bb(Context context, o oVar, i iVar) {
        super(context, oVar, iVar, a, "SystemMessagesCache", HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    public static void a(Context context, o oVar, i iVar) {
        b.a(new bb(context, oVar, iVar));
    }

    public static bb a() {
        return (bb) b.a();
    }
}
