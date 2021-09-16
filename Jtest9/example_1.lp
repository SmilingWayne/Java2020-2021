\ENCODING=ISO-8859-1
\Problem name: ilog.cplex

Maximize
 obj: x0 + 2 x1 + 3 x2
Subject To
 c1: - x0 + x1 + x2 <= 20
 c2: x0 - 3 x1 + x2 <= 30
Bounds
 0 <= x0 <= 40
 0 <= x1 <= 2147483647
      x2 >= 0
Generals
 x2 
End
