package com.duokan.reader.ui.personal;

import com.duokan.core.app.FeatureListening;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;

import java.util.List;

public interface kn extends FeatureListening {
    PurchasedSortType a();

    void a(DkCloudStoreBook dkCloudStoreBook);

    void a(PurchasedSortType purchasedSortType);

    void a(Runnable runnable, List list);

    void b();

    void c();

    void d();
}
