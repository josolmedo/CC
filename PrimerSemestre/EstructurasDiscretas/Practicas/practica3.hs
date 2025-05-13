data Arbol a = ArbolVacio | Raiz a (Arbol a) (Arbol a) deriving Show

-------------------- EJERCICIO 1 --------------------
longitud :: Arbol a -> Int 
longitud ArbolVacio = 0
longitud (Raiz _ izq der) = 1 + longitud izq + longitud der

-------------------- EJERCICIO 2 --------------------
profundidad :: Arbol a -> Int 
profundidad ArbolVacio = 0
profundidad (Raiz _ izq der) = 1 + max (profundidad izq) (profundidad der)

-------------------- EJERCICIO 3 --------------------
ancho :: Arbol a -> Int 
ancho ArbolVacio = 0
ancho (Raiz _ ArbolVacio ArbolVacio) = 1
ancho (Raiz _ izq der) = ancho izq + ancho der

-------------------- EJERCICIO 4 --------------------
data Recorrido = InOrder | PreOrder | PosOrder

recorrido :: Arbol a -> Recorrido -> [a]
recorrido ArbolVacio _ = []
recorrido (Raiz x izq der) InOrder = recorrido izq InOrder ++ [x] ++ recorrido der InOrder
recorrido (Raiz x izq der) PreOrder = [x] ++ recorrido izq PreOrder ++ recorrido der PreOrder
recorrido (Raiz x izq der) PosOrder = recorrido izq PosOrder ++ recorrido der PosOrder ++ [x]

-------------------- EJERCICIO 5 --------------------
niveles :: Arbol a -> [[a]]
niveles arbol = nivelesAux [arbol]
  where
    nivelesAux [] = []
    nivelesAux xs = [ [x | Raiz x _ _ <- xs] ] ++ nivelesAux (concat [ hijos n | n <- xs ])
    hijos (Raiz _ i d) = filter noVacio [i, d]
    hijos ArbolVacio = []
    noVacio ArbolVacio = False
    noVacio _ = True

-------------------- EJERCICIO 6 --------------------
minimo :: Arbol a -> a 
minimo (Raiz x ArbolVacio _) = x
minimo (Raiz _ izq _) = minimo izq
minimo ArbolVacio = error "Árbol vacío"

-------------------- EJERCICIO 7 --------------------
maximo :: Arbol a -> a 
maximo (Raiz x _ ArbolVacio) = x
maximo (Raiz _ _ der) = maximo der
maximo ArbolVacio = error "Árbol vacío"

-------------------- EJERCICIO 8 --------------------
eliminar :: Ord a => Arbol a -> a -> Arbol a 
eliminar ArbolVacio _ = ArbolVacio
eliminar (Raiz x izq der) n
  | n < x = Raiz x (eliminar izq n) der
  | n > x = Raiz x izq (eliminar der n)
  | otherwise = eliminarRaiz (Raiz x izq der)
  where
    eliminarRaiz (Raiz _ ArbolVacio der) = der
    eliminarRaiz (Raiz _ izq ArbolVacio) = izq
    eliminarRaiz (Raiz _ izq der) =
      let minDer = minimo der
      in Raiz minDer izq (eliminar der minDer)






