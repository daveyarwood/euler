(ns euler.003
  (:use [euler.lazy :only (primes)]))

(def big-number 600851475143)

(->> (take-while #(< % (int (Math/sqrt big-number))) primes)
     (filter #(zero? (mod big-number %)))
     last)
