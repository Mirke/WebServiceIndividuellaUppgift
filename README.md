# Web Service - Individuella Uppgift

## Mission 

https://hackmd.io/@me223fn/HJ5rMFzsi

## Kanban Board (Not open because of paywall)

https://trello.com/b/yqR94JpZ/web-service-individuella-uppgift


## Docker Command for Keycloak

docker run -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_ADMIN_PASSWORD=password quay.io/keycloak/keycloak start-dev

SETUP Realm -> Client -> Add Roles -> Admin and User -> Their password -> Admin and User Client Roles 

## Postman Commands

POST /api/newpost

json

``{
"content": "This is some new content!",
"blog_user": 3
}``

PUT /api/updatepost/5

json

``{
"content": "Alright alright NOW THIS is new content!"
}``

POST /api/newuser

json

``{
"firstName": "Angelaaaaaaaaa",
"lastName": "Rubenson",
"email": "angela@emailmail.com",
"phone": "0777777771",
"memberTypes": "enhanced",
"address": {
"id": 2,
"street": "Legends Street 8",
"postalCode": "22222",
"city": "New York",
"country": "USA"
}
}``

### Author
Av: Mikael Eriksson
