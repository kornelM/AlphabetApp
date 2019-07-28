#WordsApp
Application created as a recruitment task.

It takes path to file with text and maps every letter to list of words which contain given letter.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

##Example

Sentence: `ala ma kota, kot koduje w Javie kota` will out to console
`
a: kota,ma,ala,javie  
d: koduje  
e: koduje,javie  
i: javie  
j: koduje,javie  
k: kot,koduje,kot  
l: ala  
m: ma  
o: kot,koduje,kota  
t: kot,kota  
u: koduje  
v: javie  
w: w
`

### Build 

To build an executable fat jar run command:

```
mvn clean compile assembly:single
```

### Run app

To run the application you need to have have to files: built jar and file with text to map

```
java -jar pathToYourJar.jar path/to/text/file/to/map.txt
```

## Running tests

```
mvn clean test
```

## Author

**Korneliusz Mikołajski** 

## License

This project is licensed under the MIT License.
