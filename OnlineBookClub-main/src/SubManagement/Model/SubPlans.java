package SubManagement.Model;

/**
 * This class represents a user's subscription plan that includes fields for:
 * - subscription status
 * - description
 * - current subscription plan
 *
 * All methods and fields are directly related to managing sub details which means the LCOm4 measure for this class
 * would be low. There is high cohesion in this class since it deals with exclusively, subscription-related
 * operations, and all methods are focused on interacting with the subscription data (status, description, etc.).
 */

public class SubPlans {
    private String subStatus;  // Changed to String
    private String subDescription;
    private SubPlans currentSub;

    // Constructor
    public SubPlans(String subStatus, String subDescription, SubPlans currentSub) {
        this.subStatus = subStatus;
        this.subDescription = subDescription;
        this.currentSub = currentSub;
    }

    // Getters and Setters
    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getSubDescription() {
        return subDescription;
    }

    public void setSubDescription(String subDescription) {
        this.subDescription = subDescription;
    }

    public SubPlans getCurrentSub() {
        return currentSub;
    }

    public void setCurrentSub(SubPlans currentSub) {
        this.currentSub = currentSub;
    }
}
