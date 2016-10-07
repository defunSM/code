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
