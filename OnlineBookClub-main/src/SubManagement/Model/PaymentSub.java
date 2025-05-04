package SubManagement.Model;
/**
 * This class represents the payment info for a user and contains fields for:
 * - payment type
 * - payment identification number
 * - user's first and last name
 *
 * Since the methods are tightly related to handling payment info, the measure for the class is expected to be low.
 * All the fields are closely related in the context of managing a user's payment data, with all methods in this class
 * interact with the payment-related fields and exhibit high cohesion, meaning the class is well-focused on its primary
 * responsibility.
 */

public class PaymentSub {
    private String paymentType;  // Changed to String
    private int paymentNumberInfo;
    private String paymentFName;
    private String paymentLName;

    // Constructor
    public PaymentSub(String paymentType, int paymentNumberInfo, String paymentFName, String paymentLName) {
        this.paymentType = paymentType;
        this.paymentNumberInfo = paymentNumberInfo;
        this.paymentFName = paymentFName;
        this.paymentLName = paymentLName;
    }

    // Getters and Setters
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getPaymentNumberInfo() {
        return paymentNumberInfo;
    }

    public void setPaymentNumberInfo(int paymentNumberInfo) {
        this.paymentNumberInfo = paymentNumberInfo;
    }

    public String getPaymentFName() {
        return paymentFName;
    }

    public void setPaymentFName(String paymentFName) {
        this.paymentFName = paymentFName;
    }

    public String getPaymentLName() {
        return paymentLName;
    }

    public void setPaymentLName(String paymentLName) {
        this.paymentLName = paymentLName;
    }
}
