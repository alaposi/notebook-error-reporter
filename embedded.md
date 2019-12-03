# Embedded

## Keep in mind

The C exercises have to make sure about the followings:

- Compiles
- Does not have any undefined behaviour
- You don't use more memory than necessary
- Deallocates the memory when it's no longer used
- Does not crash

The embedded exercises have to make sure about the followings:

- Compiles
- Does not have any undefined behaviour
- Does not crash

## Get closest

Create a function called `get_closest` which takes an array of numbers as a parameter and returns the number which value is the closest to the average of the numbers in the array. 

### Example:

#### Input 1

```cpp
[1, 2, 3, 4, 7, 8]

```

#### Output 1

```cpp
4

```

#### Input 2

```cpp
[4, 44, 85, 555]

```

#### Output 2

```cpp
85
```

*If there are 2 numbers with the same difference from the average, it's ok to return just one of them.* 

## Pokemon

Create a simple pokemon register, you should store the following data in structure called `pokemon`:

- the name of the pokemon, 
- the age of the pokemon,
- the strength of the pokemon (between 0.0-10.0),
- the speed of the pokemon (between 0.0-10.0),
- the type of the pokemon (as a custom type, see below).

You should store the weight in an enum called `size`, the valid values are:
- normal
- fire
- water
- electric
- grass
- ice
- fighting
- poision
- ground
- flying
- psychic
- bug
- rock
- ghost
- dragon
- dark
- steel
- fairy

Store the registered pokemons in an array.

Implement a function called `get_faster_than` which takes the pokemon array and a speed as a parameter and returns the count of the faster pokemons than the parameter "speed".

### Example:

We are calling the `get_faster_than` function with  `6.5` as a valid speed.

#### Input 1

```cpp
example_pokemon_struct pokemons[] = {
   {"A", 12, 9.0, 8.0, NORMAL},
   {"B", 12, 5.0, 9.0, NORMAL},
   {"C", 12, 4.0, 7.0, WATER},
   {"D", 12, 3.5, 6.0, WATER}};
};
```  

#### Output 1

```cpp
3
```

Implement a function called `get_strongest_type` which takes the pokemon array as a parameter and returns the type of the strongest pokemon.

### Example:

#### Input 1

```cpp
example_pokemon_struct pokemons[] = {
   {"A", 12, 9.0, 8.0, NORMAL},
   {"B", 12, 5.0, 9.0, NORMAL},
   {"C", 12, 4.0, 7.0, WATER},
   {"D", 12, 3.5, 6.0, WATER}};
};
```  

#### Output 1

```cpp
NORMAL
```

Implement a function called `get_strongest_by_type` which takes the pokemon array and a valid type as a parameter and returns the highest strength among the "type" type pokemons

### Example:

#### Input 1

We are calling the `get_strongest_by_type` function with  `NORMAL` as a valid type.

```cpp
example_pokemon_struct pokemons[] = {
   {"A", 12, 9.0, 8.0, NORMAL},
   {"B", 12, 5.0, 9.0, NORMAL},
   {"C", 12, 4.0, 7.0, WATER},
   {"D", 12, 3.5, 6.0, WATER}};
};
```  

#### Output 1

```cpp
9.0
```

#### Input 1

We are calling the `get_strongest_by_type` function with  `WATER` as a valid type.

```cpp
example_pokemon_struct pokemons[] = {
   {"A", 12, 9.0, 8.0, NORMAL},
   {"B", 12, 5.0, 9.0, NORMAL},
   {"C", 12, 4.0, 7.0, WATER},
   {"D", 12, 3.5, 6.0, WATER}};
};
```  

#### Output 1

```cpp
4.0
```

## Send message

Your task is to write an application for ATMega168PB Xplained-Mini, which sends "Button Pressed!" string through UART to a computer. The UART peripheral must use 115200 baud rate, with 8bit, no parity bit and 1 stopbit setting. There is a button on the dev board, use that button. Using interrupts instead of polling if a plus but not necessary.

## Question 

### What is the difference between polling and using interrupts?

*type your answer here (please explain with your own words)*


### What is the difference between `switch-case` and `if-else`? 

*type your answer here (please explain with your own words)*



