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

; almost there...
; idea: loop through abundant-numbers, and for each one,
; try subtracting every abundant number below it and seeing
; if the result is in abundant-numbers
