package com.syriabazaar.cars.domain;

import static com.syriabazaar.cars.domain.AssertUtils.bigDecimalCompareTo;
import static org.assertj.core.api.Assertions.assertThat;

public class CarAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCarAllPropertiesEquals(Car expected, Car actual) {
        assertCarAutoGeneratedPropertiesEquals(expected, actual);
        assertCarAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCarAllUpdatablePropertiesEquals(Car expected, Car actual) {
        assertCarUpdatableFieldsEquals(expected, actual);
        assertCarUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCarAutoGeneratedPropertiesEquals(Car expected, Car actual) {
        assertThat(actual)
            .as("Verify Car auto generated properties")
            .satisfies(a -> assertThat(a.getId()).as("check id").isEqualTo(expected.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCarUpdatableFieldsEquals(Car expected, Car actual) {
        assertThat(actual)
            .as("Verify Car relevant properties")
            .satisfies(a -> assertThat(a.getYear()).as("check year").isEqualTo(expected.getYear()))
            .satisfies(a -> assertThat(a.getPrice()).as("check price").usingComparator(bigDecimalCompareTo).isEqualTo(expected.getPrice()))
            .satisfies(a -> assertThat(a.getMileage()).as("check mileage").isEqualTo(expected.getMileage()))
            .satisfies(a -> assertThat(a.getDrivetrain()).as("check drivetrain").isEqualTo(expected.getDrivetrain()))
            .satisfies(a -> assertThat(a.getEngine()).as("check engine").isEqualTo(expected.getEngine()))
            .satisfies(a -> assertThat(a.getTransmission()).as("check transmission").isEqualTo(expected.getTransmission()))
            .satisfies(a -> assertThat(a.getFuelType()).as("check fuelType").isEqualTo(expected.getFuelType()))
            .satisfies(a -> assertThat(a.getExteriorColor()).as("check exteriorColor").isEqualTo(expected.getExteriorColor()))
            .satisfies(a -> assertThat(a.getInteriorColor()).as("check interiorColor").isEqualTo(expected.getInteriorColor()))
            .satisfies(a -> assertThat(a.getVin()).as("check vin").isEqualTo(expected.getVin()))
            .satisfies(a -> assertThat(a.getLocation()).as("check location").isEqualTo(expected.getLocation()))
            .satisfies(a -> assertThat(a.getDescription()).as("check description").isEqualTo(expected.getDescription()))
            .satisfies(a -> assertThat(a.getPublishedDate()).as("check publishedDate").isEqualTo(expected.getPublishedDate()))
            .satisfies(a -> assertThat(a.getAdNumber()).as("check adNumber").isEqualTo(expected.getAdNumber()))
            .satisfies(a -> assertThat(a.getViews()).as("check views").isEqualTo(expected.getViews()))
            .satisfies(a -> assertThat(a.getAlloyWheels()).as("check alloyWheels").isEqualTo(expected.getAlloyWheels()))
            .satisfies(a -> assertThat(a.getSunroof()).as("check sunroof").isEqualTo(expected.getSunroof()))
            .satisfies(a -> assertThat(a.getTintedGlass()).as("check tintedGlass").isEqualTo(expected.getTintedGlass()))
            .satisfies(a -> assertThat(a.getLedHeadlights()).as("check ledHeadlights").isEqualTo(expected.getLedHeadlights()))
            .satisfies(a -> assertThat(a.getFoldableRoof()).as("check foldableRoof").isEqualTo(expected.getFoldableRoof()))
            .satisfies(a -> assertThat(a.getTowHitch()).as("check towHitch").isEqualTo(expected.getTowHitch()))
            .satisfies(a ->
                assertThat(a.getAdjustableSteeringWheel())
                    .as("check adjustableSteeringWheel")
                    .isEqualTo(expected.getAdjustableSteeringWheel())
            )
            .satisfies(a ->
                assertThat(a.getAutoDimmingRearview()).as("check autoDimmingRearview").isEqualTo(expected.getAutoDimmingRearview())
            )
            .satisfies(a -> assertThat(a.getHeatedFrontSeats()).as("check heatedFrontSeats").isEqualTo(expected.getHeatedFrontSeats()))
            .satisfies(a -> assertThat(a.getLeatherSeats()).as("check leatherSeats").isEqualTo(expected.getLeatherSeats()))
            .satisfies(a -> assertThat(a.getBlindSpotMonitor()).as("check blindSpotMonitor").isEqualTo(expected.getBlindSpotMonitor()))
            .satisfies(a ->
                assertThat(a.getAdaptiveCruiseControl()).as("check adaptiveCruiseControl").isEqualTo(expected.getAdaptiveCruiseControl())
            )
            .satisfies(a -> assertThat(a.getNavigationSystem()).as("check navigationSystem").isEqualTo(expected.getNavigationSystem()))
            .satisfies(a -> assertThat(a.getBackupCamera()).as("check backupCamera").isEqualTo(expected.getBackupCamera()))
            .satisfies(a -> assertThat(a.getAppleCarplay()).as("check appleCarplay").isEqualTo(expected.getAppleCarplay()))
            .satisfies(a -> assertThat(a.getAndroidAuto()).as("check androidAuto").isEqualTo(expected.getAndroidAuto()))
            .satisfies(a -> assertThat(a.getPremiumSoundSystem()).as("check premiumSoundSystem").isEqualTo(expected.getPremiumSoundSystem())
            )
            .satisfies(a -> assertThat(a.getIsFirstOwn()).as("check isFirstOwn").isEqualTo(expected.getIsFirstOwn()))
            .satisfies(a -> assertThat(a.getIsAccedFree()).as("check isAccedFree").isEqualTo(expected.getIsAccedFree()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCarUpdatableRelationshipsEquals(Car expected, Car actual) {
        assertThat(actual)
            .as("Verify Car relationships")
            .satisfies(a -> assertThat(a.getBrand()).as("check brand").isEqualTo(expected.getBrand()))
            .satisfies(a -> assertThat(a.getSeller()).as("check seller").isEqualTo(expected.getSeller()))
            .satisfies(a -> assertThat(a.getType()).as("check type").isEqualTo(expected.getType()))
            .satisfies(a -> assertThat(a.getModel()).as("check model").isEqualTo(expected.getModel()))
            .satisfies(a -> assertThat(a.getCity()).as("check city").isEqualTo(expected.getCity()));
    }
}
