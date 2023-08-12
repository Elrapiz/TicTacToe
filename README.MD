# CONSOLE TICTACTOE using **JAVA**
This project is intended for practicing java OOP.  
This project also doesn't use any build tools *(because I don't know how, without using IDE)*. This project will run on normal (manual) compilation.
> java version: 17.0.7 2023-04-18 LTS
## How to **RUN**  
* compile using `javac -d build src/main/*.java`
* run using `java -classpath build main.Tictactoe`

## Generating jar file
* make sure to include the `manifest.mf` of this repo
* place `manifest.mf` to the project root directory
* create a `dist` folder
* compile source code with `javac -d build src/main/*.java`
* create jar using `jar cvfm dist/tictactoe.jar manifest.mf -C build .`
* run using `java -jar dist/tictactoe.jar`