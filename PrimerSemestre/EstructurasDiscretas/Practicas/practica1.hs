distanciaPuntos::(Float,Float)->(Float, Float)->Float
distanciaPuntos (x1, y1) (x2, y2)=sqrt((x2-x1)^2+(y2-y1)^2)

valorAbsoluto::Int->Int
valorAbsoluto x=if x>=0
                   then x
                   else -x

pendiente::(Float,Float)->(Float,Float)->Float
pendiente (x1, y1) (x2, y2)=(y2-y1)/(x2-x1)

hipotenusa::Float->Float->Float
hipotenusa b h=sqrt(b^2+h^2)

raices::Float->Float->Float->(Float, Float)
raices a b c=((-b-sqrt((b^2)-(4*a*c)))/(2*a), (-b+sqrt((b^2)-(4*a*c)))/(2*a))

areaTriangulo::Float->Float->Float->Float
areaTriangulo a b c=sqrt(((a+b+c)/2)*(((a+b+c)/2)-a)*(((a+b+c)/2)-b)*(((a+b+c)/2)-c))

esBisiesto::Int->Bool
esBisiesto año =
    if año `mod` 400 == 0 then True
    else if año `mod` 100 == 0 then False
    else if año `mod` 4 == 0 then True
    else False

comparador::Int->Int->Int
comparador x y=
    if x==y then 0
    else if x<y then -1
    else 1

maximo::Int->Int->Int->Int
maximo x y z=
    if x>y && x>z then x
    else if y>x && y>z then y
    else if z>x && z>y then z
    else if x==y && z>x then z
    else if y==z && x>y then x
    else if x==y && x>z  then x
    else if y==z && y>x then y
    else x

esDescendente::Int->Int->Int->Int->Bool
esDescendente x y z w=
    if x>y && y>z && z>w then True
    else False
