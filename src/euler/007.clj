(ns euler.007
	(:use [euler.lazy :only (primes)]))

(nth primes 10000)  ; 10001st prime number
