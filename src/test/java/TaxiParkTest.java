import com.companic.model.entity.*;
import com.companic.model.entity.Car;
import com.companic.model.entity.Color;
import com.companic.model.entity.Body;
import com.companic.model.entity.PassengerCar;
import com.companic.model.entity.Duty;
import com.companic.model.entity.Truck;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static com.companic.model.entity.PassengerCarBuilder.passengerCar;
import static com.companic.model.entity.TruckBuilder.truck;
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

    private static Truck car6;
    private static Truck car7;
    private static Truck car8;
    private static Truck car9;
    private static Truck car10;

    @BeforeClass public static void init() {
        car1 = passengerCar().withVendor("Toyota").withModel("Auris").withYear(2008).withBody(Body.HATCHBACK)
                       .withColor(Color.GREEN).withMaxSpeed(250).withFuelConsumption(4).withPassengersAmount(4)
                       .withValue(2000).withLicense("12GH1G5").build();

        car2 = passengerCar().withVendor("Mercedes").withModel("E Class").withYear(2003).withBody(Body.SEDAN)
                       .withColor(Color.GREY).withMaxSpeed(240).withLicense("12GH1G5").withFuelConsumption(7)
                       .withPassengersAmount(4).withValue(3800).build();

        car3 = passengerCar().withVendor("Honda").withModel("Fit").withYear(2004).withBody(Body.HATCHBACK)
                       .withColor(Color.YELLOW).withLicense("12GH1G5").withMaxSpeed(200).withFuelConsumption(3)
                       .withPassengersAmount(4).withValue(4000).build();

        car4 = passengerCar().withVendor("Subaru").withModel("Impreza").withYear(2005).withLicense("12GH1G5")
                       .withBody(Body.SEDAN).withColor(Color.GREEN).withMaxSpeed(190).withFuelConsumption(9)
                       .withPassengersAmount(4).withValue(3000).build();

        car5 = passengerCar().withVendor("Nissan").withModel("Lafesta").withYear(2008).withBody(Body.MINI_VAN)
                       .withColor(Color.GREEN).withMaxSpeed(300).withFuelConsumption(2).withPassengersAmount(4)
                       .withLicense("12GH1G5").withValue(5500).build();

        car6 = truck().withVendor("Nissan").withModel("Lafesta").withYear(2008).withDuty(Duty.LIGHT).withPayload(2000)
                       .withColor(Color.GREEN).withMaxSpeed(150).withFuelConsumption(10).withValue(7500)
                       .withLicense("12GH1G5").build();

        car7 = truck().withVendor("Nissan").withModel("Lafesta").withYear(2008).withDuty(Duty.MEDIUM).withPayload(5000)
                       .withLicense("12GH1G5").withColor(Color.BLUE).withMaxSpeed(140).withFuelConsumption(15)
                       .withValue(17500).build();
        ;

        taxiPark = new TaxiPark(car1, car2, car3, car4, car5, car6, car7);
    }

    @Test public void sortByFuelConsumptionAscTest() {
        assertArrayEquals(new Car[] { car5, car3, car1, car2, car4, car6, car7 },
                taxiPark.sortByFuelConsumptionAsc().toArray());
    }

    @Test public void calculateTotalValueTest() {
        assertEquals(43_300, taxiPark.calculateTotalValue());
    }

    @Test public void findCarsWithinGivenMaxSpeedRangeTest() {
        assertArrayEquals(new Car[] { car2, car3, car4 },
                taxiPark.findCarsWithinGivenMaxSpeedRange(180, 245).toArray());
    }
}
