import com.companic.model.entity.Car;
import com.companic.model.Color;
import com.companic.model.TaxiPark;
import com.companic.model.Type;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static com.companic.model.CarBuilder.car;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TaxiParkTest {

    private static List<Car> cars;
    private static TaxiPark taxiPark;

    private static Car car1;
    private static Car car2;
    private static Car car3;
    private static Car car4;
    private static Car car5;

    @BeforeClass public static void init() {
        car1 = car().withVendor("Toyota").withModel("Auris").withYear(2008).withType(Type.HATCHBACK)
                       .withColor(Color.GREEN).withMaxSpeed(250).withFuelConsumption(4).withValue(2000).build();

        car2 = car().withVendor("Mercedes").withModel("E Class").withYear(2003).withType(Type.SEDAN)
                       .withColor(Color.GREY).withMaxSpeed(240).withFuelConsumption(7).withValue(3800).build();

        car3 = car().withVendor("Honda").withModel("Fit").withYear(2004).withType(Type.HATCHBACK)
                       .withColor(Color.YELLOW).withMaxSpeed(200).withFuelConsumption(3).withValue(4000).build();

        car4 = car().withVendor("Subaru").withModel("Impreza").withYear(2005).withType(Type.SEDAN)
                       .withColor(Color.GREEN).withMaxSpeed(190).withFuelConsumption(9).withValue(3000).build();

        car5 = car().withVendor("Nissan").withModel("Lafesta").withYear(2008).withType(Type.MINI_VAN)
                       .withColor(Color.GREEN).withMaxSpeed(300).withFuelConsumption(2).withValue(5500).build();

        taxiPark = new TaxiPark(car1, car2, car3, car4, car5);
    }

    @Test public void sortByFuelConsumptionAscTest() {
        assertArrayEquals(new Car[] { car5, car3, car1, car2, car4 }, taxiPark.sortByFuelConsumptionAsc().toArray());
    }

    @Test public void calculateTotalValueTest() {
        assertEquals(18_300, taxiPark.calculateTotalValue());
    }

    @Test public void findCarsWithinGivenMaxSpeedRangeTest() {
        assertArrayEquals(new Car[] { car2, car3, car4 },
                taxiPark.findCarsWithinGivenMaxSpeedRange(180, 245).toArray());
    }
}
