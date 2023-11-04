package com.businessinsights.model.services.dailyadspendservice;

import com.businessinsights.model.domain.DailyAdSpend;

import java.util.Date;
import java.util.List;

/**
 * Interface for the service that manages DailyAdSpend CRUD operations.
 */
public interface IDailyAdSpendService {

    /**
     * Creates a new DailyAdSpend record in a database.
     *
     * @param dailyAdSpend the DailyAdSpend object to be created
     * @return the created DailyAdSpend object
     */
    DailyAdSpend createDailyAdSpend(DailyAdSpend dailyAdSpend);

    /**
     * Retrieves a DailyAdSpend record from the database by its date. There will
     * only be one record per date, so a date should be sufficient.
     *
     * @param date the date of the DailyAdSpend record
     * @return the DailyAdSpend object, or null if not found
     */
    DailyAdSpend getDailyAdSpendByDate(Date date);

    /**
     * Updates an existing DailyAdSpend record.
     *
     * @param dailyAdSpend the DailyAdSpend object to be updated
     * @return the updated DailyAdSpend object
     */
    DailyAdSpend updateDailyAdSpend(DailyAdSpend dailyAdSpend);

    /**
     * Deletes a DailyAdSpend record by its date.
     *
     * @param date the date of the DailyAdSpend record to be deleted
     * @return true if the deletion was successful, false otherwise
     */
    boolean deleteDailyAdSpend(Date date);

    /**
     * Retrieves all DailyAdSpend records.
     *
     * @return a list of all DailyAdSpend objects
     */
    List<DailyAdSpend> getAllDailyAdSpends();
}
