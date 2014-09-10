(ns euler.014)

; My straightforward solution to this failed to not blow stack, even when I
; tried using "memoize"! So here is a better solution, courtesy of Clojure
; Companion Cube (http://clojure.roboloco.net?p=177)

; (I've made a couple very minor aesthetic changes)

(defn max-at [s]
  "Returns [xi x], where xi is the index number of the max element,
   (indexed from 1) and x is the max of s."
   (letfn [(find-max [s n x xi]
             (let [[f & r] s]
               (if (nil? f)
                 [xi x]
                 (if (> f x)
                   (recur r (inc n) f n)
                   (recur r (inc n) x xi)))))]
     (find-max s 1 0 0)))

(defn collatz-next [n]
  "Returns the next number in a Collatz sequence."
  (cond
    (= n 1)  1
    (odd? n) (+ 1 (* 3 n))
    :else    (/ n 2)))

(defn collatz-seq [n]
  "Returns a lazy list of numbers in a Collatz sequence."
  (iterate collatz-next n))

(defn collatz-stack [vc n]
  "Returns a lazy list of numbers in a Collatz sequence that aren't in
   vector vc."
   (take-while #(not (and (> n %) (vc %))) (collatz-seq n)))

(defn collatz-value [vc]
  "'Appends' the length of the Collatz sequence for the last value.
   Zero indexed... Ex: Given [0 1 2], returns 8."
  (let [n (count vc)
        s (collatz-stack vc n)]
    (conj vc (+ (count s) (vc (collatz-next (last s)))))))

(def lazy-collatz-vec (iterate collatz-value [0 1 2]))

; (max-at (nth lazy-collatz-vec 1000000))

; this returns [837800 525], 837800 being 1 greater than the actual
; solution... I get the general idea of the code, but can't quite get
; my head around exactly what it does, so I'm not sure how to fix it!
