(clear)
(define a (make-vector 4))
(define pos1 0)
(define pos2 0)
(define x (random 4))
(define y (random 4))
(define ram 0)
(define acc 0)
(display "Ingrese base para jugar: ")
(define numero (read))

(do
	((cont 0 (+ cont 1)))
	((= cont 4)())

	 (vector-set! a cont (make-vector 4 0))
)	

(define (potencia)
	(define xi (random 2))
	(if (= xi 0)
		numero
		(+ numero numero)
	)
)

(define (tablero)	
	(clear)
	(display "+------+------+------+------+") (newline)
	(display "|   ")
	(set! pos1 0)
	(set! pos2 0)
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 0)
	(set! pos2 1)
	(display "  |   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 0)
	(set! pos2 2)
	(display "  |   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 0)
	(set! pos2 3)
	(display "  |   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 1)
	(set! pos2 0)
	(display "  |   ")(newline)
	(display "+------+------+------+------+") (newline)
	(display "|   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 1)
	(set! pos2 1)
	(display "  |   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 1)
	(set! pos2 2)
	(display "  |   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 1)
	(set! pos2 3)
	(display "  |   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 2)
	(set! pos2 0)
	(display "  |   ")(newline)
	(display "+------+------+------+------+") (newline)
	(display "|   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 2)
	(set! pos2 1)
	(display "  |   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 2)
	(set! pos2 2)
	(display "  |   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 2)
	(set! pos2 3)
	(display "  |   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 3)
	(set! pos2 0)
	(display "  |   ")(newline)
	(display "+------+------+------+------+") (newline)
	(display "|   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 3)
	(set! pos2 1)
	(display "  |   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 3)
	(set! pos2 2)
	(display "  |   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(set! pos1 3)
	(set! pos2 3)
	(display "  |   ")
	(display (vector-ref (vector-ref a pos1) pos2))
	(display "  |   ")(newline)
	(display "+------+------+------+------+") (newline)

	
)

(define (inicio)
	(define xi (random 4))
	(define yi (random 4))
	(define ram1 (vector-ref (vector-ref a xi) yi))
	(if (= ram1 0)
		(vector-set! (vector-ref a xi) yi (potencia))
		(inicio)
	)
)




(define (arriba)
	(define cont2 0)
	(define cont1 0)
	(define (ciclo)
		(if (= (vector-ref (vector-ref a cont1) cont2) 0)
			(begin
				(if (< cont2 4)
					(begin
						(if (< cont1 3) 
							(begin
								(vector-set! (vector-ref a cont1) cont2 (vector-ref (vector-ref a (+ cont1 1)) cont2))
								(vector-set! (vector-ref a (+ cont1 1)) cont2 (vector-ref (vector-ref a cont1) cont2))
								(set! cont1 (+ cont1 1))
								(ciclo)
							)
							(begin
								(set! cont2 (+ cont2 1))
								(set! cont1 0)
								(ciclo)
							)
						)
					)
				)
			)
			(begin
				(if (not (> cont2 3))
					(begin
						(if (> cont1 2)
							(begin
								(set! cont1 0)
								(set! cont2 (+ cont2 1))
								(ciclo)
							)
						)
					)
				)
			)
		)
	)
	(ciclo)
)



(define (abajo)
  	(define cont1 0)
	(define cont2 0)
	(define posi1)
	(define posi2)
	(define num (vector-ref (vector-ref a cont1) cont2))
	(define str 0)
	(define (ciclo)
		
(set! posi1 (vector-ref (vector-ref a cont1) cont2))
		(set! posi2 (vector-ref (vector-ref a cont1) (- cont2 1)))
		(if (= cont1 3)
			(begin
				(tablero)
			)
	 		(begin
				(if (= cont2 1)
					(begin
						(if (= posi1 str) 
						(begin
							(vector-set! (vector-ref a cont1) cont2 posi2)
							(vector-set  (vector-ref a cont1) (- cont2 1) str)
							(set! cont2 (- cont2 1))
							(ciclo)
						)
						(begin
								(set! cont2 (- cont2 1))
								(ciclo)
						)
						)
					)
					(begin
						(set! cont1 (+ cont1 1))
						(set! cont2 3)
					)
				)
			 	(ciclo)
			)
		)
	)
	(ciclo)
  	(tablero)
)


(define (izquierda)
  	(define cont1 3)
	(define cont2 0)
	(define posi1)
	(define posi2)
	(define str 0)
	(define (ciclo)
		(set! posi1 (vector-ref (vector-ref a cont1) cont2))
		(set! posi2 (vector-ref (vector-ref a cont2) (- cont1 1)))
		(if (= cont2 3)
			(begin
				(tablero)
			)
	 		(begin
				(if (= cont1 1)
					(begin
						(if (= posi1 str) 
							(begin
								(vector-set! (vector-ref a cont2) cont1 posi2)
								(vector-set  (vector-ref a cont2) (- cont1 1) str)
								(set! cont2 (- cont2 1))
								(ciclo)
							)
							(begin
								(set! cont1 (- cont1 1))
								(ciclo)	
							)
						)
					 )
					(begin
						(set! cont2 (+ cont2 1))
						(set! cont1 3)
					)
				)
			 	(ciclo)
			)
		)
	)
	(ciclo)
  	(tablero)
)
 
 (define (derecha)
  	(define cont1 0)
	(define cont2 0)
	(define posi1)
	(define posi2)
	(define str 0)
	(define (ciclo)
		(set! posi1 (vector-ref (vector-ref a cont1) cont2))
		(set! posi2 (vector-ref (vector-ref a cont2) (+ cont1 1)))
		(if (= cont2 3)
			(begin
				(tablero)
			)
	 		(begin
				(if (= cont1 3)
					(begin
						(if (= posi1 str) 
							(begin
								(vector-set! (vector-ref a cont2) cont1 posi2)
								(vector-set  (vector-ref a cont2) (+ cont1 1) str)
								(set! cont1 (+ cont1 1))
								(ciclo)
							)
							(begin
								(set! cont1 (+ cont1 1))
								(ciclo)
							)
						)
					)
					(begin
						(set! cont2 (+ cont2 1))
						(set! cont1 0)
					)
				)
			 	(ciclo)	
			)
		)
	)
	(ciclo)
  	(tablero)
)


(define (juego)
	(define movimiento (read-line))
	(if (string=? movimiento "w")
		(begin
			(arriba)
		 	(tablero)
			(inicio)
		 	(juego)
		)
		(begin
		 	(if (string=? movimiento "a")
				(begin
					(izquierda)
					(inicio)
					(juego)
				)
				(begin 
				 	(if (string=? movimiento "s")
						(begin
						 	(abajo)
							(inicio)
							(juego)
						)
						(begin
						 	(if (string=? movimiento "d")
								(begin
								 	(derecha)
								 	(inicio)
		 							(juego)
								 )
								 (display "Movimiento incorrecto")
							)
						)
					)
				)
			)
		)		
	)
  	(tablero)
)

(define (main)
	(inicio)
	(inicio)
  	(tablero)
  	(juego)
)
(main)







