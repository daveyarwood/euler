(ns euler.factors 
  (:require [clojure.math.combinatorics :as combo]))

(defn prime-factors [n]
  (letfn [(factors-starting-at [f n]
            (cond 
              (= n 1)           []
              (zero? (rem n f)) (cons f (factors-starting-at f (/ n f)))
              :else             (recur (inc f) n)))]
    (factors-starting-at 2 n)))

(defn count-factors [n]
  (apply * (map #(inc %) (vals (frequencies (prime-factors n))))))

(defn proper-divisors [n]
  (into #{1} 
    (map #(apply * %)
         (combo/subsets (prime-factors n)))))

(defn sum-of-factors 
  "The sum of all factors of n, including 1 and n itself."
  [n]
  (reduce + (proper-divisors n)))
