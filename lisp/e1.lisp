(in-package :cl-user)

(defpackage #:salman-package
  (:nicknames #:spack)
  (:use :cl :cl-user)
  (:export #:binary-convertor)
  (:export #:octal-convertor)
  (:export #:hex-convertor))

(in-package :salman-package)

(defun binary-convertor (x) (write x :base 16 :radix t))

(defun octal-convertor (x) (write x :base 8 :radix t))

(defun hex-convertor (x) (write x :base 2 :radix t))
