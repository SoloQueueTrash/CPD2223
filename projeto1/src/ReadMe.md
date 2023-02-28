# Para compilar e correr o programa de c++
```
g++ -O2 matrix.cpp -o fileout -lpapi
./fileout < input_cpp.txt
``` 
## Nota: 
Se der erro no papi fazer
``` 
sudo sh -c 'echo -1 >/proc/sys/kernel/perf_event_paranoid'
```

# Para compilar e correr o programa de java
```
javac matrix.java && java matrix < input_java.txt
```