/* Adapted from code in "Java Programming", Chapter 20
   by Yakov Fain
 */
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;
import java.util.stream.Collectors;

public class BeerFest {
    public  static class Beer {
	public final String name;
	public final String country;
	private float price;

	public Beer(String name, String country,float price){
	    this.name=name;
	    this.country=country;
	    this.price=price;
	}

	public String toString(){
	    return "Country: " + country +  " Name: " + name + ", price: " + price;
	}
	public float getPrice() {
	    return price;
	}
	public void setPrice(float price) {
	    this.price = price;
	}
    }
    public static List<Beer> beerQuery(List<Beer> beerList, Predicate <Beer> predicate) {
        List<Beer> result = beerList.stream().filter( predicate ).collect(Collectors.<Beer>toList());
	    // ToDo Select Beers that match the predicate
        return result;
    }
    static List<Beer> loadCellar(){
        List<Beer> beerStock = new ArrayList<>();

        beerStock.add(new Beer("Stella", "Belgium", 7.75f));
        beerStock.add(new Beer("Sam Adams", "USA", 7.00f));
        beerStock.add(new Beer("Obolon", "Ukraine", 4.00f));
        beerStock.add(new Beer("Bud Light", "USA", 5.00f));
        beerStock.add(new Beer("Yuengling", "USA", 5.50f));
        beerStock.add(new Beer("Leffe Blonde", "Belgium", 8.75f));
        beerStock.add(new Beer("Chimay Blue", "Belgium", 10.00f));
        beerStock.add(new Beer("Brooklyn Lager", "USA", 8.25f));

        return beerStock;
    }
    static Predicate<Beer> priceRangeQuery(double lowest, double highest) {
	// ToDo: compose and return a Predicate that will
	// express the selection criterion
		return beer -> beer.getPrice() >= lowest && beer.getPrice() <= highest;
    }
    static Predicate<Beer> countryQuery(String countryName) {
	// ToDo: compose and return a Predicate that will
	// express the selection criterion
		return beer -> beer.country.equals(countryName);
    }
    public static void main(String argv[]) {
		List<Beer> beerList = loadCellar();
		// Call beerQuery with a predicate for selecting a country
		System.out.println("Every beer for the country of Belgium");
		beerQuery(beerList, countryQuery("Belgium")).forEach(System.out::println);
		// Call beerQuery with a predicate for a price range
		System.out.println("Every beer the falls between 4.00 and 5.00");
		beerQuery(beerList, priceRangeQuery(4.00, 5.00)).forEach(System.out::println);

    }
}
