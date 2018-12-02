package application;

public class DBDTO {
	private int food_id;
	private int recipe_id;
	private String recipe_name;
	private String recipe_ingredient;
	private String recipe_sequence;
	private String recipe_image;
	
	
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public String getRecipe_ingredient() {
		return recipe_ingredient;
	}
	public void setRecipe_ingredient(String recipe_ingredient) {
		this.recipe_ingredient = recipe_ingredient;
	}
	public String getRecipe_sequence() {
		return recipe_sequence;
	}
	public void setRecipe_sequence(String recipe_sequence) {
		this.recipe_sequence = recipe_sequence;
	}
	public String getRecipe_image() {
		return recipe_image;
	}
	public void setRecipe_image(String recipe_image) {
		this.recipe_image = recipe_image;
	}
	
}
