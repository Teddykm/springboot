package com.boot;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTest {
    @InjectMocks
    private ShipwreckController shipwreckController;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet() {
        Shipwreck expectedResult = new Shipwreck();
        expectedResult.setId(1l);
        when(shipwreckRepository.findOne(1l)).thenReturn(expectedResult);

        Shipwreck actualResult = shipwreckController.get(1l);

        verify(shipwreckRepository.findOne(1l));

        Assert.assertEquals(expectedResult, actualResult);
     //  MatcherAssert.assertThat(actualResult.getId(), isNull());
    }
}
