package com.businessinsights.model.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportTest {

    private Report report;

    @Before
    public void setUp() {
        report = new Report();
    }

    @Test
    public void testSettingAndGetters() {
        report.setTitle("Report Title");
        report.setDescription("This is a description");
        report.setReportType("Type1");
        report.setStartDate(new Date());
        report.setEndDate(new Date());

        assertEquals("Report Title", report.getTitle());
        assertEquals("This is a description", report.getDescription());
        assertEquals("Type1", report.getReportType());
        assertNotNull(report.getStartDate());
        assertNotNull(report.getEndDate());
    }

    @Test
    public void testToString() {
        report.setTitle("Report Title");
        String result = report.toString();
        assertTrue(result.contains("Report Title"));
    }

    @Test
    public void testEqualsAndHashCode() {
        Report report1 = new Report();
        Report report2 = new Report();

        report1.setTitle("Report Title");
        report2.setTitle("Report Title");

        assertTrue(report1.equals(report2) && report2.equals(report1));
        assertTrue(report1.hashCode() == report2.hashCode());
    }

    @Test
    public void testValidateMethodHappyPath() {
        try {
            report.setTitle("Report Title");
            report.setDescription("This is a description");
            report.setReportType("Type1");
            report.setStartDate(new Date());
            report.setEndDate(new Date());

            report.validate();
        } catch (IllegalStateException e) {
            fail("Validation failed for a valid report");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testValidateMethodNoTitle() {
        report.setDescription("This is a description");
        report.setReportType("Type1");
        report.setStartDate(new Date());
        report.setEndDate(new Date());

        report.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testValidateMethodNoDescription() {
        report.setTitle("Report Title");
        report.setReportType("Type1");
        report.setStartDate(new Date());
        report.setEndDate(new Date());

        report.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testValidateMethodNoReportType() {
        report.setTitle("Report Title");
        report.setDescription("This is a description");
        report.setStartDate(new Date());
        report.setEndDate(new Date());

        report.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testValidateMethodNoStartDate() {
        report.setTitle("Report Title");
        report.setDescription("This is a description");
        report.setReportType("Type1");
        report.setEndDate(new Date());

        report.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testValidateMethodNoEndDate() {
        report.setTitle("Report Title");
        report.setDescription("This is a description");
        report.setReportType("Type1");
        report.setStartDate(new Date());

        report.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testValidateMethodEndDateBeforeStartDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2023-10-30");
        Date endDate = sdf.parse("2023-10-29");

        report.setTitle("Report Title");
        report.setDescription("This is a description");
        report.setReportType("Type1");
        report.setStartDate(startDate);
        report.setEndDate(endDate);

        report.validate();
    }
}
