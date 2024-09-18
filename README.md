¿En qué consiste Los Recorridos del caballo de ajedrez? 
Dado un tablero de ajedrez y una casilla inicial, queremos decidir si es posible que 
un caballo recorra todos y cada uno de los escaques sin duplicar ninguno. No es 
necesario en este problema que el caballo vuelva al escaque de partida.  

Siguiendo la solución de Euler, un posible algoritmo ávido podrá decidir, en cada 
iteración, siempre y cuando colocáramos el caballo en la casilla en la cual domina 
la menor cantidad posible de casillas que aún no visitadas. 
