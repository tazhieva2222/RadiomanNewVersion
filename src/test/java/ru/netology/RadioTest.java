package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio ("noname", 100, 0, 45,10, 0,0, true);


    @Test
    public void createRadio() {
        String expected = "noname";
        radio.getName();
        radio.setName(expected);
        assertEquals(expected, radio.getName());
    }


    @Test
    public void validateChangeFields() {
        assertEquals(0, radio.getCurrentRadioStation());
        radio.setCurrentRadioStation(4);
        assertEquals(4, radio.getCurrentRadioStation());
    }

 
    @Test
    public void atMaxRadioStationPressNextStation() {
        radio.setMaxRadioStation(9);
        radio.pressNextStation();
        assertEquals(0,radio.getMinRadioStation());
    }
 
    @Test
    public void atMinRadioStationPressPrevStation() {
        radio.setMinRadioStation(0);
        radio.pressPrevStation();
        assertEquals(10, radio.getMaxRadioStation());
    }

    @Test
    public void changeOverLastRadioStation() {
        radio.setCurrentRadioStation(9);
        radio.pressNextStation();
        assertEquals(10, radio.getCurrentRadioStation());
    }

    @Test
    public void changeUnderInitialRadioStation() {
        radio.setCurrentRadioStation(0);
        radio.pressPrevStation();
        assertEquals(10, radio.getCurrentRadioStation());

    }

    @Test
    public void nextRadioStation() {
        radio.setCurrentRadioStation(6);
        radio.pressNextStation();
        assertEquals(7, radio.getCurrentRadioStation());
    }

    @Test
    public void prevRadioStation() {
        radio.setCurrentRadioStation(6);
        radio.pressPrevStation();
        assertEquals(5, radio.getCurrentRadioStation());
    }

    @Test
    public void OverInitialRadioStation() {
        radio.setCurrentRadioStation(11);
        radio.getMaxRadioStation();
        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void UnderInitialRadioStation() {
        radio.setCurrentRadioStation(-1);
        radio.getMinRadioStation();
        assertEquals(0, radio.getCurrentRadioStation());
    }

    // тестируем громкость
    @Test
    public void volumeOverMax() {
        radio.setCurrentVolume(101);
        radio.getMaxVolume();
        assertEquals(100, radio.getMaxVolume());
    }

    @Test
    public void atMaxVolumePlusVolume() {
        radio.setMaxVolume(100);
        radio.pressPlusVolume();
        assertEquals(100, radio.getMaxVolume());
    }

    @Test
    public void atMinVolumeMinusVolum() {
        radio.setMinVolume(0);
        radio.pressMinusVolume();
        assertEquals(0, radio.getMinVolume());

    }
    
    @Test
    public void volumeDownUnderMin() {
        radio.setCurrentVolume(-11);
        radio.getMinVolume();
        assertEquals(0, radio.getMinVolume());

    }

    @Test
    public void plusVolume() {
        radio.setCurrentVolume(4);
        radio.pressPlusVolume();
        assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    public void minusVolume() {
        radio.setCurrentVolume(4);
        radio.pressMinusVolume();
        assertEquals(3, radio.getCurrentVolume());
    }

}
