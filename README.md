# API Spec

## Create Product

Request :
* Method: POST
* Endpoint: /pos/product
* Header :
    - Content-Type: application/json
    - Accept: application/json
* Body
```json
{
  "name" : "string",
  "category" : "string",
  "price" : "long",
  "stock" : "integer"
}
```
* Response
```json
{
  "code" : "int",
  "message" : "string",
  "data" : {
    "id" : "string",
    "name" : "string",
    "category" : "string",
    "price" : "long",
    "stock" : "integer"
  }
}
```

## Get Product By ID

Request :
* Method: GET
* Endpoint: /pos/product/{id}
* Header :
  - Content-Type: application/json
  - Accept: application/json
* Response
```json
{
  "code" : "int",
  "message" : "string",
  "data" : {
    "id" : "string",
    "name" : "string",
    "category" : "string",
    "price" : "long",
    "stock" : "integer"
  }
}
```

## Get Product

Request :
* Method: GET
* Endpoint: /pos/product
* Header :
  - Accept: application/json
* Query Param:
  - size : number
  - page : number
* Response
```json
{
  "code" : "int",
  "message" : "string",
  "data" : [
    {
      "id" : "string",
      "name" : "string",
      "category" : "string",
      "price" : "long",
      "stock" : "integer"
    },
    {
      "id" : "string",
      "name" : "string",
      "category" : "string",
      "price" : "long",
      "stock" : "integer"
    }
  ]
}
```

## Update Product

Request :
* Method: PUT
* Endpoint: /pos/product/{id}
* Header :
  - Content-Type: application/json
  - Accept: application/json
* Body
```json
{
  "name" : "string",
  "category" : "string",
  "price" : "long",
  "stock" : "integer"
}
```
* Response
```json
{
  "code" : "int",
  "message" : "string",
  "data" : {
    "id" : "string",
    "name" : "string",
    "category" : "string",
    "price" : "long",
    "stock" : "integer"
  }
}
```

## Delete Product

Request :
* Method: DELETE
* Endpoint: /pos/product/{id}
* Header :
  - Accept: application/json
* Response
```json
{
  "code" : "int",
  "message" : "string"
}
```
