
(define (funcion decimal)
            (cond 
		(string-append (funcion (quotient decimal 2)) 
                                        (number->string (remainder decimal 2))))
)
