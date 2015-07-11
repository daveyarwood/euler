(ns euler.023 
  (:require [euler.factors :refer (sum-of-factors)]))

(defn sum-of-proper-divisors [n]
  (- (sum-of-factors n) n))

(defn evaluate
  "Determines if n is perfect, abundant, or deficient."
  [n]
  (let [x (sum-of-proper-divisors n)]
    (cond
      (= x n) :perfect
      (< x n) :deficient
      (> x n) :abundant)))

(def abundant-numbers
  (filter #(-> % evaluate (= :abundant)) (range 1 28124)))

(defn meets-criteria?
  "Cannot be written as the sum of two abundant numbers.
   
   To improve performance, this function takes a list of abundant numbers for
   comparison, instead of checking all known abundant numbers."
  [n abundants]
  (letfn [(abundant? [x]
            (contains? (set abundants) x))
          (abundant-numbers-below [n]
            (take-while #(< % n) abundant-numbers))] 
    (not-any? #(abundant? (- n %)) (abundant-numbers-below n))))

(def odd-abundant-numbers
  (filter odd? abundant-numbers))

(def even-abundant-numbers
  (filter even? abundant-numbers))

(let [odd-winners (filter #(meets-criteria? % even-abundant-numbers)
                          (range 957 20162 2))
      even-winners (filter #(meets-criteria? % 
                                             (take-while (fn [a] (<= a (/ % 2))) 
                                                         even-abundant-numbers))
                           (range 24 20161 2))]
  (reduce + (concat odd-winners even-winners)))

; can't get the performance right with this one... 
; everything i try takes forever :/
