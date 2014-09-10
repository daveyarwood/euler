(ns euler.002
	(:use [euler.lazy :only (fibs)]))
	
(reduce + (filter even? (take-while #(< % 4000000) fibs)))
