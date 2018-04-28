package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import com.duokan.common.C0267i;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ui.general.FileTransferPrompter;
import com.duokan.reader.ui.general.cm;

public class be {
    /* renamed from: a */
    public static void m9188a(Context context, long j, cm cmVar) {
        String str;
        String string = context.getResources().getString(C0247i.bookshelf__book__download_prompt__title);
        if (j <= 0) {
            str = "";
        } else {
            str = context.getString(C0247i.bookshelf__book__download_prompt_at_data_plan, new Object[]{C0267i.m599a(j)});
        }
        FileTransferPrompter.m9977a(context, j, string, str, cmVar);
    }

    /* renamed from: b */
    public static void m9189b(Context context, long j, cm cmVar) {
        FileTransferPrompter.m9978b(context, j, context.getResources().getString(C0247i.bookshelf__book__upload_prompt__title), context.getString(C0247i.bookshelf__book__upload_prompt_at_data_plan, new Object[]{C0267i.m599a(j)}), cmVar);
    }
}
