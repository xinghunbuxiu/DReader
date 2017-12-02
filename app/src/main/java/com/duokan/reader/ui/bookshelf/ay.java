package com.duokan.reader.ui.bookshelf;

import android.content.Context;

import com.duokan.b.i;
import com.duokan.reader.ui.general.FileTransferPrompter;
import com.duokan.reader.ui.general.cm;

public class ay {
    public static void a(Context context, long j, cm cmVar) {
        String str;
        String string = context.getResources().getString(i.bookshelf__book__download_prompt__title);
        if (j <= 0) {
            str = "";
        } else {
            str = context.getString(i.bookshelf__book__download_prompt_at_data_plan, new Object[]{com.duokan.common.i.a(j)});
        }
        FileTransferPrompter.a(context, j, string, str, cmVar);
    }

    public static void b(Context context, long j, cm cmVar) {
        FileTransferPrompter.b(context, j, context.getResources().getString(i.bookshelf__book__upload_prompt__title), context.getString(i.bookshelf__book__upload_prompt_at_data_plan, new Object[]{com.duokan.common.i.a(j)}), cmVar);
    }
}
