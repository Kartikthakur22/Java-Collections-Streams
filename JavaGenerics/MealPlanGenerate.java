import java.util.Scanner;

interface MealPlan {
    void displayMealPlan();
}

class VegetarianMeal implements MealPlan {
    @Override
    public void displayMealPlan() {
        System.out.println("Your Vegetarian Meal Plan: \n- Tofu Stir Fry\n- Quinoa Salad\n- Veggie Soup");
    }
}

class VeganMeal implements MealPlan {
    @Override
    public void displayMealPlan() {
        System.out.println("Your Vegan Meal Plan: \n- Lentil Soup\n- Chickpea Salad\n- Tofu Tacos");
    }
}

class KetoMeal implements MealPlan {
    @Override
    public void displayMealPlan() {
        System.out.println("Your Keto Meal Plan: \n- Grilled Chicken with Avocado\n- Zucchini Noodles\n- Cheese Salad");
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public void displayMealPlan() {
        System.out.println("Your High-Protein Meal Plan: \n- Chicken Breast\n- Scrambled Eggs\n- Grilled Fish");
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void generateMealPlan() {
        mealPlan.displayMealPlan();
    }
}

class MealPlanValidator {
    public static <T extends MealPlan> boolean validateMealPlan(T mealPlan) {
        if (mealPlan == null) {
            return false;
        }
        return true;
    }
}

public class MealPlanGenerate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Personalized Meal Plan Generator!");
        System.out.println("Please select your meal plan type: ");
        System.out.println("1. Vegetarian");
        System.out.println("2. Vegan");
        System.out.println("3. Keto");
        System.out.println("4. High-Protein");

        int choice = scanner.nextInt();
        MealPlan mealPlan = null;

        switch (choice) {
            case 1:
                mealPlan = new VegetarianMeal();
                break;
            case 2:
                mealPlan = new VeganMeal();
                break;
            case 3:
                mealPlan = new KetoMeal();
                break;
            case 4:
                mealPlan = new HighProteinMeal();
                break;
            default:
                System.out.println("Invalid choice! Exiting...");
                System.exit(0);
        }

        if (MealPlanValidator.validateMealPlan(mealPlan)) {
            Meal<MealPlan> meal = new Meal<>(mealPlan);
            meal.generateMealPlan();
        } else {
            System.out.println("Invalid meal plan. Please try again.");
        }

        scanner.close();
    }
}
