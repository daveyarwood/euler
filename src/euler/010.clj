(ns euler.010
	(:use [euler.lazy :only (primes)]))

(apply + (take-while #(< % 2000000) primes))
