import com.companic.model.entity.Car;
import com.companic.model.Color;
import com.companic.model.entity.PassengerCar;
import com.companic.model.entity.TaxiPark;
import com.companic.model.Body;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static com.companic.model.entity.PassengerCarBuilder.passengerCar;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TaxiParkTest {

    private static List<Car> cars;
    private static TaxiPark taxiPark;

    private static PassengerCar car1;
    private static PassengerCar car2;
    private static PassengerCar car3;
    private static PassengerCar car4;
    private static PassengerCar car5;

    @BeforeClass public static void init() {
        car1 = passengerCar().withVendor("Toyota").withModel("Auris").withYear(2008).withBody(Body.HATCHBACK)
                       .withColor(Color.GREEN).withMaxSpeed(250).withFuelConsumption(4).withPassengersAmount(4)
                       .withValue(2000).build();

        car2 = passengerCar().withVendor("Mercedes").withModel("E Class").withYear(2003).withBody(Body.SEDAN)
                       .withColor(Color.GREY).withMaxSpeed(240).withFuelConsumption(7).withPassengersAmount(4)
                       .withValue(3800).build();

        car3 = passengerCar().withVendor("Honda").withModel("Fit").withYear(2004).withBody(Body.HATCHBACK)
                       .withColor(Color.YELLOW).withMaxSpeed(200).withFuelConsumption(3).withPassengersAmount(4)
                       .withValue(4000).build();

        car4 = passengerCar().withVendor("Subaru").withModel("Impreza").withYear(2005).withBody(Body.SEDAN)
                       .withColor(Color.GREEN).withMaxSpeed(190).withFuelConsumption(9).withPassengersAmount(4)
                       .withValue(3000).build();

        car5 = passengerCar().withVendor("Nissan").withModel("Lafesta").withYear(2008).withBody(Body.MINI_VAN)
                       .withColor(Color.GREEN).withMaxSpeed(300).withFuelConsumption(2).withPassengersAmount(4)
                       .withValue(5500).build();

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
