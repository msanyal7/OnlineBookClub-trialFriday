package SubManagement.View;

import SubManagement.Model.PaymentSub;

/**
 * ViewPayment handles the display of payment details which includes methods to display:
 * - payment type
 * - payment number
 * - user's full name
 *
 * Methods all serve the same program so the LCOM4 measure is low. There is a high degree of cohesion as all the
 * methods work together with the 'PaymentSub' data to product output.
 */


public class ViewPayment {

    public void displayPaymentDetails(PaymentSub paymentSub) {
        displayPaymentType(paymentSub.getPaymentType());
        displayPaymentInfo(paymentSub.getPaymentNumberInfo());
        displayPaymentName(paymentSub.getPaymentFName(), paymentSub.getPaymentLName());
    }

    public void displayPaymentType(String paymentType) {
        System.out.println("Payment Type: " + paymentType);
    }

    public void displayPaymentInfo(int paymentInfo) {
        System.out.println("Payment Info: " + paymentInfo);
    }

    public void displayPaymentName(String paymentFName, String paymentLName) {
        System.out.println("Payment Full Name: " + paymentFName + " " + paymentLName);
    }
}
