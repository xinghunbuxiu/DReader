package com.duokan.reader.domain.cloud;

import org.w3c.dom.Node;

public abstract class DkCloudItemGroup extends DkCloudItem {
    public DkCloudItemGroup(long j) {
        super(j);
    }

    public DkCloudItemGroup(Node node, long j) {
        super(node, j);
    }
}
