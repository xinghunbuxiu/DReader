package com.duokan.reader.ui.general.web;

import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0256h;

public class BookHtmlController extends StorePageController {
    public BookHtmlController(IFeature mFeature) {
        super(mFeature);
    }

    protected void initContentView() {
        setContentView(C0256h.general__file_access_web_view);
    }
}
