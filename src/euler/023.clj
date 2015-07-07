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

; per https://projecteuler.net/thread=23&page=5#94786, we can add to the
; result set 1-23 and all odd integers 25-957

; algorithm planning: do these odd ints first, testing if they can be reached by summing one existing odd integer and one number from the set of even abundant numbers (so... we would need to check the even numbers too, along the way??) then check the even abundant numbers, and only see if they can be reached by summing even abundant numbers (why not two odd abundant numbers...?)

