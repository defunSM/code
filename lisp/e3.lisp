(with-output-to-string (out)
  (with-input-from-string (in "\"Can I ask who's calling?\"")
    (let ((io (make-two-way-stream in out)))
      (format io "~A It's the Jovian moon, Io!" (read io)))))
