(ns euler.022
  (:require [clojure.java.io :as io]
            [clojure.string :as s :only (replace split)]))

(def sorted-names
  (-> 
    (slurp (io/file (io/resource "names.txt")))
    (s/replace #"\"" "")
    (s/split #",")
    sort))

(def letter->value
  (zipmap "ABCDEFGHIJKLMNOPQRSTUVWXYZ" (map inc (range))))

(def scored-names
  (map-indexed (fn [i name] 
                 (* (inc i) (reduce + (map letter->value name))))
               sorted-names))

(def total-score
  (reduce + scored-names))

total-score

; I can't get this one not to throw 
; "NullPointerException   clojure.lang.Numbers.ops (Numbers.java:942)"

; It works up to (take 146 sorted-names), but there are over 5000 of them.
; Using *' and/or +', and/or coercing to BigInteger doesn't help at all.

; lol wut
