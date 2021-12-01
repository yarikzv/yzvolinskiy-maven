package org.homework21;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

class ATMTest {

    @Mock
    ATM atmMock = mock(ATM.class);
    
    @Test
    void operationsTest(){
        atmMock.operations();
        verify(atmMock, times(1)).operations();
    }
}