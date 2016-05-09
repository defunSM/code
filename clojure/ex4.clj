(ns ex4.core)

(defmacro backwards
  [form]
  (reverse form))

(backwards (" backwards" " am" "I" str))

(def addition-list (list + 1 2))

(eval addition-list)

(eval (concat addition-list [10]))

(eval (list 'def 'lucky-number (concat addition-list [10])))

lucky-number

(str "To understand what recursion is," " you must first understand recursion")

(list? (read-string "(+ 1 2)"))

(conj (read-string "(+ 1 2)") :zagglewag)

(#(+ 1 %) 3)

(read-string "'(a b c)")

(read-string "@var")

(read-string "; ignore!\n(+ 1 2)")

(eval (list (read-string "+") 1 2))

(eval (read-string "()"))

(+ 1 2)

(+ 1 (+ 2 3))

(if true 1 2)

'(a b c)

(read-string "(1 + 1)")

(eval (let [infix (read-string "(1 + 1)")]
        (list (second infix) (first infix) (last infix))))

(defmacro ignore-last-operand
  [function-call]
  (butlast function-call))

(ignore-last-operand (+ 1 2 10))

(ignore-last-operand (+ 1 2 (println "Look at me!!!")))

(defmacro infix
  [infixed]
  (list (second infixed)
        (first infixed)
        (last infixed)))

(infix (1 + 2))

(defn read-resource
  [path]
  (read-string (slurp (clojure.java.io/resource path))))

(defn read-resource
  [path]
  (-> path
      clojure.java.io/resource
      slurp
      read-string))

(defmacro my-print
  [expression]
  (list 'let ['result expression]
        (list 'println 'result)
        'result))

'(+ 1 ~(inc 1))

(defmacro code-critic
  [bad good]
  (list 'do
        (list 'println
              "Great squid of Madrid, this is bad code:"
              (list 'quote bad))
        (list 'println
              "Sweet gorilla of Manila, this is good code:"
              (list 'quote good))))

(code-critic (1 + 1) (+ 1 1))

(defmacro code-critic
  [bad good]
  `(do (println "Great squid of Madrid, this is bad code:"
                (quote ~bad))
       (println "Sweet gorilla of Manila, this is good code:"
                (quote ~good))))

(code-critic (1 + 1) (+ 1 1))

(defn criticize-code
  [criticism code]
  `(println ~criticism (quote ~code)))

(defmacro code-critic
  [bad good]
  `(do ~(criticize-code "Cursed bacteria of Liberia this is bad code:" bad)
       ~(criticize-code "Sweet sacred boa of Western this is good code:" good)))

(code-critic (1 + 1) (+ 1 1))

(defmacro code-critic
  [{:keys [good bad]}]
  `(do ~@(map #(apply criticize-code %)
              [["Sweet lion of Zion, this is bad code:" bad]
               ["Great cow of Moscow, this is good code:" good]])))

(code-critic (1 + 1) (+ 1 1))

(def message "Good Job!")

(defmacro with-mischief
  [& stuff-to-do]
  (concat (list 'let ['message "oh, big deal!"])
          stuff-to-do))

(with-mischief
  (println "Heres how I feel about that thing you did: " message))

(defmacro without-mischief
  [& stuff-to-do]
  (let [macro-message (gensym 'message)]
    `(let [~macro-message "Oh, big deal!"]
       ~@stuff-to-do
       (println "I still need to say " ~macro-message))))

(without-mischief
 (println "Heres how I feel about that thing you did: " message))

`(blarg# blarg#)

`(let [name# "Larry Potter"] name#)


(eval `(+ ~@(list 1 2 3)))

(range 0 5)

(defn summation
  [alist]
  (eval `(+ ~@alist)))

(summation (range 0 12))

(def var "Salman")


(println `(first ~@var))

(defmacro infix
  [something]
  (eval (list (second something) (first something) (last something))))

(infix (1 + 1))

(defmacro report
  [to-try]
  `(if ~to-try
     (println (quote ~to-try) "was successful:" ~to-try)
     (println (quote ~to-try) "was not successful:" ~to-try)))

(defmacro report
  [to-try]
  `(let [result# ~to-try]
     (if result#
       (println (quote ~to-try) "was successful:" result#)
       (println (quote ~to-try) "was not successful:" result#))))

(report (do (Thread/sleep 1000) (+ 1 1)))

(doseq [code ['(= 1 1) '(= 1 2)]]
  (report code))

(rand-int 2)

(defmacro doseq-macro
  [macroname & args]
  `(do
     ~@(map (fn [arg] (list macroname arg)) args)))

(doseq-macro report (= 1 1) (= 1 2))

(def order-detials-validations
  {:name ["Please enter a name" not-empty]
   :email ["Please enter an email address" not-empty]})

(future (Thread/sleep 4000)
        (println "I'll print after 4 seconds"))

(let [result (future (println "This prints once")
                     (+ 1 1))]
  (println "deref: " (deref result))
  (println "@: " @result))

(let [result (future (Thread/sleep 3000)
                     (+ 1 1))]
  (println "It will be at least 3 seconds before I print.")
  (println "The result will be: " @result))

(deref (future (Thread/sleep 1000) 0) 1000 5)

(realized? (future (Thread/sleep 1000)))

(let [f (future)]
  @f
  (realized? f))

(def jackson-5-delay
  (delay (let [message "Just call my name and I'll be there"]
           (println "First deref:" message)
           message)))

(force jackson-5-delay)

(println @jackson-5-delay)

(def gimli-headshots ["serious.jpg" "fun.jpg" "playful.jpg"])

(defn email-user
  [email-address]
  (println "Sending headshot notification to" email-address))

(defn upload-document
  [headshot]
  true)

(let [notify (delay (email-user "and-my-axe@gmail.com"))]
  (doseq [headshot gimli-headshots]
    (future (upload-document headshot)
            (force notify))))

(def my-promise (promise))

(deliver my-promise (+ 1 2))

@my-promise

(def yak-butter-international
  {:store "Yak Butter International"
   :price 90
   :smoothness 90})

(def better-than-nothing
  {:store "Butter than Nothing"
   :price 150
   :smoothness 83})

(def baby-got-yak
  {:store "Baby Got Yak"
   :price 94
   :smoothness 99})

(defn mock-api-call
  [result]
  (Thread/sleep 1000)
  result)

(defn satisfactory?
  [butter]
  (and (<= (:price butter) 100)
       (>= (:smoothness butter) 97)
       butter))

(mock-api-call (if (satisfactory? baby-got-yak)
  (println "This is satisfactory.")
  (println "This is NOT satisfactory")))

(time (some (comp satisfactory? mock-api-call)
            [yak-butter-international better-than-nothing baby-got-yak]))

(time
 (let [butter-promise (promise)]
   (doseq [butter [yak-butter-international better-than-nothing baby-got-yak]]
     (future (if-let [satisfactory-butter (satisfactory? (mock-api-call butter))]
               (deliver butter-promise satisfactory-butter))))
   (println "And the winner is:" (:store @butter-promise))))

(let [ferengi-wisdom-promise (promise)]
  (future (println "here's some Ferengi wisdom:" @ferengi-wisdom-promise))
  (Thread/sleep 1000)
  (deliver ferengi-wisdom-promise "Whisper your way to such success."))

(defmacro wait
  [timeout & body]
  `(do (Thread/sleep ~timeout) ~@body))

(time (wait 1000 (+ 1 1)))

(let [saying3 (promise)]
  (future (deliver saying3 (wait 100 "Cheerio!")))
  @(let [saying2 (promise)]
     (future (deliver saying2 (wait 400 "Pip pip!")))
     @(let [saying1 (promise)]
        (future (deliver saying1 (wait 200 "'Ello, gov'n")))
        (println @saying1)
        saying1)
     (println @saying2)
     saying2)
  (println @saying3)
  saying3)

(time @(-> (enqueue saying (wait 200 "'Ello, gov'na!") (println @saying))
    (enqueue saying (wait 400 "Pip ip!") (println @saying))
    (enqueue saying (wait 100 "Cheerio!") (println @saying))))

(defmacro enqueue
  ([q concurrent-promise-name concurrent serialized]
   `(let [~concurrent-promise-name (promise)]
      (future (deliver ~concurrent-promise-name ~concurrent))
      (deref ~q)
      ~serialized
      ~concurrent-promise-name))
  ([concurrent-promise-name concurrent serialized]
   `(enqueue (future) ~concurrent-promise-name ~concurrent ~serialized)))

(def fred (atom {:cuddle-hunger-level 0
                 :percent-deteriorated 0}))

@fred

(let [zombie-state @fred]
  (if (>= (:percent-deteriorated zombie-state) 50)
    (future (println (:cuddle-hunger-level zombie-state)))))

(swap! fred
       (fn [current-state]
         (merge-with + current-state {:cuddle-hunger-level 1
                                      :percent-deteriorated 1})))

(defn increase-cuddle-hunger-level
  [zombie-state increase-by]
  (merge-with + zombie-state {:cuddle-hunger-level increase-by}))

(increase-cuddle-hunger-level @fred 10)

(swap! fred increase-cuddle-hunger-level 10)

(update-in {:a {:b 10}} [:a :b] inc)

(swap! fred update-in [:cuddle-hunger-level] + 10)

(let [num (atom 1)
      s1 @num]
  (swap! num inc)
  (println "State 1:" s1)
  (println "Current State:" @num))

(-> (let [num (atom 1)
      s1 @num]
  (swap! num inc)
  (println "State 1:" s1)
  (println "Current State:" @num)))

(reset! fred {:cuddle-hunger-level 0
              :percent-deteriorated 0})

@fred

(defn shuffle-speed
  [zombie]
  (* (:cuddle-hunger-level zombie)
     (- 100 (:percent-deteriorated zombie))))

(defn shuffle-alert
  [key watched old-state new-state]
  (let [sph (shuffle-speed new-state)]
    (if (> sph 5000)
      (do
        (println "Run, you fool!")
        (println "The zombie's SPH is now " sph)
        (println "This message brought to your courtesy of " key))
      (do
        (println "All's well with " key)
        (println "Cuddle hunger: " (:cuddle-hunger-level new-state))
        (println "Percent deteriorated: " (:percent-deteriorated new-state))
        (println "SPH: " sph)))))

(reset! fred {:cuddle-hunger-level 22
              :percent-deteriorated 2})

(add-watch fred :fred-shuffle-alert shuffle-alert)

(swap! fred update-in [:percent-deteriorated] + 1)

(swap! fred update-in [:cuddle-hunger-level] + 30)

(defn percent-deteriorated-validator
  [{:keys [percent-deteriorated]}]
  (and (>= percent-deteriorated 0)
       (<= percent-deteriorated 100))
  (throw (IllegalStateException. "That's not mathy!")))

(def bobby
  (atom
   {:cuddle-hunger-level 0 :percent-deteriorated 0}
   :validator percent-deteriorated-validator))

(swap! bobby update-in [:percent-deteriorated] + 200)

(def sock-varieties
  #{"darned" "argyle" "wool" "horsehair" "mulleted"
    "passive-aggressive" "striped" "polka-dotted"
    "athletic" "business" "power" "invisible" "gollumed"})

(defn sock-count
  [sock-variety count]
  {:variety sock-variety
   :count count})

(defn generate-sock-gnome
  [name]
  {:name name
   :socks #{}})

(def sock-gnome (ref (generate-sock-gnome "Barumpharumph")))

(def dryer (ref {:name "LG 1337"
                 :socks (set (map #(sock-count % 2) sock-varieties))}))

(defn steal-sock
  [gnome dryer]
  (dosync
   (when-let [pair (some #(if (= (:count %) 2) %) (:socks @dryer))]
     (let [updated-count (sock-count (:variety pair) 1)]
       (alter gnome update-in [:socks] conj updated-count)
       (alter dryer update-in [:socks] disj pair)
       (alter dryer update-in [:socks] conj updated-count)))))
(steal-sock sock-gnome dryer)

(:socks @sock-gnome)

(require 'clojure.xml)

(parse )

(use '[clojure.xml :only (parse)])

(parse (slurp "https://www.google.com/?gws_rd=ssl#q=word"))

(def ^:dynamic *notification-address* "dobby@elf.org")
