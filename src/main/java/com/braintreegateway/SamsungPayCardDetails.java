package com.braintreegateway;

import com.braintreegateway.util.NodeWrapper;

public class SamsungPayCardDetails extends SamsungPayCardSuper {
    private String issuerLocation;
    private String paymentInstrumentName;

    public SamsungPayCardDetails(NodeWrapper node) {
        super(node);
        issuerLocation = node.findString("issuer-location");
    }

}
