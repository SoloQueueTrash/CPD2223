import matplotlib.pyplot as plt
from numpy import double, longlong
import numpy as np
import csv

cpp_file = open('data_cpp.csv')

with cpp_file:
    cpp_lst = list(csv.reader(cpp_file))

for i in range(len(cpp_lst)):
    print(cpp_lst[i])

java_file = open('data_java.csv')

with java_file:
    java_lst = list(csv.reader(java_file))

java_file.close()
cpp_file.close()