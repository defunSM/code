(ns sm.read)

(use 'clojure.java.io)

(defn pcurrentdir []
  (println "Current Directory:" (System/getProperty "user.dir")))

(defn currentdir []
  (println (System/getProperty "user.dir")))

(defn trancatefile []
  (with-open [wrtr (writer (read-line))]
    (println "Enter text: ")
    (.write wrtr "")))

(defn appendtofile []
  (with-open [wrtr (writer (read-line) :append true)]
    (println "Enter text: ")
    (.write wrtr (read-line))))

(defn displayfile []
  (with-open [rdr (reader (read-line))]
    (doseq [line (line-seq rdr)]
      (println line))))

(defn mangefile []
  (let [x (read-line)]
    (cond x "t" (trancatefile))
    (cond x "a" (appendtofile))
    (cond x "d" (displayfile))))

(mangefile)

(displayfile)

(trancatefile)

(appendtofile)

(fileappend "test.txt" "This is being added.")
