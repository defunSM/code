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

(parse)

(use '[clojure.xml :only (parse)])

(parse (slurp "https://www.google.com/?gws_rd=ssl#q=word"))

(def ^:dynamic *notification-address* "dobby@elf.org")

(= #{} (set nil))

(= 3 (count #{1 2 3}))

(= #{1 2 3 4 5} (set '(1 1 2 2 3 3 4 4 5 5)))

(= #{1 2 3 4 5} (clojure.set/union #{1 2 3 4} #{2 3 5}))

(= {:a :b} (hash-map :a :b))

(get {:a 1 :b 2} :b)

(= ({:a 1 :b 2} :b) (get {:a 1 :b 2} :b))

(time ({:a 1 :b 2} :b))

(time (:b {:a 1 :b 2}))

(time (assoc {:a 1 :b 2} :c 3))

(= 6 (#(* 3 %1 %2) 1 2))

(= 25 ((fn [x] (x 5)) (fn [n] (* n n))))

(let [x 5]
  (= :your-road (cond (= x 1) :false-road
                      (= x 2) :falsey-road
                      :else :your-road)))

(if-not (zero? 1)
  true
  false)

(defn explain-defcon [term]
  (case term
    :level-one :blue
    :level-two :red
    :level-three :green))

(explain-defcon :level-two)

(map (fn [x] (* x x)) (vec (range 0 10)))

(= "longest" (reduce (fn [a b]
                       (if (< (count a) (count b)) b a))
                     ["which" "word" "is" "longest"]))

(defmulti diet (fn [x] (:eater x)))
(defmethod diet :herbivore [a] (str (:name a) " eats leafs."))
(defmethod diet :carnivore [a] (str (:name a) " eats meat."))

(def salman (atom {:name "Salman" :eater :carnivore}))
(def shihab (atom {:name "Shihab" :eater :herbivore}))

(time (reset! shihab (assoc @shihab :eater :herbivore)))

(defn carnivore? [x] (if (= (:eater x) :carnivore)
                       true
                       false))

(carnivore? @shihab)

@salman

(ns koans.meditations.lazy-sequences)

"There are many ways to generate a sequence"
(= '(1 2 3 4) (range 1 5))

"The range starts at the beginning by default"
(= '(0 1 2 3 4) (range 5))

"Only take what you need when the sequence is large"
(= [0 1 2 3 4 5 6 7 8 9]
   (take 10 (range 100)))

"Or limit results by dropping what you don't need"
(= [95 96 97 98 99]
   (drop 95 (range 100)))

"Iteration provides an infinite lazy sequence"
(= (range 20) (take 20 (iterate inc 0)))



"Repetition is key"
(= [:a :a :a :a :a :a :a :a :a :a]
   (repeat 10 :a))

"Iteration can be used for repetition"
(= (repeat 100 :foo)
   (take 100 (iterate (fn [x] x) :foo)))

(repeat 100 :foo)



"Sequence comprehensions can bind each element in turn to a symbol"
(= '(0 1 2 3 4 5)
   (for [index (range 6)]
     index))

"They can easily emulate mapping"
(= '(0 1 4 9 16 25)
   (map (fn [index] (* index index))
        (range 6))
   (for [index (range 6)]
     (* index index)))

"And also filtering"
(= '(1 3 5 7 9)
   (filter odd? (range 10))
   (for [index (range 10) :when (odd? index)]
     index))

"Combinations of these transformations is trivial"
  (= '(1 9 25 49 81)
     (map (fn [index] (* index index))
          (filter odd? (range 10)))
     (for [index (range 10) :when (odd? index)]
       (* index index)))

  "More complex transformations simply take multiple binding forms"
  (= [[:top :left] [:top :middle] [:top :right]
      [:middle :left] [:middle :middle] [:middle :right]
      [:bottom :left] [:bottom :middle] [:bottom :right]]
     (for [row [:top :middle :bottom]
           column [:left :middle :right]]
       [row column]))


"One may know what they seek by knowing what they do not seek"
(= [true false true] (let [not-a-symbol? (complement symbol?)]
                      (map not-a-symbol? [:a 'b "c"])))

"Praise and 'complement' may help you separate the wheat from the chaff"
  (= [:wheat "wheat" 'wheat]
     (let [not-nil? (complement nil?)]
       (filter not-nil? [nil :wheat nil "wheat" nil 'wheat nil])))

  "Partial functions allow procrastination"
  (= 20 (let [multiply-by-5 (partial * 5)]
          (multiply-by-5 4)))

  "Don't forget: first things first"
  (= [:a :b :c :d]
     (let [ab-adder (partial concat [:a :b])]
       (ab-adder [:c :d])))

(defn square [n] (* n n))
"Functions can join forces as one 'composed' function"
(= 25 (let [inc-and-square (comp square inc)]
        (inc-and-square 4)))

"Have a go on a double dec-er"
(= 8 (let [double-dec (comp dec dec)]
         (double-dec 10)))

"Be careful about the order in which you mix your functions"
  (= 99 (let [square-and-dec (comp dec square)]
          (square-and-dec 10)))

#_(def koans '(
               "Recursion ends with a base case"
               (= true (is-even? 0))

               "And starts by moving toward that base case"
               (= false (is-even? 1))

               #_(
                  "Having too many stack frames requires explicit tail calls with recur"
                  (= false (is-even-bigint? 100003N)))


               "Reversing directions is easy when you have not gone far"
               (= '(1) (recursive-reverse [1]))

               "Yet it becomes more difficult the more steps you take"
               (= '(5 4 3 2 1) (recursive-reverse [1 2 3 4 5]))

               "Simple things may appear simple."
               (= 1 (factorial 1))

               "They may require other simple steps."
               (= 2 (factorial 2))

               "Sometimes a slightly bigger step is necessary"
               (= 6 (factorial 3))

               "And eventually you must think harder"
               (= 24 (factorial 4))

               #(_
                 "You can even deal with very large numbers"
                 (< 1000000000000000000000000N (factorial 1000N))

                 "But what happens when the machine limits you?"
                 (< 1000000000000000000000000N (factorial 100003N)))))



(defn factorial [n]
  (loop [n n
         acc 1]
    (if (= 0 n)
      acc
      (recur (dec n) (* n (acc))))))

(factorial 10)

(defn is-even? [n]
    (if (= n 0)
      true
      (not (is-even? (dec n)))))

(is-even? 2)

(defn is-even-bigint? [n]
    (loop [n   n
           acc true]
      (if (= n 0)
        acc
        (recur (dec n) (not acc)))))

(defn recursive-reverse [coll]
  (loop [coll coll
         reversed ()]
    (if (= () coll)
      reversed
      (recur (rest coll) (cons (first coll) reversed)))))

(clojure.string/join (concat "s" "a"))

(defn strict-map1 [f coll]
    (loop [coll coll, acc nil]
        (if (empty? coll)
          (reverse acc)
          (recur (next coll) (cons (f (first coll)) acc)))))


(strict-map1 - (range 5))

(defn strict-map2 [f coll]
    (loop [coll coll, acc []]
        (if (empty? coll)
            acc
            (recur (next coll) (conj acc (f (first coll)))))))

(vector? (first {:width 10 :height 20 :depth 15}))

(nth (vec {:width 10 :height 20 :depth 15}) 2)

(doseq [[dimension amount] {:width 10 :height 20 :depth 15}]
    (println (str (name dimension) ":") amount "inches"))

(def dice1 (range 5))

(range 5)

(defmethod print-method clojure.lang.PersistentQueue
  [q, w]
  (print-method '<- w) (print-method (seq q) w) (print-method '-< w))

(def schedule
    (conj clojure.lang.PersistentQueue/EMPTY
        :wake-up :shower :brush-teeth))

(last schedule)

(pop schedule)

(def new (rest schedule))

(#{:a :b :c :d} :c)

(#{:a :b :c :d} :e)

(get #{:a 1 :b 2} :b)

#{[] ()}

(sorted-set [3 4] [1 2])

(def my-set (sorted-set :a :b))

(contains? #(1 2 3 4) 4)

(clojure.set/difference #{1 2 3 4} #{3 4 5 6})

(defn xconj [t v]
    (cond
        (nil? t) {:val v :L nil :R nil}))

(xconj nil 5)

(def salman (ref {:name "Salman"}))

(assoc @salman :age 10)

(def the-world (ref "hello"))

(def the-world (ref "hello"))
(def bizarro-world (ref {}))

(meditations
  "In the beginning, there was a word"
  (= __ (deref the-world))

  "You can get the word more succinctly, but it's the same"
  (= __ @the-world)

  "You can be the change you wish to see in the world."



  "Alter where you need not replace"
  (= __ (let [exclamator (fn [x] (str x "!"))]
          (dosync
           (alter the-world exclamator)
           (alter the-world exclamator)
           (alter the-world exclamator))
          @the-world))

  "Don't forget to do your work in a transaction!"


  "Functions passed to alter may depend on the data in the ref"


  "Two worlds are better than one")



(= "better" (do
              (dosync (ref-set the-world "better"))
              @the-world))

(= 0 (do (dosync (ref-set the-world 0))
         @the-world))

(= 20 (do
        (dosync (alter the-world (partial + 20)))))

(def bizarro-world (ref {}))

(= ["Real Jerry" "Bizarro Jerry"
     (do
       (dosync
        (ref-set the-world {})
        (alter the-world assoc :jerry "Real Jerry")
        (alter bizarro-world assoc :jerry "Bizarro Jerry")))])

(def atomic-clock (atom 0))

"Atoms are like refs"
(= 0 @atomic-clock

  "You can change at the swap meet"
  (= 1 (do
          (swap! atomic-clock inc)
          @atomic-clock))

  "Keep taxes out of this: swapping requires no transaction"
  (= 5 (do
         (swap! atomic-clock + 4)
         @atomic-clock))

  "Any number of arguments might happen during a swap"
  (= 20 (do
          (swap! atomic-clock + 1 2 3 4 5)
          @atomic-clock))

  "Atomic atoms are atomic"
  (= 20 (do
          (compare-and-set! atomic-clock 100 :fin)
          @atomic-clock))

  "When your expectations are aligned with reality, things proceed that way"
  (= :fin (do
            (compare-and-set! atomic-clock 20 :fin)
            @atomic-clock)))

"Wrap a quote around a list to suppress evaluation"
  (= (quote (1 2 3 4 5)) '(1 2 3 4 5))

  "There is a shortcut too!"
  (= (quote (1 2 3 4 5)) '(1 2 3 4 5))

  "You can quote symbols as well as lists... without evaluation!"
  (= __ (let [age 9] (quote age)))

  "You can use a literal list as a data collection without having Clojure try to call a function"
  (= (cons 1 (__ (2 3))) (list 1 2 3) (cons 1 [2 3]))

  "The quote affects all of its arguments, not just the top level"
(= (list 1 __) '(1 (+ 2 3))

  "Syntax-quote (`) acts similarly to the normal quote")
(= (list 1 2 3) `(1 2 3) '(1 2 3)


  "Unquote (~) within a syntax-quoted expression lets you mark specific expressions as requiring evaluation")
(= (list __ __) `(1 ~(+ 2 3)) '(1 5))

(defmacro hello [x]
  (str "Hello, " x))

(defmacro infix [form]
  (list (second form) (first form) (nth form 2)))

(defn triangle
  [n]
  (/ (* n (+ n 1)) 2))

(println (triangle 10))

(map triangle (range 1 11))

(def tri-nums (map triangle (iterate inc 1)))

(take 10 tri-nums)

(take 10 (filter even? tri-nums))

(nth tri-nums 99)

(take 2 (drop-while #(< % 10000) tri-nums))

(double (reduce + (take 1000 (map / tri-nums))))

(defn defer-expensive [cheap expensive]
    (if-let [good-enough (force cheap)]
        good-enough
        (force expensive)))

(defer-expensive (delay :cheap)
                 (delay (do (Thread/sleep 5000) :expensive)))

(defer-expensive (delay nil)
                 (delay (do (Thread/sleep 500) :expensive)))

(defn atest
  [n]
  (if-let [something n]
      (println n)
      (println "False")))

(defn my-re-seq [re string]
  (let [matcher (re-matcher re string)]
    (loop [match (re-find matcher)
           result []]
      (if-not match
        result
        (recur (re-find match)
               (conj result match))))))
