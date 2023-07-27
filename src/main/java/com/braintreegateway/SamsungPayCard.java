package com.braintreegateway;

import com.braintreegateway.util.NodeWrapper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SamsungPayCard extends SamsungPayCardSuper implements PaymentMethod {

  private Address billingAddress;
  private Calendar createdAt;
  private String customerId;
  private String customerLocation;
  private boolean isDefault;
  private boolean isVenmoSdk;
  private boolean isExpired;
  private String uniqueNumberIdentifier;
  private List<Subscription> subscriptions;
  private Calendar updatedAt;

  public SamsungPayCard(NodeWrapper node) {
    super(node);
    createdAt = node.findDateTime("created-at");
    updatedAt = node.findDateTime("updated-at");
    customerId = node.findString("customer-id");
    customerLocation = node.findString("customer-location");
    isDefault = node.findBoolean("default");
    isExpired = node.findBoolean("expired");
    uniqueNumberIdentifier = node.findString("unique-number-identifier");
    NodeWrapper billingAddressResponse = node.findFirst("billing-address");
    if (billingAddressResponse != null) {
      billingAddress = new Address(billingAddressResponse);
    }
    subscriptions = new ArrayList<Subscription>();
    for (NodeWrapper subscriptionResponse : node.findAll("subscriptions/subscription")) {
      subscriptions.add(new Subscription(subscriptionResponse));
    }
    }

  public Address getBillingAddress() {
    return billingAddress;
  }


  public Calendar getCreatedAt() {
    return createdAt;
  }

  public String getCustomerId() {
    return customerId;
  }

  public String getCustomerLocation() {
    return customerLocation;
  }

  public String getExpirationDate() {
    return expirationMonth + "/" + expirationYear;
  }

  public String getUniqueNumberIdentifier() {
    return uniqueNumberIdentifier;
  }

  public List<Subscription> getSubscriptions() {
    return subscriptions;
  }


  public Calendar getUpdatedAt() {
    return updatedAt;
  }

  public boolean isDefault() {
    return isDefault;
  }

  public boolean isVenmoSdk() {
    return isVenmoSdk;
  }

  public boolean isExpired() {
    return isExpired;
  }
}
