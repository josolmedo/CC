factorial::Int->Int
factorial 1=1
factorial n=n*factorial(n-1)

fibonacci::Int->Int
fibonacci 0=0
fibonacci 1=1
fibonacci n=fibonacci(n-1) + fibonacci(n-2)

-- listaCualquierTipo::[a]->[a] --Admite cualquier parametro

longitud::[Int]->Int
longitud []=0
longitud (x:xs) = 1+ longitud xs {-La x signfica que es un elemento mas pequeño que xs, xs es una lista obligatoriamente -> x:xs -> [1,2,3] ->1:(2:(3:[]))-}