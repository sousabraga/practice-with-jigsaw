# practice-with-jigsaw
Practice with new Java modular architecture (Jigsaw) and some new APIs (based on the book [Java 9 Interativo, reativo e modularizado](https://www.casadocodigo.com.br/products/livro-java9))

### Commands to compile modules

```shell
javac -d mods/br.com.casadocodigo.domain --module-path mods src/br.com.casadocodigo.domain/module-info.java $(find src/br.com.casadocodigo.domain -name "*.java")

javac -d mods/br.com.casadocodigo.http --module-path mods src/br.com.casadocodigo.http/module-info.java	$(find src/br.com.casadocodigo.http -name "*.java")

javac -d mods/br.com.casadocodigo.nf --module-path mods src/br.com.casadocodigo.nf/module-info.java $(find src/br.com.casadocodigo.nf -name "*.java")

javac -d mods/br.com.casadocodigo --module-path	mods src/br.com.casadocodigo/module-info.java $(find src/br.com.casadocodigo -name "*.java")    
```

### Command to execute after compile
```shell
java --module-path mods -m br.com.casadocodigo/br.com.casadocodigo.Main
```

### Creating a image

- Creating a image setting modules manually 
```shell
jlink --module-path $JAVA_HOME/jmods --add-modules java.base,java.net.http --output JRE-bookstore
```

- Creating a image setting modules through the project (**this mode is better because we don't need to enter the modules one by one manually**) 
```shell
jlink --module-path $JAVA_HOME/jmods:mods --add-modules br.com.casadocodigo --output JRE-bookstore
```

### Command to see list of modules from image
```shell
JRE-bookstore/bin/java --list-modules
```

### Execute project from image
```shell
JRE-bookstore/bin/java --module-path mods -m br.com.casadocodigo/br.com.casadocodigo.Main
```
or (**without module path information**)
```shell
JRE-bookstore/bin/java -m br.com.casadocodigo/br.com.casadocodigo.Main
```

