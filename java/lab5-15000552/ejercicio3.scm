(display "Ingrese nombre de libro" )
(define nombre (read-line) )
(newline)
(display "Ingrese numero de paginas del libro" )
(define paginas (read))
(newline)
(display "Ingrese en cuantos dias quiere leer el libro" )
(define dias (read))
(define total (quotient paginas dias))
(define total2 (+ total 1))
(newline)
(display total2)
