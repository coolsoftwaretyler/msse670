# Tyler Williams MSSE 670 Fall 2023

This is the class project for MSSE 670 in Fall 2023 term for Tyler Williams.

## Week 1

You can find my design document for week 1 at https://regis365-my.sharepoint.com/:w:/g/personal/twilliams019_regis_edu/EdJSpQYjEr5MohG7rSHW5uQB7_ZHgbrR_M31G3khrSivnw?e=KlQERY. It was also uploaded to WorldClass.

It's also available at the root of the repository at `./weekly-assignment-docs/williams-tyler-Week1.docx`.

## Week 2

You can find my design document for week 2 at https://regis365-my.sharepoint.com/:w:/g/personal/twilliams019_regis_edu/Ef0ut9B7VQRFgBQ09lZ6PzIBxQRSIgl6UXoN5J5ptOm1sA?e=pSshkt. I also uploaded it to WorldClass.

Available at the root of the repository at `./weekly-assignment-docs/williams-tyler-Week2.docx`

## Week 3

You can find my design document for week 3 at https://regis365-my.sharepoint.com/:w:/g/personal/twilliams019_regis_edu/Ee3kSjwquRxLg8okN-J3I_gBh47pMjl_Hd7bDzRXJJyU9Q?e=R0Oge6. It was also uploaded to WorldClass.

It's also available at the root of the repository at `./weekly-assignment-docs/williams-tyler-Week3.docx`

## Week 4

In week 4:

1. I had already implemented three services, so I did not add new ones for this week.
2. I already had exceptions implemented in my services, so I did not add any new ones there, but I did add a custom exception to the factory.
3. One of my test files already handled exceptions, so I updated the other two to do so as well.
4. Implemented the Serializable interface in my domain classes.
5. Added an `IService` marker interface and extended it with existing service interfaces.
6. Implemented the decoupled ServiceFactory as instructed
7. Added `config/application.properties` file

You can find my design document for week 4 at `./weekly-assignment-docs/williams-tyler-Week4.docx`. It's also been uploaded to WorldClass.

## Week 5

In week 5:

1. I started with the RunApp class to create a reasonable program execution flow that would inform the rest of my changes.
2. Then I added a `ManagerSuperType` and an `InsightsManager` to handle the required command strings: `GENERATE_REPORT` and `LIST_REPORTS`
3. Then I updated the `ReportService` interface and implementation to handle those methods, coordinating with the `Composite` model.
4. Up next, I added methods to the `Composite` model that would allow it to collaborate with the `ReportService` as necessary.
5. Then I made sure to configure the `ManagerSuperType` to work with the property file location.
6. Finally, I updated the code to pass values around correctly.
   
You can find my design document with screenshots for week 5 at `./weekly-assignment-docs/williams-tyler-Week5.docx`. It's also been uploaded to WorldClass.
