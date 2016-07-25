'''
Created on Jun 16, 2016

@author: mkankanala
'''
import sys
def fibonacci(n): #generator function
    a, b, counter = 0, 1, 0
    while True:
        if (counter > n): 
            return
        yield a
        a, b = b, a + b
        counter += 1
f = fibonacci(1000) #f is iterator object

while True:
   try:
      print (next(f), end=" ")
   except StopIteration:
      print("exiting")
      sys.exit()