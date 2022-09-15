# RICK & MORTY - GRAPHQL API

## Stack
- Java 17
- Junit 5
- Spring Boot 2.7.3
- Gradle
- Makefile

## How to run it?
First of all, you'll need to:
- Install Java 17 ([Windows](https://www.oracle.com/java/technologies/downloads/#java17)|[Mac](https://formulae.brew.sh/formula/openjdk@17))
- Install [Gradle](https://gradle.org/install/)

Then, you can just use one of the Make commands on the root folder of the project
- ```make build``` to build the project
- ```make run``` to run it directly


## Playing around
Once running, you can access the GraphQL interface ([GraphiQL](https://github.com/graphql/graphiql)) at http://localhost:8080/graphiql and run your queries.

The API supports queries by full name:
```graphql
{
  findByName(name: "Rick Sanchez") {
    id
    name
    status
    species
    type
    gender
    origin {
      name
      url
    }
    location {
      name
      url
    }
    image
    episode
    url
    created
  }
}
```
Response:
```json
{
  "data": {
    "findByName": [
      {
        "id": 1,
        "name": "Rick Sanchez",
        "status": "Alive",
        "species": "Human",
        "type": "",
        "gender": "Male",
        "origin": {
          "name": "Earth (C-137)",
          "url": "https://rickandmortyapi.com/api/location/1"
        },
        "location": {
          "name": "Citadel of Ricks",
          "url": "https://rickandmortyapi.com/api/location/3"
        },
        "image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        "episode": [...],
        "url": "https://rickandmortyapi.com/api/character/1",
        "created": "2017-11-04T18:48:46.250Z"
      }
    ]
  }
}
```
Or by a single or family name:
```graphql
{
  findByName(name: "Smith") {
    id
    name
    status
    species
    type
    gender
    origin {
      name
      url
    }
    location {
      name
      url
    }
    image
    episode
    url
    created
  }
}
```
Response:
```json
{
  "data": {
    "findByName": [
      {
        "id": 2,
        "name": "Morty Smith",
        "status": "Alive",
        "species": "Human",
        "type": "",
        "gender": "Male",
        "origin": {
          "name": "unknown",
          "url": ""
        },
        "location": {
          "name": "Citadel of Ricks",
          "url": "https://rickandmortyapi.com/api/location/3"
        },
        "image": "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
        "episode": [...],
        "url": "https://rickandmortyapi.com/api/character/2",
        "created": "2017-11-04T18:50:21.651Z"
      },
      {
        "id": 3,
        "name": "Summer Smith",
        "status": "Alive",
        "species": "Human",
        "type": "",
        "gender": "Female",
        "origin": {
          "name": "Earth (Replacement Dimension)",
          "url": "https://rickandmortyapi.com/api/location/20"
        },
        "location": {
          "name": "Earth (Replacement Dimension)",
          "url": "https://rickandmortyapi.com/api/location/20"
        },
        "image": "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
        "episode": [...],
        "url": "https://rickandmortyapi.com/api/character/3",
        "created": "2017-11-04T19:09:56.428Z"
      },
      {...}
    ]
  }
}
```
## Conclusion
It's my first time working with GraphQL and I have to admit that I have quite fun doing it.
Thank you for the opportunity. I hope you enjoy my code!
If you have any questions, feel free to contact me under the email [danilopereirait@gmail.com](mailto:danilopereirait@gmail.com)
