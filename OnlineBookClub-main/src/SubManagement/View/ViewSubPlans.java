package SubManagement.View;

import SubManagement.Model.SubPlans;

/**
 * ViewSubPlans displays details about user's subscription plan:
 * - sub status
 * - description
 * - current sub
 *
 * The LCOM4 measure for this class is also low as all methods are focused on displaying different aspects of a
 * sub plan. Each method operates on the 'SubPlans' data to ensure high cohesion within the class. All methods
 * contribute to presenting subscription-related information.
 */

public class ViewSubPlans {

    public void displaySubscriptionDetails(SubPlans subPlans) {
        displaySubPlans(subPlans);
        displaySubDescription(subPlans.getSubDescription());
        displayCurrentSub(subPlans.getCurrentSub() != null ? subPlans.getCurrentSub().getSubStatus() : "No Current Subscription");
    }

    public void displaySubPlans(SubPlans subPlans) {
        System.out.println("Subscription Status: " + subPlans.getSubStatus());
    }

    public void displaySubDescription(String subDescription) {
        System.out.println("Subscription Description: " + subDescription);
    }

    public void displayCurrentSub(String currentSub) {
        System.out.println("Current Subscription: " + currentSub);
    }
}
