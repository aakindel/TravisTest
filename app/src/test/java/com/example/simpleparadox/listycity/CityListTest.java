package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());

        cityList.add(new City("Regina", "Saskatchewan"));

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City edmonton = cityList.getCities().get(0);
        cityList.delete(edmonton);  // test for a city that was already in list

        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(edmonton));

        City regina = new City("Regina", "Saskatchewan");
        cityList.add(regina);

        assertEquals(1, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(regina));

        cityList.delete(regina);  // test for a newly added city
        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(regina));
    }
}
