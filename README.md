# sprintform-hw-backend
This project is a backend of a financial transaction tracking application.

## Prerequisites

Tools that are required to build and run the application:
* JDK-17 (Preferably Temurin OpenJDK 17)
* Apache Maven (3.8.1)

## Build and run

To build the application please perform the following command: 

`mvn clean install`

To run the application please perform the following steps: 

Navigate to the target directory:

`cd target`

Execute the runnable jar:

`java -jar sprintform-hw-backend-1.0-SNAPSHOT.jar`

## API documentation

### Constants

When transaction category is used, the following values are required:
HOUSING,
TRAVEL,
FOOD,
UTILITIES,
INSURANCE,
HEALTHCARE,
FINANCIAL,
LIFESTYLE,
ENTERTAINMENT,
MISCELLANEOUS

### Create Transaction

`POST /transaction`

RequestBody

```json
{
    "summary": "albérlet + rezsi",
    "category": "HOUSING",
    "sum": 175000,
    "currency": "HUF",
    "paidAt": "2023-11-04T10:15:30+01:00"
}
```

ResponseBody
```json
{
    "id": "1554f95d-7e7b-4bde-8615-09d5a3bb9583",
    "createdAt": "2023-11-05T16:23:19.8965822",
    "summary": "albérlet + rezsi",
    "category": "HOUSING",
    "sum": 175000,
    "currency": "HUF",
    "paidAt": "2023-11-04T09:15:30Z"
}
```

### Read Transaction

`GET /transaction/{id}`

ResponseBody
```json
{
    "id": "1554f95d-7e7b-4bde-8615-09d5a3bb9583",
    "createdAt": "2023-11-05T16:23:19.8965822",
    "summary": "albérlet + rezsi",
    "category": "HOUSING",
    "sum": 175000,
    "currency": "HUF",
    "paidAt": "2023-11-04T09:15:30Z"
}
```

ResponseBody (non-existing Transaction)

```json
{
    "code": 1001,
    "description": "ENTITY_NOT_FOUND"
}
```

### Update Transaction

`PUT /transaction`

RequestBody

```json
{
    "id": "1554f95d-7e7b-4bde-8615-09d5a3bb9583",
    "summary": "albérlet + rezsi",
    "category": "HOUSING",
    "sum": 185000,
    "currency": "HUF",
    "paidAt": "2023-11-04T09:15:30Z"
}
```

ResponseBody
```json
{
    "id": "1554f95d-7e7b-4bde-8615-09d5a3bb9583",
    "createdAt": "2023-11-05T16:23:19.896582",
    "summary": "albérlet + rezsi",
    "category": "HOUSING",
    "sum": 185000,
    "currency": "HUF",
    "paidAt": "2023-11-04T09:15:30Z"
}
```
ResponseBody (non-existing Transaction)

```json
{
    "code": 1001,
    "description": "ENTITY_NOT_FOUND"
}
```
### Delete Transaction

`DELETE /transaction/{id}`

The result is always 200 OK even if the entity did not exist before.

### List Transactions

`GET /transaction`

Request parameters:
* Pagination and sorting (size, page, sort, etc.)
* summaryFilter
* categoryFilter
* sumFrom
* sumTo
* currencyFilter
* paidAtFrom
* paidAtTo

ResponseBody
```json
{
    "content": [
        {
            "id": "6e6e0465-30ad-4758-a3a6-6163bd60ea0d",
            "summary": "albérlet",
            "category": "TRAVEL",
            "sum": 7000,
            "currency": "HUF",
            "paidAt": "2011-12-03T09:15:30Z"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 1,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalPages": 11,
    "totalElements": 11,
    "size": 1,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}
```

### Transaction statistics

Returns aggregated statistics by transaction category.

`GET /transaction/statistics`

Request parameters:
* category: filter by category

ResponseBody
```json
[
    {
        "category": "HOUSING",
        "sum": 720000,
        "count": 4
    },
    {
        "category": "TRAVEL",
        "sum": 51000,
        "count": 6
    }
]
```

### Transaction forecast

Returns a forecast based on the last given months.

`GET /transaction/forecast/{months}`

Request parameters:
* months: the last number of months to calculate the averga spending from

ResponseBody
```json
{
    "forecastSum": 85222.22222222222
}
```
