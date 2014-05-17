package needsCalculators;

public class PersonalProfile {
	private double weight;
	private double height;
	private double age;
	private String gender;
	private String preferences;
	private String activityLevel;
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setAge(double age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}
	public double getHeight() {
		return height;
	}
	public double getAge() {
		return age;
	}
	public String getPreferences() {
		return preferences;
	}
	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
}
