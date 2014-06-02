package com.fluffy_minions.prototype.needsCalculators;

/**
 * This class represents the information about a person
 * who wants to generate a menu for a week.
 */

public class PersonalProfile {

    /**
     * The class stores the weight, height, age, gender, and activity level of the person.
     */

	private double weight;
	private double height;
	private double age;
	private String gender;
	private String preferences;
	private String activityLevel;

    /**
     * This method changes the weight of the person.
     * @param weight new value of the weight
     */

	public void setWeight(double weight) {
		this.weight = weight;
	}

    /**
     * This method changes the height of the person.
     * @param height new value of the height
     */

    public void setHeight(double height) {
		this.height = height;
	}

    /**
     * This method changes the age of the person.
     * @param age new value of the age
     */

    public void setAge(double age) {
		this.age = age;
	}

    /**
     * This method changes the activity level of the person.
     * @param activityLevel new value of the activity level
     */

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    /**
     * This method changes the gender of the person.
     * @param gender new value of the gender
     */

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * This method returns the gender of the person.
     * @return person's gender
     */

    public String getGender() {
		return gender;
	}

    /**
     * This method returns the weight of the person.
     * @return person's weight
     */

    public double getWeight() {
		return weight;
	}

    /**
     * This method returns the height of the person.
     * @return person's height
     */

	public double getHeight() {
		return height;
	}

    /**
     * This method returns the age of the person.
     * @return person's age
     */

    public double getAge() {
		return age;
	}

    /**
     * This method returns the activity of the person.
     * @return person's activity
     */

    public String getActivityLevel() {
		return activityLevel;
	}

    /**
     * This method returns whether the profile is filled out.
     * @return true if all fields are completed and false if at least one is not completed
     */

    public boolean isComplete() {
        return (weight != 0 && height != 0 && age != 0 && gender != null && activityLevel != null);
    }
}
