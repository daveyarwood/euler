(ns euler.025
  (:use [euler.lazy :only (fibs)]))

(let [limit (.pow (BigInteger/TEN) 999)] 
  (count (take-while #(< % limit) fibs)))
