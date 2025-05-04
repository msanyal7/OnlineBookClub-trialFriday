package SubManagement.Controller;

import SubManagement.Model.SubPlans;

/**
 * ModifySubs is a class that modifies a user's subscription plan:
 * - methods to add, delete, and change the sub plan
 *
 * There is low expectancy for this class as the methods relate to modifying the sub status or the plan itself
 * to ensure high cohesion. The class is focused on modifying sub plans and manages / updates sub data
 * which means they are semantically related.
 */

public class ModifySubs {

    // Method to modify subscriptions
    public void ModifySubs(SubPlans subPlans) {
        addSub(subPlans, true);  // Example to add subscription
        deleteSub(subPlans, false);  // Example to delete subscription
        changeSub(subPlans);  // Example to change subscription
    }

    // Add subscription
    public void addSub(SubPlans subPlans, boolean subStatus) {
        System.out.println("Adding Subscription: " + subPlans.getSubDescription() + " with status: " + subStatus);
    }

    // Delete subscription
    // Uses command pattern
    public void deleteSub(SubPlans currentSub, boolean subStatus) {
        System.out.println("Deleting Subscription: " + currentSub.getSubDescription() + " with status: " + subStatus);
    }

    // Change subscription
    public void changeSub(SubPlans subPlans) {
        System.out.println("Changing Subscription to: " + subPlans.getSubDescription());
    }
}
