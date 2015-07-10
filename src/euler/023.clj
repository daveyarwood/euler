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

(defn- abundant? [n]
  (contains? (set abundant-numbers) n))

(defn- abundant-numbers-below [n]
  (take-while #(< % n) abundant-numbers))

(defn meets-criteria?
  "Cannot be written as the sum of two abundant numbers."
  [n]
  (not-any? #(abundant? (- n %)) (abundant-numbers-below n)))

; almost there...
; idea: for each number 1-28123, try subtracting every abundant number below
; it and seeing if the result is in abundant-numbers

; hmm... (reduce + (filter meets-criteria? (range 1 28124))) takes too long.
