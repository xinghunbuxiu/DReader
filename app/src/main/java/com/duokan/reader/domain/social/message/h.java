package com.duokan.reader.domain.social.message;

import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.domain.account.i;

import org.apache.http.HttpStatus;

public class h extends DkMessagesManager implements ah {
    private static final int[] a = new int[]{5, 10, 17, 19, 18};
    private static final ai b = new ai();

    private h(Context context, o oVar, i iVar) {
        super(context, oVar, iVar, a, "FeedMessagesCache", HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    public static void a(Context context, o oVar, i iVar) {
        b.a(new h(context, oVar, iVar));
    }

    public static h a() {
        return (h) b.a();
    }
}
