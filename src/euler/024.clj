(ns euler.024
  (:require [clojure.math.combinatorics :as combo]))

(apply str (combo/nth-permutation (range 10) 999999))
