package com.duokan.reader.domain.store;

import com.duokan.reader.common.webservices.duokan.DkStoreAbsBookInfo;

public abstract class DkStoreItemDetail extends DkStoreItem {
    public abstract String[] getAuthorIds();

    public abstract DkStoreAbsBookInfo[] getUserRelatedBooks();
}
