package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}

/*
 * 
 * 
 * Offset Pagination - Trigger COUNT(*) OVER And Return Page<dto>

Description: Typically, in offset pagination, there is one query needed for fetching the data and one for counting the total number of records. But, we can fetch this information in a single database rountrip via a SELECT COUNT subquery nested in the main SELECT. Even better, for databases vendors that support Window Functions there is a solution relying on COUNT(*) OVER() as in this application that uses this window function in a native query against MySQL 8. So, prefer this one instead of SELECT COUNT subquery. This application return a Page<dto>.

Key points:

create a Spring projection (DTO) to contains getters only for the columns that should be fetched
write a repository that extends PagingAndSortingRepository
fetch data via a native query (that includes counting) into a List<dto>
use the fetched List<dto> and Pageable to create a Page<dto>
Example:
*/