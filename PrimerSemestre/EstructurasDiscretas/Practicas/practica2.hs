--Realizado por: José Ángel Olmedo Guevara


-- 1. Obtener la longitud de una lista
longitud :: [a] -> Int --De entrada algùn elemento de tipo 'a', cualquier tipo y devuelve un entero (la suma)
longitud [] = 0 --Caso base, si la lista es vacìa (Romperà la recursiòn)
longitud (_:xs) = 1 + longitud xs --Devuelve 1 + longitud de los demàs elementos de la lista

-- 2. Sumar todos los números de una lista
sumaLista :: Num a => [a] -> a --Restringe que 'a' sea un objeto de la clase Num (Int, Integer, Float, Double) y devolverà un objeto de tipo a (necesariamente de la clase Num)
sumaLista [] = 0 --Caso base
sumaLista (x:xs) = x + sumaLista xs --Suma el primer elemento de una lista màs la suma del resto de los elemento de la lista

-- 3. Agregar un elemento a una lista dependiendo de un booleano
agregaElemento :: [a] -> a -> Bool -> [a] --Recibe una lista de tipo 'a', un elemento de tipo 'a', el booleano y devuelve una lista de tipo 'a'
agregaElemento xs x True = x : xs --Recibe la lista, el elemento y si es true, lo agrega al inicio.
agregaElemento xs x False = xs ++ [x] --Recibe la lista, el elemento y si es false, lo agrega al final de la lsita

-- 4. Obtener el máximo de una lista
maximoLista :: (Ord a, Num a) => [a] -> a --Restringe que 'a' sea un objeto de la clase Num (un nùmero) y que debe poder compararse (Ord: < > => <=), recibe una lista de numeros y devuelve un nùmero
maximoLista [] = 0
maximoLista [x] = x --Caso Base: Hay un ùnico elemento en la lista
maximoLista (x:y:xs) =  --Hay dos o más elementos en una lista
    if x >= y 
        then maximoLista (x:xs)  -- Si x es mayor o igual, descartamos y
        else maximoLista (y:xs)  -- Si y es mayor, descartamos x

-- 5. Recuperar un elemento de una lista por su índice
recuperarElemento :: [a] -> Int -> a --Recibe una lista de tipo 'a' (cualquier tipo), un entero (el indice) y devuelve un elemento de tipo a
recuperarElemento [] _ = error "Lista vacía" --En dado caso que tengamos la lista vacía y cualquier índice, sin importar (por eso el guión bajo _) se lanzará un error que diga "Lista vacía"
recuperarElemento (x:xs) n = 
    if n < 0 then error "Índice no válido" 
    else if n == 0 then x
    else recuperarElemento xs (n - 1)

-- 6. Obtener los divisores de un número n
divisoresDeN :: Int -> [Int] --Recibe un entero y devuelve una lista de enteros
divisoresDeN n = [x | x <- [1..n], n `mod` x == 0] --Devolverá una lista de enteros de la forma [1..n] tal que el residuo de dividir el número de entrada entre los elementos enteros hasta el número de entrada sea 0


-- Función auxiliar para eliminar todas las apariciones de un elemento
eliminar :: Eq a => a -> [a] -> [a] --Recibe una lista de elementos de tipo 'a' que puedan compararse entre sí (==, /=), un elemento de tipo 'a' y devuelve otra lista de elementos de tipo 'a'
eliminar _ [] = [] --Caso Base si la lista es vacía devuelve el vacío
eliminar y (x:xs) --Elimina y de la lista tomando como base el primer elemento de la lista y la lista
  | x == y    = eliminar y xs -- Si el primer elemento es igual al elemento que queremos eliminar continua evaluando con el elemento.
  | otherwise = x : eliminar y xs --Caso contrario, concatena el primer elemento y aplicamos recursion.


-- 7. Convertir una lista a conjunto (eliminando duplicados)
conjuntoLista :: Eq a => [a] -> [a] --Recibe una lista de elementos de tipo 'a' que puedan compararse entre sí (==, /=) y devuelve otra lista de elementos de tipo 'a'
conjuntoLista [] = [] --Si la lista es vacía devuelve el vacío
conjuntoLista (x:xs) = x : conjuntoLista (eliminar x xs) --Concatenar primer parametro y eliminar los repetidos


-- 8. Obtener los números pares de una lista
soloPares :: [Int] -> [Int] --Recibe una lista de enteros y devuelve una lista de enteros
soloPares xs = [x | x <- xs, x `mod` 2 == 0] --Devuelve los elementos de la lista tal que su residuo al dividir entre 2 sea 0
