package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;
import com.duokan.reader.common.async.work.a;
import com.duokan.reader.common.async.work.e;
import com.duokan.reader.common.async.work.j;

class bc extends j {
    final /* synthetic */ ba a;

    bc(ba baVar, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.a = baVar;
        super(iAsyncWorkProgressListener);
    }

    public CheckErrorResult a(n nVar, e eVar) {
        return a.a(new a().a(eVar), super.a(nVar, eVar));
    }
}
