package com.businessinsights.model.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DailyAdSpendTest {

    private DailyAdSpend dailyAdSpend;
    private Date date;

    @BeforeEach
    void setUp() throws ParseException {
        dailyAdSpend = new DailyAdSpend();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.parse("2023-01-01");
    }

    @Test
    void getDate() {
        dailyAdSpend.setDate(date);
        assertEquals(date, dailyAdSpend.getDate());
    }

    @Test
    void getAmountSpent() {
        dailyAdSpend.setAmountSpent(123.45f);
        assertEquals(123.45f, dailyAdSpend.getAmountSpent());
    }

    @Test
    void getPlatform() {
        dailyAdSpend.setPlatform("Facebook");
        assertEquals("Facebook", dailyAdSpend.getPlatform());
    }

    @Test
    void testToString() {
        dailyAdSpend.setDate(date);
        dailyAdSpend.setAmountSpent(123.45f);
        dailyAdSpend.setPlatform("Facebook");
        String expected = "DailyAdSpend{date=" + date + ", amountSpent=123.45, platform='Facebook'}";
        assertEquals(expected, dailyAdSpend.toString());
    }

    @Test
    void testEquals() {
        DailyAdSpend other = new DailyAdSpend();
        other.setDate(date);
        other.setAmountSpent(123.45f);
        other.setPlatform("Facebook");

        dailyAdSpend.setDate(date);
        dailyAdSpend.setAmountSpent(123.45f);
        dailyAdSpend.setPlatform("Facebook");

        assertEquals(other, dailyAdSpend);
    }

    @Test
    void testHashCode() {
        dailyAdSpend.setDate(date);
        dailyAdSpend.setAmountSpent(123.45f);
        dailyAdSpend.setPlatform("Facebook");

        DailyAdSpend other = new DailyAdSpend();
        other.setDate(date);
        other.setAmountSpent(123.45f);
        other.setPlatform("Facebook");

        assertEquals(other.hashCode(), dailyAdSpend.hashCode());
    }

    @Test
    void validate() {
        dailyAdSpend.setDate(date);
        dailyAdSpend.setAmountSpent(123.45f);
        dailyAdSpend.setPlatform("Facebook");

        assertDoesNotThrow(() -> dailyAdSpend.validate());
    }

    @Test
    void validateWithInvalidAmount() {
        dailyAdSpend.setDate(date);
        dailyAdSpend.setAmountSpent(-123.45f);
        dailyAdSpend.setPlatform("Facebook");

        assertThrows(IllegalStateException.class, () -> dailyAdSpend.validate());
    }

    @Test
    void validateWithNullDate() {
        dailyAdSpend.setAmountSpent(123.45f);
        dailyAdSpend.setPlatform("Facebook");

        assertThrows(IllegalStateException.class, () -> dailyAdSpend.validate());
    }

    @Test
    void validateWithEmptyPlatform() {
        dailyAdSpend.setDate(date);
        dailyAdSpend.setAmountSpent(123.45f);
        dailyAdSpend.setPlatform("");

        assertThrows(IllegalStateException.class, () -> dailyAdSpend.validate());
    }
}
