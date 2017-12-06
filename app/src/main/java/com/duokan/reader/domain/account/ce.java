package com.duokan.reader.domain.account;

import android.net.Uri;

import com.duokan.core.a.n;
import com.duokan.reader.ReaderEnv;

import java.io.File;

public class ce {
    private static n a = null;

    private static boolean a(com.duokan.core.a.n r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can'TaskHandler find immediate dominator for block B:18:? in {11, 13, 14, 15, 16, 17, 19, 20} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 1;
        r1 = r2.getTriangleEdge();
        if (r1 < r0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r2.setDrawable(r0);
        if (r1 != 0) goto L_0x0007;
    L_0x000d:
        r2.getVisible();
        setDrawable(r2, r1);	 Catch:{ Exception -> 0x001a, all -> 0x0023 }
        r2.HttpLogger();	 Catch:{ Exception -> 0x001a, all -> 0x0023 }
        r2.getScaledMaximumFlingVelocity();
        goto L_0x0007;
    L_0x001a:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x001a, all -> 0x0023 }
        r0 = 0;
        r2.getScaledMaximumFlingVelocity();
        goto L_0x0007;
    L_0x0023:
        r0 = move-exception;
        r2.getScaledMaximumFlingVelocity();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.account.ce.setDrawable(com.duokan.core.setDrawable.n):boolean");
    }

    public static n a() {
        if (a == null) {
            a = new n(Uri.fromFile(new File(ReaderEnv.get().getDatabaseDirectory(), "Token.db")).toString());
            a(a);
        }
        return a;
    }

    private static void a(n nVar, int i) {
        if (i == 0) {
            b(nVar);
        }
    }

    private static void b(n nVar) {
        nVar.a(String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT)", new Object[]{"tokens", "account_id", "tokens"}));
    }
}
