(defpackage #:my-new-package
  (:use :cl)
  (:export #:mad-adder))

(in-package :my-new-package)

(defun %madder (x)
  (declare (integer x))
  (apply #'+ (loop for i from 1 upto x
		   collect (* x i))))

(defun mad-adder (x)
  "Call %MADDER with interger argument X."
  (%madder x))

(in-package :cl-user)

(my-new-package:mad-adder 10)

(my-new-package::%madder 10)
