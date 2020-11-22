
#### Account Servisi (Account Yaratma)
```
 http://localhost:8501/account

{
	"username" : "irkan",
    "name" : "Irkan",
    "surname" : "AHMADOV",
    "email" : "irkan.ahmadov@gmail.com",
    "birthDate" : "1989-01-01"
}
```

#### Ticket Servisi (Ticket Yaratma)

```
 http://localhost:8502/ticket

{
	"description" : "Test Ticket 1",
    "notes" : "Test Ticket 1 - Docker Compose Xetasi",
    "assignee" : "irkan",
    "priorityType" : "URGENT",
    "ticketStatus" : "OPEN",
    "ticketDate" : "1999-01-01"
}
```