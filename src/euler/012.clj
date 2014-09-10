(ns euler.012
  (:use [euler.lazy :only (triangle-numbers)]
        [euler.factors :only (count-factors)]))

(first (drop-while #(<= (count-factors %) 500) triangle-numbers))
