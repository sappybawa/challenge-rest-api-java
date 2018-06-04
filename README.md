# REST API Challenge

We would like you to implement a simple application which works with 3
REST APIs.

Suppose the user object only has three properties: id, name and role.

The first API allows the client to query a specific set of user objects by property
where the request may look like this.

```
GET /users/?role=foo
```
The response should look like this.

```JSON
[
  {
    "id": "977e3f5b-6a70-4862-9ff8-96af4477272a",
    "name": "java beans",
    "role": "foo"
  }
]
```
The second API allows the client to create a user object with a request like this.

```
POST /users/
```
```JSON
{
  "name": "cookie bars",
  "role": "bar"
}
```

The third API allows the client to retrieve a user object given its ID

```
GET /users/977e3f5b-6a70-4862-9ff8-96af4477272a
```
```JSON
{
  "name": "java beans",
  "role": "foo"
}
```
 - This is an open-end code challenge. We would love to see your approach to
the problem.
 - The code maintainability is important.
 - Everything would run from Docker containers.
 - BONUS: Any log message must be non-blocking.
 - BONUS: Logs would be stored in a non-relational database.
 - BONUS: Usage of circuit-breakers.
 - BONUS: Usage of search engines

## Submission
Send a PR to this repo once you're done.