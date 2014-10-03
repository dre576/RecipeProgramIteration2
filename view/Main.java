package view;

import java.util.ArrayList;
import java.util.HashMap;

import model.Category;
import model.Recipe;
import model.RecipeManager;
import model.dao.RecipeDAO;
import controller.RecipeManagerController;

public class Main {
	public static void main(String[] args) {
		/*This is the "script" and to create the information for the database,
		 * just run this method once.
		 */
		script();
	}

	private static void script() {
		/*Creating fields to send to the database*/
		String directions = "1. In a medium bowl, mash together the avocados, " +
		"lime juice, and salt.\n2. Mix in onion, cilantro, tomatoes, and garlic.\n3. Stir in cayenne "+
		"pepper.\n4. Refrigerate 1 hour for best flavor, or serve immediately.";
		String title = "Guacamole";	
		
		/*Defining ingredients and their amounts*/
		HashMap<String, String> ingredients = new HashMap<String, String>();
		ingredients.put("Avocados", "3");
		ingredients.put("Lime", "1");
		ingredients.put("Salt", "1/2 Cup");
		ingredients.put("Diced Onion", "1 Teaspoon");
		ingredients.put("Chopped Cilantro", "3 Tablespoons");
		ingredients.put("Tomatoes", "2");
		ingredients.put("Minced Garlic", "1 Teaspoon");		

		/*Defining the categories*/
		ArrayList<String> categories = new ArrayList<String>();
		categories.add("Appetizer");
		
		/*Saving recipe 1*/
		RecipeManagerController.createRecipe(directions, title, ingredients, categories);
		
		
		/*Creating fields to send to the database*/
		directions = "1. Place eggs in a pot of salted water. Bring the water to a boil, and let eggs cook in boiling water until they are hard boiled, approximately 10 to 15 minutes. Drain eggs, and let cool.\n2. Cut eggs in half, lengthwise. Remove the egg yolks and mash them together in a small mixing bowl. Mix in the paprika, mayonnaise, and dry mustard. Spoon mixture into the egg whites; cool and serve.";
		title = "Deviled Eggs";	
		
		/*Defining ingredients and their amounts*/
		ingredients = new HashMap<String, String>();
		ingredients.put("Eggs", "6");
		ingredients.put("Paprika", "1/2 Teaspoon");
		ingredients.put("Mayonnaise", "2 Tablespoons");
		ingredients.put("Mustard Powder", "1/2 Teaspoon");	

		/*Defining the categories*/
		categories = new ArrayList<String>();
		categories.add("Appetizer");
		
		/*Saving recipe 2*/
		RecipeManagerController.createRecipe(directions, title, ingredients, categories);
		
		
		/*Creating fields to send to the database*/
		directions = "1. Sift together flour, baking powder, salt, and sugar in a large bowl.\n2. Whisk in melted butter, egg, and milk until combined. Let batter rest for 5 minutes.\n3. Preheat a large skillet over medium-high heat. Spray with cooking spray. Pour batter into the hot skillet, about 1/4 cup of batter for each pancake. Cook for 2 to 3 minutes, until bubbles appear on the sides and center of each pancake. Flip and cook until golden, about 1 to 2 minutes.";
		title = "Pancakes";	
		
		/*Defining ingredients and their amounts*/
		ingredients = new HashMap<String, String>();
		ingredients.put("All Purpose Flour", "1 & 1/2 Cups");
		ingredients.put("Baking Power", "3 & 1/2 Teaspoons");
		ingredients.put("Salt", "1 Teaspoon");
		ingredients.put("White Sugar", "1 Tablespoon");	
		ingredients.put("Melted Butter", "3 Tablespoons");
		ingredients.put("Egg", "1");
		ingredients.put("Milk", "1 & 1/4 Cups");
		ingredients.put("Cooking Spray", "");

		/*Defining the categories*/
		categories = new ArrayList<String>();
		categories.add("Breakfast");
		
		/*Saving recipe 3*/
		RecipeManagerController.createRecipe(directions, title, ingredients, categories);
		
		
		/*Creating fields to send to the database*/
		directions = "1. Place about 1/2 cup strawberry slices into 2 glasses or parfait dishes. Spoon about 1/2 cup yogurt into each glass and top with about 1/4 cup granola.\n2. Divide remaining strawberries into glasses and top with banana slices. Place about 1/4 cup blueberries over bananas and top with remaining 1 cup yogurt.\n3. Layer remaining 1/2 cup granola over yogurt and drizzle each parfait with honey.";
		title = "Berry Parfait";	
		
		/*Defining ingredients and their amounts*/
		ingredients = new HashMap<String, String>();
		ingredients.put("Sliced Strawberries", "2 Cups");
		ingredients.put("Vanilla Yogurt", "2 Cups");
		ingredients.put("Granola", "1 Cup");	
		ingredients.put("Sliced Bananas", "1 Cup");
		ingredients.put("Blueberries", "1/2 Cup");
		ingredients.put("Honey", "1 Tablespoon");	

		/*Defining the categories*/
		categories = new ArrayList<String>();
		categories.add("Breakfast");
		
		/*Saving recipe 4*/
		RecipeManagerController.createRecipe(directions, title, ingredients, categories);
		
		
		/*Creating fields to send to the database*/
		directions = "Mix apples, oranges, marshmallows, grapes, yogurt, and walnuts together in a bowl.";
		title = "Zesty Apple Salad";	
		
		/*Defining ingredients and their amounts*/
		ingredients = new HashMap<String, String>();
		ingredients.put("Granny Smith Apples", "2");
		ingredients.put("Mandarin Oranges", "1 Can");
		ingredients.put("Miniature Marshmallows", "1 & 1/2 Cups");
		ingredients.put("Seedless Red Grapes", "1 Cup");
		ingredients.put("Lemon Yogurt", "8 Ounce");
		ingredients.put("Chopped Walnuts", "2 Tablespoons");

		/*Defining the categories*/
		categories = new ArrayList<String>();
		categories.add("Lunch");
		
		/*Saving recipe 5*/
		RecipeManagerController.createRecipe(directions, title, ingredients, categories);
		
		
		/*Creating fields to send to the database*/
		directions = "1. If the cooked rice is cold, reheat it in the microwave. When hot, mix in the Cheddar until the cheese melts. Set aside to cool to room temperature.\n2. Mash the avocado and lime juice together in a small bowl with a fork until it becomes a spreadable consistency.\n3. Lay the tortilla out on a cutting board. Spread the mashed avocado on the tortilla, leaving a 1-inch outer border without any avocado. In the bottom third of the tortilla, lay out in a log shape the rice, beans, carrots and salsa.\n4. Roll over once tightly, then tuck in the sides and continue rolling. The avocado should help the burrito stay together. Cut in half. Wrap in a paper towel, followed by a layer of aluminum foil. Serve at room temperature.";
		title = "Brown Rice and Bean Burrito";	
		
		/*Defining ingredients and their amounts*/
		ingredients = new HashMap<String, String>();
		ingredients.put("Cooked Brown Rice", "1/4 Cup");
		ingredients.put("Shredded Cheddar", "1 Tablespoon");
		ingredients.put("Avocado", "1/4");
		ingredients.put("Lime Juice", "1 Teaspoon");
		ingredients.put("Whole Wheat 8-Inch Tortilla", "1");
		ingredients.put("Black Beans", "2 Tablespoons");
		ingredients.put("Shredded Carrots", "2 Tablespoons");
		ingredients.put("Salsa", "1 Tablespoon");		

		/*Defining the categories*/
		categories = new ArrayList<String>();
		categories.add("Lunch");
		
		/*Saving recipe 6*/
		RecipeManagerController.createRecipe(directions, title, ingredients, categories);
				

		/*Creating fields to send to the database*/
		directions = "Melt butter in a medium saucepan over medium low heat. Add cream and simmer for 5 minutes, then add garlic and cheese and whisk quickly, heating through. Stir in parsley and serve.";
		title = "Alfredo Sauce";	
		
		/*Defining ingredients and their amounts*/
		ingredients = new HashMap<String, String>();
		ingredients.put("Butter", "1/4 Cup");
		ingredients.put("Heavy Cream", "1 Cup");
		ingredients.put("Crushed Garlic", "1 Clove");
		ingredients.put("Grated Parmesan Cheese", "1 & 1/2 Cups");
		ingredients.put("Chopped Parsley", "1/4 Cup");	

		/*Defining the categories*/
		categories = new ArrayList<String>();
		categories.add("Dinner");
		
		/*Saving recipe 7*/
		RecipeManagerController.createRecipe(directions, title, ingredients, categories);
		

		/*Creating fields to send to the database*/
		directions = "1. Heat oil in a large skillet over medium high heat. Add garlic, saute for 1 minute; then add chicken and cook for 7 to 8 minutes on each side. When chicken is close to being cooked through (no longer pink inside), add spinach and saute all together for 3 to 4 minutes.\n2. Meanwhile, stir in 2 tablespoons pesto and 1 cup Alfredo Sauce; set aside.\n3. In a large pot of salted boiling water, cook pasta for 8 to 10 minutes or until al dente. Rinse under cold water and drain.\n4. Add chicken/spinach mixture to pasta, then stir in pesto/Alfredo sauce. Mix well, top with cheese and serve.";
		title = "Pesto Chicken Florentine";	
		
		/*Defining ingredients and their amounts*/
		ingredients = new HashMap<String, String>();
		ingredients.put("Olive Oil", "2 Tablespoons");
		ingredients.put("Chopped Garlic", "2 Cloves");
		ingredients.put("Chicken Strips", "4 Pieces");
		ingredients.put("Spinach", "2 Cups");
		ingredients.put("Alfredo Sauce", "1 Cup");
		ingredients.put("Pesto", "2 Tablespoons");
		ingredients.put("Penne Pasta", "1 & 1/2 Cups");
		ingredients.put("Grated Romano Cheese", "1 Tablespoon");

		/*Defining the categories*/
		categories = new ArrayList<String>();
		categories.add("Dinner");
		
		/*Saving recipe 8*/
		RecipeManagerController.createRecipe(directions, title, ingredients, categories);		
		
		
		/*Creating fields to send to the database*/
		directions = "In a blender, combine soy milk, oats, banana and strawberries. Add vanilla and sugar if desired. Blend until smooth. Pour into glasses and serve.";
		title = "Strawberry Moothie";	
		
		/*Defining ingredients and their amounts*/
		ingredients = new HashMap<String, String>();
		ingredients.put("Soy Milk", "1 Cup");
		ingredients.put("Rolled Oats", "1/2 Cup");
		ingredients.put("Banana", "1");
		ingredients.put("Strawberries", "14");
		ingredients.put("Vanilla Extract", "1/2 Teaspoon");
		ingredients.put("White Sugar", "1 & 1/2 Teaspoons");

		/*Defining the categories*/
		categories = new ArrayList<String>();
		categories.add("Dessert");
		
		/*Saving recipe 9*/
		RecipeManagerController.createRecipe(directions, title, ingredients, categories);
		

		/*Creating fields to send to the database*/
		directions = "1. Preheat the oven to 350 degrees F (175 degrees C). Grease a 9x13 inch baking dish.\n2. Cut each apple into 8 wedges and set aside. Separate the crescent roll dough into triangles. Roll each apple wedge in crescent roll dough starting at the smallest end. Pinch to seal and place in the baking dish.\n3. Melt butter in a small saucepan and stir in the sugar and cinnamon. Pour over the apple dumplings. Pour Mountain Dew™ over the dumplings.\n4. Bake for 35 to 45 minutes in the preheated oven, or until golden brown.";
		title = "Apple Dumplings";	
		
		/*Defining ingredients and their amounts*/
		ingredients = new HashMap<String, String>();
		ingredients.put("Granny Smith Apples", "2 Large");
		ingredients.put("Crescent Roll Dough", "2 Cans");
		ingredients.put("Butter", "1 Cup");
		ingredients.put("White Sugar", "1 & 1/2 Cups");
		ingredients.put("GroundCinnamon", "1 Teaspoon");
		ingredients.put("Mountain Dew", "1 Can");

		/*Defining the categories*/
		categories = new ArrayList<String>();
		categories.add("Dessert");
		
		/*Saving recipe 10*/
		RecipeManagerController.createRecipe(directions, title, ingredients, categories);
	}
}
