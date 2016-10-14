(+ 2 3)

(defun hello-world ()
  (format t "hello, world"))

(list :a 1 :b 2 :c 3) ;; a list

(defun make-cd (title artist rating ripped)
  (list :title title :artist artist :rating rating :ripped ripped))



(defvar *db* nil)

(defun add-record (cd) (push cd *db*))

(add-record (make-cd "Fly" "Dixie Chicks" 9 t))

*db*

(defun dumb-db ()
  (dolist (cd *db*)
    (format t "~{~a:~8t~a~%~}~%" cd)))

(dumb-db)

(defun prompt-read (prompt)
  (format *query-io* "~a: " prompt)
  (force-output *query-io*)
  (read-line *query-io*))

(defun prompt-for-cd ()
  (make-cd
   (prompt-read "Title")
   (prompt-read "Artist")
   (or (parse-integer (prompt-read "Rating") :junk-allowed t) 0)
   (y-or-n-p "Ripped [y/n]: ")))

(defun add-cds ()
  (loop (add-record (prompt-for-cd))
     (if (not (y-or-n-p "Another? [y/n]: ")) (return))))

(add-cds)

*db*

(defun save-db (filename)
  (with-open-file (out filename
                       :direction :output
                       :if-exists :supersede)
    (with-standard-io-syntax
      (print *db* out))))

(save-db "~/cdlist.db")

(defun load-db (filename)
  (with-open-file (in filename)
    (with-standard-io-syntax
      (setf *db* (read in)))))

(remove-if-not #'(lambda (x) (= 0 (mod x 2))) '(1 2 3 4 5 6 7 8 9 10))

(defun select-by-artist (artist)
  (remove-if-not
   #'(lambda (cd) (equal (getf cd :artist) artist))
   *db*))

(defun select (selector-fn)
  (remove-if-not selector-fn *db*))

(defun artist-selector (artist)
  #'(lambda (cd) (equal (getf cd :artist) artist)))

(select (artist-selector "Dixie Chicks"))

(defun where (&key title artist rating (ripped nil ripped-p))
  #'(lambda (cd)
      (and
       (if title (equal (getf cd :title) title) t)
       (if artist (equal (getf cd :artist) artist) t)
       (if rating (equal (getf cd :rating) rating) t)
       (if ripped-p (equal (getf cd :ripped) ripped) t))))

(defun update (selector-fn &key title artist rating (ripped nil ripped-p))
  (setf *db*
        (mapcar
         #'(lambda (row)
             (when (funcall selector-fn row)
               (if title (setf (getf row :title) title))
               (if artist (setf (getf row :artist) artist))
               (if rating (setf (getf row :rating) rating))
               (if ripped-p (setf (getf row :ripped) ripped)))
             row) *db*)))

(update (where :artist "Dixie Chicks") :rating 13)

(defun delete-rows (selector-fn)
  (setf *db* (remove-if-not selector-fn *db*)))

(defmacro backwards (expr) (reverse expr))

(backwards ("Hello, world" t format))


(defun make-comparison-expr (field value)
  `(equal (getf cd ,field) ,value))

(defun make-comparison-list (fields)
  (loop while fields
     collecting (make-comparison-expr (pop fields) (pop fields))))

(defmacro where (&rest clauses)
  `#'(lambda (cd) (and ,@ (make-comparison-list clauses))))

(defun verbose-sum (x y)
  "Sum any two numbers after printing a message."
  (format t "Summing ~d and ~d.~%" x y)
  (+ x y))



(foo 1 2 3)

(defun factorial (num &optional (sum 1))
  "A factorial function"
  (if (eql num 0) sum (factorial (- num 1) (* sum num))))

(factorial 5)

(defun foobar (&key a b c)
  "A function with keyword parameters."
  (list a b c))

(foobar :b 1 :c 3)

(defun foo (n)
  "A function demonstrating return-from"
    (dotimes (i 10)
    (dotimes (j 10)
      (when (> (* i j) n)
        (return-from foo (list i j))))))

(foo 30)

(eq (function foo) #'foo)

(equal (foo 10) (funcall #'foo 10))

(defun plot (fn min max step)
  (loop for i from min to max by step do
       (loop repeat (funcall fn i) do (format t "*"))
       (format t "~%")))

(plot #'(lambda (x) (* 3 x)) 0 10 1)

(let* ((x 10)
      (y (+ x 10)))
  (list x y))

(defparameter *fn* (let ((count 0)) #'(lambda () (setf count (1+ count)))))

(funcall *fn*)

(defvar *count* 0
  "Counting")

(defparameter *gap-tolerance* 0.001)

(defun incremental-widget-count ()
  "increases widget count"
  (incf *count*))
