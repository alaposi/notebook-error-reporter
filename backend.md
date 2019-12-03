# Green Fox Notebook Error Reporter

Build a webapp that people can use to report technical issues.

## Highlights

- It has a frontend which can:

  - list all the tickets (reported errors) with details
  - save new error reports

## Main page

![main](assets/backend-form.png)

- the **frontend** should have

  - a heading with the title of the site (not displayed on the image above but you need to make it!)

  - form to register an error

    - drop-down list with all the reporter-name options
    - input field to set the manufacturer
    - input field to set the serial number (can contain numbers and letters)
    - input field to set the description
    - a REPORT button which sends the form data

## Backend

The backend should

- validate incoming data
- perform database calls

## Endpoints

- you should create these endpoints:

### GET `/`

This endpoint should render an HTML displaying the report form (explained above)

### GET `/list`

This endpoint should render an HTML displaying the full list of tickets
![list example](assets/backend-list.png)

### POST `/report`

This endpoint should

- receive all the information of the error
- supplement the issue with the actual date (You can provide day only or day with time. Feel free to define the format.)
- save the issue into database if the reporter's name is valid (reporter name is valid if it equals to any of the names listed on the main page - you shall define these names)
- if saved redirect to `/list`

### POST `/complete/{id}`

This endpoint should delete the specified ticket if the request's body contains
`"secret" : "voala"`

### GET `/list/query`

This endpoint should return all the tickets which has matching either
manufacturer or reporter

Example query:

`http://localhost:8080/list/query?manufacturer=dell`

- this should return a json with every ticket where the manufacturer is "dell"

```json
{
    "result": "ok",
    "tickets":
    [
        {
            "id" : "21",
            "reporter" : "Egg",
            "manufacturer" : "dell",
            "serialnumber" : 123456789,
            "description" : "screen pixel error",
            "date" : "2018.01.10"
        },
        {
            "id" : "27",
            "reporter" : "Szilvi",
            "manufacturer" : "dell",
            "serial number" : 987654321,
            "description" : "touchpad not working",
            "date" : "2018.01.17"
        }
    ]
}
```

`http://localhost:8080/list/query?reporter=Egg`

- this should return a json with every ticket where the reporter is "Egg"

## Question

Given the following table named `employees`

| id | name            | role         |
|:---|:----------------|:-------------|
| 0  | Bořivoj Souček  | mentor       |
| 1  | Kocsis Ivett    | psychologist |
| 2  | Papp Patrícia   | mentor       |
| 3  | Dagmar Benešová | psychologist |

And given the following table named `devices`

| id | name                  | serial_number | type   | employee_id |
|:---|:----------------------|:--------------|:-------|:------------|
| 0  | Bořivoj's iPhone      | 123-412-512   | mobile | 0           |
| 1  | Kocsis Ivett's device | 321-234-155   | laptop | 1           |
| 2  | Bořivoj's mobile      | 321-234-155   | mobile | 0           |

Write an SQL query to select the name of those psychologists who have got at
least one mobile phone in an alphabetical order.
