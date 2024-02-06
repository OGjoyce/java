(define (exptlist exp . dmas)
  (define lista)
  (define lista2)
  (if (zero? dmas)
      (display "invalid")
      (begin
        (set! lista (make-list (length dmas) exp)
              (map expt dmas lista2))
        lista
        )
      )
  lista
 
                      