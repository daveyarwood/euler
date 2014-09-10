(ns euler.067
  (:use [euler.018 :only (triangle-sums)])
  (:require [clojure.string :as str]))

(def triangle
  (->> (slurp (.getFile (clojure.java.io/resource "triangle.txt")))
       (#(str/split % #"\n"))
       (map #(str/split % #"\s+"))
       (map #(remove empty? %))
       (map (fn [row] (map #(str/replace % #"\A0" "") row)))
       (mapv #(mapv read-string %))))

(ffirst (triangle-sums triangle))


