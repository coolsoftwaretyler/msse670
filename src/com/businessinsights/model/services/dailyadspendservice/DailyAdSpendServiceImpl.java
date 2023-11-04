package com.businessinsights.model.services.dailyadspendservice;

import com.businessinsights.model.domain.DailyAdSpend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class DailyAdSpendServiceImpl implements IDailyAdSpendService {

    private final List<DailyAdSpend> dailyAdSpends = new ArrayList<>(); // Temporary in-memory list

    @Override
    public DailyAdSpend createDailyAdSpend(DailyAdSpend dailyAdSpend) {
        try {
            System.out.println("Creating a new DailyAdSpend record in the database");
            if (dailyAdSpend == null) {
                throw new IllegalArgumentException("DailyAdSpend object cannot be null");
            }
            dailyAdSpend.validate(); // Ensure the DailyAdSpend is valid before adding
            dailyAdSpends.add(dailyAdSpend);
            return dailyAdSpend;
        } catch (Exception e) {
            // Log error and/or notify the caller that operation has failed
            System.out.println("Failed to create DailyAdSpend: " + e.getMessage());
            return null;
        }
    }

    @Override
    public DailyAdSpend getDailyAdSpendByDate(Date date) {
        try {
            System.out.println("Retrieving a DailyAdSpend record by date from the database");
            if (date == null) {
                throw new IllegalArgumentException("Date cannot be null");
            }
            return dailyAdSpends.stream()
                    .filter(d -> date.equals(d.getDate()))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("Failed to retrieve DailyAdSpend: " + e.getMessage());
            return null;
        }
    }

    @Override
    public DailyAdSpend updateDailyAdSpend(DailyAdSpend dailyAdSpend) {
        try {
            System.out.println("Updating an existing DailyAdSpend record in the database");
            if (dailyAdSpend == null) {
                throw new IllegalArgumentException("DailyAdSpend object cannot be null");
            }
            dailyAdSpend.validate();

            Optional<DailyAdSpend> existingAdSpend = dailyAdSpends.stream()
                    .filter(d -> d.getDate().equals(dailyAdSpend.getDate()))
                    .findFirst();

            if (existingAdSpend.isPresent()) {
                DailyAdSpend toUpdate = existingAdSpend.get();
                toUpdate.setPlatform(dailyAdSpend.getPlatform());
                toUpdate.setAmountSpent(dailyAdSpend.getAmountSpent());
                System.out.println("DailyAdSpend record updated for date: " + toUpdate.getDate());
                return toUpdate;
            } else {
                System.out.println("No DailyAdSpend record found for date: " + dailyAdSpend.getDate());
                return null;
            }
        } catch (Exception e) {
            System.out.println("Failed to update DailyAdSpend: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteDailyAdSpend(Date date) {
        try {
            System.out.println("Deleting a DailyAdSpend record by date from the database");
            if (date == null) {
                throw new IllegalArgumentException("Date cannot be null");
            }
            return dailyAdSpends.removeIf(d -> date.equals(d.getDate()));
        } catch (Exception e) {
            System.out.println("Failed to delete DailyAdSpend: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<DailyAdSpend> getAllDailyAdSpends() {
        try {
            System.out.println("Retrieving all DailyAdSpend records from the database");
            return new ArrayList<>(dailyAdSpends);
        } catch (Exception e) {
            System.out.println("Failed to retrieve all DailyAdSpends: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
