import com.companic.model.Car;
import com.companic.model.Color;
import com.companic.model.TaxiPark;
import com.companic.model.Type;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.companic.model.CarBuilder.car;

public class TaxiParkTest {

    private static ArrayList<Car> cars;
    private static TaxiPark taxiPark;

    private static Car car1;
    private static Car car2;
    private static Car car3;
    private static Car car4;
    private static Car car5;

    @BeforeClass public static void init() {
        car1 = car().withVendor("Toyota").withModel("Auris").withYear(2008).withType(Type.HATCHBACK)
                       .withColor(Color.GREEN).withMaxSpeed(250).withFuelConsumption(4).withAccelerationTime(8)
                       .withValue(2000).build();

        car2 = car().withVendor("Mercedes").withModel("E Class").withYear(2003).withType(Type.SEDAN)
                       .withColor(Color.GREY).withMaxSpeed(240).withFuelConsumption(7).withAccelerationTime(7)
                       .withValue(3800).build();

        car3 = car().withVendor("Honda").withModel("Fit").withYear(2004).withType(Type.HATCHBACK)
                       .withColor(Color.YELLOW).withMaxSpeed(200).withFuelConsumption(3).withAccelerationTime(11)
                       .withValue(4000).build();

        car4 = car().withVendor("Subaru").withModel("Impreza").withYear(2005).withType(Type.SEDAN)
                       .withColor(Color.GREEN).withMaxSpeed(190).withFuelConsumption(9).withAccelerationTime(8)
                       .withValue(3000).build();

        car5 = car().withVendor("Nissan").withModel("Lafesta").withYear(2008).withType(Type.MINI_VAN)
                       .withColor(Color.GREEN).withMaxSpeed(250).withFuelConsumption(2).withAccelerationTime(8)
                       .withValue(5500).build();

        cars = new ArrayList<>(Arrays.asList(car1, car2, car3, car4, car5));
        taxiPark = new TaxiPark(cars);
    }

    @Test public void sortByFuelConsumptionAscTest() {
        Assert.assertArrayEquals(new Car[] { car5, car3, car1, car2, car4 },
                taxiPark.sortByFuelConsumptionAsc().toArray());
    }

    @Test public void calculateTotalValueTest() {
        Assert.assertEquals(18_300, taxiPark.calculateTotalValue());
    }
}
