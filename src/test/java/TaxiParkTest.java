import com.companic.model.TaxiPark;
import com.companic.model.entity.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.companic.model.entity.PassengerCarBuilder.passengerCar;
import static com.companic.model.entity.TruckBuilder.truck;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TaxiParkTest {

    private static TaxiPark taxiPark;

    private static PassengerCar car1;
    private static PassengerCar car2;
    private static PassengerCar car3;
    private static PassengerCar car4;
    private static PassengerCar car5;

    private static Truck truck1;
    private static Truck truck2;
    private static Truck truck3;
    private static Truck truck4;
    private static Truck truck5;

    @BeforeClass public static void init() {
        //use json
        car1 = passengerCar().withVendor("Toyota").withModel("Auris").withYear(2008).withBody(Body.HATCHBACK)
                       .withColor(Color.GREEN).withMaxSpeed(250).withFuelConsumption(4).withPassengersAmount(4)
                       .withValue(2000).withLicense("12GH1G5").build(); //names

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

        truck1 = truck().withVendor("International").withLicense("4RSL95H").withModel("CV515: 115\" BBC").withYear(2018)
                         .withDuty(Duty.MEDIUM).withPayload(10000).withColor(Color.RED).withMaxSpeed(180)
                         .withFuelConsumption(20).withValue(100500).build();

        truck2 = truck().withVendor("HINO").withLicense("8F483NA").withModel("NH: 155\" Cabover").withYear(2007)
                         .withDuty(Duty.MEDIUM).withPayload(10000).withColor(Color.GREY).withMaxSpeed(140)
                         .withFuelConsumption(17).withValue(34500).build();

        truck3 = truck().withVendor("Ford").withLicense("JF71NH5").withModel("F150").withYear(1977).withDuty(Duty.LIGHT)
                         .withPayload(2000).withColor(Color.BLUE).withMaxSpeed(160).withFuelConsumption(11)
                         .withValue(5700).build();

        truck4 = truck().withVendor("Freightliner").withLicense("8GH5N12").withModel("BUSINESS CLASS M2 106")
                         .withYear(2007).withDuty(Duty.HEAVY).withPayload(20000).withColor(Color.WHITE)
                         .withMaxSpeed(130).withFuelConsumption(25).withValue(15700).build();

        truck5 = truck().withVendor("Kenworth").withLicense("93N12L9").withModel("K100").withYear(1984)
                         .withDuty(Duty.HEAVY).withPayload(25000).withColor(Color.BLACK).withMaxSpeed(120)
                         .withFuelConsumption(30).withValue(19000).build();

        taxiPark = new TaxiPark(new Car[] { car1, car2, car3, car4, car5, truck1, truck2, truck3, truck4, truck5 });
    }

    @Test public void sortByFuelConsumptionAscTest() {
        assertArrayEquals("wrong order\\amount of cars", new Car[] { car5, car3, car1, car2, car4, truck3, truck2, truck1, truck4, truck5 },
                taxiPark.sortByFuelConsumptionAsc().toArray());
    }

    @Test public void shouldReturnEmptyList_OnEmptyPark_for_sortByFuelConsumption() {
        assertArrayEquals("should return empty list", new Car[]{},
                new TaxiPark().sortByFuelConsumptionAsc().toArray());
    }

    @Test public void calculateTotalValueTest() {
        assertEquals("wrong calculation",193_700, taxiPark.calculateTotalValue());
    }

    @Test public void shouldReturn_Zero_on_Empty_Park_for_calculateTotalValue() {
        assertEquals("should return empty list", 0,
                new TaxiPark().calculateTotalValue());
    }

    @Test public void findCarsWithinGivenMaxSpeedRangeTest() {
        assertArrayEquals(new Car[] { car2, car3, car4, truck1, truck3 },
                taxiPark.findCarsWithinGivenMaxSpeedRange(150, 245).toArray());
    }

    @Test public void shouldReturnEmptyList__When_No_Cars_in_GivenSpeedRange() {
        assertArrayEquals(new Car[]{}, new TaxiPark().findCarsWithinGivenMaxSpeedRange(10, 20).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void  shouldThrow_IllegalArgumentException_when_Invalid_Args_for_MaxSpeedRange_method() {
        taxiPark.findCarsWithinGivenMaxSpeedRange(200, 100);
    }

    @Test public void shouldReturn_SingleCar_FromSpeedRange_If_It_Is_TheOnlyOne() {
        assertEquals("should be the only car",1, taxiPark.findCarsWithinGivenMaxSpeedRange(290, 320).size());
    }
}
