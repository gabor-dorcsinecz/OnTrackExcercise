Any of these requests can result on Http 500 - Internal Server Error 

#Get all the addresses paginated
`curl -X GET -H "Content-Type: application/json" https://bla.bla/v1/addressbook?offset=200&size=100`

- 200 with payload

#Add a new element to the address book
`curl -X POST -H "Content-Type: application/json" -d '{...}' https://bla.bla/v1/addressbook/`

- 201 with payload containing the newly created id
- 400 or 422 for invalid json, the json body containing the list of problematic parts

#Get one address
`curl -X GET -H "Content-Type: application/json" https://bla.bla/v1/addressbook/{id}`

- 200 with payload containing the the address book entry
- 404 entry with the id given was not found

#Update an element
`curl -X PUT -H "Content-Type: application/json" -d '{...}' https://bla.bla/v1/addressbook/{id}`

- 204 update was successful 
- 400 or 422 for invalid json, the json body containing the list of problematic parts
- 404 entry with the id given was not found

#Delete an element
`curl -X DELETE -H "Content-Type: application/json" https://bla.bla/v1/addressbook/{id}`

- 204 delete was successful
- 404 entry with the id given was not found
