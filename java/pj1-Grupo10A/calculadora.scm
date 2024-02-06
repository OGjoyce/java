(clear)
(display "               ************************************************
	       * Ludwin Ronaldo Gomez Godinez       15000552  *     
	       * Carlos Alejandro Montiel Lorenzana 15000552  *
	       * Wilson alexander luis              1400686   * 
	       * Seccion A                                    *
	       ************************************************:")
(newline)
(display "calculadora>> ")
(define a (read-line))
(define b (string-search-forward " " a))
(define c (string-search-backward " " a))
(define e (- (string-length a) 1))
        (define f (substring a 1 b))
       	(define h (substring a c e))

(define i)
(define j)

       
       	(define op (substring a (+ b 1) (- c 1)))
       	(set! i (string->number f))
       	(set! j (string->number h))

(define resultado)

(if (equal? op "+")
(begin
      (set! resultado (+ i j))
       (display resultado)))


(if (equal? op "-")
(begin
      (set! resultado (- i j))
       (display resultado)))

(if (equal? op "*")
(begin
      (set! resultado(* i j))
       (display resultado)))

(if (equal? op "/")
(begin
(set! resultado (/ i j))
       (display resultado)))

