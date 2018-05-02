package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.ai;

import java.util.concurrent.Callable;

class gq implements Callable {
    final /* synthetic */ PageController a;

    gq(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Integer a() {
        return Integer.valueOf(ai.a().h());
    }
}
