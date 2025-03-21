# Animals API

## API Endpoints

Base URL: ['http://localhost:8080/animals'](http://localhost:8080/animals)

### ['/all'] (http://localhost:8080/animals/all) (GET)
Get a list of all animals in the database

#### Response:
```
[
  {
    "animalId": 1,
    "name": "tiger",
    "description": "a tiger is a predator",
    "diet": "carnivore"
  },
  {
    "animalId": 2,
    "name": "horse",
    "description": "a horse is a prey",
    "diet": "herbivore"
  }
]
```

### ['/{animalId}'] (http://localhost:8080/animals/1) (GET)
Get an animal by its ID. Each animal has a number represented by animalId.

#### Parameters
- Path Variable: animalID %lt; integer&gt; - REQUIRED

#### Response:
```
{
  "animalId": 1,
  "name": "tiger",
  "description": "a tiger is a predator",
  "diet": "carnivore"
}
```

### ['/new'] (http:localhost:8080/animals/new (POST)
Add a new animal

#### Request Body
```
{
  "name": "shark",
  "description": "a shark is a predator",
  "diet": "carnivore"
}
```

#### Response:
```
[
  {
    "animalId": 1,
    "name": "tiger",
    "description": "a tiger is a predator",
    "diet": "carnivore"
  },
  {
    "animalId": 2,
    "name": "horse",
    "description": "a horse is a prey",
    "diet": "herbivore"
  },
  {
    "animalId": 3,
    "name": "shark",
    "description": "a shark is a predator",
    "diet": "carnivore"
  }
]
```

### ['/update/{animalId}'] (http://localhost:8080/animals/update/1) (PUT)
Update an existing animal.

#### Parameters
- Path Variable: 'animalId' &lt; integer&gt; - REQUIRED

#### Request Body
```
{
    "name": "tiger",
    "description": " the tiger is the largest wild cat in the world",
    "diet": "carnivore"
}
```

#### Response:
```
{
  "animalId": 1,
  "name": "tiger",
  "description": "the tiger is the largest wild cat in the world",
  "diet": "carnivore"
}
```

### ['/delete/{animalId}'] (http://localhost:8080/animals/delete/1) (DELETE)
Delete an existing animal.

#### Parameters
- Path Variable: 'animalId' &lt; integer&gt; - REQUIRED

#### Response:
```
[
  {
    "animalId": 2,
    "name": "horse",
    "description": "a horse is a prey",
    "diet": "herbivore"
  },
  {
    "animalId": 3,
    "name": "shark",
    "description": "a shark is a predator",
    "diet": "carnivore"
  }
]
```

### ['/diet/{diet}'] (http://localhost:8080/animals/diet/carnivore) (GET)
Get all animals by their diet

#### Parameters
- Path Variable: 'diet' &lt; String&gt; - REQUIRED

#### Response:
```
[
  {
    "animalId": 1,
    "name": "tiger",
    "description": "a tiger is a predator",
    "diet": "carnivore"
  },
  {
    "animalId": 3,
    "name": "shark",
    "description": "a shark is a predator",
    "diet": "carnivore"
  }
]
```

### ['/name'] (http://localhost:8080/animals/name?search=tig) (GET)
Get animals whose name contains a string;

#### Parameters
- Query Parameter: 'search' &lt; String&gt; - REQUIRED

#### Response:
```
{
  "animalId": 1,
  "name": "tiger",
  "description": "a tiger is a predator",
  "diet": "carnivore"
}
```

